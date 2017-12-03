// ****************************************************************
//   Student.java
//
//   Define a student class that stores name, score on test 1, and
//   score on test 2.  Methods prompt for and read in grades,
//   compute the average, and return a string containing students info.
// ****************************************************************
import java.util.Scanner;

public class Student
{
    String name;
    Double test1, test2;
    Scanner scan = new Scanner(System.in);

    //-----------------------------------------------
    //constructor
    //-----------------------------------------------
    public Student(String studentName) {
       name = studentName;
    }

    //-----------------------------------------------
    //inputGrades: prompt for and read in student's grades for test1 and test2.
    //Use name in prompts, e.g., "Enter's Joe's score for test1".
    //-----------------------------------------------
    public void inputGrades()
    {
	     System.out.println("Enter " + name + "'s for test 1: ");
       test1 = scan.nextDouble();
       System.out.println("Enter " + name + "'s for test 2: ");
       test2 = scan.nextDouble();
    }

    //-----------------------------------------------
    //getAverage: compute and return the student's test average
    //-----------------------------------------------

    public double getAverage() {
	     return (test1 + test2) / 2;
    }

    //-----------------------------------------------
    //getName: print the student's name
    //-----------------------------------------------

    public void getName() {
	     System.out.println(name);
    }

    public String toString() {
      return "Name: " + name + " Test1: " + test1 + " Test2: "  + test2;
    }
}

