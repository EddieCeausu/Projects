import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.*;

public class ch3design {

// *************************************************************
// Not design lab essential
// *************************************************************

public static void fileprint(int[] array, Scanner scan) {
  final String FILENAME = "ch3design.txt";
  BufferedWriter bw = null;
  FileWriter fw = null;

  try {
    fw = new FileWriter(FILENAME);
    bw = new BufferedWriter(fw);
    bw.write(consoleprint(array, scan));

    System.out.println("File was written to class directory under filename: " + FILENAME);
  } catch(IOException e) {
      System.out.println("Writing to file failed.");
    }
  finally {
      try {
        bw.close();
        fw.close();
      }
      catch(IOException e) {
        e.printStackTrace();
      }
    }
}

  final static int searchinx(int[] array, int n) {
    for(int i = 0; i < array.length; i++)
      if(array[i] == n) return i;
      return (-1); // returns -1 if number is not found
    } // function wil return index of number search

    static String consoleprint(int[] array, Scanner scan) {
      int[] intarray = array;
      int count = 0;
      String str = new String();
      System.out.println("How many integers per line?");
      int nrlines = scan.nextInt(); System.out.println(" ");

      for(int j = 0; j < intarray.length; j++) {
        str += (intarray[j] + " ");
        count++;
        if(count == nrlines) { str += "\n"; count = 0; }
      }
      return str;
    }

// *************************************************************
// Main methods
// *************************************************************

   static int[] createarray(Scanner scan, Random random) {
    int array[] = new int[1000]; //init of array

    System.out.println("What is your upperlimit?");
    int upperlimit = scan.nextInt();
    for(int i = 0; i < array.length; i++) {// cycle through array
      array[i] = random.nextInt(upperlimit) + 1; // creation of number
    }
    return array;
  }

  final static void printarray(int[] array, Scanner scan) {
    System.out.println("Would you like to print to a new file(NF) or to the console(C).");
    String response = scan.next();

    if("c".equalsIgnoreCase(response)) {
      String str = consoleprint(array, scan);
      System.out.println(str);
    }
    if("nf".equalsIgnoreCase(response)) fileprint(array, scan);
}

  final static void SearchNr(int[] array, Scanner scan) {
    int count = 0;
    System.out.println("What number are you looking for?");
    int response  = scan.nextInt();
    System.out.println("\n");
      for(int i = 0; i < array.length; i++)
        if(array[i] == response) {
          System.out.println(response + " was found at index: " + i);
          count++;
      }
      System.out.println(response + " was found a total of " + count + " time(s).");
  }

  final static void interlab(int[] array, Scanner scan, DecimalFormat df) {
    int lowerLimit = 0, upperLimit = 0;
    Boolean done = false, done2 = false;
    // Scan for lowerlimit with dummy proof
    while(!done){
    System.out.println("Please enter the lower limit between 1 & 500");
    lowerLimit = scan.nextInt();
    if((lowerLimit > 500) || (lowerLimit < 1)) System.out.println("Try again"); // dummy proof
    else done = true;
  }
    // Scan for upperlimit with dummy proof
    while(!done2){
    System.out.println("Please enter the upper limit between 501 & " + array.length);
    upperLimit = scan.nextInt();
    if((upperLimit > 1000) || (upperLimit < 501)) System.out.println("Try again."); // dummy proof
    else done2 = true;
  }
    int sumarr[] = new int[lowerLimit + upperLimit];
    // for loop searches through limits
    for(int i = lowerLimit; i <= upperLimit; i++){
      System.out.println("index: " + i + " | value: " + array[i] + "| sqrt: " + df.format((Math.sqrt((double)(array[i])))));
      for(int j = 0; j < sumarr.length; j++) sumarr[j] = array[i];
    }
    int sum = IntStream.of(sumarr).sum();
    System.out.println("Sum of values from index " + lowerLimit + " to " + upperLimit + " is: " + sum);
  }

  final static void enhlab(int[] array, Scanner scan) {
    int max = array[0], min = array[0];
      for(int i = 0; i < array.length; i++) {
        if(min >= array[i]) min = array[i];
        if(max <= array[i]) max = array[i];
      }
      System.out.println("Max value is: " + max + " | index: " + searchinx(array, max));
      System.out.println("Min value is: " + min + " | index: " + searchinx(array, min));
  }

// *************************************************************
// Main
// *************************************************************

  public static void main(String[] args) {
      //Global variable initialzation
      int arrayf[] = new int[1000];
      Scanner scan = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("###.###");
      Random random = new Random();
      Boolean done = false;
      System.out.println("Welcome to Chapter 3 design lab. A fully functional java program.");

      while(!done) { // main while loop
        System.out.println("\nPlease select an option: ");
        System.out.println("Create array\t\t1");
        System.out.println("Printarray\t\t2");
        System.out.println("SearchNr\t\t3");
        System.out.println("Intermediate lab\t4");
        System.out.println("Enhanced Lab\t\t5");
        System.out.println("Quit\t\t\t6");
        int response = scan.nextInt();
        System.out.println(" ");
        // Switch case with methods prefered over while loop. This prevents
        // errors with SearchNr and the Intermediate Lab.
        switch(response) {

          case 1:
            arrayf = createarray(scan, random);
            break;

          case 2:
            printarray(arrayf, scan);
            break;

          case 3:
            SearchNr(arrayf, scan);
            break;

          case 4:
            interlab(arrayf, scan, df);
            break;

          case 5:
            enhlab(arrayf, scan);
            break;

          case 6:
            System.out.println("Good-Bye!");
            done = true;
            break;

          default:
            System.out.println("Not an option; Try again.");

        }// end switch;
      } //end while

    }// end main

}// end ch3design
