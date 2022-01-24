// import java packages
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;


public class ColourCSTM extends JFrame implements ActionListener{

	// variable declaration
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel colourtitle = new JLabel("Colour Customization?");
	private JLabel colourlabel, colourlabel1;
	private JButton pinkbtn, yellowbtn, bluebtn;

	// font declarations
	Font newfont, smallestfont, newfont1;	

	public ColourCSTM() {

		try {
			smallestfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(10f);
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
		} catch (IOException | FontFormatException e){

		}

		// initializing frame
		final int HEIGHT = 250;
		final int WIDTH = 400;
		frame = new JFrame("Logout?"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);


		colourtitle.setFont(newfont1);
		colourtitle.setHorizontalAlignment(SwingConstants.CENTER);
		colourtitle.setBounds(59, 6, 278, 46);

		colourlabel = new JLabel("Which colour would");
		colourlabel.setHorizontalAlignment(SwingConstants.CENTER);
		colourlabel.setFont(newfont);
		colourlabel.setBounds(42, 43, 321, 46);

		colourlabel1 = new JLabel("you like to switch to?");
		colourlabel1.setHorizontalAlignment(SwingConstants.CENTER);
		colourlabel1.setFont(newfont);
		colourlabel1.setBounds(42, 55, 321, 46);

		bluebtn = new JButton("Ocean");
		bluebtn.setBackground(new Color(164, 210, 237));
		bluebtn.setBounds(31, 100, 89, 23);
		bluebtn.setFont(newfont);

		yellowbtn = new JButton("Bumble");
		yellowbtn.setBackground(new Color(255, 208, 37));
		yellowbtn.setBounds(149, 100, 89, 23);
		yellowbtn.setFont(newfont);

		pinkbtn = new JButton("Blossom");
		pinkbtn.setBackground(new Color(240, 156, 166));
		pinkbtn.setBounds(262, 100, 89, 23);
		pinkbtn.setFont(newfont);

		// actual GUI
		frame.add(colourtitle);
		frame.add(colourlabel);
		frame.add(colourlabel1);
		frame.add(pinkbtn);
		frame.add(yellowbtn);
		frame.add(bluebtn);


		bluebtn.addActionListener(this);
		yellowbtn.addActionListener(this);
		pinkbtn.addActionListener(this);
		frame.setVisible(true);
	}

	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == pinkbtn){
			
		
		}
	}

}
