import java.util.Scanner;
import java.text.DecimalFormat;

public class paint {
  public static void main(String[] args) {
    // Variable initialization
    final int COVERAGE = 350;
    int length, width, height, windows, doors;
    double totalSqFt, paintNeeded;
    String gallonsNeeded;
    DecimalFormat decformat = new DecimalFormat("#.##");
    Scanner scan = new Scanner (System.in);

    // User inputed variables
    System.out.println("Enter length of the room: ");
    length = scan.nextInt();
    System.out.println("Enter the width of the room: ");
    width = scan.nextInt();
    System.out.println("Enter the height of the room: ");
    height = scan.nextInt();
    System.out.println("Enter the number of windows: ");
    windows = scan.nextInt();
    System.out.println("Enter the number of doors: ");
    doors = scan.nextInt();

    //Compute the amount of paint needed
    totalSqFt = 2*(length * height) + 2*(width * height);
    totalSqFt = totalSqFt - (doors * 20) - (windows * 15);
    paintNeeded = totalSqFt / COVERAGE;

    // rounded off total gallons needed
    gallonsNeeded = decformat.format(paintNeeded);
    paintNeeded = Math.ceil(paintNeeded);

    System.out.println("Paint Needed: " + gallonsNeeded + " gallons");
    System.out.println("You should by " + (int)(paintNeeded) + " gallons");
  }// end main
}// end class paint
