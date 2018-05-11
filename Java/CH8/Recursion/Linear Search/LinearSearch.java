public class LinearSearch {
  static int[] arry = new java.util.Random().ints(100, 0, 100).toArray();

  static int search(int[] a, int index, int num) {
    if (index == a.length)
      return -1;
    if (num == a[index])
      return index;

    return search(a, index + 1, num);
  }

  public static void printMenu() {
    System.out.println("\n   Menu   ");
    System.out.println("   ====");
    System.out.println("0: Quit");
    System.out.println("1: Create new list elements (** do this first!! **)");
    System.out.println("2: Sort the list using selection sort");
    System.out.println("3: Find an element in the list using linear search");
    System.out.println("4: Print the list");
    System.out.print("\nEnter your choice: ");
  }

  public static sort() {
    int curr;
    for(int i = 0; i < arry.length; i ++) {
      curr = i;
      for(int j = i + 1; j < arry.length; j ++)
        if(arry[curr] < curr[j])
          curr = j;
    }
  }

  public static void main(String[] args) {

    System.out.println(java.util.Arrays.toString(arry));
    System.out.println("Searching for number " + num + "\nResult is: " + search(arry, 0, num));
  }
}
