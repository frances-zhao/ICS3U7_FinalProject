import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.awt.event.*;


public class accountCfm extends JFrame implements ActionListener{

	// variable declaration
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel acctitle = new JLabel("Which Account?");
	private JLabel acclabel;
	private JButton confirmbtn;
	private JButton cancelbtn;
	private JLabel userlabel;
	private JTextField username;


	// font declaration
	Font newfont;
	Font newnewfont;

	// file IO variables
	private BufferedReader input;
	private String fileName = "userInfo.txt";
	String [] usernames, passwords;
	int usernum;
	private String[][] totalAcc = new String[2][1000]; // maximum number of totalAcc creation: 1000

	public static String userinput;
	public static String pwinput;



	/**
	 * @throws IOException 
	 */
	public accountCfm() throws IOException {
		
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
			newnewfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
		} catch (IOException | FontFormatException e){
			
		}

		// initializing frame
		final int HEIGHT = 250;
		final int WIDTH = 400;
		frame = new JFrame("Logout?"); // title of application
		frame.setTitle("Which Account?");
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);

		acctitle.setFont(newnewfont);
		acctitle.setHorizontalAlignment(SwingConstants.CENTER);
		acctitle.setBounds(109, 6, 171, 46);

		acclabel = new JLabel("Please input the username");
		acclabel.setHorizontalAlignment(SwingConstants.CENTER);
		acclabel.setFont(newfont);
		acclabel.setBounds(42, 43, 321, 46);
		
		acclabel = new JLabel("you'd like to switch to:");
		acclabel.setHorizontalAlignment(SwingConstants.CENTER);
		acclabel.setFont(newfont);
		acclabel.setBounds(42, 55, 321, 46);

		confirmbtn = new JButton("Confirm");
		confirmbtn.setFont(newfont);
		confirmbtn.setBounds(226, 128, 117, 56);
		confirmbtn.addActionListener(this);

		cancelbtn = new JButton("Cancel");
		cancelbtn.setFont(newfont);
		cancelbtn.setBounds(42, 128, 117, 56);
		cancelbtn.addActionListener(this);

		username = new JTextField();
		username.setFont(newfont);
		username.setBounds(109, 90, 171, 26);
		username.setColumns(10);

		userlabel = new JLabel("USER: ");
		userlabel.setFont(newfont);
		userlabel.setHorizontalAlignment(SwingConstants.RIGHT);
		userlabel.setBounds(42, 95, 61, 16);
		
		// actual GUI
		frame.add(acctitle);
		frame.add(acclabel);
		frame.add(confirmbtn);
		frame.add(cancelbtn);
		frame.add(userlabel);
		frame.add(username);
		
		frame.setVisible(true);
	}


	// reading in users on text file "userInfo.txt"
	public void readUsers() throws IOException {
		input = new BufferedReader(new FileReader(fileName));

		usernames = input.readLine().split(", ");
		usernum = usernames.length;
		for(int i = 0; i < usernum; i++) {
			totalAcc[0][i] = usernames[i];
		}
		input.close(); //closing input

	}

	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == confirmbtn) { // if confirm button clicked
			try {
				readUsers(); // read in all users
				userinput = username.getText(); // getting user's typed in username
				if (Arrays.asList(totalAcc[0]).contains(userinput)) { // if totalAcc[0] contains username input
					JOptionPane.showMessageDialog(this, "Found User! Returning to login page...");
					new Main(); // return to main class
					frame.dispose(); // dispose frame
				}
				else { // if no username exists, let user know
					JOptionPane.showMessageDialog(this, "This user doesn't exist!");

				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		if (e.getSource() == cancelbtn) { // if cancel button clicked
			frame.dispose(); // dispose frame
		}
	}


}
