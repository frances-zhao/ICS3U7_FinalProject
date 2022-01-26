import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
// import packages
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;


public class Yearly extends YearlySize implements ActionListener{

	// variable declarations
	private static final long serialVersionUID = 1L;
	JButton next = new JButton("Next");
	JButton back = new JButton("Back");
	JButton home = new JButton("Home");
	JFrame frame= new JFrame();


	public Yearly() {

		// frame settings
		frame.getContentPane().setBackground(yellow1);
		frame.setSize(1400, 800);
		frame.setLayout(new GridLayout(0, 5, 0, 0)); // grid layout = 5 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		// importing icon for next button and settings
		Icon nexticon = new ImageIcon("images/nextarrow.png");
		next = new JButton(nexticon);
		next.setOpaque(false);
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);

		// importing icon for back button and settings
		Icon backicon = new ImageIcon("images/backarrow.png");
		back = new JButton(backicon);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);

		// importing icon for home button and settings
		Icon homeicon = new ImageIcon("images/logo.png");
		home = new JButton(homeicon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);

		// adding action listener
		home.addActionListener(this);
		next.addActionListener(this);
		back.addActionListener(this);

		// adding in the twelve months (twelve set calendars)
		for (int i = 0; i < 12; i++) {
			YearlySize ch = new YearlySize();
			ch.setDate(new Date(yearint, i, 1));
			frame.add(ch);
		}
		// pack frame: at or above preferred size
		frame.pack();

		// actual GUI
		frame.add(back);
		frame.add(home);
		frame.add(next);

		// set frame to visible
		frame.setVisible(true);

	}


	// if button clicked, using Action Listener continue accordingly
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == next) {
			yearint++; // move to the next year
			new Yearly();
			frame.dispose();

		}
		if (e.getSource() == back) {
			yearint--; // move to the previous year
			new Yearly();
			frame.dispose();

		}
		if (e.getSource() == home) {
			try {
				new Mainscreen();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			frame.dispose();
		}
	}
}