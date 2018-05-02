
// ****************************************************************
// Sales.java
//
// Reads in and stores sales for each of 5 salespeople.  Displays
// sales entered by salesperson id and total sales for all salespeople.
//
// ****************************************************************
import java.util.Scanner;

public class sales {
  public static void main(String[] args) {
    final int SALESPEOPLE = 5;
    int[] sales = new int[SALESPEOPLE];
    int sum;

    Scanner scan = new Scanner(System.in);

    for (int i = 0; i < sales.length; i++) {
      System.out.print("Enter sales for salesperson " + i + ": ");
      sales[i] = scan.nextInt();
    }

    System.out.println("\nSalesperson   Sales");
    System.out.println("--------------------");
    sum = 0;
    for (int i = 0; i < sales.length; i++) {
      System.out.println("     " + (i + 1) + "         " + sales[i]);
      sum += sales[i];
    }

    System.out.println("\nTotal sales: " + sum + "\nAverage is " + (sum / sales.length));
    int max = sales[0], index = 0, min = sales[0], index2 = 0, i;
    for (i = 0; i < sales.length; i++) {
      if (sales[i] > max) {
        max = sales[i];
        index = i;
      }
      if (sales[i] < min) {
        min = sales[i];
        index2 = i;
      }
    }
    System.out.println("salesperson " + (index + 1) + " had the highest sales with " + max + " in revenue");
    System.out
        .println("salesperson " + (index2 + 1) + " had the lowest sales with " + min + " in revenue\nEnter a value: ");
    int input = scan.nextInt(), count = 0;
    for (i = 0; i < sales.length; i++)
      if (sales[i] > input) {
        count++;
        System.out.println("Sales person " + (i + 1) + " exceeded this value with " + sales[i] + " in sales");
      }
    System.out.println("Number of salespeople who exceeded this value is: " + count);
  }
}
