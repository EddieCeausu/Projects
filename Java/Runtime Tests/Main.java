public class Main {
  public static void main(String[] args) {
      try {
        String cmdString = "HelloWorld from the Java Runtime";
        System.out.printf("Command to run: %s\n", cmdString);
        ProcessBuilder proc = new ProcessBuilder("echo", cmdString);
        Process p = proc.start();
      } catch(Exception e) {
        System.out.printf("didnt work with %s occuring", e);
      }
      System.out.println(Runtime.getRuntime().toString());
  }
}
