import java.util.*;
public class test {
    public static Random rand = new Random();
    private char[][] board = new char[3][3];
    int current = 1;
    public test(char c) {
        char n = Character.toUpperCase(c);
        if(n == 'O') current = 2;
        if(n == 'X');
        else throw new IllegalArgumentException("Inputs can only be X or O");
    }
    public test() {}

    void print() {
        for(char[] b : board) {
            System.out.print("");
            for(int i = 0; i < b.length; i++)
                System.out.print(b[i] + ( (i == b.length-1) ? " " : " | ") );
            System.out.println("\n---------");
        }
    }

    private boolean checkIfFull() {
      for(char[] c : board) {
        for(char n : c) {
          if(n == '\u0000') // n == null
            return false;
        }
      }
      return true;
    }

    void play() {
        char play;
        do {
            int x = rand.nextInt(3), y = rand.nextInt(3);
            //System.out.printf("%d, %d\n",x,y);
            if(board[x][y] == '\u0000') {
                if(current % 2 == 0) play = 'O';
                else play = 'X';
                board[x][y] = play;
                current++;
            }
        } while(!checkIfFull());
    }
    public static void main(String args[]) {
        test tt = new test();
        tt.play();
        System.out.println();
        tt.print();
    }
}
