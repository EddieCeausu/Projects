import java.util.*;
import java.util.stream.IntStream;

public class BubbleSort {
  /**
  * @param int[]
  * <p> will sort using bubbleSort algorithm. Compares each pair of adjacent items and swaps them if they are in the wrong
  * order. </p>
  */
  static void sort(int[] list) {
    Boolean pass = false;
    do {
      pass = false;
      for(int i = 0; i < list.length - 1; i++) // iterate through array
        if(list[i] > list[i+1]) { // if i > i+1 swap them and mark pass as true
          pass = true;
          list[i] ^= list[i+1];
          list[i+1] ^= list[i];
          list[i] ^= list[i+1];
        }
      //  for(int i : list) System.out.print(i + " ");
      //  System.out.print("\n");
    } while(pass);
  }

  static Boolean isSorted(int[] a) {
    for(int i = 0; i < a.length - 1; i++)
      if(a[i] > a[i+1]) return false;
    return true;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    //Size input
    System.out.println("Welcome to Bubble Sort\nEnter your list size: ");
    int max = scan.nextInt();
    scan.close();

    //Creation of List and then arrayList
    int[] list = new Random().ints(max, 0, max + 1).toArray();

    //Sorting
    System.out.println("Before sort: ");
    System.out.println(Arrays.toString(list));
    sort(list);
    System.out.println("\nAfter sort: ");
    System.out.println(Arrays.toString(list));
    System.out.println("Check to see if array is sorted: " + isSorted(list));

  }
}
