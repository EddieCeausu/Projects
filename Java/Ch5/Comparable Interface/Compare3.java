public class Compare3 {
  static String largest(String a, String b, String c) {
    int large = Math.max( a.length(), Math.max(b.length(), c.length()) );
    if(large == a.length())
      return a;
    if(large == b.length())
      return b;
    if(large == c.length())
      return c;
    else return " ";

  }
  public static void main(String[] args) {
    System.out.println(largest("asdfghjk", "sdfghytredcvbh", "jytfvh"));
  }
}
