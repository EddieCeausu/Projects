public class MultiPrime {
  public static int max = Integer.MAX_VALUE;
  public static void main(String[] args) {
      for(int i = 0; i < 40; i++) {
        PrimeRunnable object = new PrimeRunnable(max);
        object.start();
      }
  }
}
