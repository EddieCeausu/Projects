import java.lang.Math;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.*;

public class euler {
  static double factorial(int n) {
    int total = 0;
    for(int i = n; i>0; i--) {
      total *= i;
    }
    return total;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    double number = 0;
    BigDecimal e = new BigDecimal("1");
    //Double total = 0.0;
    //BigDecimal sum = new BigDecimal();

    double count = 1.0, fact = 1.0;
    System.out.println("Java's max euler number: " + Math.E);
    System.out.println("\n How many digits would you like to calculate? ");
    double digits = scan.nextDouble();

    // Foy Method
    for(int i = 1; i <= digits*20; i++) {
      // e += 1.0 / factorial(i);
      e = e.add(new BigDecimal(Double.toString(1.0 / factorial(i))));

    }
    //BigDecimal _e = new BigDecimal(e);
    System.out.println(e);
    // Cade Method

    /*int n = 1;
    while (total < digits) {
      total += Math.log10(n);
      n++;
    }
    BigDecimal e = new BigDecimal(Double.toString(total));
    System.out.println(e + " " + total); */
  }
}
