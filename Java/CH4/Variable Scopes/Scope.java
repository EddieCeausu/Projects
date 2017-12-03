import java.util.Scanner;

public class Scope
{

public static void scopeV(int[] rcvArray, String rcvString, int rcvInt) {
	for (int x = 0; x < 10; x ++) {
  	rcvArray[x] = x + 5;
		//System.out.println(rcvArray[x]);
	}
	rcvString = "Crattie cannot be stopped";
	rcvInt = -200;
	System.out.println("... received string is now " + rcvString);
	System.out.println("... received integer is now " + rcvInt);
	System.out.print("... received array is now ");
	for (int x = 0; x < 10; x ++)
		System.out.print(rcvArray[x] + " ");
	System.out.println();
}

Scanner invalue = new Scanner(System.in);

public static void main(String[] args) {
	int[] scopeArray = new int[10];
	int integer1, integer2;
	String s1, s2;

	 for (int i = 0; i < 10; i++)
	  scopeArray[i] = i;

	 integer1 = 100;
	 s1 = "Stop Crattie";

	 System.out.println("Before method");
	 System.out.println("Array is ");
	 for (int i = 0; i < 10; i++)
		 System.out.print(scopeArray[i] + " ");
	 System.out.println();
	 System.out.println("String is " + s1);
	 System.out.println("Integer is " + integer1);

	 scopeV(scopeArray, s1, integer1);

	 System.out.println("After method");
	 System.out.println("Array is ");
	 for (int i = 0; i < 10; i++)
		 System.out.print(scopeArray[i] + " ");
	 System.out.println();
	 System.out.println("String is " + s1);
	 System.out.println("Integer is " + integer1);


}  // end of main

}  // end of class
