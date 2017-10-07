/************************************************
 *  File:		Ch3Demo
 *  Author:		J.Foy
 *  Created:	7/14/2015
 *  Demos several Chapter 3 concepts
 *  Revision History
 *  	Rev 0:	Initial Release
 *      Rev 1:  Modified 8/3/2015 to include logical operators
 *      Rev 2:  Modified 8/31/2016 to include additional explorations
 *
 */

//  Explorations:
//  Number 1: Run the program, as is.  Answer yes for GPA
//  Number 2: Run the program, as is.  Answer no for GPA.  Does the program work the way you expect?
//  Number 3: rerun with a different number of courses
//  Number 4: What happens if you change the declaration
//     double sumgrades = 0.0 to double sumgrades?
//  Number 5: comment out the line done = answer.equals, rerun code.
//     It is just before the closing bracket for while loop. What happens now?
//  Number 6: What happens if you enter "Yes" or "YES" to responses to prompts listed in lines
//     87 - 105?  If the code does not work as you intend, change it
//  Number 7: Inside the "for (x = 0; x < nrcourses - 1...) brackets, add the following
//     line of code: x = x + 1.  Rerun the code, does it behave the same?
//  Number 8: Using the logic in the complex "if" statement at the bottom of "main", add
//     logic that determines if you may drop your lowest 100 point grade.  The Knox County
//     rule for this is: if you are not a senior and you have a "C" or better and you have
//     two or less absences, you can drop your lowest 100 point grade.  Write a statement
//     that tells if a student is eligible for this, or not.
//

import java.util.*;
import java.util.Scanner;

public class Ch3Demo
{
	public static void main(String[] args)
	{
	boolean done = false;
	boolean intgpa = false;
	int nrcourses = 1;
	int x;
	String answer, course;
	double gpa = 0.0;
	double sumgrades =0.0;

	// next two lines are arrays, will learn in Chapter 6
	int[] grades = new int[8];
	String[] classes = new String[8];

	Scanner invalue = new Scanner(System.in);

	x = 0;
	// while statement: pages 136 - 146
	while (!done)
	{
	 System.out.print("Enter name of course: ");
	 course = invalue.next();
	 classes[x] = course;
	 System.out.print("\nEnter grade ");
	 grades[x] = invalue.nextInt();
	 nrcourses++;
	 sumgrades = sumgrades + grades[x];
	 x++;
	 answer = "";
	 System.out.print("Are you done (Yes or No): ");
	 answer = invalue.next();
	 answer.toLowerCase();

	 // comment out the following line for Exploration number 5
	 done = answer.equals("yes");
	}  // end of while loop

	System.out.println("\nCourse\t\t Grade");

	// Number 7 code
	for (x=0; x< nrcourses-1; x++)
	{
	 System.out.println(classes[x] + "\t\t" + grades[x]);
	} // end of for loop
	System.out.print("Do you want to calculate GPA? (Enter 0 for no, 1 for yes) ");
	x = invalue.nextInt();

	// if statement: pages 121 - 130
	if (x > 0)
	{
	  gpa = sumgrades/(nrcourses - 1);
	}  // end of if x > 0

	System.out.println("GPA is " + gpa);

	// Exploration Number 6....
	System.out.println("Final Exam Exemption Decision...");
	boolean takingAPtest = false;
	boolean senior = false;
	boolean nrabsences = false;
	boolean goodgrade = false;
	int absent = 5;

	System.out.print("\n Are you taking the AP test? (yes or no)? ");
	String instring = invalue.next();
	takingAPtest = instring.equals("yes");
	System.out.print("\n Are you a senior (yes or no)? ");
	instring = invalue.next();
	senior = instring.equals("yes");
	System.out.print("\n How many absences do you have? ");
	absent = invalue.nextInt();
	nrabsences = (absent <= 2);
	System.out.print("\n Is your grade 75 or better (yes or no)? ");
	instring = invalue.next();
	goodgrade = instring.equals("yes");

	// Number 8: Use next line as a pattern to write logic for dropping lowest
	// 100 point grade, write the new if statement after these lines
	if ((senior && goodgrade && nrabsences) || takingAPtest)
	 System.out.println("\n You are exempt from the final exam.");
	 else System.out.println("\n You are not exempt from the final exam. ");
	 if (!senior && goodgrade && nrabsences) {
		 System.out.println("You can drop your lowest 100 point grade.");
	 }
	} // end of main
} // end of class
