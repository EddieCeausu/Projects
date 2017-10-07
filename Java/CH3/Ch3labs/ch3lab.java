import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Math;
import java.text.NumberFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ch3lab {

  static void println(Object line) {
    if(line == null) {
      System.out.println(" ");
    } else {
      System.out.println(line);
    }
  }

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
    println("Current Salary:       " + money.format(currentSalary));
    println("Amount of your raise: " + money.format(raise));
    println("Your new salary:      " + money.format(newSalary));
  }// end of Salary

  static void love(Scanner scan) {
    println("What is your limit?");
    double limit = scan.nextDouble();
	  int count = 1, sum = 0;

	  while (count <= limit + 1) {
	     println(count + " I love Computer Science!!");
	     count++;
    }
    for(int i = 1; i <= count - 1; i++) {
        sum += i;
    }
    println("Printed this message " + (count - 1) + " time(s). The sume of 1 to " + (count - 1) + " is " + sum);
  }// end of love

  static void Powersof2(Scanner scan) {
    int numPowersOf2;        //How many powers of 2 to compute
    int nextPowerOf2 = 1;    //Current power of
    int exponent = 0;            //Exponent for current power of 2 -- this
    double n;                  	   //also serves as a counter for the

    println("How many powers of 2 would you like printed?");
    numPowersOf2 = scan.nextInt();

        //print a message saying how many powers of 2 will be printed
        //initialize exponent -- the first thing printed is 2 to the what?

	  while (exponent <= numPowersOf2) {
      n = Math.pow((double)(2), (double)(exponent));
      println("2^" + exponent + " = " + (int)(n));
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
      println("Enter n: ");
      do {
        try {
          n = scan.nextInt();
          if(n < 0) {
            println("You cannot enter a negative number!");
            println("Enter n: ");
            n = scan.nextInt();
          } else {
            println(n + "! = " + factorial2((long)(n)));
          }
          input = false;
        } catch(InputMismatchException ex) {
            println("WRONG! You need to enter an integer ex.(1,2,3)");
            println("Enter n: ");
            scan.nextLine();
        } catch(StackOverflowError ex) {
            println("Long is too long...");
            println("Enter n: ");
            scan.nextLine();
        }
      } while(input); // end do-while
  } // end of factorial

  static void guess(Scanner scan) {
    Random random = new Random();
    int answer, guess = 0, count = 1, high = 0, low = 0;
    final int MAX = random.nextInt(100) + 1;

    answer = random.nextInt(12) + 1;
    println("Guess a number between 1 and " + 12);

    while (guess != answer) {
      guess = scan.nextInt();
      if(answer < guess) {
        high += 1;
      } else {
        low += 1;
      }
      if (guess == answer) {
        println("You got it; It took you " + count + " tries. With " + low + " low tries and " + high + " high tries.");

      } else {
        println("Nope. Try Again");
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

  static void baseballstats(Scanner scan) {// Unfinshed
    Scanner fileScan, lineScan;
    String fileName;
    int maxlines = 0;
    Boolean done = false;
    BufferedReader br = null;

    System.out.print ("Please locate the file.");
    File file = findfile();
    println("The file you chose is: " + file.getName());
    try {
      br = new BufferedReader(new FileReader(file));
      while(!done) {
      String line = br.readLine();
      //ArrayList<String> array = new ArrayList();

      }
    } catch(IOException ex) {
        ex.printStackTrace();
    }

  }

  static void maxandmin(Scanner scan, Random random) {
    final int HOURS_PER_DAY = 24;
  	int temp, response;

  	ArrayList<Integer> temps = new ArrayList<Integer>();

  	println ("\nTemperature Readings for 24 Hour Period\n");
    println ("Random(1) or Custom(2)?");
    response = scan.nextInt();
    if (response == 2) {
  	for (int hour = 0; hour < HOURS_PER_DAY; hour++) {
  	    System.out.print ("Enter the temperature reading at " + hour +
  				" hours: ");
  	    temp = scan.nextInt();
        temps.add(temp);
  	}
  }
  if (response == 1) {
    for (int hour = 0; hour < HOURS_PER_DAY; hour++) {
      temp = random.nextInt(100) + 1;
      temps.add(temp);
  	    System.out.print("Enter the temperature reading at " + hour +
  				" hours: " + temp + "\n");
  	}
  }
    int maxnr = temps.get(1), minnr = temps.get(2);
    for(int i : temps) {
      if(maxnr <= i) maxnr = i; if(minnr >= i) minnr = i;
    }
    println("Your max Temp is:" + maxnr + " Minimum Temp: " + minnr);
  }

  static void charcount(Scanner scan) {
    String phrase;
    Boolean done = false;
    int countBlank, length, space = 0;
    int chA=0, chB=0, chC=0; // ...
    // Print a program header
    println("Character Counter");

    while(!done){
      System.out.print ("\nEnter a sentence or phrase: \n");
      phrase = scan.nextLine().toUpperCase();
      if(phrase.isEmpty())
        phrase = scan.nextLine().toUpperCase();
      if(phrase.equals("QUIT")) break;
      for(int i = 0; i <= phrase.length() - 1; i++) {
        println(phrase.charAt(i));
        switch(phrase.charAt(i)) {
          case 'a':
          case 'A': chA++; break;
          case 'b':
          case 'B': chB++; break;
          case 'c':
          case 'C': chC++; break;
          // ...
          case ' ': space++; break;
        }// end switch
      }//  end for
      println("Number of blank spaces: " + space + " number of A, B, C: " + chA + " " + chB + " " + chC);
    }// end while
  }// end charcount


  public static void main(String[] args) {
    Boolean done = false;
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    while(!done) {
      println("\nChoose an option:\nSalary\t\t// Salary Lab\nLove\t\t// I love CSA lab\nPowersOf2\t// PowersOf2 lab\nFactorial\t// Factorial lab\nGuess\t\t// Guessing game lab\nBaseball Stats\t// baseballstats lab (WIP)\nTemperature\t// Max&Min Lab\ncharcount\t// Charater Count Lab\nQuit\t\t// Quit Program");

      String response = scan.next().toLowerCase();
      switch (response) {
        case "salary":
          Salary(scan);
        break;

        case "1":
          Salary(scan);
          break;

        case "love":
          love(scan);
          break;

        case "2":
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

        case "temperature":
          maxandmin(scan, random);
          break;
        case "charcount":
          charcount(scan);
          break;
        case "quit": // Quit case
          done = true;
          break;
        default: // if error, throw response so program crash
          println(response + " is not an option.");
      } // end switch
    }// end while
  }// end main
}// end class
