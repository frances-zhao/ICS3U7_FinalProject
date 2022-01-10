import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;


public class SwitchAcc extends JFrame implements ActionListener{

	// variable declaration
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel switchtitle = new JLabel("Switch Account?");
	private JLabel switchlabel;
	private JButton confirmbtn;
	private JButton cancelbtn;
	
	// font declarations
	static Font font1 = new Font("Tahoma", Font.PLAIN, 15);
	static Font font2 = new Font("Tahoma", Font.PLAIN, 18);


	public SwitchAcc() {

		// initializing frame
		final int HEIGHT = 250;
		final int WIDTH = 400;
		frame = new JFrame("Switch Account?"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);

		switchtitle.setFont(font2);
		switchtitle.setHorizontalAlignment(SwingConstants.CENTER);
		switchtitle.setBounds(121, 6, 148, 46);

		switchlabel = new JLabel("<html>Are you sure you want <br>to switch accounts?</html>");
		switchlabel.setHorizontalAlignment(SwingConstants.CENTER);
		switchlabel.setFont(font1);
		switchlabel.setBounds(42, 43, 321, 46);

		confirmbtn = new JButton("Confirm");
		confirmbtn.setFont(font1);
		confirmbtn.setBounds(226, 120, 117, 56);
		confirmbtn.addActionListener(this);

		cancelbtn = new JButton("Cancel");
		cancelbtn.setFont(font1);
		cancelbtn.setBounds(42, 120, 117, 56);
		cancelbtn.addActionListener(this);
		
		// actual GUI
		frame.add(switchtitle);
		frame.add(switchlabel);
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
				new accountCfm(); // redirect to accountCfm class
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();

		}

		if (e.getSource() == cancelbtn) { // if cancel button clicked
			frame.dispose(); // dispose frame
		}
	}

	// testing the main program
	public static void main(String[] args) {
		try {
			new SwitchAcc();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
