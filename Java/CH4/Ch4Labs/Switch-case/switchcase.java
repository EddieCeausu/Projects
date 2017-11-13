/************************************************
 *  File:		Switch Case Demo
 *  Author:		J.Foy
 *  Created:	7/22/2015
 *  Demos Switch Case statements
 *  Revision History
 *  	Rev 0:	Initial Release
 *      Rev 1:  8/3/2016 added exploration 2, resequenced following ones, added
 *              new exploration number 5
 *      Rev 2:  11/2/2017 added method practice exploration
 *
 */

//  Explorations:
//  Nr 1:  in answer to the prompt, enter a value that is
//         not between 0 and 9, i.e. 12, or the letter 'a'
//  Nr 2:  Modify each case block of code so that it prompts for a value to convert,
//         instead of using values that are "hard coded".
//  Nr 3:  ADVANCED: Refer to method donemenu.  Notice at the bottom, just before
//         the return statement, there is an if-statement that uses JAVA scanner
//         class method hasNextInt().  What is the function of this "if" statement?
//  Nr 4:  If you were collaborating to write a program like this with one other
//         classmate, what would you be able to work together on, and what could
//         work in parallel on?
//  Nr 5:  Using existing code as a pattern, add two more unit conversions; one
//		   will be MPH to feet per second, then second will be knots to MPH. These
//         will require changes to the switch-case statements.
//  Nr 6:  Modify code so that after the call to demomenu but before the switch case
//         statement, the program prompts for a value to assign to variable
//         "originalvalue"
//  Nr 7:  Instead of using inline code within each case, write methods for each
//         unit conversion. Methods should return nothing, but should print the result
//         to the console.  Methods should receive variable "originalvalue".  Create your
//         own name for each method


import java.util.*;

public class switchcase
{

	public static int demomenu()
	{
	    int menuval;
	    Scanner invalue = new Scanner(System.in);
		System.out.println("\nUnit Conversions");
	    System.out.println("____________________________");
		System.out.println("Convert radian to degrees:        1");
		System.out.println("Convert degrees to radians:       2");
		System.out.println("Convert pounds to Newtons:        3");
		System.out.println("Convert Newtons to pounds:        4");
	    System.out.println("Convert meters to feet:           5");
	    System.out.println("Convert feet to meters:           6");
	    System.out.println("Convert Fahrenheit to Centigrade: 7");
	    System.out.println("Convert Centigrade to Fahrenheit: 8");
	    System.out.println("Quit:                             0");
	    System.out.print("Enter Selection: ");

	   // Exploration NR3 refers to the following two lines
	    if (invalue.hasNextInt()) menuval = invalue.nextInt();
	    else menuval = 11;
	    return menuval;
	}  // end of method demomenu


	public static void main(String[] args)
	{
		final double PI = Math.PI;
		boolean done = false;
		int menuchoice;
		double originalvalue = 70.0;
		double newvalue;

        while (!done)
        {
         menuchoice = demomenu();
         switch (menuchoice)
         {
         case 0:
          done = true;
         break;
         case 1:  // radians to degrees
          newvalue = originalvalue* 180/PI;
          System.out.println(originalvalue + " radians is " + newvalue + " degrees");
         break;
         case 2:  // degrees to radians
          newvalue = originalvalue * PI/180;
          System.out.println(originalvalue + " degrees is " + newvalue + " radians");
         break;
         case 3:  // pounds to Newtons
        	 newvalue = originalvalue / 4.448;
             System.out.println(originalvalue + " pounds is " + newvalue + " Newtons");
         break;
         case 4:  // Newtons to pounds
        	 newvalue = originalvalue * 4.448;;
             System.out.println(originalvalue + " Newtons is " + newvalue + " pounds");
         break;
         case 5:  // meters to feet
        	 newvalue = originalvalue / 0.3048;
             System.out.println(originalvalue + " meters is " + newvalue + " feet");
         break;
         case 6:  // feet to meters
        	 newvalue = originalvalue * 0.3048;
             System.out.println(originalvalue + " feet is " + newvalue + " meters");
         break;
         case 7:  // F to C
        	 newvalue = 5.0 / 9.0 *(originalvalue - 32);
             System.out.println(originalvalue + " F is " + newvalue + " C");
         break;
         case 8:  // C to F
        	 newvalue = 1.8 * originalvalue + 32;
             System.out.println(originalvalue + " C is " + newvalue + " F");
         break;
         default:  // did not enter a valid choice
          System.out.println("\n ****** Error *****");
          System.out.println("Choice must be between 0 and 8\n");
         break;
         }  // end of switch
        } // end of while loop

	}  // end of main

} // end of class
