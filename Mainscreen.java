import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class Mainscreen implements ActionListener{
	
	static // declaring all components to be used for the main screen 
	JFrame frame;
	static JPanel panel; 
	private static JButton settings, weekly, monthly, yearly; //buttons for week, month, year 
	private static JLabel calendars; 
	private static JLabel username; 
	GridBagConstraints gbc = new GridBagConstraints();
	GridBagConstraints gbc_ = new GridBagConstraints(); // made a seperate constraint to 
							    // set borders between calendar buttons
							    // and the username display
	
	// declaring minor decorative details 
	static Color yellow1 = new Color(243, 215, 3); // tackle logo bg yellow color 
	static Color yellow2 = new Color(130, 113, 53); // buttons color (dark)
	static Color yellow3 = new Color(255, 229, 96); // lighter yellow 
	static Icon icon = new ImageIcon("images/logo.png");
	static Font font1 = new Font("Tahoma", Font.BOLD, 20);
	static Font font2 = new Font("Tahoma", Font.BOLD, 15);
	
	public static void main(String[] args) {
		Screen();
	}
	
	public Mainscreen(){
		// setup the GridBagLayout
		panel.setLayout(new GridBagLayout());
		Insets insets = new Insets(5, 5, 250, 250); // border/spacing for the components; will apply to 
							    // all components using the constraint of gbc. 
							    // parameters order:
							    // (top, bottom, left, right) || might come in handy? 
		
		// add the components 
		calendars = new JLabel("CALENDARS");
		calendars.setFont(font1);
		gbc.gridx = 0; 
		gbc.gridy = 0; 
		frame.add(calendars);
		
		settings = new JButton(icon);
		settings.setFont(font2);
		gbc.gridx = 0;
		gbc.gridy = 1; 
		frame.add(settings); 
		
		weekly = new JButton("Weekly");
		weekly.setFont(font2);
		gbc.gridx = 1;
		gbc.gridy = 1;
		frame.add(weekly);
		
		monthly = new JButton("Monthly");
		monthly.setFont(font2);
		gbc.gridx = 2; 
		gbc.gridy = 1;
		frame.add(monthly);
		
		yearly = new JButton("Yearly");
		yearly.setFont(font2);
		gbc.gridx = 3; 
		gbc.gridy = 1;
		frame.add(yearly);
		
		username = new JLabel("<display username here>"); // get a different public variable to store user input
		username.setFont(font2);			  // for usertxt and display it here?
		gbc.gridx = 1; 									   
		gbc.gridy = 3; 
		frame.add(username);	
	}
	
	static void Screen() {
		Mainscreen ms = new Mainscreen();
		
		// set basic format of the screen 
		frame.setTitle("Tackle");
		frame.setSize(500, 500);
		frame.setBackground(yellow3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(ms); // why qwq
			       // try remove the frame from the frame.add(component) in Mainscreen constructor
			       // and adding a method to make the addition work? 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
