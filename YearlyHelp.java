import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;


public class YearlyHelp implements ActionListener{
	// variable declaration
	private JFrame frame;
	private JLabel helptitle = new JLabel("Yearly Help");
	private JLabel helplabel, helplabel1, helplabel2, helplabel3, yearpicture;
	private JButton returnbtn;
	private JLabel ducklabel;


	// font declarations
	Font newfont;
	Font newfont1;

	public YearlyHelp() {

		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
		} catch (IOException | FontFormatException e){

		}

		// initializing frame
		final int HEIGHT = 500;
		final int WIDTH = 800;
		frame = new JFrame("Yearly Help"); 
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		helptitle.setFont(newfont1);
		helptitle.setHorizontalAlignment(SwingConstants.CENTER);
		helptitle.setBounds(223, 6, 358, 46);

		helplabel = new JLabel("The yearly calendar is also very very easy to use!");
		helplabel.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel.setFont(newfont);
		helplabel.setBounds(28, 43, 747, 46);

		helplabel1 = new JLabel("Click on the yellow arrows to move back and forth to different years,");
		helplabel1.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel1.setFont(newfont);
		helplabel1.setBounds(28, 63, 747, 46);
		
		helplabel2 = new JLabel("click on the logo (checkmark) to return back to the main screen!");
		helplabel2.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel2.setFont(newfont);
		helplabel2.setBounds(38, 83, 737, 46);
		
		helplabel3 = new JLabel("(^^This is the home button!^^)");
		helplabel3.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel3.setFont(newfont);
		helplabel3.setBounds(46, 322, 729, 46);

		Icon icon = new ImageIcon("images/yearlyhelp.png");
		Border b = new LineBorder(Color.WHITE, 3);

		yearpicture = new JLabel(icon);
		yearpicture.setBorder(b);
		yearpicture.setBounds(161, 141, 483, 195);
		frame.add(yearpicture);


		returnbtn = new JButton("Return Home");
		returnbtn.setFont(newfont);
		returnbtn.setBounds(307, 364, 205, 41);
		returnbtn.addActionListener(this);

		Icon duckdance = new ImageIcon("images/chirp.gif");
		ducklabel = new JLabel(duckdance);
		ducklabel.setBounds(484, 283, 151, 195);
		
		// actual GUI
		frame.add(helptitle);
		frame.add(helplabel);
		frame.add(helplabel1);
		frame.add(helplabel2);
		frame.add(helplabel3);
		frame.add(returnbtn);

		frame.add(ducklabel);
		

		frame.setVisible(true);
	}

	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == returnbtn) {
			new Help();
			frame.dispose();
		}


	}
}