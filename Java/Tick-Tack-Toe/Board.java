import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Board {

  char[] row = { 'A', 'B', 'C' };
  private Player[][] board = new Player[3][3];
  private Player[] moveList = new Player[9];
  private Player one,
                 two,
                 ai;
  int movesMade;
  private List<String> availableMoves = new ArrayList<String>(
      Arrays.asList("a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"));

  public enum Player {
    Blank, X, O
  }

  /**
  * <p>Constructs a two player board that allows input from two users.</p>
  */
  public Board() {
    this.one = coinToss();
    this.two = this.one == Player.X ? Player.O : Player.X;
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[i].length; j++)
        board[i][j] = Player.Blank;
    System.out.println(one + " won the coin toss. They will go first");
    for (int i = 0; i < moveList.length; i++)
      moveList[i] = i % 2 == 0 ? one : two;

  }

  /**
  *<p>Constructs a single player board that allows input from a single
  * user.</p>
  */
  public Board(char n) {
    Player won = coinToss();
    Player other = won == Player.X ? Player.O : Player.X;
    switch (n) {
    case 'x':
      one = Player.X;
      ai = Player.O;
    case 'o':
      one = Player.O;
      ai = Player.X;
    }

    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[i].length; j++)
        board[i][j] = Player.Blank;

    System.out.println(won + " won the coin toss. They will go first");

    for (int i = 0; i < moveList.length; i++)
      moveList[i] = i % 2 == 0 ? won : other;
  }

  /**
  * @return A random Player, <i>X</i> or <i>0</i>.
  */
  private Player coinToss() {
    return Math.toIntExact(Math.round(Math.random())) == 1 ? Player.X : Player.O;
  }
  /**
  *<p>Used to get Board for the AI.</p>
  */
  Player[][] getBoard() {
    return board;
  }
  /**
  *<p>Used to get AI for the AI.</p>
  */
  Player getPlayerAI() {
    return ai;
  }
  /**
  *<p>Used to get Human Player for the AI.</p>
  */
  Player getHuman() {
    return one;
  }
  /**
  *<p>Used to get current Player for the AI.</p>
  */
  Player getCurrentPlayer() {
    return moveList[movesMade];
  }
  /**
  *<p>Used to get MoveList for AI.</p>
  */
  Player[] getMoveList() {
    return moveList;
  }
  /**
  *<p>Used to get AvailableMoves for AI.</p>
  */
  List getAvailableMoves() {
    return availableMoves;
  }
  /**
  * <p> Returns the x and y cordinates of the inputed play.
  * will not throw an error, instead will display invalid
  * move and return -1, -1. </p>
  * @param Strings
  * @return int[]
  */
  static int[] play(String str) {
    switch (str.toLowerCase().replaceAll("\\s+", "")) {
    case "a1":
      return new int[] { 0, 0 };
    case "a2":
      return new int[] { 0, 1 };
    case "a3":
      return new int[] { 0, 2 };
    case "b1":
      return new int[] { 1, 0 };
    case "b2":
      return new int[] { 1, 1 };
    case "b3":
      return new int[] { 1, 2 };
    case "c1":
      return new int[] { 2, 0 };
    case "c2":
      return new int[] { 2, 1 };
    case "c3":
      return new int[] { 2, 2 };
    default:
      System.err.println("Invalid input");
    }
    return new int[] { -1, -1 };
  }

  public String toString() {
    int j = 0;
    String str = "";
    str += ("  1   2   3\n");
    for (Player[] b : board) {
      str += ("");
      for (int i = 0; i < b.length; i++) {
        // period is used for aesthetics
        if (b[i] == Player.Blank) // if i = 0 print row[j] + " " else "" if i = length - 1 print " " else ""
          str += ((i == 0 ? row[j] + " " : "") + "." + ((i == b.length - 1) ? " " : " | "));
        else //           same but it'll print the a player instead of a period
          str += ((i == 0 ? row[j] + " " : "") + b[i] + ((i == b.length - 1) ? " " : " | "));
      }
      str += ("\n  ---------\n");
      j++;
    }
    return str;
  }

  /**
  *<p>Will check if move is possible</p>
  * @param String
  * @return boolean
  */
  boolean canMove(String str) {
    int x = play(str)[0], y = play(str)[1];
    if (x == -1 || y == -1)
      return false;
    if (board[x][y] != Player.Blank) {
      System.out.println("Spot is already taken!");
      return false;
    }
    return true;
  }

  /**
  * <p> Will make selected move for the player. Checks to
  * see if the move is invalid is checked in canMove().
  * @param String
  * @param int
  */
  void move(String str, int p) {
    int x = play(str)[0], y = play(str)[1];
    board[x][y] = moveList[p];
    movesMade += 1;
    if (checkWinner(one, board)) {
      System.out.println(toString());
      System.out.println(this.one + " won!");
      System.exit(0);
    }
    if (checkWinner(two, board)) {
      System.out.println(toString());
      System.out.println(this.two + " won!");
      System.exit(0);
    }
    if (movesMade == 9) {
      System.out.println(toString());
      System.out.println("Its a draw!");
      System.exit(0);
    }
  }

  static boolean checkWinner(Player p, Player[][] n) {
    if (
    /* rows */
    n[0][0] == n[0][1] && n[0][1] == n[0][2] && n[0][2] == p ||
    n[1][0] == n[1][1] && n[1][1] == n[1][2] && n[1][2] == p ||
    n[2][0] == n[2][1] && n[2][1] == n[2][2] && n[2][2] == p ||
    /* diagonal */
    n[0][0] == n[1][1] && n[1][1] == n[2][2] && n[2][2] == p ||
    /* antiDiagonal */
    n[0][2] == n[1][1] && n[1][1] == n[2][0] && n[2][0] == p ||
    /* Column */
    n[0][0] == n[1][0] && n[1][0] == n[2][0] && n[2][0] == p ||
    n[0][1] == n[1][1] && n[1][1] == n[2][1] && n[2][1] == p ||
    n[0][2] == n[1][2] && n[1][2] == n[2][2] && n[2][2] == p)
      return true;
    return false;
  }

}
