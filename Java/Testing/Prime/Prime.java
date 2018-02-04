import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Prime {
  static boolean prime(BigInteger x) {
    BigInteger two = new BigInteger("2");
    if ( !(x.isProbablePrime(10)) ) return false;
    if(x.equals(two)) return true;
    if(x.mod(two).equals(BigInteger.ZERO)) return false;

    for ( BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(x) < 1; i = i.add(two) )
      if ( x.mod(i).equals(BigInteger.ZERO) ) return false;

    return true;
  }
  public static void main(String[] args) {
    AtomicInteger count = new AtomicInteger(0);
    //int count = 0;
    Scanner scan = new Scanner(System.in);
    BigInteger two = new BigInteger("2");
    BigInteger start = new BigInteger(Long.toString(Long.MAX_VALUE));
    BigInteger max = new BigInteger("22953686867719691230002707821868552601124472329080");
    int input;

    System.out.println("WELCOME TO PRIME CHECKER JAVA\n Enter 1 to start");
    input = scan.nextInt();

    if(input == 1) {
      LongStream.rangeClosed(1L, Long.MAX_VALUE - 1L).parallel()
      .forEach(i -> {
        if(prime ( new BigInteger(Long.toString(i))) ) {
	  count.getAndIncrement();
          //if(count.equals(new AtomicInteger(10000)))
System.out.println(i); //count.set(0);
       }
     });
       for(BigInteger i = start; i.compareTo(max) < 1; i = i.add(two))
         if(prime(i)){
              //count.addAndGet(1);
             // if(count.equals(new AtomicInteger(10))) { System.out.println(i); count.set(0);}
            //count ++;
            //if(count == 10) System.out.println(i);
      }
    }
  } //end main
}// end class
