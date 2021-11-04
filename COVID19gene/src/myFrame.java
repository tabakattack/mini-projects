import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class myFrame {

	public static void main(String[] args) {
		
		// create a new JFrame
		JFrame myFrame = new JFrame("COVID Gene Sequencing");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add a new JPanel
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbcon = new GridBagConstraints();
		gbcon.weightx = 1.0;
		gbcon.weighty = 1.0;
		
		
		// create a drop-down menu for the number of codons 
		// to search for
		gbcon.gridx = 0;
		gbcon.gridy = 2;
		gbcon.gridheight = 2;
		gbcon.gridwidth = 1;
		final String[] numChoices = {"0", "1", "2", "3", "4", "5", "6"};
		JComboBox<String> numBox = new JComboBox<>(numChoices);
		numBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(numBox, gbcon);
		
		JButton button2 = new JButton("2");
		gbcon.gridx = 3;
		gbcon.gridy = 2;
		gbcon.gridheight = 2;
		gbcon.gridwidth = 1;
		mainPanel.add(button2, gbcon);
		
		
		
		// create and add start button
		JButton startButt = new JButton("SEARCH");
		gbcon.gridx = 2;
		gbcon.gridy = 3;
		gbcon.gridheight = 1;
		gbcon.gridwidth = 1;
		mainPanel.add(startButt, gbcon);
		
		myFrame.add(mainPanel);
		
		
	
		
		
		
		
		// display the window
		myFrame.pack();
		myFrame.setVisible(true);
		 
		
	}
	

}
