import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;

public class distance extends JFrame {
  public JLabel label1, label2, label3, label4;
  public JTextField x1, x2, y1, y2, output1;
  public JButton CalculateButton;
  DecimalFormat decf = new DecimalFormat("####.0000");
  public distance() {
    setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
    label1 = new JLabel("x\u00B9");
    add(label1);
    x1 = new JTextField(8);
    add(x1);

    label2 = new JLabel("y\u00B9");
    add(label2);
    y1 = new JTextField(8);
    add(y1);

    label3 = new JLabel("x\u00B2");
    add(label3);
    x2 = new JTextField(8);
    add(x2);

    label4 = new JLabel("y\u00B2");
    add(label4);
    y2 = new JTextField(8);
    add(y2);

    CalculateButton = new JButton("Calculate");
  	add(CalculateButton);
    
    output1 = new JTextField(10);
    add(output1);

    setEnabled(true);
    setVisible(true);

    CalculateButton.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        String x1string = x1.getText();
        Double X1 = Double.valueOf(x1string);
        String x2string = x2.getText();
        Double X2 = Double.valueOf(x2string);
        String y1string = y1.getText();
        Double Y1 = Double.valueOf(y1string);
        String y2string = y2.getText();
        Double Y2 = Double.valueOf(y2string);

        double distancef = Math.sqrt(Math.pow((X2-X1), 2) + Math.pow((Y2-Y1), 2));
  			String outval = decf.format(distancef);
  			output1.setText("");
  			output1.setText(outval);
      }
    });
  }
  public static void main(String[] args) {
    distance frame = new distance();
    frame.setTitle("Distance Lab");
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 200);
    frame.getContentPane().setBackground(Color.lightGray);
		frame.setVisible(true);
  }
}
