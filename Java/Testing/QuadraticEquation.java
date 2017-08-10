import java.util.*;
import javax.swing.*;

public class QuadraticEquation {
 public static void main(String[] args) {
    String a = JOptionPane.showInputDialog(" Enter operand a :  ");
    double aa = Double.parseDouble(a);
    String b = JOptionPane.showInputDialog(" Enter operand b :  ");
    double bb = Double.parseDouble(b);
    String c = JOptionPane.showInputDialog(" Enter operand c :  ");
    double cc = Double.parseDouble(c);
    double temp = Math.sqrt(bb * bb - 4 * aa * cc);
    double r1 = ( -bb + temp) / (2*aa);
    double r2 = ( -bb -temp) / (2*aa);
    if (temp > 0) {
          JOptionPane.showMessageDialog(null, "the equation has two real roots" +"\n"+" the roots are : "+  r1+" and " +r2);

      }
    else if(temp ==0) {
          JOptionPane.showMessageDialog(null, "the equation has one root"+  "\n"+ " The root is :  " +(-bb /2 * aa));

      }

    else{

          JOptionPane.showMessageDialog(null, "the equation has no real roots !!!");
      }
  }
}
