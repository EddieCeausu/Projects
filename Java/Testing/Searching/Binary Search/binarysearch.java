import java.util.*;
import java.io.*;

public class binarysearch {
  static int search(int num, int[] list) {
    int low = 0, high = list.length - 1;
    int middle = 0;
    while (low <= high) {
      middle = (low + high) / 2;

      if(list[middle] == num) // if the middle equals the value then end
        return middle;

      if(list[middle] > num) // if the middle is greater than the value increase low to the middle + 1
        high = middle - 1;

      if(list[middle] < num) // if the middle is less than the value decrease the maximum to the middle - 1
        low = middle + 1;

    } // end while
    return -1;
  }
  public static void main(String[] args) {
    int[] list = {10, 5,2,3,4,5,3};
    Arrays.sort(list);
    System.out.println(Arrays.toString(list));
    System.out.println(search(10, list));
  
  }
}
