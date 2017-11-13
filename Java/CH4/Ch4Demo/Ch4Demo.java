/************************************************
 *  File:		Ch4Demo
 *  Author:		J.Foy
 *  Created:		7/14/2015
 *  Demos several Chapter 4 concepts
 *  Revision History
 *  	Rev 0:		Initial Release
 *      1:		Changed for school year 2016
 *
 */

// Explorations:
// Number 1: Write a line of code that reads the color of
//           a specific Car object int string "color".  Instance
//           variable "Color" is defined in accompanying file Car.java.
// Number 2: Assign a color string value (i.e. "white") to string
//			 color, then change the Color instance value for one of
// 			 the Car objects
// Number 3: Write a line of code that attempts to read the Value of a
//           Car object.  What happens?  When it does not work, call
//           Car class method getValue instead.
// Number 4: Create two more Car objects.  This will require you to
//           change the value of constant NRCARS, and also to include
//           constructors for both inside the for loop that creates
//           the objects
// Number 5a: Using two of the Car objects in the car array, call Car
//           method "fault" to see who is at fault in a collision. Use
//           the pattern provided with the Hawkins Foy collision code to
//           see how to refer to the two cars in a single line of code.
//           NOTE: if you hit a car from behind, you are almost always
//           found to be at fault.
// Number 5b: For Exploration 5a, modify logic such that if one of the
//           cars is Crattie, that car is automatically at fault
// Number 6: Create a for loop that prints out all of the car objects
//           in array car_array.  Example "println" statements in the bottom of
//           Listing 4.4 on page 194 are an example.
// Number 7: After reading about method "adjustValue" in class Car,
//           write a line of code that adjusts the value of a specific
//           car object.  The "acct3.withdraw(800.0, 0)" line of code in
//           Listing 4.4 on page 194 is an example.
// Number 8: Note that exploration number 7, and Car class method
//           "adjustValue" could cause a car's value to be a negative
//           number.  Write an "if" statement in method "adjustvalue"
//           that recognizes this, and instead sets the value to 0.
//
// EXPLORATIONS 9, 10, AND 11 ARE AFTER A CLASSROOM EXPLANATION
// Number 9:  Add a method to the Car class that reads the value of
//			  instance variable Vin.  Then add code in this program
//            that reads instance values of Make, Model, and Vin and
//            then writes these to the Console with appropriate text.
// Number 10: Write two new methods in class Car; one gets the value
//           of Car object instance variable Mileage, the second changes
//           the value of that instance variable to a number provided
//           by the method call in this program.
// Number 11: Two cars are in a collision.  Decide on a damage amount for
//            each, and adjust each's value.  To do this, you will need
//            to call "getValue" for each, and then call "adjustValue" with
//            each. Finally, use Car class method bothTotaled to see
//            if both are totaled or not.
// Number 12: Code at the bottom of the file prints two car objects
//            Run the code, notice what is printed.  Then go into file
//            Car.java and comment the toString method.  Then rerun this
//            file and notice what is printed.

import java.util.*;
import java.util.Scanner;

public class Ch4Demo
{

	public static void main(String[] args)
	{
	Car c1, c2, c3, c4;
	String faultdriver;
	String color;
	final int NRCARS = 5;
	int i, randdriver;
	Car[] car_array = new Car[NRCARS];
	Scanner invalue = new Scanner(System.in);

	// previous declaration is for an array, described in chapter 6
	// next for loop loads 3 vehicles into the array, passing their
	// constructor the necessary information
	//
	for (i = 0; i < NRCARS; i++) {
		car_array[0] = new Car("Foy","Rav4", "Toyota", 150000, 32, 2003, 2000, 555444);
		car_array[1] = new Car("Crattie", "Model T", "Ford", 590000,4, 1908, 13,1);
		car_array[2] = new Car("Hawkins", "Jeep", "Chrysler", 300, 26, 2014, 9000,123432);
		car_array[3] = new Car("Sharon", "Accord", "Honda", 45000,30,2012, 10000, 2468);
		car_array[4] = new Car("NASA", "OSIRIS", "Satellite", 200000, 10000, 2016, 10000000, 123);
	} // end of for

	// Explorations 1 and 2:
	c1 = car_array[0];
	color = car_array[0].Color;
	System.out.println("Original color " + color);
    color = "white";
    car_array[0].Color = color;
    System.out.println("Color is now " + car_array[0].Color);

    // Exploration 3
 //  i = car_array[0].Value;
    i = car_array[1].getValue();
    System.out.println("\nValue of "+ car_array[1].Owner + "'s car is $" + i + "\n");

    // Following code is an example for Exploration 5a, 5b
	// method fault determines whose fault it is if car1 strikes car2
    c1 = car_array[0];   //  Foy's car
    c2 = car_array[2];   //  Hawkin's car

     faultdriver = c1.fault(c2);
     System.out.print("When " + (c1.Owner) + " strikes " + (c2.Owner));
     System.out.println(" from behind, "+ faultdriver + " is at fault");

     // Exploration 6
     System.out.println("\nFollowing output is Exploration 6");

     // Exploration 7
     randdriver = 10 % NRCARS;
     c1 = car_array[randdriver];
     System.out.println("Randomly selected " + c1.Owner + "'s car.");
     System.out.print("\n What value adjustment? (positive or negative integer)? ");

     // call to adjustValue goes here

     System.out.println("\n " + c1.Owner + "'s car is now worth $" + c1.getValue());

	// Exploration 9
    c1 = car_array[0];

  // line of code that uses new Car method that reads a Vin

    System.out.println("\n Exploration 9");
    System.out.println("Make is: " + c1.Make + ", model is " + c1.Model + ", VIN is " + i + "\n");

    // Exploration 10 code goes here
    System.out.println("\n Exploration 10");


    // Exploration 11
    System.out.println(" \n Exploration 11");
    c1 = car_array[1];	// Crattie's car
    c2 = car_array[0];
    System.out.println("Pre accident value for " + c1.Owner + "'s car is $" + c1.getValue());
    System.out.println("and for " + c2.Owner + "'s car is $" + c2.getValue());
    System.out.print("Enter damage amount: ");
    i = invalue.nextInt();

//  Exploration 12
    c1 = car_array[0];   //  Foy's car
    c2 = car_array[2];   //  Hawkin's car
    System.out.println(c1);
    System.out.println(c2);
	} // end of main

}  // end of class
