import java.util.*;
public class MyClass {
     static void insertionSort(int array[]) {  
        int n = array.length, passes = 0;
        long startTime = System.nanoTime();
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                passes ++;
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
        long endTime = System.nanoTime();
        System.out.println(passes + " Time to Sort " + (endTime - startTime));
    }  
static void InsertionSort(int array[]) {
    int temp, passes = 0;
    long startTime = System.nanoTime();

    for (int i = 1; i < array.length; i ++)
      for (int j = i; j > 0; j --)
        if(array[j] < array[j-1]) {
          temp = array[j-1];
          array[j-1] = array[j];
          array[j] = temp;
          passes ++;
        }

    long endTime = System.nanoTime();
    System.out.printf("Sorting Completed\nTook %d nanoseconds and %d passes\n", (endTime - startTime), passes);
  }
    static void SelectionSort(int[] array) {
     int temp, passes = 0;
     for(int j = 0; j < array.length; j ++) {
         for(int i = j; i < array.length; i ++) {
           if(array[j] >= array[i]) { // swap array[i] and array[min]
             temp = array[j];
             array[j] = array[i];
             array[i] = temp;
             passes ++;
           }
         }
     }
     System.out.println("Sorting finished...Took " + passes + " passes");
  }
    static String print(int[] list) {
        String lol = "[";
        for(int i = 0; i < 17; i++)
            lol += (list[i] + ", ");
        lol += ("...");
        return lol;
    }
    public static void main(String args[]) {
        int[] list = new Random().ints(500000, 0, 50000).toArray();
        int[] arry = new int[500000];
        int[] array = new int[500000];
        for(int i = 0; i < list.length; i ++) {
            arry[i] = list[i];
            array[i] = list[i];
        }
        
        System.out.println(print(list) + " size = " + list.length);
        insertionSort(list);
        System.out.println(print(list));
        InsertionSort(arry);
        System.out.println(print(arry));
        SelectionSort(array);
        
    }
}

