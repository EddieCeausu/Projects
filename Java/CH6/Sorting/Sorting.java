import java.util.*;

public class Sorting {
  static Scanner scan = new Scanner(System.in);
  static Random rand = new Random();
  static int[] array = new int[30];
  static String print;

  static void SelectionSort() {
    int temp, swap = 0, min;
    for(int j = 0; j < array.length; j ++) {
       min = j;
        for(int i = j + 1; i < array.length; i ++)
          if(array[min] > array[i])
            min = i;
            // swap array[i] and array[min]
            temp = array[min];
            array[min] = array[j];
            array[j] = temp;
            swap ++;
    }
    System.out.println("Sorting finished...Took " + swap + " swaps");
  }
  static void checkForDups() {
    int dups = 0, num;
    Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

    for(int i : array) {
      num = i;
      dups = 0;
      for(int j = 0; j < array.length; j++) {
        if(i == array[j]) {
          dups ++;
        }
        if(j == array.length - 1 && dups >= 2)
          map.put(num, dups);
      } // end j for

    } // end i  for-each

    System.out.println("Duplicate Items: Number = Number of Occurences\n" + map.toString());
  }

  static void linearSearch(int item) {
    boolean found = false;
    long startTime = System.nanoTime(), endTime = 0l;
     for(int i  = 0; i < array.length; i++)
       if(array[i] == item) {
         endTime = System.nanoTime();
         System.out.println("Item was found at index: " + i);
         found = true;

       }

    if(found)
      System.out.printf("Time to find through was %d nano seconds\n", endTime - startTime);
    else System.out.println("Item not found");
   }

  static void binarySearch(int item) {
    int max = array.length - 1, min = 0, middle, passes = 0;
    if(print.contains(Integer.toString(item))) {
       long startTime = System.nanoTime();
       while(min <= max) {
         middle = (min + max) / 2;
         passes ++;
         if(array[middle] == item) {
          long endTime = System.nanoTime();
          System.out.println("Item found at index " + middle + "\nTook " + (endTime - startTime) + " nano seconds and " + passes + " passes");
          return;
        }
        if(array[middle] > item)
          max = middle - 1;
        else
          min = middle + 1;
        }
      }
    System.out.printf("Item not found\nTook %d passes\n", passes);
  }

  static void create() {
    if(array.length <= 20000)
    for(int i = 0; i < array.length; i++)
      array[i] = rand.nextInt(20);
    else array = new Random().ints(array.length, 0, 50001).parallel().toArray();
  }

  static void printArray() {
    print = "[";

    for(int i = 0; i < array.length; i++) {
      if(i % 10 == 0 && i != 0)
        print += "\n";
      if(i != array.length - 1)
        print += (array[i] + ", ");
      else
        print += (array[i] + "]");
      }
  }

  static int menu() {
    boolean done = false;
    int input = 0;
    while(!done) {
      System.out.println("Load Array\t\t1");
      System.out.println("Selection Sort\t\t2");
      System.out.println("Linear Search\t\t3");
      System.out.println("Binary Search\t\t4");
      System.out.println("Print Array\t\t5");
      System.out.println("Search for Duplicates\t6");
      System.out.println("Exit\t\t\t0");
      System.out.println("Enter your choice: ");
      input = scan.nextInt();

      if(input < 0 || input > 6)
        System.out.println("Try again");
      else done = true;
    }
    return input;
  }

  public static void main(String[] args) {
    int item;
    do {
      switch(menu()) {
        case 0: System.exit(0); break;
        case 1: create(); printArray(); break;
        case 2: SelectionSort(); printArray(); break;
        case 3:
          System.out.println("What item would you like to search for? ");
          item = scan.nextInt();
          linearSearch(item);
          break;
        case 4:
          System.out.println("What item would you like to search for? ");
          item = scan.nextInt();
          binarySearch(item);
          break;

        case 5: System.out.println(print); break;
        case 6: checkForDups();
        default: System.err.println("Thats not an option"); break;
      }
    } while(true);
  }
}
