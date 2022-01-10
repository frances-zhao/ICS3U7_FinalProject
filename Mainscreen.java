import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

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
	static Font font2 = new Font("Tahoma", Font.PLAIN, 15);


	// declaring minor decorative details 


	public void doSmth() throws IOException {
	      

	   }
	Mainscreen() throws IOException{
		
		Main loginpage = new Main();
	    String userDisplay = loginpage.getUser();

		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame = new JFrame("Tackle"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(yellow1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// setup the GridBagLayout
		frame.getContentPane().setLayout(new GridBagLayout());
		Insets insets = new Insets(5, 5, 250, 250); // border/spacing for the components; will apply to 
		// all components using the constraint of gbc. 
		// parameters order:
		// (top, bottom, left, right) || might come in handy? 

		// add the components 
		calendars = new JLabel("CALENDARS");
		calendars.setFont(font1);
		gbc.gridx = 0; 
		gbc.gridy = 0; 

		settings = new JButton(icon);
		settings.setFont(font2);
		gbc.gridx = 0;
		gbc.gridy = 1; 

		weekly = new JButton("Weekly");
		weekly.setFont(font2);
		gbc.gridx = 1;
		gbc.gridy = 1;

		monthly = new JButton("Monthly");
		monthly.setFont(font2);
		gbc.gridx = 2; 
		gbc.gridy = 1;

		yearly = new JButton("Yearly");
		yearly.setFont(font2);
		gbc.gridx = 3; 
		gbc.gridy = 1;

		username = new JLabel(userDisplay); // get a different public variable to store user input
		username.setFont(font2);			  // for usertxt and display it here?
		gbc.gridx = 1; 									   
		gbc.gridy = 3; 
		
		
		settings.addActionListener(this);
		weekly.addActionListener(this);
		monthly.addActionListener(this);
		yearly.addActionListener(this);

		frame.getContentPane().add(calendars);
		frame.getContentPane().add(settings); 
		frame.getContentPane().add(weekly);
		frame.getContentPane().add(monthly);
		frame.getContentPane().add(yearly);
		GridBagConstraints gbc_username = new GridBagConstraints();
		gbc_username.gridx = 5;
		frame.getContentPane().add(username, gbc_username);

		frame.setVisible(true);

	}

	static void Screen() throws IOException {	
		// set basic format of the screen 

		new Mainscreen();


		// why qwq
		// try remove the frame from the frame.add(component) in Mainscreen constructor
		// and adding a method to make the addition work? 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == settings) {
			
		}
		
		if (e.getSource() == weekly) {
			new Weekly();
			frame.dispose(); // dispose of current frame

		}
		if (e.getSource() == monthly) {
			new Monthly();
			frame.dispose(); // dispose of current frame

		}
		if (e.getSource() == yearly) {
			new Yearly();
			frame.dispose(); // dispose of current frame

		}
		
		
	}
	public static void main(String[] args) {
		try {
			new Mainscreen();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
