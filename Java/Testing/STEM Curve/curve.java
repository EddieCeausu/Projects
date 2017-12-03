import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class curve {

  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("##.#");
    String input = JOptionPane.showInputDialog("Enter your Current Score");
    double inputf = Double.parseDouble(input);
    JOptionPane.showMessageDialog(null, "Your STEM Science curved score is: " + df.format((Math.sqrt(inputf) * 10.15)));
    System.exit(0);
  }
}
