import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Encrypt_str {
  private String encrypted = "";
  private ArrayList<Integer> encrypted2 = new ArrayList<Integer>();
  private String message = "";
  private int seed;
  private Map<Character, Integer> encrypt_map = new HashMap<Character, Integer>();

  /**
  * @param String message to encrypt
  * <p>Sets the random seed, fills the encryption map, and encrypts the message.</p>
  */
  public Encrypt_str(String m) {
    this.message = m;
    this.seed = rand(2,500);
    fillmap();
    encrypt();
  }
  /**
  * @param int minimum value
  * @param int maximum value
  * @return A random value between min and max using Math.random
  */
  private int rand(int min, int max)
  {
     int range = Math.abs(max - min) + 1;
     return (int)(Math.random() * range) + (min <= max ? min : max);
  }

  private void fillmap() {
    for(int i = 32; i < 127; i ++)
      encrypt_map.put((char) i, (i * seed));
  }
  /**
  * <p>Used to encrypt the message.</p>
  * <p>Seperates the message into a char arrays. Gets the char encrypted value and mods it by 127 to get a random ascii value.
  * This method also adds the original encrypted integer to an Arraylist</p>
  */
  private void encrypt() {
    char[] message_array = message.toCharArray();
    int i = 0;
    for(char c : message_array){
      encrypted += (char) (encrypt_map.get(c) % 127);
      encrypted2.add(encrypt_map.get(c));
    }
  }

  public String getEncrypted() { return encrypted; }

  /**
  * @return String decrypted message
  * <p> gets each value from the encrypted array and reverts it back to its orginal value</p>
  */
  public String decrypt() {
    String decrypt = "";
    for(int i = 0 ; i < encrypted2.size(); i++)
      decrypt += (char)(encrypted2.get(i) / this.seed);
    return decrypt;
  }

  public static void main(String[] args) {
    Encrypt_str foo = new Encrypt_str("Hello World!");
    System.out.printf("Encrypted: %s\nDecrypted: %s", foo.getEncrypted(), foo.decrypt());
  }
}
