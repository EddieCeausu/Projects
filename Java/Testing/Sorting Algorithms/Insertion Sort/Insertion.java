import java.util.*;

public class Insertion {

  static void sort(int[] list) {

    for(int i = 1; i < list.length; i++)
      for(int j = i; j > 0; j--)
        if(list[j] < list[j-1]) {
          list[j-1] ^= list[j];
          list[j] ^= list[j-1];
          list[j-1] ^= list[j];
        }

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
    System.out.println(Arrays.toString(list) + "\n");
    sort(list);
    System.out.println("\nAfter sort: ");
    System.out.println(Arrays.toString(list));
    System.out.println("Check to see if array is sorted: " + isSorted(list));

  }
}
