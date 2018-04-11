import java.util.Random;

public class Board {

  char[] row = { 'A', 'B', 'C' };
  Player[][] board = new Player[3][3];
  private Player[] moveList = new Player[9];

  enum Player {
    Blank, X, O
  };

  Player one, two;
  int movesMade;

  // single player constructor
  public Board(char c) {
    this.one = coinToss();
    if (Character.toLowerCase(c) == 'x') {
      one = Player.X;
      two = Player.O;
    }
    if (Character.toLowerCase(c) == 'o') {
      one = Player.O;
      two = Player.X;
    } else
      throw new IllegalArgumentException("You can only choose X or O");

    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[i].length; j++)
        board[i][j] = Player.Blank;
    System.out.println(one + " won the coin toss. They will go first");
    for (int i = 0; i < moveList.length; i++) {
      moveList[i] = i % 2 == 0 ? one : two;
    }

  }

  // two palyer constructor
  public Board() {
    this.one = coinToss();
    this.two = this.one == Player.X ? Player.O : Player.X;
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[i].length; j++)
        board[i][j] = Player.Blank;
    System.out.println(one + " won the coin toss. They will go first");
    for (int i = 0; i < moveList.length; i++) {
      moveList[i] = i % 2 == 0 ? one : two;
    }
  }

  private Player coinToss() {
    return Math.toIntExact(Math.round(Math.random())) == 1 ? Player.X : Player.O;
  }

  void print() {
    int j = 0;
    System.out.println("  1   2   3\n");
    for (Player[] b : board) {
      System.out.print("");
      for (int i = 0; i < b.length; i++) {
        // period is used for aesthetics
        if (b[i] == Player.Blank) // if i = 0 print row[j] + " " else "" if i = length - 1 print " " else ""
          System.out.print((i == 0 ? row[j] + " " : "") + "." + ((i == b.length - 1) ? " " : " | "));
        else //           same but it'll print the a player instead of a period
          System.out.print((i == 0 ? row[j] + " " : "") + b[i] + ((i == b.length - 1) ? " " : " | "));
      }
      System.out.println("\n  ---------");
      j++;
    }
  }

  int move(int x, int y, int p) {
    if (board[x][y] == Player.Blank)
      board[x][y] = moveList[p];
    else {
      System.out.println("Spot is already taken!");
      return -1;
    }
    movesMade += 1;
    if (checkWinner(x, y, moveList[p]) == one) {
      print();
      System.out.println(this.one + " won!");
      System.exit(0);
    }
    if (checkWinner(x, y, moveList[p]) == two) {
      print();
      System.out.println(this.two + " won!");
      System.exit(0);
    }
    if (movesMade == 9) {
      print();
      System.out.println("Its a draw!");
      System.exit(0);
    }
    return 1;
  }

  private Player checkWinner(int x, int y, Player p) {
    int count = 0;
    // Row Checks
    for (int i = 0; i < 3; i++) {
      if (board[x][i] == p)
        count++;
      if (count == 3)
        return p;
    }
    count = 0;
    // column checks
    for (int i = 0; i < 3; i++) {
      if (board[i][x] == p)
        count++;
      if (count == 3) {
        return p;
      }
    }
    count = 0;
    // diagonal checks
    for (int i = 0; i < 3; i++) {
      if (board[i][i] != p)
        break;
      if (i == 2)
        return p;
    }
    count = 0;
    // anti diagonal
    for (int i = 2, j = 0; i >= 0; i--, j++) {
      if (board[j][i] == p)
        count++;
      if (count == 3)
        return p;
    }
    return null;
  }

}
