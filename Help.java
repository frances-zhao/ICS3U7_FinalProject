// importing packages
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * class that helps user with tutorials on how to use special features
 * @author Frances Zhao
 *
 */
public class Help implements ActionListener{

	// variable declarations
	private JFrame frame;
	private JLabel helptitle = new JLabel("Help");
	private JLabel helplabel, helplabel1;

	// font declarations
	Font newfont;
	Font newfont1;
	private JButton weeklytut;
	private JButton monthlytut;
	private JButton yearlytut;
	private JButton returnbtn;
	private JLabel duckimage;


	/**
	 * constructor that implements GUI interface 
	 */
	public Help() {

		// trying fonts
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
		} catch (IOException | FontFormatException e){
			System.out.println("Help - Cannot import font.");

		}

		// initializing frame
		final int HEIGHT = 500;
		final int WIDTH = 800;
		frame = new JFrame("Help"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);

		helptitle.setFont(newfont1);
		helptitle.setHorizontalAlignment(SwingConstants.CENTER);
		helptitle.setBounds(358, 6, 90, 46);

		helplabel = new JLabel("Curious about Tackle? Or need some directions?");
		helplabel.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel.setFont(newfont);
		helplabel.setBounds(28, 43, 738, 46);
		
		helplabel1 = new JLabel("Click on one of the buttons for a tutorial on each section.");
		helplabel1.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel1.setFont(newfont);
		helplabel1.setBounds(28, 58, 738, 46);

		weeklytut = new JButton("Weekly Help");
		weeklytut.setBounds(200, 101, 117, 41);
		weeklytut.setFont(newfont);
		weeklytut.addActionListener(this);
		
		monthlytut = new JButton("Monthly Help");
		monthlytut.setBounds(332, 101, 127, 41);
		monthlytut.setFont(newfont);
		monthlytut.setHorizontalAlignment(SwingConstants.CENTER);
		monthlytut.addActionListener(this);
		
		yearlytut = new JButton("Yearly Help");
		yearlytut.setBounds(471, 101, 117, 41);
		yearlytut.setFont(newfont);
		yearlytut.addActionListener(this);


		returnbtn = new JButton("Return Home");
		returnbtn.setFont(newfont);
		returnbtn.setBounds(332, 154, 127, 41);
		returnbtn.addActionListener(this);

		Icon icon = new ImageIcon("images/ducklings.gif");
		duckimage = new JLabel(icon);
		duckimage.setBounds(105, 207, 541, 178);
		
		// actual GUI
		frame.add(helptitle);
		frame.add(helplabel);
		frame.add(helplabel1);
		frame.add(weeklytut);
		frame.add(monthlytut);
		frame.add(yearlytut);
		frame.add(returnbtn);	
		frame.add(duckimage);

		frame.setVisible(true);
	}

	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == returnbtn) {
			frame.dispose();
		}
		
		if (e.getSource() == weeklytut) {
			new WeeklyHelp();
			frame.dispose();

		}
		if (e.getSource() == monthlytut) {
			new MonthlyHelp();
			frame.dispose();

		}
		
		if (e.getSource() == yearlytut) {
			new YearlyHelp();
			frame.dispose();

		}
	}
}
