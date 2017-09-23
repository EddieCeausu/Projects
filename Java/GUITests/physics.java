import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class physics extends JFrame {
  public JLabel label1, label2, label3, label4;
  public JTextField launchAngle, range, altmax, velocity;
  public double ViH, ViV, t, tmaxa;
  public String wmessage;
  public final double ACCEL = 9.8;
  public JButton CalculateButton; // Button
  // Decimal Format
  DecimalFormat decf = new DecimalFormat("#.00");

public double degree2radian(double degree) {
  double deg = degree;
  double radian = deg * (Math.PI / 180);
  return radian;
} // End degree 2 radian

public double jtext2double(JTextField str) {
  String str1 = str.getText();
  return Double.valueOf(str1);
} // end jtext2double

  public physics() {
    setLayout(new FlowLayout(FlowLayout.LEFT, 25, 20));
    label1 = new JLabel("Launch Angle \u03B8");
    add(label1);
    launchAngle = new JTextField(8);
    add(launchAngle);

    label2 = new JLabel("Velocity m/s");
    add(label2);
    velocity = new JTextField(10);
    add(velocity);

    label3 = new JLabel("Maximum Altitude");
    add(label3);
    altmax = new JTextField(8);
    add(altmax);

    label4 = new JLabel("Max Distance");
    add(label4);
    range = new JTextField(8);
    add(range);

    CalculateButton = new JButton("Calculate");
    add(CalculateButton);

    setVisible(true);
    setEnabled(true);

    CalculateButton.addActionListener( new ActionListener() {
      public void actionPerformed( ActionEvent event) {
        String error = "Error";
        String errorm = "You failed at life";
        try {
          // Conversions
          Double launchAngleD = jtext2double(launchAngle);
          Double launchAngle = degree2radian(launchAngleD);
          Double velocity1 = jtext2double(velocity);

          // Math
          ViH = velocity1 * Math.cos(launchAngle);
          ViV = velocity1 * Math.sin(launchAngle);
          tmaxa = ViV / ACCEL;
          t = tmaxa * 2;
          altmax.setText(decf.format((ViV * tmaxa) - (ACCEL * 0.5 * Math.pow(tmaxa, 2))));
          range.setText(decf.format((ViH * t)));

          // popup box message
          wmessage = "Initial horizontal velocity: " + decf.format(ViH) + "\nInitial vertical velocity: " + decf.format(ViV) + "\nTime to max altitude: " + decf.format(tmaxa);
          if (true) JOptionPane.showMessageDialog(null, wmessage, null, JOptionPane.PLAIN_MESSAGE);
        }
        catch (NumberFormatException s) {
            if(true) JOptionPane.showMessageDialog(null, errorm, error, JOptionPane.PLAIN_MESSAGE); // error message
        }
          String mS = new String("vertical horizontal velocity changes does not change because of zero accleration direction");
          //vertical velocity changes because of vertical acceleration
          // horizontal velocity does not change because of zero acceleration
          System.out.println(mS.substring(0,8) + mS.substring(19,37) + mS.substring(53, 64) + mS.substring(0, 8) + mS.substring(68, 80) + "\n" + mS.substring(9, 29) + mS.substring(37, 80));


      } // end action preformed
    }); // end Calculate button listener
  } // end public physics function
    public static void main(String[] args) {
      physics frame = new physics();
      frame.setTitle("Physics Design Lab");
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600, 200);
      frame.getContentPane().setBackground(Color.lightGray);
  		frame.setVisible(true);
    } // end main
} // end Public physics
