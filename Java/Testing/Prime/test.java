/*
* Primality test with seive
* V 1.0
* TODO: Convert to BigInteger
*/

import java.math.BigInteger;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
  public static Scanner scan = new Scanner(System.in);

  static boolean checkPrime(long prime) {
    for(long i = 3; i * i < prime; i += 2) {
      if(prime % i != 0) return false;
    }
    return true;
  }

  public static void rangePrime(long start) {
    BigInteger two = new BigInteger("2");
    if ( !(BigInteger.valueOf(start).isProbablePrime(10)) ) return;
    if(checkPrime(start)) {
      
    } else System.out.printf("%d is not a prime!", start);
    return;
  }
  public static void main(String[] args) {
    System.out.println("Prime Generator!!!!");
    System.out.println("Enter a prime < 2^64 - 1 to start at: ");
    long start = scan.nextlong();
    rangePrime(start);

  }
}
