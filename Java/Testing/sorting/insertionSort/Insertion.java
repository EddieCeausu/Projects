import java.util.*;
import java.io.*;

public class Insertion {
  public static Scanner scan = new Scanner(System.in);
  public static Random rand = new Random();

  static void sort(List<Integer> array) {

    for(int i = 1; i < array.size(); i++)
      for(int j = i; j > 0; j--)
        if( array.get(i).compareTo(array.get(j-1) ) < 0 ) {
          Collections.swap(array, i, j-1);
        }
  }
/*
  static void sort() {
    String temp;
    for(int i = 1; i < list.length; i++)

      for(int j = i; j > 0; j--)
        if(list[j].compareTo(list[j-1]) < 0) {
          temp = list[j];
          list[j] = list[j-1];
          list[j-1] = temp;
        }
  }
*/

  static Boolean isSorted(Object[] a) {
    for(int i = 0; i < a.length - 1; i++)
      if(a[i].equals(a[i+1])) return false;
    return true;
  }

  static int[] toArray(List<Integer> list) {
    int[] arry = new int[list.size() - 1];
    for(int i = 0; i < list.size(); i++) {
      arry[i] = list.get(i);
    }
    return arry;
  }

  public static void printArray(int[] list) {
    System.out.println("Before sort: ");
    System.out.println(Arrays.toString(list) + "\n");
    List<Integer> array = Arrays.stream(list).boxed().collect(java.util.stream.Collectors.toList());
    sort(array);
    System.out.println("\nAfter sort: ");
    System.out.println(Arrays.toString(array.toArray()));
    System.out.println("Check to see if array is sorted: " + isSorted(array.toArray()));

  }

  public static void main(String[] args) {
    //Size input
    System.out.println("Welcome to Insertion Sort\nEnter your list size: ");
    int max = scan.nextInt();
    int[] list = new Random().ints(max, 0, max + 1).toArray();
    printArray(list);

  }
}
