// *******************************************************************
//   PlusTest.java
//
//   Demonstrate the different behaviors of the + operator
// *******************************************************************

public class PlusTest
{
    // -------------------------------------------------
    // main prints some expressions using the + operator
    // -------------------------------------------------
    public static void main (String[] args)
    {
	     System.out.println ("This is a long string that is the " +
			        "concatenation of two shorter strings.");

	     System.out.println ("The first computer was invented about " + 55 +
			        " years ago.");

	System.out.println ("8 plus 5 is " + 8 + 5);

	System.out.println ("8 plus 5 is " + (8 + 5));

	System.out.println (8 + 5 + " equals 8 plus 5.");
  System.out.println (10 + " robins plus " + 13 + " canaries is " + 23 + " birds.");
    }
}

/*
Compile and run the program. For each of the last three output statements
(the ones dealing with 8 plus 5) write down what was printed.
Now for each explain why the computer printed what it did given that the
following rules are used for +. Write out complete explanations.
If both operands are numbers + is treated as ordinary addition.
(NOTE: in the expression a + b the a and b are called the operands.)
If at least one operand is a string the other operand is converted to a string
and + is the concatenation operator.If an expression contains more than one operation expressions inside parentheses are evaluated first.
If there are no parentheses the expression is evaluated left to right.
d.	The statement about when the computer was invented is too scrunched up. How should that be fixed?
*/
// Question 1: 85, 13, 5, 23
// Qustion 2: 85 was printed because the code is inserted as concatenations with 8 and 5 being different numbers. 13 was printed because 8 and 5 were added up. 13 was printed again because the code is being compiled left to right. 23 is outputted because that is what is in the code to be printed.
