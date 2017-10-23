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

@SuppressWarnings("serial")
public class Ch3Design extends JFrame {
  public static int[] arrayf;

  public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("###.###");
    Random random = new Random();

    Functions Functions = new Functions();
    Interface frame = new Interface(df, random);

    frame.setTitle("Chapter 3 Design Lab");
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(550,150);
    frame.getContentPane();
    frame.setBackground(Color.LIGHT_GRAY);
    frame.setVisible(true);

    }// end main

}// end ch3design
