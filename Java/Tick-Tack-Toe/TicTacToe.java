import java.io.Console;
public class TicTacToe {
  public static Console console = System.console();

  void TwoPlayer() {

  }

   public static void main(String[] args) {
     Board b;
     System.out.println("Welcome to TicTacToe\nWould you like to select a player or have one chosen for you?\n Select\t1\nRandom\t2\nEnter Option: ");
     String input = console.readLine();
     int input1 = Integer.parseInt(input);
     if(input1 == 1) {
       input = console.readLine("Would you like to be X or O");
       b = new Board(input.toCharArray()[0]);
     }
     else b = new Board();
   }
}
