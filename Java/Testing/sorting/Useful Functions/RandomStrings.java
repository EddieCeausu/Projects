import java.util.*;
import java.io.*;

public class RandomStrings {

  public String[] randomStrings(int size) {
    String[] array = new String[size-1];
    String file = "/Users/eddieceausu/Projects/Java/Testing/Sorting Algorithms/words.txt";
    try {
      BufferedReader bf = new BufferedReader(new FileReader(file));
      String currentLine = null;
      int i = 0, j = 0, limit = new Random().nextInt(10);

      while ((currentLine = bf.readLine()) != null && j < array.length) {
        if(i % limit == 0) {
          array[j] = currentLine;
          j++;
        }
        i++;
      }
      bf.close();
    } catch(IOException ex) {
      System.err.println(ex);
    }


    return array;
  }
}
