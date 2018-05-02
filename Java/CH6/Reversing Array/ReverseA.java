import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ReverseA {

  public int[] foo;

  public ReverseA(int[] a) {
    this.foo = a;
    System.out.println("Reversing");
    reverse();
  }

  private void reverse() {
    int temp;
    for (int i = 0, j = foo.length - 1; i < (foo.length / 2) + (foo.length % 2 == 0 ? 0 : 1); i++, j--) {
      temp = foo[i];
      foo[i] = foo[j];
      foo[j] = temp;
    }

  }

  public String toString() {
    String str = "[";
    for (int i : foo)
      str += String.valueOf(i) + ", ";
    return str.substring(0, str.length() - 2) + "]";
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<Integer>();
    for (String s : args)
      list.add(Integer.parseInt(s));
    int[] t = new Random().ints(11, 0, 20).toArray();
    for (int i : t)
      list.add(i);
    t = new int[list.size()];
    for (int i = 0; i < list.size(); i++)
      t[i] = list.get(i);
    System.out.println(list);
    ReverseA bar = new ReverseA(t);
    System.out.println(bar.toString());

  }
}
