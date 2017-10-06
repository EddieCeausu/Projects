import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ch3DesignGUI extends JFrame {

  public final JLabel createL, printAL, searchL, interL, enhanL;
  public final JButton printAB, createB, searchB, interB, enhanB;
  public static int arrayf[] = new int[1000];

  // *************************************************************
  // Graphic user interface
  // *************************************************************

  public Ch3DesignGUI(DecimalFormat df, Random random) {
    Boolean done = false;

    setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20)); // init FlowLayout

    createL = new JLabel("Create Array");
    createB = new JButton("Start");
    add(createL);
    add(createB);

    printAL = new JLabel("Print Array");
    printAB = new JButton("Start");
    add(printAL);
    add(printAB);

    searchL = new JLabel("SearchNr");
    searchB = new JButton("Start");
    add(searchL);
    add(searchB);

    interL = new JLabel("Intermediate Lab");
    interB = new JButton("Start");
    add(interL);
    add(interB);

    enhanL = new JLabel("Enhanced Lab");
    enhanB = new JButton("Start");
    add(enhanL);
    add(enhanB);

    setEnabled(false);
    setEnabled(true);


    // Button Listeners
    createB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event){
        arrayf = createarray(random);
    }
  });

    printAB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
          printarray();
      }
    });

    searchB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        SearchNr();
      }
    });

    interB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        interlab(df);
      }
    });

    enhanB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        enhlab();
      }
    });

  }// end GUI

// *************************************************************
// functional functions
// *************************************************************

public static void fileprint() {
  final String FILENAME = "ch3design.txt";
  BufferedWriter bw = null;
  FileWriter fw = null;

  try {
    fw = new FileWriter(FILENAME);
    bw = new BufferedWriter(fw);
    bw.write(consoleprint());

    String str = "File was written to class directory under filename: " + FILENAME;
    JOptionPane.showMessageDialog(null, str);
  } catch(IOException e) {
      String str = "Writing to file failed.";
      JOptionPane.showMessageDialog(null, str);
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

  final static int searchinx(int n) {
    for(int i = 0; i < arrayf.length; i++)
      if(arrayf[i] == n) return i;
      return (-1); // returns -1 if number is not found
    } // function wil return index of number search

    static String consoleprint() {
      int count = 0;
      String str = new String();
      String strl = JOptionPane.showInputDialog("How many integers per line?");
      int nrlines = Integer.valueOf(strl);

      for(int j = 0; j < arrayf.length; j++) {
        str += (arrayf[j] + " ");
        count++;
        if(count == nrlines) { str += "\n"; count = 0; }
      }
      return str;
    }

// *************************************************************
// Main methods
// *************************************************************

   public static int[] createarray(Random random) {
     int upperlimit = 0;
     int[] array = arrayf;
     while(true) {
       try {
         String ulimit = JOptionPane.showInputDialog("What is your upperlimit?");
         upperlimit = Integer.valueOf(ulimit);
         break;
       } catch(Exception e) {
         if(upperlimit > 0)
           JOptionPane.showMessageDialog(null, "Try again");
          else
         JOptionPane.showMessageDialog(null, "Number must be greater than 0");
       }
     }
     for(int i = 0; i < array.length; i++) { // cycle through array
       array[i] = random.nextInt(upperlimit) + 1; // creation of number
     }
     return array;
 }

  final static void printarray() { // prints array to either console or File
      int response = JOptionPane.showConfirmDialog(null, "Would you like to print to a New File?", null, JOptionPane.YES_OPTION);
      if(response == JOptionPane.NO_OPTION) {
        String str = consoleprint();
        JOptionPane.showMessageDialog(null, str);
      }
      if(response == JOptionPane.YES_OPTION) fileprint();
    }// end printarray

  final static void SearchNr() { // searches through array for number
    int count = 0;
    String wmessage = "";

    String res = JOptionPane.showInputDialog("What number are you looking for?");
    int response = Integer.valueOf(res);
      for(int i = 0; i < arrayf.length; i++)
        if(arrayf[i] == response) {
          wmessage += (response + " was found at index: " + i);
          count++;
      }
      JOptionPane.showMessageDialog(null, wmessage);
      String message = response + " was found a total of " + count + " time(s).";
      JOptionPane.showMessageDialog(null , message);
  } // end SearchNr

  final static void interlab(DecimalFormat df) { // prints values and indexes from a range
    int lowerLimit = 0, upperLimit = 0;
    Boolean done = false, done2 = false;
    String str = "";
    // Scan for lowerlimit with dummy proof
    while(!done){
    String lw = JOptionPane.showInputDialog("Please enter the lower limit between 1 & 500");
    lowerLimit = Integer.valueOf(lw);
    if((lowerLimit > 500) || (lowerLimit < 1)) JOptionPane.showMessageDialog(null, "Try again"); // dummy proof
    else done = true;
  }
    // Scan for upperlimit with dummy proof
    while(!done2){
    String uw = JOptionPane.showInputDialog("Please enter the upper limit between 501 & " + arrayf.length);
    upperLimit = Integer.valueOf(uw);
    if((upperLimit > 1000) || (upperLimit < 501)) JOptionPane.showMessageDialog(null, "Try again"); // dummy proof
    else done2 = true;
  }
    int sumarr[] = new int[lowerLimit + upperLimit];
    // for loop searches through limits
    for(int i = lowerLimit; i <= upperLimit; i++){
      str += ("index: " + i + " | value: " + arrayf[i] + "| sqrt: " + df.format((Math.sqrt((double)(arrayf[i])))) + "\n");

      for(int j = 0; j < sumarr.length; j++) sumarr[j] = arrayf[i];
    }
    JOptionPane.showMessageDialog(null, str);
    int sum = IntStream.of(sumarr).sum();
    str = "Sum of values from index " + lowerLimit + " to " + upperLimit + " is: " + sum;
    JOptionPane.showMessageDialog(null, str);
  } // end Intermediate Lab

  final static void enhlab() {// prints max and min value
    int max = arrayf[0], min = arrayf[0];
      for(int i = 0; i < arrayf.length; i++) {
        if(min >= arrayf[i]) min = arrayf[i];
        if(max <= arrayf[i]) max = arrayf[i];
      }
      String wmessage = "Max value is: " + max + " | index: " + searchinx(max);
      wmessage += " Min value is: " + min + " | index: " + searchinx(min);
      JOptionPane.showMessageDialog(null, wmessage);
  } // end Enhanced Lab

// *************************************************************
// Main
// *************************************************************

  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("###.###");
    Random random = new Random();

    Ch3DesignGUI frame = new Ch3DesignGUI(df, random);
    frame.setTitle("Chapter 3 Design Lab");
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(550,150);
    frame.getContentPane();
    frame.setBackground(Color.LIGHT_GRAY);
    frame.setVisible(true);
    }// end main

}// end ch3design
