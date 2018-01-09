import java.math.BigInteger;
import java.util.Scanner;
public class Prime {
  static boolean prime(BigInteger x) {
    BigInteger two = new BigInteger("2");
    //check via BigInteger.isProbablePrime(certainty)
    if ( !(x.isProbablePrime(10)) ) return false;
    if(x.equals(two)) return true;
    if(x.mod(two).equals(BigInteger.ZERO)) return false;

    for ( BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(x) < 1; i = i.add(two) )
      if ( x.mod(i).equals(BigInteger.ZERO) ) return false;

    return true;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    BigInteger input;
    System.out.println("WELCOME TO PRIME CHECKER JAVA\nEnter your prime");
    input = scan.nextBigInteger();
    scan.close();
    long startTime = System.currentTimeMillis();

    System.out.println(prime(input));

    long endTime = System.currentTimeMillis();

    System.out.println("That took " + (endTime - startTime) + " milliseconds");


  }
}
