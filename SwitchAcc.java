import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;


public class SwitchAcc extends JFrame implements ActionListener{

	// variable declaration
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel switchtitle = new JLabel("Switch Account?");
	private JLabel switchlabel, switchlabel1;
	private JButton confirmbtn;
	private JButton cancelbtn;
	
	// font declarations
	Font newfont;
	Font newnewfont;


	public SwitchAcc() {
		
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
			newnewfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
		} catch (IOException | FontFormatException e){
			
		}

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

		switchtitle.setFont(newnewfont);
		switchtitle.setHorizontalAlignment(SwingConstants.CENTER);
		switchtitle.setBounds(94, 6, 205, 46);

		switchlabel = new JLabel("Are you sure you want ");
		switchlabel.setHorizontalAlignment(SwingConstants.CENTER);
		switchlabel.setFont(newfont);
		switchlabel.setBounds(42, 43, 321, 46);
		
		switchlabel1 = new JLabel("to switch accounts?");
		switchlabel1.setHorizontalAlignment(SwingConstants.CENTER);
		switchlabel1.setFont(newfont);
		switchlabel1.setBounds(42, 55, 321, 46);

		
		confirmbtn = new JButton("Confirm");
		confirmbtn.setFont(newfont);
		confirmbtn.setBounds(226, 120, 117, 56);
		confirmbtn.addActionListener(this);

		cancelbtn = new JButton("Cancel");
		cancelbtn.setFont(newfont);
		cancelbtn.setBounds(42, 120, 117, 56);
		cancelbtn.addActionListener(this);
		
		// actual GUI
		frame.add(switchtitle);
		frame.add(switchlabel);
		frame.add(switchlabel1);
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

	
}
