import java.util.Scanner;

class CollatzConjucture {
  public static int Collatz(int n) {
    int steps = 1;
    System.out.println(steps + " : " + n);
    while(n > 1) {
      if(n % 2 == 0)
        n /= 2;
      else
        n = (n * 3) + 1;
    steps ++;
    System.out.println(steps + " : " + n);
    }
    return steps;
  }
  public static int CollatzLoop(int n) {
    int steps = 1;
    while(n > 1) {
      if(n % 2 == 0)
        n /= 2;
      else
        n = (n * 3) + 1;
    steps ++;

    }
    return steps;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to the Collatz Conjucture\nEnter a number > 1 to continue or type loop to start");
    var input = scan.next();
    try{
      int numTest = Integer.parseInt(input);
      System.out.println("Number of steps to complete: " + Collatz(numTest));
    } catch(Exception ex) {
      for(int i = 2; i < 214748364; i++) {
        int result = CollatzLoop(i);
        if(result >= 300)
          System.out.println("\nSteps to find " + i + ": " + result+"\n");
      }
    }
  }
}
