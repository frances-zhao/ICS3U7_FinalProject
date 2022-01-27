// import java packages
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;


public class ColourCSTM extends JFrame implements ActionListener{

	// variable declaration
	static Color firstcolour;
	static Color secondcolour;
	static Color thirdcolour;
	
	int i = 0;

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
		
		// getting current User String
		
	}
	
	

	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == pinkbtn){
			i = 1;
			JOptionPane.showMessageDialog(this, "Changing to blossom theme... ");
			setColours();
			try {
				new Mainscreen();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
		
		if(e.getSource() == bluebtn) {
			i = 2;
			JOptionPane.showMessageDialog(this, "Changing to ocean theme... ");
			setColours();
			try {
				new Mainscreen();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
		if (e.getSource() == yellowbtn) {
			i = 3;
			JOptionPane.showMessageDialog(this, "Changing to bumble theme... ");
			setColours();
			try {
				new Mainscreen();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}
	}
	
	public void setColours() {
		if(i == 1) {
			firstcolour = new Color(240, 156, 166);
			secondcolour = new Color(240, 156, 166);
			thirdcolour = new Color(138, 39, 58);

		}
		if (i == 2) {
			firstcolour = new Color(164, 210, 237);
			secondcolour = new Color(76, 150, 194);
			thirdcolour = new Color(35, 61, 77);
		}
		
		if(i == 3) {
			firstcolour = new Color(255, 208, 37);
			secondcolour = new Color(245, 208, 76);
			thirdcolour = new Color(69, 62, 39);
		}
	}
	
	public static Color getFirstColour() {
		return firstcolour;
	}
	
	public static Color getSecondColour() {
		return secondcolour;
	}
	public static Color getThirdColour() {
		return thirdcolour;
	}
	
}
