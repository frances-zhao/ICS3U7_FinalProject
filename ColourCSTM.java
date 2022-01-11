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
	private JButton confirmbtn;
	private JButton cancelbtn;

	// font declarations
	Font newfont;
	Font newfont1;

	
	public ColourCSTM() {
		
		try {
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

		confirmbtn = new JButton("Confirm");
		confirmbtn.setFont(newfont);
		confirmbtn.setBounds(226, 120, 117, 56);
		confirmbtn.addActionListener(this);

		cancelbtn = new JButton("Cancel");
		cancelbtn.setFont(newfont);
		cancelbtn.setBounds(42, 120, 117, 56);
		cancelbtn.addActionListener(this);


		// actual GUI
		frame.add(colourtitle);
		frame.add(colourlabel);
		frame.add(colourlabel1);
		frame.add(confirmbtn);
		frame.add(cancelbtn);

		frame.setVisible(true);
	}

	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == confirmbtn) { // if confirm button clicked
			JOptionPane.showMessageDialog(this, "Changing colour theme...");
			frame.dispose();

		}

		if (e.getSource() == cancelbtn) { // if cancel button clicked
			frame.dispose(); // dispose of current frame
		}
	}

	// testing the main program
	public static void main(String[] args) {
		try {
			new ColourCSTM();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
