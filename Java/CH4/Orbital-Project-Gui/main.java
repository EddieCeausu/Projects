import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class main {
  public static DecimalFormat dfmt = new DecimalFormat("###.###");
  public static Satellite[] sat = new Satellite[5];
  public static Satellite csat;

  public static void main(String[] args) {

    OInterface frame = new OInterface();
    frame.setTitle("Satellite control Panel");
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(645,142);
    frame.getContentPane();
    frame.setBackground(Color.LIGHT_GRAY);
    frame.setVisible(true);
  }
}
