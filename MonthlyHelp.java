import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

public class MonthlyHelp extends JFrame implements ActionListener {
	private JFrame frame;
	private JButton returnbtn;
	private JLabel helptitle = new JLabel("Monthly Help");
	private JLabel helplabel, helplabel1, helplabel2;
	private JLabel monthlogo, duckimage;


	// font declarations
	Font newfont;
	Font newfont1;

	public MonthlyHelp(){

		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
		} catch (IOException | FontFormatException e){

		}

		// initializing frame
		final int HEIGHT = 500;
		final int WIDTH = 800;
		frame = new JFrame("Monthly Help"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);

		helptitle.setFont(newfont1);
		helptitle.setHorizontalAlignment(SwingConstants.CENTER);
		helptitle.setBounds(295, 6, 221, 46);

		helplabel = new JLabel("The Monthly Calendar is fairly simple to use! Here are some tips: ");
		helplabel.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel.setFont(newfont);
		helplabel.setBounds(28, 43, 738, 46);

		helplabel1 = new JLabel("click on the arrow buttons to go back and forth per monthly calendar,");
		helplabel1.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel1.setFont(newfont);
		helplabel1.setBounds(28, 58, 738, 46);

		helplabel2 = new JLabel("click on the logo (checkmark) to return back to the main screen!");
		helplabel2.setHorizontalAlignment(SwingConstants.CENTER);
		helplabel2.setFont(newfont);
		helplabel2.setBounds(37, 380, 729, 46);

		returnbtn = new JButton("Return Home");
		returnbtn.setFont(newfont);
		returnbtn.setBounds(348, 420, 117, 41);
		returnbtn.addActionListener(this);

		Border b = new LineBorder(Color.WHITE, 3);

		Icon icon = new ImageIcon("images/monthlogo.png");
		monthlogo = new JLabel(icon);

		monthlogo.setBorder(b);
		monthlogo.setBounds(164, 101, 462, 185);

		Icon icon1 = new ImageIcon("images/duckplan.gif");
		duckimage = new JLabel(icon1);
		duckimage.setBounds(164, 293, 454, 97);



		frame.add(monthlogo);
		frame.add(duckimage);
		frame.add(returnbtn);
		frame.add(helptitle);
		frame.add(helplabel);
		frame.add(helplabel1);
		frame.add(helplabel2);

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == returnbtn) {
			new Help();
			frame.dispose();
		}
	}
}
