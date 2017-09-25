import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Math;
import java.text.NumberFormat;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ch3lab {

  static void Salary(Scanner scan) {
    double currentSalary, raise = 0, newSalary;
    String rating;
    Boolean done = false;
    System.out.print ("Enter the current salary: ");
    currentSalary = scan.nextDouble();
    System.out.print ("Enter the performance rating (Excellent, Good, or Poor): ");
    rating = scan.next().toLowerCase();
    // Switch & while statement controlling output
    while (!done) {
      switch (rating) {
        case "excellent":
          raise = currentSalary * 0.06;
          done = true;
          break;

        case "good":
          raise = currentSalary * 0.04;
          done = true;
          break;

        case "poor":
          raise = currentSalary * 0.015;
          done = true;
          break;

        default:
          throw new IllegalArgumentException("Invalid performance rating: " + rating);
      }// end switch
    }// end while

    newSalary = currentSalary + raise;

    // end
    NumberFormat money = NumberFormat.getCurrencyInstance();
    // Print the results
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

  static long factorial2(long n) {
    if (n == 0) {
      return 1;
    } else {
      return n * factorial2(n-1);
    }
  }

  static void factorial(Scanner scan) {
      int sum = 1, n;
      Boolean input = true;
      System.out.println("Enter n: ");
      do {
        try {
          n = scan.nextInt();
          if(n < 0) {
            System.out.println("You cannot enter a negative number!");
            n = scan.nextInt();
          } else {
            System.out.println(n + "! = " + factorial2((long)(n)));
          }
          input = false;
        } catch(InputMismatchException ex) {
            System.out.println("WRONG! You need to enter an integer ex.(1,2,3)");
            scan.nextLine();
        }
      } while(input); // end do-while
  } // end of factorial

  static void guess(Scanner scan) {
    Random random = new Random();
    int answer, guess = 0, count = 0;
    String response;
    final int MAX = random.nextInt(100) + 1;

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
    }// end while
  }// end guess

  static File findfile() {
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "CSV files", "csv");
    chooser.setCurrentDirectory(new File("."));
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(chooser);
    File file = chooser.getSelectedFile();
    return file;
  }

  static void baseballstats(Scanner scan) {
    Scanner fileScan, lineScan;
    String fileName;
    int maxlines = 0;
    Boolean done = false;
    BufferedReader br = null;
    System.out.print ("Please locate the file.");
    File file = findfile();
    System.out.println("The file you chose is: " + file.getName());
    try {
      br = new BufferedReader(new FileReader(file));
      while(!done) {
      //  String line = br.readLine();

      }
    } catch(IOException ex) {
        ex.printStackTrace();
    }

  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Boolean done = false;
    System.out.println("Choose an option:\nSalary\t\t// Salary Lab\nLove\t\t// I love CSA lab\nPowersOf2\t// PowersOf2 lab\nFactorial\t// Factorial lab\nGuess\t\t// Guessing game lab\nBaseball Stats\t// baseballstats lab\nQuit\t\t// Quit Program");
    String response = scan.next().toLowerCase();
    while(!done)
    {
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

        case "factorial":
          factorial(scan);
          break;

        case "guess":
          guess(scan);
          break;

        case "baseball stats":
          baseballstats(scan);
          break;

          case "quit": // Quit case
          done = true;
          break;

        default: // if error, throw response so program doesnt crash
          throw new IllegalArgumentException(response + " is not an option.");
      } // end switch
    }// end while
  }// end main
}// end class
