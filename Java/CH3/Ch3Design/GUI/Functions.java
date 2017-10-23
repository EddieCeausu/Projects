import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.*;
import javax.swing.JOptionPane;

public class Functions {
// Why I used FileWriter over BufferedWriter.
// FileWriter writes in one single process, while BufferedWriter writes using
// an internal buffer therefor becomes efficient when the number of writes is
// great.
// Since I am writing the entire array in one single write it is more
// efficient to write using FileWriter than BufferedWriter.

// *************************************************************
// Functional Functions
// *************************************************************

  public static void fileprint(String str, int n) {
    // init of variables for try requirement
    String FILENAME = "";
    if(n == 0) FILENAME = "ch3design.txt";
    if(n == 1) FILENAME = "ch3design-inter-lab.txt";
    FileWriter fw = null;
    BufferedWriter bw = null;

    try {
      fw = new FileWriter(FILENAME);
      bw = new BufferedWriter(fw);
      for (int i = 0; i < 100; i++) {
        bw.write("Array size: " + Ch3Design.arrayf.length + "\n\n" + str);
      }
      String hyatt = "File was written to class directory under filename: " + FILENAME;
      JOptionPane.showMessageDialog(null, hyatt);
    } catch(IOException e) {
        String greg = "Writing to file failed.";
        JOptionPane.showMessageDialog(null, greg);
      }
    finally {
        try { // close FileWriter
          fw.close();
        }
        catch(IOException e) {
          e.printStackTrace();
        }
      }
  }

    final static int searchinx(int n) {
      for(int i = 0; i < Ch3Design.arrayf.length; i++)
        if(Ch3Design.arrayf[i] == n) return i;
        return (-1); // returns -1 if number is not found
      } // function wil return index of number search

      static String consoleprint() {
        int count = 0, nrlines = 0;
        String str = new String();
        while(true){
          try {
            String strl = JOptionPane.showInputDialog("How many integers per line?");
            nrlines = Integer.valueOf(strl);
            break;
          } catch(Exception ex) { error(); }
        }
        for(int j = 0; j < Ch3Design.arrayf.length; j++) {
          str += (Ch3Design.arrayf[j] + " ");
          count++;
          if(count == nrlines) { str += "\n"; count = 0; }
        }
        return str;
      }

      static void error() {
        JOptionPane.showMessageDialog(null, "Try again");
      }

// *************************************************************
// Main methods
// *************************************************************

     public static int[] createarray(Random random) {
       int upperlimit = 0, size = 0;

       while(true) {
         try {
           String sz = JOptionPane.showInputDialog("How large will it be?");
           size = Integer.valueOf(sz);
           break;
         } catch(NumberFormatException ex) { error(); }
       } // end while 1

       while(true) {
         try {
           String ulimit = JOptionPane.showInputDialog("What is your upperlimit?");
           upperlimit = Integer.valueOf(ulimit);
           break;
        } catch(NumberFormatException ex) { error(); }
      } // end while 2
      int array[] = new int[size];
       for(int i = 0; i < array.length; i++) { // cycle through array
         array[i] = random.nextInt(upperlimit) + 1; // creation of number using random class
       }
       return array;
   } // end createarray

    final static void printarray() {
      String str;// prints array to either console or File
      int response = JOptionPane.showConfirmDialog(null, "Would you like to print to a New File?", null, JOptionPane.YES_OPTION);
      str = consoleprint();
      if(response == JOptionPane.NO_OPTION) {
        System.out.println(str + "\n Array size: " + Ch3Design.arrayf.length);
        JOptionPane.showMessageDialog(null, "check the console");
      }
      else fileprint(str, 0);
    } // end printarray

    final static void SearchNr() { // searches through array for number
      int count = 0, response = 0;
      String wmessage = "";
      while(true) {
        try {
          String res = JOptionPane.showInputDialog("What number are you looking for?");
          response = Integer.valueOf(res);
          break;
        } catch(Exception ex) { error(); }
      } // end while
        for(int i = 0; i < Ch3Design.arrayf.length; i++)
          if(Ch3Design.arrayf[i] == response) { // if i = search value
            wmessage += response + " was found at index: " + i + " "; // adds to total string to print out.
            count++;
        }
        JOptionPane.showMessageDialog(null, wmessage);
        String message = response + " was found a total of " + count + " time(s).";
        JOptionPane.showMessageDialog(null , message);
    } // end SearchNr

    final static void interlab(DecimalFormat df) { // prints values and indexes from a range
      int lowerLimit = 0, upperLimit = 0, sum = 0;
      Boolean done = false, done2 = false;
      int a[] = new int[(Ch3Design.arrayf.length / 2) - 1];
      int b[] = new int[Ch3Design.arrayf.length / 2];
      String str = "";

      // Scan for lowerlimit with dummy proof
      while(!done) {
        try {
          String lw = JOptionPane.showInputDialog("Please enter the lower limit between 1 & " +  (Ch3Design.arrayf.length / 2));
          lowerLimit = Integer.valueOf(lw);
          if((lowerLimit > (Ch3Design.arrayf.length / 2)) || (lowerLimit < 1)) error(); // dummy proof
          else done = true;
        } catch(NumberFormatException e) { error(); }
      }

      // Scan for upperlimit with dummy proof
      while(!done2) {
        try{
          String uw = JOptionPane.showInputDialog("Please enter the upper limit between " + ((Ch3Design.arrayf.length / 2) + 1) + " & " + Ch3Design.arrayf.length);
          upperLimit = Integer.valueOf(uw);
          if((upperLimit > Ch3Design.arrayf.length) || (upperLimit < ((Ch3Design.arrayf.length / 2) + 1))) error(); // dummy proof
          else done2 = true;
        } catch(NumberFormatException e) { error(); }
      }

      // for loop searches through limits
      if(lowerLimit % 2 == 0)
      for(int i = lowerLimit; i <= upperLimit; i += 2) {
        str += "index: " + i + " | value: " + Ch3Design.arrayf[i] + " | sqrt: " + df.format((Math.sqrt((double)(Ch3Design.arrayf[i])))) + "\n";
        sum += Ch3Design.arrayf[i];
      }

      int response = JOptionPane.showConfirmDialog(null, "Would you like to print the range to a file?", null, JOptionPane.YES_OPTION);
      if(response == JOptionPane.NO_OPTION){
        JOptionPane.showMessageDialog(null, "\ncheck the console\n");
        System.out.println("\n" + str);
      } else fileprint(str, 1);

      str = "Sum of values from index " + lowerLimit + " to " + upperLimit + " is: " + sum;
      JOptionPane.showMessageDialog(null, str);
    } // end Intermediate Lab

    final static void enhlab() { // prints max and min value
      int max = Ch3Design.arrayf[0], min = Ch3Design.arrayf[0];
        for(int i = 0; i < Ch3Design.arrayf.length; i++) {
          if(min >= Ch3Design.arrayf[i]) min = Ch3Design.arrayf[i];
          if(max <= Ch3Design.arrayf[i]) max = Ch3Design.arrayf[i];
        }
        String wmessage = "Max value is: " + max + " | index: " + searchinx(max);
        wmessage += " Min value is: " + min + " | index: " + searchinx(min);
        JOptionPane.showMessageDialog(null, wmessage);
    } // end Enhanced Lab

} // end class
