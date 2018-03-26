import java.util.Random;
import java.util.Arrays;

public class TwoDArray {
  static final int ROWS = 100;
  static final int COLUMNS = 200;
  static int[][] foo = new int[ROWS][COLUMNS];

  static void print() {
    for(int[] i : foo) {
      System.out.print("[");
      for(int j = 0; j < i.length; j++) {
        if(j == i.length - 1) System.out.print(i[j]);
        else System.out.print(i[j] + ", ");
      }
      System.out.print("]\n");
    }
  }

  static void fill() {
    for(int i = 0; i < foo.length; i++)
      for(int j = 0; j < foo[i].length; j++)
        foo[i][j] = new Random().nextInt(100);
  }

  static void sort() {
    // Sort rows
    for (int row = 0; row < foo.length; row++) {
      for (int i = 1; i < foo[row].length; i++) {
        int x = foo[row][i], j = i - 1;
        while (j >=0 && foo[row][j] > x) {
          foo[row][j+1] = foo[row][j];
          j--;
        }
        foo[row][j+1] = x;
      } // end foo[row] for
    } // end foo for
    // Sort columns based on index 0 and then 1 if they are equal
    Boolean pass;
    do {
      pass = false;
      for(int row = 0; row < foo.length - 1; row++)
      //int i = 0;
        if(foo[row][i] > foo[row+1][i]) {
          pass = true;
          int[] temp = foo[row];
          foo[row] = foo[row+1];
          foo[row+1] = temp;
        }
    } while(pass);
  }

  public static void main(String[] args) {
    fill();
    print();
    System.out.println();
    sort();
    print();
  }
}
