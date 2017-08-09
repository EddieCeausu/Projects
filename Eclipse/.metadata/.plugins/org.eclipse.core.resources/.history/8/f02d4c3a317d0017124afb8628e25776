/************************************************
 *  File:		Ch2Demo
 *  Author:		J.Foy
 *  Date:		8/2017
 *  Demos several Chapter 2 concepts
 *  Revision History
 *  	Rev 0:	Initial Release
 *      1:  Modified for school year 2017
 */

//  Explorations:
//  Nr 0: change the author and date above to your name and today's date
//  Nr 1:  Run the code a few times so that you are familiar with what it does.
//  Nr 2:  Notice that the line "Course Name Final Grade" is printed multiple times.  Modify the code so that
//         it is only printed once.
//  Nr 3:  For the final prompt about average, try answering with different versions of "yes" and "no", i.e.
//         Yes, YES, yes, No, NO, no.  Does code behave the same way for intended response?
//  Nr 4:  The rows of course names and grades are not aligned when the group is printed out.  Experiment with
//         the tab escape character found in Figure 2.3 on page 60 to make them align
//  Nr 5:  Using example Listing 2.10 on page 87, modify the grade random number generator found in line 74 so
//         that it creates grades in the range of 85 to 100.
//  Nr 6:  Change the double forward slash at the beginning of the next line to /*, and notice what happens
//  Nr 7:  What happens if you enter the number 0 in response to the denominator prompt?
//  Nr 8:  For the last set of prompts (numerator, denominator), is the number what you expect?
//

import java.util.*;
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

public class Ch2Demo
{

	public static void main(String[] args)

	{

	String course, response;
	int nrApHonors = 1;
	int i, x, y, z, average;
	int sum = 0;
	// Following are array declarations.  Arrays are found in textbook chapter 6
	String[] cnames = new String[8];
	double[] finalgrades = new double[8];

	// Random class introduced on pages 85 - 87
    Random rgen = new Random();
    DecimalFormat fmt = new DecimalFormat("##.##");

	// First position in an array is at location 0, not location 1
	for (i = 0; i < 8; i++)
	{
		cnames[i] = "";
	} // end of initialization for loop

	// Scanner class: see pages 89 - 91
	 Scanner invalue = new Scanner(System.in);
	 System.out.print("How many AP and Honors courses are you taking this year? ");
	 nrApHonors = invalue.nextInt();
	 System.out.println("nrAPHonors = " + nrApHonors);
	 System.out.println();

	 // for loops are found in textbook chapter 3
	 for (i = 0; i < nrApHonors; i++)
	 {
		System.out.print("Enter Course name (8 characters or less): ");
		course = invalue.next();
		cnames[i] = course;
	// the backslash-n is an escape sequence.  See textbook Figure 2.3 on page 60
		System.out.print("\n");
	 }  // end of for loop

	 //  random method in Math class is listed in Figure 2.12 on page 88
     for (i = 0; i< nrApHonors; i++)
     {
    	finalgrades[i] = 100 * Math.random();
     }  // end of random loading

    for (i = 0; i < nrApHonors; i++)
    {
     System.out.println(" Course Name    Final Grade");
  // See example in textbook on page 94, format method is listed
  // on page 95, Figure 2.15
     System.out.println("  " + cnames[i] + "  " + fmt.format(finalgrades[i]));
    } // end of print out

    // integer math is different than in your math classes
    sum = 6 + 6 + 8;
    average = sum / 3;
    System.out.println("Average of integers 6, 6 and 8 is " + average);

    // String methods listed in Figure 2.5 on page 78
    System.out.print("Is this correct? (Enter yes or no) ");
    response = invalue.next();

    // if statement is described in Chapter 3
    if (response.equals("NO"))
     System.out.println("OK they are not equal");
    else
     System.out.println("OK, I guess they are equal");

    // Exploration 7
    System.out.println("Enter Numerator value: ");
    x = invalue.nextInt();
    System.out.println("Enter Denominator value: ");
    y = invalue.nextInt();
    System.out.println("Numerator divided by denominator is " + (x/y));

	} // end of main

}  // end of class
