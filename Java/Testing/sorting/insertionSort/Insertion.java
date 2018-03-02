import java.util.*;
import java.io.*;

public class Insertion {
  public static Scanner scan = new Scanner(System.in);
  public static Random rand = new Random();
  public static RandomStrings use = new RandomStrings();

  static void sort(int[] list) {

    for(int i = 1; i < list.length; i++)
      for(int j = i; j > 0; j--)
        if(list[j] < list[j-1]) {
          System.out.printf("j:%d, j-1%d",list[j], list[j-1]);
          list[j-1] ^= list[j];
          list[j] ^= list[j-1];
          list[j-1] ^= list[j];
        }

  }

  static void sort(String[] list) {
    String temp;
    for(int i = 1; i < list.length; i++)

      for(int j = i; j > 0; j--)
        if(list[j].compareToIgnoreCase(list[j-1]) < 0) {
          temp = list[j];
          list[j] = list[j-1];
          list[j-1] = temp;
        }
  }

  static Boolean isSorted(int[] a) {
    for(int i = 0; i < a.length - 1; i++)
      if(a[i] > a[i+1]) return false;
    return true;
  }

  static Boolean isSorted(String[] a) {
    for(int i = 0; i < a.length - 1; i++)
      if(a[i].compareTo(a[i+1]) >= 0) return false;
    return true;
  }

  public static void printArray(String[] list) {
    System.out.println("Before sort: ");
    System.out.println(Arrays.toString(list) + "\n");
    sort(list);
    System.out.println("\nAfter sort: ");
    System.out.println(Arrays.toString(list));
    System.out.println("Check to see if array is sorted: " + isSorted(list));

  }
  public static void printArray(int[] list) {
    System.out.println("Before sort: ");
    System.out.println(Arrays.toString(list) + "\n");
    sort(list);
    System.out.println("\nAfter sort: ");
    System.out.println(Arrays.toString(list));
    System.out.println("Check to see if array is sorted: " + isSorted(list));

  }

  public static void main(String[] args) {
    //Size input
    System.out.println("Welcome to Bubble Sort\nEnter your list size: ");
    int max = scan.nextInt();
    System.out.println("\nList of Integers(1) or Random Strings(2)?");
    int input = scan.nextInt();
    scan.close();

    if(input == 1) {
      int[] list = new Random().ints(max, 0, max + 1).toArray();
      printArray(list);
    } else {
        String[] list = use.randomStrings(max);
        printArray(list);
    }
  }
}
