import java.util.Scanner;
import java.util.Random;

public class guessing {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    int answer, guess = 0, count = 0;
    String response;
    final int MAX = random.nextInt(random.nextInt((random.nextInt((random.nextInt((random.nextInt((random.nextInt((random.nextInt(100) + 1)) + 1)) + 1)) + 1)) + 1)) + 1) + 1;

    answer = random.nextInt(MAX) + 1;
    System.out.println("Guess a number between 1 and " + MAX);
    while (guess != answer) {
      guess = scan.nextInt();
      if(count < 10) {
        response = "Wow your smart!";
      } else {
        response = "Wow your an idiot!";
      }
      if (guess == answer) {
        System.out.println("You got it; " + response);

      } else {
        System.out.println("Nope"); System.out.println("Try Again");
        count += 1;
      }
    }
  }
}
