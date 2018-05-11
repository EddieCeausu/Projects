import java.util.Scanner;

public class BaseConversion {

  static String bConversion(int q, int b) {
    int quotient = q / b;
    int remainder = q % b;
    if (quotient == 0)
      return "" + remainder;
    return "" + bConversion(quotient, b) + remainder;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter base");
    int base = scan.nextInt();
    System.out.println("Enter number");
    int number = scan.nextInt();
    System.out.println(bConversion(number, base));
  }
}
