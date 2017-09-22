import java.util.Scanner;
import java.util.Random;
public class loop {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    while(true) {
      String response = "";
      System.out.println("Would you like a Set or Random amount of rows");
      response = scan.next();
      response.toLowerCase();
      if((response == "set amount") || (response == "set"));
      String hash = "#";

      System.out.println("How many rows?");
      int max_rows = scan.nextInt();

      for(int row = 1; row <= max_rows; row++) {
          for(int i = 1; i <= row; i++) {
            System.out.print(hash);
          }
          System.out.println("");
          }
      for(int brow = 1; brow <= max_rows; brow--) {
      for(int j = 1; j <= brow; j--) {
        System.out.print(hash);
      }
        System.out.print("");
      }

      if((response == "random amount") || (response == "random"));
        // random();
    }

  }
}
