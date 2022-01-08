import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener{
	private static JPasswordField passwordtxt;
	private static JTextField usertxt;
	private static JLabel userLabel;
	private static JLabel pwLabel;
	private static JButton loginButton;
	private static JLabel success;
	private static JLabel lblNewLabel;

	public static void main(String[] args) {
		LoginPage();

	}

	static void LoginPage(){

		final int HEIGHT = 800;
		final int WIDTH = 1400;
		JFrame frame = new JFrame("Tackle - Lucia Kim, Frances Zhao");
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(243, 215, 3));
		frame.getContentPane().setBackground(new Color(243, 215, 3));
		frame.setLayout(null);
		frame.setResizable(false);

		JLabel image = new JLabel("Tackle Logo Image");
		image.setFont(new Font("Tahoma", Font.PLAIN, 13));
		image.setBounds(457, 107, 466, 160);
		frame.add(image);
		image.setIcon(new ImageIcon("images/logo.png"));

		usertxt = new JTextField();
		usertxt.setColumns(10);
		usertxt.setBounds(639, 279, 175, 26);
		frame.add(usertxt);

		passwordtxt = new JPasswordField();
		passwordtxt.setColumns(10);
		passwordtxt.setBounds(639, 317, 175, 26);
		frame.add(passwordtxt);

		userLabel = new JLabel("user: ");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userLabel.setBounds(592, 284, 35, 16);
		frame.add(userLabel);

		pwLabel = new JLabel("password: ");
		pwLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwLabel.setBounds(559, 322, 68, 16);
		frame.add(pwLabel);

		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginButton.setBounds(642, 359, 117, 29);
		loginButton.addActionListener(new Main());
		frame.add(loginButton);

		success = new JLabel("");
		success.setFont(new Font("Tahoma", Font.PLAIN, 13));
		success.setHorizontalAlignment(SwingConstants.CENTER);

		success.setBounds(584, 400, 240, 16);
		frame.add(success);

		JLabel credentials = new JLabel("<html>Creators: Frances Zhao, Lucia Kim <br>Course: ICS3U7-01<br>Teacher: Ms. Xie</html>");
		credentials.setFont(new Font("Tahoma", Font.PLAIN, 13));
		credentials.setBounds(6, 716, 202, 56);
		frame.add(credentials);

		lblNewLabel = new JLabel("Main.java version 1.1 12/29/2021");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(1063, 756, 331, 16);
		frame.add(lblNewLabel);
		frame.setVisible(true);
	}

	/*
	 * currently, without the create account method, the login doesn't fully work yet
	 * once Create Account class created, the if statement will be changed to match the new account
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String user = usertxt.getText();
		String password = passwordtxt.getText();
		System.out.println(user + ", " + password);

		if (user.equals(usertxt.getText()) && password.equals(passwordtxt.getText())) {
			success.setText("login successful!");
		}
		else {
			success.setText("username or password invalid");
		}
	}
}
