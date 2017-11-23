//*

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class OInterface extends JFrame {

  public JFrame iframe = new JFrame("Select a Satellite");
  public JFrame nframe = new JFrame("Satellite Control Panel");
  public JLabel sat1, sat2, sat3, sat4, sat5;
  public JButton sel1, sel2, sel3, sel4, sel5;
  static int wait = 0; // 0 = wait, 1 = go;
  public final JLabel printSat, selectSat, updateVel, changeOrbit, changePower;
  public final JButton go1, go2, go3, go4, go5, quit;

  public void initframe() {
    iframe.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
    sat1 = new JLabel("ISS");
    sel1 = new JButton("Select");
    iframe.add(sat1);
    iframe.add(sel1);

    sat2 = new JLabel("MRO");
    sel2 = new JButton("Select");
    iframe.add(sat2);
    iframe.add(sel2);

    sat3 = new JLabel("JWST/Webb");
    sel3 = new JButton("Select");
    iframe.add(sat3);
    iframe.add(sel3);

    sat4 = new JLabel("SkyLab");
    sel4 = new JButton("Select");
    iframe.add(sat4);
    iframe.add(sel4);

    sat5 = new JLabel("ChinaSat");
    sel5 = new JButton("Select");
    iframe.add(sat5);
    iframe.add(sel5);

    iframe.setEnabled(true);
    iframe.setVisible(true);

    sel1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        wait = 1;
      }
    });

    sel2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        wait = 1;
      }
    });

    sel3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        wait = 1;
      }
    });

    sel4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        wait = 1;
      }
    });

    sel5.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        wait = 1;
      }
    });

  }

  OInterface() {

    initframe();

    //iframe.setVisible(false);
if(wait == 1){
    nframe.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
    printSat = new JLabel("Print Satelites");
    go1 = new JButton("Start");

    selectSat = new JLabel("Select a Satellite");
    go2 = new JButton("Start");

    updateVel = new JLabel("Update satellite velocity");
    go3 = new JButton("Start");

    changeOrbit = new JLabel("Change satellite orbit type");
    go4 = new JButton("Start");

    changePower = new JLabel("Chnage Satellite power type");
    go5 = new JButton("Start");

    quit = new JButton("Quit");



      nframe.add(printSat);
      nframe.add(go1);


      nframe.add(selectSat);
      add(go2);


      add(updateVel);
      add(go3);


      add(changeOrbit);
      add(go4);


      add(changePower);
      add(go5);

      add(quit);

      setEnabled(true);

      go1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {

        }
      });

      go2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {

        }
      });

      go3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {

        }
      });

      go4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {

        }
      });

      go5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {

        }
      });

      quit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
          System.exit(0);
        }
      });

    } // end wait
  } // end OInterface
} // end class
