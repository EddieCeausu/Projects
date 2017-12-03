// ****************************************************************
//   Grades.java
//
//   Use Student class to get test grades for two students
//   and compute averages
//
// ****************************************************************
public class Grades {
  public static void main(String[] args) {
    double average;
	   Student st1 = new Student("Mary");
     Student st2 = new Student("Mike");
     st1.inputGrades();
     average = st1.getAverage();
	   System.out.println("Average: " + average);
	   st2.inputGrades();
     average = st2.getAverage();
     System.out.println("Average: " + average);
     System.out.println(st1 + "\n" + st2);
    }
}
