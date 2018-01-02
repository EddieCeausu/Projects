import java.math.BigInteger;

public class test {
  public static boolean isPrime(unsigned long long n) {
      return !new String(new char[n]).matches(".?|(..+?)\\1+");
  }
  public static void main(String[] args) {
    //BigInteger prime = new BigInteger("40206835204840513073");
    long long prime = 40206835204840513073;
    System.out.println(prime);
    System.out.println(isPrime(prime));
  }
}
