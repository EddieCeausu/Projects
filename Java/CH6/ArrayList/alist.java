import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class alist {
  public static Scanner scan = new Scanner(System.in);
  public static Random rand = new Random();
  public static int length;
  public static ArrayList<Integer> list = new ArrayList<Integer>();

  static void load_sort() {
    int i, next;
    list.clear();
    System.out.println("Enter the number of items: ");
    length = scan.nextInt();

    for (i = 0; i < length; i++)
      next = insert(rand.nextInt(1001));

  }

  static void insert() {
    System.out.println("Enter your Integer to add: ");
    int input = scan.nextInt();
    if (input < list.get(0)) {
      list.add(0, input);
      System.out.println("Item added to list at index: 0");
      return;
    }
    System.out.println("Element added at index : " + insert(input));
  }

  static int insert(int n) {
    int i;
    for (i = list.size(); i > 0 && n < list.get(i - 1); i--)
      ;
    list.add(i, n);
    return i;
  }

  static void removeInt() {
    System.out
        .println("Enter the index of the item you would like to remove\n" + print() + "\nEnter removal location: ");
    int input = scan.nextInt();
    list.remove(input);
    System.out.println("New size is: " + list.size());
  }

  static String print() {
    String str = "[";
    for (int i = 0; i < list.size(); i++) {
      if (i % 10 == 0 && i != 0)
        str += "\n";
      if (i != list.size() - 1)
        str += (list.get(i) + ", ");
      else
        str += (list.get(i) + "]");
    }
    return str;
  }

  static void sumA() {
    int sum = 0;
    for (Integer i : list)
      sum += i;
    System.out.println("Sum of ArrayList is: " + sum);
  }

  static void biggerThan() {
    int i, count = 0;
    System.out.println("Enter the item you would like to compare: ");
    int input = scan.nextInt();
    System.out.println(print());
    for (i = 0; i < list.size(); i++)
      if (list.get(i) >= input)
        count++;
    System.out.println("Number of items ≥ input: " + count);
  }

  static int menu() {
    System.out.println("Load\\sort Arraylist\t1");
    System.out.println("Insert Integer\t\t2");
    System.out.println("Remove Integer\t\t3");
    System.out.println("Sum ArrayList\t\t4");
    System.out.println("Bigger Than\t\t5");
    System.out.println("Print ArrayList\t\t6");
    System.out.println("Exit\t\t\t0");
    return scan.nextInt();
  }

  public static void main(String[] aris) {
    while (true) {
      switch (menu()) {
      case 0:
        System.exit(0);
        break;
      case 1:
        load_sort();
        break;
      case 2:
        insert();
        break;
      case 3:
        removeInt();
        break;
      case 4:
        sumA();
        break;
      case 5:
        biggerThan();
        break;
      case 6:
        System.out.println(print());
        break;
      default:
        System.err.println("That is not an option");
        break;
      }
    }
  }
}
