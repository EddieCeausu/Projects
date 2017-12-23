import java.text.DecimalFormat;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JOptionPane;

public class curve {
  public static void main(String[] args) {
    double inputf = 0.0;
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine math = mgr.getEngineByName("JavaScript");
    DecimalFormat df = new DecimalFormat("##.###");
    // String input = ;
    try {
      inputf = (Double) math.eval(JOptionPane.showInputDialog("Enter your Current Score"));
    } catch(Exception ex) {
    System.err.println("Error evaluating the script: " + ex.getMessage());
  }
    JOptionPane.showMessageDialog(null, "Your STEM Science curved score is: " + df.format( (Math.sqrt(inputf) * 10.15) * 10 ));
    System.exit(0);
  }
}
