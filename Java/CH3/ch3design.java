import java.text.DecimalFormat;
import java.util.*;

public class ch3design {

  final static void println(Object line){
    if (line == null) System.out.println();
    else System.out.println(line);
  }

  final static int[] createarray() {

    return;
  }

  final static void SearchNr(int[] array) {

  }

  final static void interlab(int[] array) {

  }

  final static void enhlab(int[] array) {

  }

  public static void main(String[] args) {
      //Global variable initialzation
      int array[] = new int[1000];
      Scanner scan = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("###.###");
      Random random = new Random();
      Boolean done = false;

      while(!done) { // main while loop
        println("Please select an option: ");
        println("Create array\t\t1");
        println("SearchNr\t\t2");
        println("Intermediate lab\t\t3");
        println("Enhanced Lab\t\t4");
        println("Quit\t\t5");
        int response = scan.nextInt();
        switch(response) {

          case 1:
            array = createarray();
            break;

          case 2:
            SearchNr(array);
            break;

          case 3:
            interlab(array);
            break;

          case 4:
            enhlab(array);
            break;

          case 5:
            done = true;
            break;

          default:
            println("Not an option; Try again.");

        }// end switch;
      } //end while

    }// end main

}// end ch3design
