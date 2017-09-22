import java.lang.Math;
import java.util.Scanner;
import java.text.NumberFormat;
public class ch3lab {
  
  static void Salary(Scanner scan) {
    double currentSalary;  // employee's current  salary
    double raise;          // amount of the raise
    double newSalary;      // new salary for the employee
    String rating;         // performance rating

    System.out.print ("Enter the current salary: ");
    currentSalary = scan.nextDouble();
    System.out.print ("Enter the performance rating (Excellent, Good, or Poor): ");
    rating = scan.next().toLowerCase();

    switch (rating) {
      case "excellent":
        raise = currentSalary * 0.06;
      break;
      case "good":
        raise = currentSalary * 0.04;
      break;
      case "poor":
        raise = currentSalary * 0.015;
      break;
      default:
        throw new IllegalArgumentException("Invalid performance rating: " + rating);
    }

    newSalary = currentSalary + raise;

    // Print the results
    NumberFormat money = NumberFormat.getCurrencyInstance();
    System.out.println();
    System.out.println("Current Salary:       " + money.format(currentSalary));
    System.out.println("Amount of your raise: " + money.format(raise));
    System.out.println("Your new salary:      " + money.format(newSalary));
    System.out.println();
  }// end of Salary

  static void love(Scanner scan) {
    System.out.println("What is your limit?");
    double limit = scan.nextDouble();
	  int count = 0, sum = 0;

	  while (count <= limit) {
	     System.out.println(count + " I love Computer Science!!");
	     count++;
    }
    for(int i = 1; i <= count - 1; i++) {
        sum += i;
    }
    System.out.println("Printed this message " + (count - 1) + " time(s). The sume of 1 to " + (count - 1) + " is " + sum);
  }// end of love

  static void Powersof2(Scanner scan) {
    int numPowersOf2;        //How many powers of 2 to compute
    int nextPowerOf2 = 1;    //Current power of
    int exponent = 0;            //Exponent for current power of 2 -- this
    double n;                  	   //also serves as a counter for the

    System.out.println("How many powers of 2 would you like printed?");
    numPowersOf2 = scan.nextInt();

        //print a message saying how many powers of 2 will be printed
        //initialize exponent -- the first thing printed is 2 to the what?

	  while (exponent <= numPowersOf2) {
      n = Math.pow((double)(2), (double)(exponent));
      System.out.println("2^" + exponent + " = " + (int)(n));
	    exponent++;
    }
  }// end of PowersOf2

  static void factorial(Scanner scan) {

  } // end of factorial
  public static void main(String[] args) {
    System.out.println("Choose an option:\nSalary\tlove\nPowersOf2");
    Scanner scan = new Scanner(System.in);
    String response = scan.next().toLowerCase();
    switch (response) {
      case "salary":
        Salary(scan);
      break;

      case "love":
        love(scan);
        break;
      case "powersof2":
        Powersof2(scan);
        break;
      default:
        throw new IllegalArgumentException(response + " is not an option.");
    } // end switch
  }// end main
}// end class
