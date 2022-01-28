import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Main extends JFrame implements ActionListener{

	// variable declaration

	// GUI variables
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPasswordField passwordtxt;
	private JTextField usertxt;
	private JLabel userLabel, pwLabel, success, projectVer, credentials, credentials_1, credentials_2, confirmPW, confirmnote, confirmnote_1;
	private JButton loginButton;
	private JButton createAccount;
	private JPasswordField confirmPWTEXT;
	static File filename1, filename2;
	
	Font newfont;
	Font btnfont = new Font("Tahoma", Font.PLAIN, 13);
	// file IO variables
	private String fileName = "userInfo.txt";
	private BufferedWriter output;
	private BufferedReader input;
	// login variables
	
	private String[][] totalAcc = new String[4][1000]; // maximum number of totalAcc creation: 1000
	String [] usernames, passwords, eventnamefile, eventdescfile;
	static int usernum;
	public static String currentUser;
	private static String currentPW;
	private static String PWconfirm;
	public static String fname1, fname2; 


	// Main Login Page Class
	Main() throws IOException{

		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
		} catch (IOException | FontFormatException e){
			
		}
		// reading in all usernames and passwords
		input = new BufferedReader(new FileReader(fileName));

		usernames = input.readLine().split(", ");
		passwords = input.readLine().split(", ");
		eventnamefile = input.readLine().split(", ");
		eventdescfile = input.readLine().split(", ");
		usernum = usernames.length;
		for(int i = 0; i < usernum; i++) {
			totalAcc[0][i] = usernames[i];
			totalAcc[1][i] = passwords[i];
			totalAcc[2][i] = eventnamefile[i];
			totalAcc[3][i] = eventdescfile[i];

		}
		input.close(); //closing input

		// initializing screen size
		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame = new JFrame("Tackle - Lucia Kim, Frances Zhao"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(243, 215, 3));
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// initializing JLABEL for logo image
		JLabel image = new JLabel("Tackle Logo Image");
		image.setFont(newfont);
		image.setBounds(457, 107, 466, 160);
		frame.add(image);
		image.setIcon(new ImageIcon("images/logo.png"));

		usertxt = new JTextField();
		usertxt.setFont(newfont);
		usertxt.setColumns(10);
		usertxt.setBounds(639, 279, 175, 26);

		passwordtxt = new JPasswordField();
		passwordtxt.setColumns(10);
		passwordtxt.setBounds(639, 317, 175, 26);

		userLabel = new JLabel("user: ");
		userLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		userLabel.setFont(newfont);
		userLabel.setBounds(560, 284, 67, 16);

		pwLabel = new JLabel("password: ");
		pwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLabel.setFont(newfont);
		pwLabel.setBounds(527, 322, 100, 16);

		loginButton = new JButton("Login");
		loginButton.setFont(newfont);
		loginButton.setBounds(639, 386, 175, 29);
		loginButton.addActionListener(this);

		createAccount = new JButton("Create Account");
		createAccount.setFont(newfont);
		createAccount.setBounds(639, 417, 175, 29);
		createAccount.addActionListener(this); 

		success = new JLabel("");
		success.setFont(newfont);
		success.setHorizontalAlignment(SwingConstants.CENTER);
		success.setBounds(609, 399, 240, 16);

		confirmPWTEXT = new JPasswordField();
		confirmPWTEXT.setColumns(10);
		confirmPWTEXT.setBounds(639, 355, 175, 26);

		confirmPW = new JLabel("confirm password:* ");
		confirmPW.setHorizontalAlignment(SwingConstants.RIGHT);
		confirmPW.setFont(newfont);
		confirmPW.setBounds(481, 360, 149, 16);

		// credentials for application
		credentials = new JLabel("Creators: Frances Zhao, Lucia Kim");
		credentials.setFont(newfont);
		credentials.setBounds(6, 700, 272, 26);
		
		credentials_1 = new JLabel("Course: ICS3U7-01");
		credentials_1.setFont(newfont);
		credentials_1.setBounds(6, 720, 272, 26);
		
		credentials_2 = new JLabel("Teacher: Ms. Xie");
		credentials_2.setFont(newfont);
		credentials_2.setBounds(6, 740, 272, 26);

		projectVer = new JLabel("Main.java version final 01/27/2022");
		projectVer.setForeground(Color.LIGHT_GRAY);
		projectVer.setFont(newfont);
		projectVer.setHorizontalAlignment(SwingConstants.RIGHT);
		projectVer.setBounds(1063, 740, 331, 26);

		confirmnote = new JLabel("*confirm password only ");
		confirmnote.setFont(newfont);
		confirmnote.setBounds(673, 441, 176, 40);
		
		confirmnote_1 = new JLabel("if creating new account");
		confirmnote_1.setFont(newfont);
		confirmnote_1.setBounds(673, 455, 176, 40);

		// actual GUI
		frame.add(usertxt);
		frame.add(passwordtxt);
		frame.add(userLabel);
		frame.add(pwLabel);
		frame.add(loginButton);
		frame.add(createAccount);
		frame.add(credentials);
		frame.add(credentials_1);
		frame.add(credentials_2);
		frame.add(projectVer);
		frame.add(success);
		frame.add(confirmPW);
		frame.add(confirmPWTEXT);
		frame.add(confirmnote);
		frame.add(confirmnote_1);		


		frame.setVisible(true); // making JFrame visible
	}

	// getting current User String
	public static String getUser() {
		return Main.currentUser;
	}


	// adding a new user
	public void addNewUser() throws IOException {
		totalAcc[1][usernum] = currentPW;
		totalAcc[0][usernum] = currentUser;
		totalAcc[2][usernum] = usernum + "eventname";
		totalAcc[3][usernum] = usernum + "eventdesc";
		
		// new file names for new account
		
		filename1 = new File(usernum + "eventname.txt");
		filename2 = new File(usernum + "eventdesc.txt");

		usernum++; // increasing the length of the 2D array to allow for bug-proof adding of account info
		
		// creating new files
		filename1.createNewFile();
		filename2.createNewFile();
		
		// new buffered writer
		BufferedWriter out_t = new BufferedWriter(new FileWriter(filename1)); // title+time of event 
		BufferedWriter out_d = new BufferedWriter(new FileWriter(filename2)); // event description 
		
		// writing Sample, into new files
		for(int i = 0; i < 8; i++) {
			out_t.write("Sample, ");
			out_t.newLine();
		}
		for(int i = 0; i < 7; i++) {
			out_d.write("Sample, ");
			out_d.newLine();

		}
		out_t.close();
		out_d.close();

		// saved user method
		savedUsers();
		
	}
	
	// getter method for current file1
	public static String getfile1() {
		fname1 = usernum-1 + "eventname.txt";
		return fname1;
	}

	// getter method for current file2
	public static String getfile2() {
		fname2 = usernum-1 + "eventdesc.txt";
		return fname2;
	}
	
	// class for savedUsers, writes out all account information – username and password, into fileName (userinfo.txt)
	public void savedUsers() throws IOException {
		output = new BufferedWriter(new FileWriter(fileName));
		for(int i = 0; i < usernum; i++) {
			output.write(totalAcc[0][i] + ", "); // separating each username with ", "
		}
		output.newLine();

		for(int i = 0; i < usernum; i++) {
			output.write(totalAcc[1][i] + ", "); // separating each password with ", "
		}
		output.newLine();
		
		for(int i = 0; i < usernum; i++) {
			output.write(totalAcc[2][i] +", "); // separating each file name with ", "
		}
		output.newLine();
		
		for(int i = 0; i < usernum; i++) {
			output.write(totalAcc[3][i] +", "); // separating each file name with ", "
		}
		output.newLine();
		
		output.close(); // closing Bufferedwriter
		
		
	}

	//checking if username and password match up
	public boolean loginResult() {
		for(int i = 0; i < usernum; i++) {
			if(currentUser.equals(totalAcc[0][i]) && currentPW.equals(totalAcc[1][i])) {
				return true;
			}

		}
		return false;
	}
	

	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==loginButton) { // if login button clicked
			currentUser = usertxt.getText(); // input of user in JTextField becomes current user
			currentPW = passwordtxt.getText(); // input of password in JPasswordField becomes current password
			if(loginResult()) { // testing if username and password match
				JOptionPane.showMessageDialog(this, "Login Successful!"); // pop up panel
				try {
					new Mainscreen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // link to new JFrame
				frame.dispose(); // dispose of current frame

			} else {
				JOptionPane.showMessageDialog(this, "Wrong username or password!"); // if they do not match up, let user know
			}

		}
		if (e.getSource() == createAccount) { // if create account button clicked

			currentUser = usertxt.getText(); // input of user in JTextField becomes current user
			currentPW = passwordtxt.getText(); // input of password in JPasswordField becomes current password
			try {
				if(currentUser.equals("") || currentPW.equals("")) { // ensuring that new account created has both a username and password
					JOptionPane.showMessageDialog(this, "You must enter both a user and password to create an account.");
				}

				else if(Arrays.asList(totalAcc[0]).contains(currentUser)){ // if the first row of strings (usernames), contains the currentUser
					JOptionPane.showMessageDialog(this, "An account with this user already exists!"); // let user know

				} else { // if username and password are filled, with no duplicate username
					PWconfirm = confirmPWTEXT.getText();
					if (currentPW.equals(PWconfirm)) {
						addNewUser();
						JOptionPane.showMessageDialog(this, "Account Created!");
						new Mainscreen(); // link to new JFrame
						frame.dispose(); // dispose of current frame
					}
					else {
						JOptionPane.showMessageDialog(this, "Wrong password confirmation!");
					}
				} 

			} catch (IOException event) {
				event.printStackTrace();
			}
		}

	} // end actionPerformed


	// testing the main program
	public static void main(String[] args) {
		try {
			new Main();
		} catch (IOException e) {
			System.out.println("Cannot run");
		}

	}
}
