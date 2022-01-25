import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class Help implements ActionListener{

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


	public Help() {

		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
		} catch (IOException | FontFormatException e){

		}

		// initializing frame
		final int HEIGHT = 500;
		final int WIDTH = 800;
		frame = new JFrame("Help"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		weeklytut.setBounds(213, 101, 117, 41);
		weeklytut.setFont(newfont);
		weeklytut.addActionListener(this);

		
		monthlytut = new JButton("Monthly Help");
		monthlytut.setBounds(342, 101, 117, 41);
		monthlytut.setFont(newfont);
		monthlytut.addActionListener(this);


		
		yearlytut = new JButton("Yearly Help");
		yearlytut.setBounds(471, 101, 117, 41);
		yearlytut.setFont(newfont);
		yearlytut.addActionListener(this);


		returnbtn = new JButton("Return Home");
		returnbtn.setFont(newfont);
		returnbtn.setBounds(342, 154, 117, 41);
		returnbtn.addActionListener(this);

		
		// actual GUI
		frame.add(helptitle);
		frame.add(helplabel);
		frame.add(helplabel1);
		frame.add(weeklytut);
		frame.add(monthlytut);
		frame.add(yearlytut);
		frame.add(returnbtn);
		
		Icon icon = new ImageIcon("images/ducklings.gif");
		duckimage = new JLabel(icon);
		
		duckimage.setBounds(105, 207, 541, 178);
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