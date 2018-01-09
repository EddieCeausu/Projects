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
  static void printA(ArrayList n) {
    for(Object i : n) {
      System.out.print(i + " ");
    }
    System.out.print("\n\n");
  }
  public static ArrayList rangePrime(BigInteger max) {
    BigInteger TWO = new BigInteger("2");
    BigInteger LENGTH = max.add(BigInteger.ONE);

    if(max.compareTo (BigInteger.valueOf (Integer.MAX_VALUE) ) < 0) {
    ArrayList<BigInteger> finArray = new ArrayList<BigInteger>();
    // BigInteger array[] = new BigInteger[max.intValue() + 1];
    ArrayList<BigInteger> array = new ArrayList<BigInteger>(Collection.nCopies(max.intValue + 1, BigInteger.ONE));
}
    array.add(0, BigInteger.ZERO);
     array.add (1, BigInteger.ZERO);
    //printA(array);

    for(BigInteger i = TWO; i.multiply(i).compareTo(LENGTH) < 0 ; i.add(BigInteger.ONE)) {
      if(array.get(i.intValue()).equals(BigInteger.ONE)){
        for(BigInteger j = i; i.multiply(j).compareTo(LENGTH) < 0; j.add(BigInteger.ONE)){
            array [j.multiply(i).intValue()] = BigInteger.ZERO;
        }
      }
    }
    //printA(array);

    for(BigInteger i = BigInteger.ZERO; i.compareTo(LENGTH) < 0; i.add(BigInteger.ONE)) {
      if(array [i.intValue()].equals(BigInteger.ONE)) {
        finArray.add(i);
      }
    }

    return finArray;
  }
  public static void main(String[] args) {
    ArrayList<BigInteger> array = new ArrayList<BigInteger>();

    System.out.printf("Enter your max range: ");
    BigInteger max = scan.nextBigInteger();
    array = rangePrime(max);

    scan.close();
    System.out.printf("There are %d primes below %d\n", array.size(), max);
    if(array.contains(max)) System.out.printf("%d is prime", max);
    else System.out.printf("%d is not prime", max);
  }
}
