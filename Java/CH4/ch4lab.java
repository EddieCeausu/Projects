import java.util.*;
import java.text.*;
import java.lang.Math;

public class ch4lab {

  public static void main(String[] args) {
    Scanner invalue = new Scanner(System.in);
System.out.println("Enter the low limit: ");
int lowerLimit = 0;
lowerLimit = invalue.nextInt();

int sum = 0;

for(int x = lowerLimit;  x <= 15;  x++) {

sum += x;

}

System.out.println("Sum: " + sum);
  }
}
