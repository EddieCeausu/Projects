import java.util.*;
public class selection {
  public static Scanner scan = new Scanner(System.in);
  public static Random rand = new Random();

  static void SelectionSort(int[] array) {
     int temp, passes = 0, min;
     for(int j = 0; j < array.length; j ++) {
        min = j;
         for(int i = j + 1; i < array.length; i ++)
           if(array[min] > array[i])
             min = i;
             // swap array[i] and array[min]
             temp = array[min];
             array[min] = array[j];
             array[j] = temp;
             passes ++;
     }
     System.out.println("Sorting finished...Took " + passes + " passes");
  }

  static Boolean isSorted(int[] a) {
    for(int i = 0; i < a.length - 1; i++)
      if(a[i] > a[i+1]) return false;
    return true;
  }

  public static void printArray(int[] list) {
    System.out.println("Before sort: ");
    System.out.println(Arrays.toString(list) + "\n");
    SelectionSort(list);
    System.out.println("\nAfter sort: ");
    System.out.println(Arrays.toString(list));
    System.out.println("Check to see if array is sorted: " + isSorted(list));

  }

  public static void main(String[] args) {
    //Size input
    System.out.println("Welcome to Selection Sort\nEnter your list size: ");
    int max = scan.nextInt();
    scan.close();

    int[] list = new Random().ints(max, 0, max + 1).toArray();
    printArray(list);


    }
}
