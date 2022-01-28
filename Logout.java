// import java packages
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

/**
 * class that logouts of the mainscreen for the user, brings user back to home screen
 * @author Frances Zhao
 *
 */
public class Logout extends JFrame implements ActionListener{

	// variable declaration
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel logouttitle = new JLabel("Logout?");
	private JLabel logoutlabel, logoutlabel1;
	private JButton confirmbtn;
	private JButton cancelbtn;


	// font declarations
	Font newfont;
	Font newfont1;


	/**
	 * constructor that implements GUI interface
	 */
	public Logout() {


		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
		} catch (IOException | FontFormatException e){
			System.out.println("Logout - Cannot import font.");

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


		logouttitle.setFont(newfont1);
		logouttitle.setHorizontalAlignment(SwingConstants.CENTER);
		logouttitle.setBounds(155, 6, 90, 46);

		logoutlabel = new JLabel("Are you sure you want ");
		logoutlabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoutlabel.setFont(newfont);
		logoutlabel.setBounds(42, 43, 321, 46);

		logoutlabel1 = new JLabel("to log out of your account?");
		logoutlabel1.setHorizontalAlignment(SwingConstants.CENTER);
		logoutlabel1.setFont(newfont);
		logoutlabel1.setBounds(42, 55, 321, 46);

		confirmbtn = new JButton("Confirm");
		confirmbtn.setFont(newfont);
		confirmbtn.setBounds(226, 120, 117, 56);
		confirmbtn.addActionListener(this);

		cancelbtn = new JButton("Cancel");
		cancelbtn.setFont(newfont);
		cancelbtn.setBounds(42, 120, 117, 56);
		cancelbtn.addActionListener(this);


		// actual GUI
		frame.add(logouttitle);
		frame.add(logoutlabel);
		frame.add(logoutlabel1);
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
			try {
				ColourCSTM.firstcolour = null;
				ColourCSTM.secondcolour = null;
				ColourCSTM.secondcolour = null;

				JOptionPane.showMessageDialog(this, "Logging out...");
				frame.dispose();
				new Main(); // redirect to main class
			} catch (IOException e1) {
				System.out.println("cannot return to login");
			}


		}

		if (e.getSource() == cancelbtn) { // if cancel button clicked
			frame.dispose(); // dispose of current frame
			try {
				new Mainscreen();
			} catch (IOException e1) {
				System.out.println("cannot return to main screen");
			}
		}
	}

	


}
