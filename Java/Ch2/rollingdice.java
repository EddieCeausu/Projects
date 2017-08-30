import java.util.Random;
public class rollingdice {
  public static void main(String[] args) {
    Random random = new Random();
    int x = random.nextInt(6) + 1;
    int y = random.nextInt(6) + 1;
    System.out.println("Your rolled dice: " + x + " & " + y);
    System.out.println("Your total roll: " + (x + y));
  }
}
