import java.io.IOException;
import java.util.Scanner;
// TODO: Give to Jakob to find bugs
// TODO: MAKE THAT BOT

class TicTacToe {
  public static Scanner scan = new Scanner(System.in);
  static Board b;
  static TTAI ai;

  static void TwoPlayer() {
    String move;
    for(Board.Player p : b.getMoveList()) {
      System.out.println(b);
      while (true) {
        System.out.println("Enter move: ");
        move = scan.next();
        if (b.canMove(move))
          break;
      }
      b.move(move, b.movesMade);
    }
  }

  static void singlePlayer() {
    String moveU;
    for (Board.Player p : b.getMoveList()) {
      System.out.println(b);
      if (p != b.getPlayerAI())
        while (true) {
          System.out.println("Enter move: ");
          moveU = scan.next();
          if (b.canMove(moveU))
            break;
        }
      else {
        ai.getNextMove();
        moveU = ai.toString();
        System.out.println(moveU);
      }
      b.move(moveU, b.movesMade);
    }
  }

  public static void main(String[] args) {
    String input;
    int temp;
    while (true) {
      System.out.println("Welcome to TicTacToe!\nOne Player (1)\nTwo Player (2): ");

      while (true) {
        input = scan.next();
        try {
          temp = Integer.parseInt(input);
          break;
        } catch (NumberFormatException ex) {
          System.out.println("Not an option\nTry again: ");
        }
      }

      switch (temp) {
      case 1:
        while (true) {
          System.out.println("Would you like to be X or O: ");
          input = scan.next();
          if ("x".equalsIgnoreCase(input.replaceAll("\\s+", ""))) {
            b = new Board('x');
            break;
          } else if ("o".equalsIgnoreCase(input.replaceAll("\\s+", ""))) {
            b = new Board('o');
            break;
          } else
            System.out.println("Not a valid input");
        }
        ai = new TTAI(b);
        singlePlayer();
      case 2:
        b = new Board();
        TwoPlayer();
        break;
      default:
        System.err.println("Not an option\n");
        break;
      }// end switch
    } // end while
  }
}
