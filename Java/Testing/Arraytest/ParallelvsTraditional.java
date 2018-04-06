import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.concurrent.CopyOnWriteArrayList;
import java.text.DecimalFormat;

class ParallelvsTraditional {
  static float length;
  public static Random rand = new Random();
  public static ArrayList<Integer> list = new ArrayList<Integer>();
  public static CopyOnWriteArrayList<Integer> temp = new CopyOnWriteArrayList<Integer>();
  public static DecimalFormat fmt = new DecimalFormat("#,###.##");

  static void load_sort() {
    int i;
    long end1, start1, end2, start2;

    start1 = System.nanoTime();
    System.out.println("Length is :" + fmt.format(length));
    for (i = 0; i < length; i++)
      insert(rand.nextInt(1001));
    end1 = System.nanoTime();

    list.clear();
    temp.clear();

    System.out.println("Time to load: " + fmt.format(nToSec(end1 - start1)) + "\n starting parallelStream");
    start2 = System.nanoTime();

    IntStream.range(0, (int) length).parallel().forEach(f -> insert(temp, rand.nextInt(1001)));

    list.addAll(temp);
    end2 = System.nanoTime();

    System.out.println("Time to load: " + fmt.format(nToSec(end2 - start2)) + "\nParallel - traditional: "
        + fmt.format(nToSec((end2 - start2) - (end1 - start1))) + "\n");

    //  }
  }

  static float nToSec(long n) {
    return (n / 1000000000.0f) > 1f || (n / 1000000000.0f) < 0f ? (n / 1000000000.0f) : n;
  }

  static void loop(int n) {
    list.clear();
    if (n >= 5) {
      for (int j = 2; j < n; j++) {
        length = (float) Math.pow(10, n) + (float) (5 * Math.pow(10, j));
        load_sort();
      }
    } else {
      length = (float) Math.pow(10, n);
      load_sort();
    }
  }

  static void insert(CopyOnWriteArrayList<Integer> t, int n) {
    int i;
    for (i = t.size(); i > 0 && n < t.get(i - 1); i--)
      ;
    t.add(i, n);
  }

  static void insert(int n) {
    int i;
    for (i = list.size(); i > 0 && n < list.get(i - 1); i--)
      ;
    list.add(i, n);
  }

  public static void main(String[] args) {
    System.out.println("How high would you like to go? 10^");
    int n = new Scanner(System.in).nextInt();

    for (int i = 0; i < n; i++)
      loop(i);
  }
}
