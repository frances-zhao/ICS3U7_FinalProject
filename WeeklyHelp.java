import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class WeeklyHelp implements ActionListener{

	private JFrame frame;
	private JLabel helptitle = new JLabel("Weekly Help");
	private JLabel helplabel, helplabel1, helplabel2, helplabel3, yearpicture;

	// font declarations
	Font newfont;
	Font newfont1;

	private JButton returnbtn;
	private JLabel lblNewLabel;


	public WeeklyHelp() {

		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
		} catch (IOException | FontFormatException e){

		}

		// initializing frame
		final int HEIGHT = 500;
		final int WIDTH = 800;
		frame = new JFrame("Weekly Help"); 
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		helptitle.setFont(newfont1);
		helptitle.setHorizontalAlignment(SwingConstants.CENTER);
		helptitle.setBounds(223, 6, 358, 46);

		helplabel = new JLabel("The weekly scheduler is a pretty unique feature!");
		helplabel.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel.setFont(newfont);
		helplabel.setBounds(28, 43, 747, 46);

		helplabel1 = new JLabel("Click on add event to add a new schedule, and make sure to write in a day of the week to schedule it under.");
		helplabel1.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel1.setFont(newfont);
		helplabel1.setBounds(28, 63, 747, 46);
		
		helplabel2 = new JLabel("Add the event and you'll see it pop up under your scheduler!");
		helplabel2.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel2.setFont(newfont);
		helplabel2.setBounds(38, 83, 737, 46);
		
		helplabel3 = new JLabel("If you want to clear your entire weekly scheduler (since you're done for the week), you can click Clear.");
		helplabel3.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel3.setFont(newfont);
		helplabel3.setBounds(46, 322, 729, 46);

		Icon icon = new ImageIcon("images/weekly.gif");
		Border b = new LineBorder(Color.WHITE, 3);

		yearpicture = new JLabel(icon);
		yearpicture.setBorder(b);
		yearpicture.setBounds(249, 127, 305, 183);
		frame.add(yearpicture);


		returnbtn = new JButton("Return Home");
		returnbtn.setFont(newfont);
		returnbtn.setBounds(307, 364, 205, 41);
		returnbtn.addActionListener(this);


		// actual GUI
		frame.add(helptitle);
		frame.add(helplabel);
		frame.add(helplabel1);
		frame.add(helplabel2);
		frame.add(helplabel3);
		frame.add(returnbtn);
		
		Icon duckdance = new ImageIcon("images/chirp.gif");
		lblNewLabel = new JLabel(duckdance);
		lblNewLabel.setBounds(484, 300, 151, 195);
		frame.add(lblNewLabel);
		
		


		frame.setVisible(true);
	}

	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */

	public static void main(String[]args ) {
		new WeeklyHelp();
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == returnbtn) {
			try {
				new Mainscreen();
				frame.dispose();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}


	}
}