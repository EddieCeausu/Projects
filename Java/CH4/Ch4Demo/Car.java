import java.util.Scanner;

/************************************************
 *  File:		Car
 *  Author:		J.Foy
 *  Created:		9/24/2016
 *  Defines a class used in Ch4Demo program
 *  Revision History
 *  	Rev 0:	Initial Release
 *
 */

public class Car
{
	// following is instance data, every object, every new Car data
	// has all of the instance data
	String Owner;  // owner's first name
	String Make;   // Chrysler, Toyota, etc.
	String Model; // 300, RAV4, etc.
	int Mpg_hwy;
	int Year;
	private int Mileage;    // private data is not visible outside this class
	String Color = "pink";
	private int Value;
	private int Vin;
	static int dpayment;


	 // Constructor must have same name as class
	 // There is no word in front of constructor except "public" or "private"
	 // constructor, it initializes instance variables
	 public Car(String cowner, String cmake, String cmodel, int miles,
		int cmpghwy, int cyr, int cvalue, int cvin)
	 {
	  Owner = cowner;
	  Make = cmake;
	  Model = cmodel;
	  Mileage = miles;
	  Mpg_hwy = cmpghwy;
	  Year = cyr;
	  Value = cvalue;
	  Vin = cvin;
	 }  // end of constructor


	public int getValue()   // this method returns an integer
	{
	  return Value;
	}

// following method does not return a value, but it is called with a value
	public void adjustValue(int svalue)
	{
	  Value+=svalue;
	}

// following method is used to who is at fault when a car strikes
// a second car.  Car c1 is the second car

	public String fault(Car c1)
	{
    String baddriver;

	if ((c1.Owner).equalsIgnoreCase("crattie") ||
		(this.Owner).equalsIgnoreCase("crattie"))
		baddriver = "Crattie";
	else baddriver = this.Owner;
	return baddriver;
	} // end of method fault

	public boolean bothTotaled(Car c1)
	{
	 boolean bothdone;
	 int v1, v2;

	 v1 = c1.Value;
	 v2 = this.Value;
	 bothdone = ((v1 <= 0) && (v2 <= 0));
	 return bothdone;
	}  // end of method wreck


	public String toString()
	{
	 return (this.Owner + ", " + this.Model);
	}
} // end of class
