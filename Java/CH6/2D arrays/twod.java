import java.util.*;
public class twod {
  public static Scanner scan = new Scanner(System.in);
  public static Random rand = new Random();
  static int[][] list = new int[15][15]; // int[rows][columns]

  static void load() {
    for(int i = 0; i < list.length; i++)
      for(int j = 0; j < list[i].length; j++)
        list[i][j] = rand.nextInt(101);

  }
  
  static void sort() {
    // Sort rows
    for (int row = 0; row < list.length; row++) {
      for (int i = 1; i < list[row].length; i++) {
        int x = list[row][i], j = i - 1;
        while (j >=0 && list[row][j] > x) {
          list[row][j+1] = list[row][j];
          j--;
        }
        list[row][j+1] = x;
      } // end list[row] for
    } // end list for
    // Sort columns based on index 0 and then 1 if they are equal
    Boolean pass;
    do {
      pass = false;
      for(int row = 0; row < list.length - 1; row++) {
        if(list[row][0] > list[row+1][0]) {
          pass = true;
          int[] temp = list[row];
          list[row] = list[row+1];
          list[row+1] = temp;
        }
        if(list[row][0] == list[row+1][0] && (list[row][1] > list[row+1][1])) {
            int[] temp = list[row];
            list[row] = list[row+1];
            list[row+1] = temp;
        }
      }
    } while(pass);
  }


  static void sumRow() {
    int row = 0;
    while(true) {
    System.out.println("Which row would you like to sum: ");
    row = scan.nextInt();
    if(row >= list.length) System.out.println("Input cannot be larger than " + (list.length - 1));
    else break;
  }
    int sum = 0;
    for(int i : list[row]) sum += i;
    System.out.println("The sum of row " + row + " is " + sum);
  }

  static void sumColumn() {
    int col = 0;
    while(true) {
    System.out.println("Enter your column to select: ");
    col = scan.nextInt();
    if(col >= list.length) System.out.println("Input cannot be greater than: " + (list.length - 1));
    else break;
  }
    int sum = 0;
    for(int i = 0; i < list.length; i++) sum += list[i][col];

    System.out.println("Sum of column" + " is: " + sum);
  }

  static void minMax() {
    int max = 0, maxX = 0, maxY = 0;

    for(int i = 0; i < list.length; i++)
      for (int j = 0; j < list[i].length; j++)
        if(list[i][j] > max ) {
          max = list[i][j];
          maxX = i;
          maxY = j;
        }

    if(!findDups(max)) System.out.printf("One max value of %d found at: [%d,%d]\n",max, maxX, maxY);
    else {
      String print = "";
      for (int i = 0 ; i < list.length ; i++)
        for (int j = 0 ; j < list[i].length ; j++)
          if (list[i][j] == max) print += " [" + i + "," + j + "] ";

      System.out.printf("Max value %d found at locations%s", max, print);
    }
  }

  static void sumA() {
    int sum = 0;
    for(int[] l : list)
      for(int i : l)
        sum += i;
    System.out.println("Sum of entire array is: " + sum);
  }

  static boolean findDups(int n) { // to be used to find min & max values in minMax();
    int x = 0;
    for(int[] arry : list)
      for(int i = 0 ; i < arry.length; i++)
        if(arry[i] == n)
          x++;
    return x > 1;
  }

  static String print() {
    String str = "";
    for(int[] i : list){
    str += "[";
      for(int j = 0; j < list.length; j++)
        str += (j == list.length - 1) ? (i[j] + "]\n") : (i[j] + ", ");
      }
      return str;
  }

  static void swap() {
    int row = 0;
    while(true) {
    System.out.println("Enter row to swap: ");
    row = scan.nextInt();
    if(row >= list.length)
      System.out.println("Input cannot be larger than " + (list.length - 1));
    else break;
    }
    int[] temp = new int[list.length], temp2 = list[row];

    // storing columns to temp
    for(int i = 0; i < list.length; i++) temp[i] = list[i][row];

    list[row] = temp; // comumns is now a row

    // row is now column
    for(int i = 0; i < list.length; i++) list[i][row] = temp2[i];
  }

  static int menu() {
    System.out.println("Load\t\t\t1");
    System.out.println("Sort\t\t\t2");
    System.out.println("Sum of Row\t\t3");
    System.out.println("Sum of Column\t\t4");
    System.out.println("Find max\t\t5");
    System.out.println("Sum of Array\t\t6");
    System.out.println("Swap\t\t\t7");
    System.out.println("Print\t\t\t8");
    System.out.println("Exit\t\t\t0");
    while(true) {
      try {
        return scan.nextInt();
      } catch(InputMismatchException ex) {
        System.out.println("Not a valid input");
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("Welcome to 2-D Array Lab");
    while(true) {
      switch(menu()) {
        case 0: System.exit(0); break;
        case 1: load(); break;
        case 2: sort(); break;
        case 3: sumRow(); break;
        case 4: sumColumn(); break;
        case 5: minMax(); break;
        case 6: sumA(); break;
        case 7: swap(); break;
        case 8: System.out.println(print()); break;
        default: System.err.println("You cant do that!!!");
      } // end while
    } // end switch
  } // end main
} // end class
