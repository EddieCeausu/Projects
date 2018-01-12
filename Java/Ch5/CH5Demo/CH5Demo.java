/**
* *************************************************
*  Chapter 5 Demo Program
*  Designer:  J.Foy
*  Revision History:
*   0:  11/23/2015
*   1:  11/25/2016 Modified for school year 2016-2017
*
* *************************************************
*
* Exploration 1: Write a block of code that loads array
* intlist with random integers between 0 and 100 inclusive.
* This code addition will be in main, where indicated by a
* comment.  Refer to elements in intlist by using brackets;
* i.e. intlist[x] =
*
* Exploration 2: Run the code, notice what happens when two integers are swapped vs
* two integers in an array.  Code will print out "before swap" twice, once before calling
* swap methods once at the beginning and inside of the method.  "After swap" also printed
* twice; once inside of swap method before return, once in "main" after control shifts back
* to main.  What is different about the two "after swap" results?
*
* Exploration 3: choose two world languages, preferably ones which will have necessary vocabulary
* (see class Language for vocabulary).  Languages that do not include words such as "array", (i.e
* latin, Quechua, Navajo, Cherokee) might not be good candidates.
*
* Exploration 4: create two additional classes, one per chosen language.  With instructor help
* implement the same methods that you see in class Language, however Strings should be in the
* appropriate language.  You will need to edit Case 3 in "main" of this file so that it refers
* to your language classes.  Remember to create these two classes using guidance provided in
* paragraphs 5 and 6 of file "Ch5Demo.docx".   THIS WILL BE GRADED.  You will receive extra
* credit if you have a native speaker validate your vocabulary.  In your language file, list as
* comments your source for vocabulary (i.e. Google translate...)
*
* Exploration 5:  TO BE PERFORMED AFTER ABOVE EXPLORATIONS ALL WORK
* Modify Case 3 in "main" in this file, so that it calls a language selection menu.
* This will require adding a new method to interface "UserPrompts", and a new language specific
* method to each of the three language classes; Language plus your two classes.
*
**/
import java.util.*;

public class CH5Demo
{
	static public UserPrompts mylanguage = new Language();
	static int languageindicator = 1;


// ************************************************************************
// method swap: swaps two integers, prints out pre-swap and post swap values

 public static void swap (int x, int y)
 {
	int temp;
	String swapstring;

	swapstring = mylanguage.beforeSwap() + x + " , " + y;
	System.out.println(swapstring);
	temp = x;
	x = y;
	y = temp;
	swapstring = mylanguage.afterSwap() + x + " , " + y;
	System.out.println(swapstring);
 }// end of method swap
//************************************************************************
// overloaded method swap: swaps two integers in an integer array, prints
// array pre and post values

 public static void swap(int[] integerlist, int x, int y)
 {
	 int temp;
	 String outstring;

	 outstring = mylanguage.beforeSwap();
	 System.out.println(outstring);
	 for (int i = 0; i <= integerlist.length; i++)
		{
		 System.out.print(integerlist[i] + ", ");
		 if (((i + 1) % 10) == 0) System.out.println();
		}

	 temp = integerlist[x];
	 integerlist[x] = integerlist[y];
	 integerlist[y] = temp;
	 outstring = mylanguage.afterSwap();
	 System.out.println(outstring);
		for (int i = 0; i < 20; i++)
		{
		 System.out.print(integerlist[i] + ", ");
		 if (((i + 1) % 10) == 0) System.out.println();
		}

 }
//************************************************************************
 public static void main(String[] args) {
	int selection;
	String outstring;
	boolean done = false;
	int[] intlist = new int[20];
	int n1, n2;
	Random rand = new Random();
	// Exploration 1
	// Insert code here that loads intlist, an array of 20
	// elements, with random integers between 0 and 100 inclusive

	//for (int i : intlist) i = rand.nextInt(101);

	while (!done)
	{
	selection = mylanguage.menu();
	switch (selection)
	{
	case 0:
		done = true;
		break;
	case 1:
		outstring = mylanguage.beforeSwap();
		System.out.println(outstring);
		swap(1, 8);
		outstring = mylanguage.afterSwap();
		System.out.println(outstring);
		break;
	case 2:			// swap two numbers in array, print the array before and after swap
		n1 = mylanguage.idSwapNrs(intlist);
		n2 = mylanguage.idSwapNrs(intlist);
		outstring = mylanguage.printHeader();
		System.out.println(outstring);
		outstring = mylanguage.beforeSwap();
		System.out.println(outstring);
		for (int i = 0; i < 20; i++)
		{
		 System.out.print(intlist[i] + ", ");
		 if (((i + 1) % 10) == 0) System.out.println();
		}
		swap(intlist, n1, n2);
		outstring = mylanguage.afterSwap();
		System.out.println(outstring);
		for (int i = 0; i < 20; i++)
		{
		System.out.print(intlist[i] + ", ");
		if (((i + 1) % 10) == 0) System.out.println();
		}
		break;

// EXPLORATION 4: After choosing two languages and looking
// up necessary vocabulary words, you will replace Dutch and
// Russian in case 3.



// EXPLORATION 5:  You will replace the if statements with
// a language selection algorithm of your design

	case 3:		// change to second or third language
		languageindicator++;
		if ((languageindicator % 3) == 0)
		  //mylanguage = new DutchLanguage();
		if ((languageindicator % 3) == 1)
		  mylanguage = new Language();
		if ((languageindicator % 3) == 2)
		 //mylanguage = new Russian();

		break;
	case 4:			// reload array
		Random generator4 = new Random();
		for (int i = 0; i < 20; i++)
		{
			intlist[i] = generator4.nextInt(101);
		}  // end of for
		break;
	case 5:		// print array
		outstring = mylanguage.printHeader();
		System.out.println(outstring);
		for (int i = 0; i < 20; i++)
		{
		 System.out.print(intlist[i] + ", ");
		 if (((i + 1) % 10) == 0) System.out.println();
		}
		break;
	} // end of switch
	} // end of while !done
 } // end of main

}  // end of class
