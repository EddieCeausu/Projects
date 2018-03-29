import java.util.Random;

public class Board {

  char[] row = {'A', 'B', 'C'};
  Player[][] board = new Player[3][3];
  enum Player {Blank, X, O};
  Player human, comp;
  int movesMade;

  public Board(char c) {
    if(Character.toLowerCase(c) == 'x') {
      human = Player.X;
      comp = Player.O;
    }
    if(Character.toLowerCase(c) == 'o') {
      human = Player.O;
      comp = Player.X;
    } else throw new IllegalArgumentException("You can only choose X or O");

    for(int i = 0; i < board.length; i++)
      for (int j = 0; j < board[i].length; j++)
        board[i][j] = Player.Blank;
  }

  public Board() {
    human = new Random().nextInt(3) <= 1 ? Player.X : Player.O;

    for(int i = 0; i < board.length; i++)
      for (int j = 0; j < board[i].length; j++)
        board[i][j] = human;
  }

  void print() {
    int j = 0;
      System.out.println("  1   2   3\n");
      for(Player[] b : board) {
          System.out.print("");
          for(int i = 0; i < b.length; i++)
              System.out.print((i == 0 ? row[j] + " " : "") + b[i] + ( (i == b.length-1) ? " " : " | ") );
          System.out.println("\n  ---------");
          j++;
      }
  }
  void move(int x, int y, Player p) {
    if(board[x][y] == Player.Blank)
      board[x][y] = p;
    moveMade += 1;
    if(checkWinner(x, y, p) == human) {
      System.out.println("You won!");
      System.exit(0);
    }
    if (checkWinner(x, y, p) == comp) {
      System.out.println("You lost!");
      System.exit(0);
    }

  }

  Player checkWinner(int x, int y, Player p) {
    // Row Checks
    for(int i =0; i < 3; i++) {
      if(board[x][i] != p) break;
      if(i == 2) {
        return p;
      }
    }
    return Player.Blank;
  }
}
