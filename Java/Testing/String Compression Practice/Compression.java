public class Compression {
  private String item;
  private int length;
  Byte[] compressed;

  public Compression(String item) {
    this.item = item;
    this.legnth = item.length();
  }

  public String encode() {


    return "Item is compressed!";
  }

  public String toString() {
    return "Item before: " + item + "| Item after compression: " + compressed;
  }

}
