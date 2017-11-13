import java.util.Scanner;

public class construct {
  public static void main(String[] args) {
    int greg;
    String hyatt;
    double foy;
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the string");
    hyatt = scan.nextLine();

    System.out.println("Enter the Integer");
    greg = scan.nextInt();

    System.out.println("Enter the Double");
    foy = scan.nextDouble();

    Two t1 = new Two(hyatt, greg, foy);
    t1.print();
  }
}
