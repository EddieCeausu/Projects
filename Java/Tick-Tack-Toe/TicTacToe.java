import java.io.IOException;
import java.util.Scanner;
// TODO: Give to Jakob to find bugs
// TODO: MAKE THAT BOT

public class TicTacToe {
  public static Scanner scan = new Scanner(System.in);
  static Board b;

  static void TwoPlayer() {
    String move;
    int check;
    while (b.movesMade < 9) {
      b.print();
      while (true) {
        System.out.println("Enter move: ");
        move = scan.next();
        if (play(move)[0] != -1)
          break;
      }
      if (b.movesMade % 2 == 0) {
        check = b.move(play(move)[0], play(move)[1], b.movesMade);
        if (check < 0)
          b.movesMade--;
      } else {
        check = b.move(play(move)[0], play(move)[1], b.movesMade);
        if (check < 0)
          b.movesMade--;
      }
    }
  }

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

  public static void main(String[] args) {
    int input;
    while (true) {
      System.out.println("\nWelcome to TicTacToe!\nOne Player (1)\nTwo Player (2): ");
      input = scan.nextInt();

      switch (input) {
      case 1:
        System.out.println(
            "Would you like to select a player or have one chosen for you?\n Select\t1\nRandom\t2\nEnter Option: ");
        input = scan.nextInt();
        if (input == 1) {
          System.out.println("Would you like to be X or O: ");
          String inp = scan.next();
          b = new Board(inp.toCharArray()[0]);
        } else
          b = new Board();
        break;
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
