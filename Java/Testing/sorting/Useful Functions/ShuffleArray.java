import java.util.*;

public class ShuffleArray<T> {
  public static Random rand = new Random();

  static <T>void shuffle(T[] a) {
    T temp;
    int max;

    for(int i = 0; i < a.length; i++) {
      max = rand.nextInt(a.length);
      temp = a[max];
      a[max] = a[i];
      a[i] = temp;
    }
  }
  static void shuffle(int[] a) {
    Integer[] what = Arrays.stream( data ).boxed().toArray( Integer[]::new );
    shuffle(what);
  }
  
  public static void main(String[] args) {
    Integer[] arry = {1,2,3,4,5,6,7,8,9,10};
    System.out.print(Arrays.toString(arry) + arry.length);
    shuffle(arry);
    System.out.print(Arrays.toString(arry) + arry.length);

  }
}
