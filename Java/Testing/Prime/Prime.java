import java.math.BigInteger;
import java.util.Scanner;
public class Prime {
  static boolean cprime(BigInteger x) {
    //check via BigInteger.isProbablePrime(certainty)
    /*
   if (!number.isProbablePrime(5))
       return false;

   //check if even
   BigInteger two = new BigInteger("2");
   if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
       return false;

   //find divisor if any from 3 to 'number'
   for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) { //start from 3, 5, etc. the odd number, and look for a divisor if any
       if (BigInteger.ZERO.equals(number.mod(i))) //check if 'i' is divisor of 'number'
           return false;
   }
   return true;
    */
    if ( !(x.isProbablePrime(10)) ) return false;

    BigInteger two = new BigInteger("2");
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
    long startTime = System.currentTimeMillis();

    System.out.println(cprime(input));

    long endTime = System.currentTimeMillis();
    System.out.println("That took " + (endTime - startTime) + " milliseconds");
  }
}
