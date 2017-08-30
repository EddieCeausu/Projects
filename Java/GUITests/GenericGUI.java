import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;
public class GenericGUI extends JFrame
{
//****************************************
//** GUI Structure
//** Title: Holston Middle School
//** Weight prompt (jlabel, jtext)
//** planet pulldown
//** Weight on planet (jlabel, jtext)
//** calculate button
//****************************************
public JTextField entry1, entry2, output1;
public JLabel label1, label2,label3;
public JComboBox combob; // Dropdown menu
public JButton CalculateButton; // Button
public String mtitle, cmessage;
String[] itemmenu = {"item1","item2", "item3", "item4","item5", "item6", "item7", "item8", "item9"};
double exponent;
boolean boxon = false;

public GenericGUI()
{
	setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
	label1 = new JLabel("Label1");
	add(label1);
	entry1 = new JTextField(8);
	add(entry1);
	setEnabled(true);
	setVisible(true);
	label2 = new JLabel("Label2");
	add(label2);
	entry2 = new JTextField(8);
	add(entry2);
	setEnabled(true);
	setVisible(true);
	label3 = new JLabel("Output");
	add(label3);
	output1 = new JTextField(8);
	add(output1);
	setEnabled(false);
	setVisible(true);
	final JComboBox combob = new JComboBox(itemmenu);
	combob.setSelectedIndex(4);
	add(combob);
	setEnabled(true);
	CalculateButton = new JButton("Calculate");
	add(CalculateButton);
	CalculateButton.addActionListener( new ActionListener()
	{
		public void actionPerformed(ActionEvent event)
		{
			String entry1string = entry1.getText();
			Double e1value = Double.valueOf(entry1string);
			String entry2string = entry2.getText();
			Double e2value = Double.valueOf(entry2string);
			int menunr = combob.getSelectedIndex();
			switch (menunr)
			{
			case 0: exponent = 0; break;
			case 1: exponent = 1; break;
			case 2: exponent = 2; break;
			case 3: exponent = 3; break;
			case 4: exponent = 4; break;
			case 5: exponent = 5; break;
			case 6: exponent = 6; break;
			case 7: exponent = 7; break;
			case 8: exponent = 8; break;
			} //** switch
			String wmessage = "You selectected exponent "+ menunr;
			String wtitle = "Pop Up Box";
			boxon = true;
			if (boxon) JOptionPane.showMessageDialog(null, wmessage, wtitle, JOptionPane.PLAIN_MESSAGE);
			double outval = e1value + Math.pow(e2value,exponent);
			DecimalFormat tout = new DecimalFormat("####.000");
			String outstring = tout.format(outval);
			output1.setText("");
			output1.setText(outstring);
		}//** actionPerformed
	}); //** Action Listener
	} //** GenericGUI constructor

	public static void main(String[] args)
	{
		GenericGUI frame = new GenericGUI();
		frame.setTitle("Distance Lab");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 200);
		frame.setBackground(Color.CYAN);
		frame.getContentPane().setBackground(Color.lightGray);
		frame.setVisible(true);
	} //** main
} //** class
