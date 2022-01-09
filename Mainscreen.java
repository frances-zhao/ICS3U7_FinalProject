import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class Mainscreen extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	static // declaring all components to be used for the main screen 
	JFrame frame = new JFrame("Tackle");
	static JPanel panel; 
	private static JButton settings, weekly, monthly, yearly; //buttons for week, month, year 
	private static JLabel calendars; 
	private static JLabel username; 
	GridBagConstraints gbc = new GridBagConstraints();
	GridBagConstraints gbc_ = new GridBagConstraints(); // made a seperate constraint to 
	// set borders between calendar buttons
	// and the username display

	static Color yellow1 = new Color(243, 215, 3); // tackle logo bg yellow color 
	static Color yellow2 = new Color(130, 113, 53); // buttons color (dark)
	static Color yellow3 = new Color(255, 229, 96); // lighter yellow 
	static Icon icon = new ImageIcon("images/logo.png");
	static Font font1 = new Font("Tahoma", Font.BOLD, 20);
	static Font font2 = new Font("Tahoma", Font.BOLD, 15);

	
	// declaring minor decorative details 


	Mainscreen(){
		
		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame = new JFrame("Tackle"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(yellow1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// setup the GridBagLayout
		frame.setLayout(new GridBagLayout());
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
		
		frame.setVisible(true);

	}

	static void Screen() {	
		// set basic format of the screen 
		
		new Mainscreen();
		
		
		// why qwq
		// try remove the frame from the frame.add(component) in Mainscreen constructor
		// and adding a method to make the addition work? 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		try {
			new Mainscreen();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
