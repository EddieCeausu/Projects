import java.util.*;

public class Sorting {
  public static Scanner scan = new Scanner(System.in);
  public static Random rand = new Random();

  public static void SelectionSort(int[] list) {
     int temp, passes = 0;
     for(int j = 0; j < list.length; j ++) {
         for(int i = j; i < list.length; i++) {
           if(list[j] >= list[i]) { // swap list[i] and list[min]
             temp = list[j];
             list[j] = list[i];
             list[i] = temp;
             passes ++;
           }
         }
     }
     System.out.println("Sorting finished...Took " + passes + " passes");
  }

  public static void linearSearch(int[] list, int item) {
    long startTime = System.nanoTime();
     for(int i  = 0; i < list.length; i++)
       if(list[i] == item) System.out.println("Item was found at index: " + i);
    long endTime = System.nanoTime();
    System.out.printf("Time to find through was %d nano seconds\n", endTime - startTime);
   }

  public static void binarySearch(int[] list, int item) {
   int max = list.length - 1, min = 0, middle, passes = 0;
   long startTime = System.nanoTime();
   while(min <= max) {
     middle = (min + max) / 2;
     passes ++;
     if(list[middle] == item) {
      long endTime = System.nanoTime();
      System.out.println("Item found at index " + middle + "\nTook " + (endTime - startTime) + " nano seconds and " + passes + " passes");
      return;
    }
    if(list[middle] > item)
      max = middle - 1;
    else
      min = middle + 1;
    }
    System.out.println("Item not found");
  }

  public static void create(int[] list) {
    for(int i = 0; i < list.length; i++)
      list[i] = rand.nextInt(50000);
  }

  public static String printArray(int[] list) {
    String print = "[";

    for(int i = 0; i < list.length; i++)
      if(i != list.length - 1)
        print += (list[i] + ", ");
      else
        print += (list[i] + "]");

      return print;
  }
  
  public static int menu() {
    boolean done = false;
    int input = 0;
    while(!done) {
      System.out.println("Load Array\t\t1");
      System.out.println("Selection Sort\t\t2");
      System.out.println("Linear Search\t\t3");
      System.out.println("Binary Search\t\t4");
      System.out.println("Print Array\t\t5");
      System.out.println("Exit\t\t\t0");
      System.out.println("Enter your choice: ");
      input = scan.nextInt();

    if(input < 0 || input > 5)
      System.out.println("Try again");
    else done = true;
    }
    return input;
  }

  public static void main(String[] args) {
    int[] array = new int[100];
    int item;
    while(true) {
      switch(menu()) {
        case 0: System.exit(0); break;
        case 1: create(array); break;
        case 2: SelectionSort(array); break;
        case 3:
          System.out.println("What item would you like to search for? ");
          item = scan.nextInt();
          linearSearch(array, item);
          break;
        case 4:
          System.out.println("What item would you like to search for? ");
          item = scan.nextInt();
          binarySearch(array, item);
          break;

        case 5: System.out.println(printArray(array)); break;
        default: System.err.println("Thats not an option"); break;
      }
    }
  }
}
