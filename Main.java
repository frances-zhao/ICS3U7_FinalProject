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
	private JLabel userLabel;
	private JLabel pwLabel;
	private JButton loginButton;
	private JLabel success;
	private JLabel projectVer;
	private JButton createAccount;
	private JLabel credentials;
	private JLabel confirmPW;
	private JPasswordField confirmPWTEXT;
	private JLabel confirmnote;

	Font btnfont = new Font("Tahoma", Font.PLAIN, 13);
	// file IO variables
	private String fileName = "userInfo.txt";
	private BufferedWriter output;
	private BufferedReader input;
	// login variables
	private String[][] totalAcc = new String[2][1000]; // maximum number of totalAcc creation: 1000
	String [] usernames, passwords;
	int usernum;
	public static String currentUser;
	private static String currentPW;
	private static String PWconfirm;



	// Main Login Page Class
	Main() throws IOException{

		// reading in all usernames and passwords
		input = new BufferedReader(new FileReader(fileName));

		usernames = input.readLine().split(", ");
		passwords = input.readLine().split(", ");
		usernum = usernames.length;
		for(int i = 0; i < usernum; i++) {
			totalAcc[0][i] = usernames[i];
			totalAcc[1][i] = passwords[i];
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
		image.setFont(btnfont);
		image.setBounds(457, 107, 466, 160);
		frame.add(image);
		image.setIcon(new ImageIcon("images/logo.png"));

		usertxt = new JTextField();
		usertxt.setColumns(10);
		usertxt.setBounds(639, 279, 175, 26);

		passwordtxt = new JPasswordField();
		passwordtxt.setColumns(10);
		passwordtxt.setBounds(639, 317, 175, 26);

		userLabel = new JLabel("user: ");
		userLabel.setFont(btnfont);
		userLabel.setBounds(592, 284, 35, 16);

		pwLabel = new JLabel("password: ");
		pwLabel.setFont(btnfont);
		pwLabel.setBounds(559, 322, 68, 16);

		loginButton = new JButton("Login");
		loginButton.setFont(btnfont);
		loginButton.setBounds(639, 386, 117, 29);
		loginButton.addActionListener(this);

		createAccount = new JButton("Create Account");
		createAccount.setFont(btnfont);
		createAccount.setBounds(639, 417, 117, 29);
		createAccount.addActionListener(this); 

		success = new JLabel("");
		success.setFont(btnfont);
		success.setHorizontalAlignment(SwingConstants.CENTER);
		success.setBounds(609, 399, 240, 16);

		confirmPWTEXT = new JPasswordField();
		confirmPWTEXT.setColumns(10);
		confirmPWTEXT.setBounds(639, 355, 175, 26);

		confirmPW = new JLabel("confirm password:* ");
		confirmPW.setFont(new Font("Tahoma", Font.PLAIN, 13));
		confirmPW.setBounds(503, 360, 127, 16);

		// credentials for application
		credentials = new JLabel("<html>Creators: Frances Zhao, Lucia Kim <br>Course: ICS3U7-01<br>Teacher: Ms. Xie</html>");
		credentials.setFont(btnfont);
		credentials.setBounds(6, 716, 202, 56);

		projectVer = new JLabel("Main.java version 1.2 01/09/2021");
		projectVer.setForeground(Color.LIGHT_GRAY);
		projectVer.setFont(btnfont);
		projectVer.setHorizontalAlignment(SwingConstants.RIGHT);
		projectVer.setBounds(1063, 756, 331, 16);

		confirmnote = new JLabel("<html>*confirm password only if creating new account</html>");
		confirmnote.setFont(btnfont);
		confirmnote.setBounds(673, 441, 164, 40);

		// actual GUI
		frame.add(usertxt);
		frame.add(passwordtxt);
		frame.add(userLabel);
		frame.add(pwLabel);
		frame.add(loginButton);
		frame.add(createAccount);
		frame.add(credentials);
		frame.add(projectVer);
		frame.add(success);
		frame.add(confirmPW);
		frame.add(confirmPWTEXT);
		frame.add(confirmnote);		

		frame.setVisible(true); // making JFrame visible
	}


	// adding a new user
	public void addNewUser() throws IOException {
		totalAcc[1][usernum] = currentPW;
		totalAcc[0][usernum] = currentUser;
		usernum++; // increasing the length of the 2D array to allow for bug-proof adding of account info
		savedUsers();
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
		output.close(); // closing Bufferedwriter
	}

	//checking if username and password match up
	private boolean loginResult() {
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
				new Mainscreen(); // link to new JFrame
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

	}

	// testing the main program
	public static void main(String[] args) {
		try {
			new Main();
		} catch (IOException e) {
			System.out.println("Cannott run");
		}

	}
}
