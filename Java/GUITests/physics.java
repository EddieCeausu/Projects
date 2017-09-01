import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class physics extends JFrame {
  public Jlabel label1, label2, label3, label4;
  public final int AKCEL = 9.8;
  DecimalFormat decf = new DecimalFormat("####.00");

  public physics() {
    setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

}
