import java.util.*;
import java.io.*;

public class binarysearch {
  static String print = "";
  /**
  * Searches the array for the item, num, using the Binary Search algorithm and returns the number of passes and the index of where the item first appeared.
  * @param int num, the int to be found
  * @param int[] list, the list to be search through
  * @return an int array containing the index at int[0] and the numebr of passes at int[1]. If the number was not found then int[1] will be -1.
  **/
  static int[] search(int num, int[] list) {
    int low = 0, high = list.length - 1;
    int middle = 0, passes = 0;
    while (low <= high) {
      middle = (low + high) / 2;
      passes++;
      //System.out.printf("low: %d, high: %d, mid: %d, pass: %d\n", low, high, middle, passes);
      if(list[middle] == num) // if the middle equals the value then end
        return new int[] {middle, passes};

      if(list[middle] > num) // if the middle is greater than the value increase low to the middle + 1
        high = middle - 1;

      if(list[middle] < num) // if the middle is less than the value decrease the maximum to the middle - 1
        low = middle + 1;

    } // end while
    return new int[] {-1, passes};
  }
  public static void main(String[] args) {
    int[] list = new Random().ints(116000, 0, 50001).parallel().toArray();;
    Arrays.sort(list);
    //Sytem.out.println(Arrays.toString(list));
    int[] foo = search(list[14], list);
    System.out.println("Enter a number you would like to search for: " + list[14]);
    if(foo[0] != -1)
      System.out.println("Index location: " + foo[0] + " Number of passes " + foo[1] + "\n");
    else System.out.printf("Item not found after %d passes\n\n\n", foo[1]);

  }
}
