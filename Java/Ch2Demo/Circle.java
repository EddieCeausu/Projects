//**********************************************************
//  Circle.java
//
//  Print the area of a circle with two different radii
//**********************************************************
import java.util.Scanner;

public class Circle
{
    public static void main(String[] args)
    {
     int radius;
     double area1;
     double area2;
     double areaf;
     double circum;

     radius = 10;
     area1 = Math.PI * radius * radius;
     circum = 2 * Math.PI * radius;

     System.out.println("The area of a circle with radius " + radius + " is " + area1);

     System.out.println("The circumfrance of the circle with a radius " + radius + " is " + area1);

     radius = 20;
     area2 = Math.PI * radius * radius;
     circum = 2 * Math.PI * radius;

     System.out.println("The area of a circle with radius " + radius + "  is " + area2);

     System.out.println("The circumfrance of the circle with a radius " + radius + " is " + area2);

     areaf = area2 / area1;

     System.out.println("The second area divided by the first area is: " + areaf);
    }
}
