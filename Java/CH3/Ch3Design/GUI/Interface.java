import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.*;
import java.text.*;

@SuppressWarnings("serial")
public class Interface extends JFrame{

  public final JLabel createL, printAL, searchL, interL, enhanL;
  public final JButton printAB, createB, searchB, interB, enhanB, quit;
  
  Interface(DecimalFormat df, Random random) {


    setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20)); // init FlowLayout

    createL = new JLabel("Create Array");
    createB = new JButton("Start");
    add(createL);
    add(createB);

    printAL = new JLabel("Print Array");
    printAB = new JButton("Start");
    add(printAL);
    add(printAB);

    searchL = new JLabel("SearchNr");
    searchB = new JButton("Start");
    add(searchL);
    add(searchB);

    interL = new JLabel("Intermediate Lab");
    interB = new JButton("Start");
    add(interL);
    add(interB);

    enhanL = new JLabel("Enhanced Lab");
    enhanB = new JButton("Start");
    add(enhanL);
    add(enhanB);

    quit = new JButton("Quit");
    add(quit);

    setEnabled(false);
    setEnabled(true);


    // Button Listeners
    createB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event){
        Ch3Design.arrayf = Functions.createarray(random);
    }
  });

    printAB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
          Functions.printarray();
      }
    });

    searchB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Functions.SearchNr();
      }
    });

    interB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Functions.interlab(df);
      }
    });

    enhanB.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Functions.enhlab();
      }
    });
    quit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });
  }// end GUI

}
