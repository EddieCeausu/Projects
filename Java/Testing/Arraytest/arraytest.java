import java.util.*;
import java.util.stream.*;

public class arraytest {

  public static void main(String[] args) {

    List<Integer> numbers = new ArrayList<Integer>();

    for(int i = 0; i <= 100; i++){
      if(i%3==0 || i%5==0){
        numbers.add(i);
      }
    }
    int sum = 0;
    for(int i : numbers){
      sum += i;
    }
    System.out.println(sum);
  }
}
