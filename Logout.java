// import java packages
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;


public class Logout extends JFrame implements ActionListener{

	// variable declaration
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel logouttitle = new JLabel("Logout?");
	private JLabel logoutlabel;
	private JButton confirmbtn;
	private JButton cancelbtn;

	// font declarations
	static Font font1 = new Font("Tahoma", Font.PLAIN, 15);
	static Font font2 = new Font("Tahoma", Font.PLAIN, 18);

	
	public Logout() {
		
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

		
		logouttitle.setFont(font2);
		logouttitle.setHorizontalAlignment(SwingConstants.CENTER);
		logouttitle.setBounds(155, 6, 90, 46);

		logoutlabel = new JLabel("<html>Are you sure you want to <br>log out of your account?</html>");
		logoutlabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoutlabel.setFont(font1);
		logoutlabel.setBounds(42, 43, 321, 46);

		confirmbtn = new JButton("Confirm");
		confirmbtn.setFont(font1);
		confirmbtn.setBounds(226, 120, 117, 56);
		confirmbtn.addActionListener(this);

		cancelbtn = new JButton("Cancel");
		cancelbtn.setFont(font1);
		cancelbtn.setBounds(42, 120, 117, 56);
		cancelbtn.addActionListener(this);


		// actual GUI
		frame.add(logouttitle);
		frame.add(logoutlabel);
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
				new Main(); // redirect to main class
				frame.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}

		if (e.getSource() == cancelbtn) { // if cancel button clicked
			frame.dispose(); // dispose of current frame
		}
	}

	// testing the main program
	public static void main(String[] args) {
		try {
			new Logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
