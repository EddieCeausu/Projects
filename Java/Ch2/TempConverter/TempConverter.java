import java.util.Scanner;

public class TempConverter {

  public static void main(String[] args) {
    String degree;
    double temp;
    double finaltemp = 0.0;
    Scanner scan = new Scanner (System.in);

    System.out.print("Is your degree mesurement Fahrenheit or Celsius: ");
    degree = scan.next().toUpperCase();
    System.out.print("What is your Tempature: ");
    temp = scan.nextDouble();

    if(degree.equals("F") || (degree.equals("Fahrenheit"))) {
      finaltemp = (temp - 32) * (5.0/9.0);
      System.out.println((int)(finaltemp) + "\u00B0" + "F");
    }

    if(degree.equals("C") || (degree.equals("Celsius"))) {
      finaltemp = temp * (9.0/5.0) + 32;
      System.out.println((int)(finaltemp) + "\u00B0" + "C");
    }
  }
}
