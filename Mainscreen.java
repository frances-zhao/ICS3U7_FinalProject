import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Mainscreen extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	static // declaring all components to be used for the main screen 
	JFrame frame = new JFrame("Tackle");
	static JPanel panel; 
	private static JButton weekly, monthly, yearly; //buttons for week, month, year 
	private static JLabel username; 
	private static JLabel scheduleLabel;

	Font newfont;

	
	static Color yellow1 = new Color(243, 215, 3); // tackle logo bg yellow color 
	static Color yellow2 = new Color(130, 113, 53); // buttons color (dark)
	static Color yellow3 = new Color(255, 229, 96); // lighter yellow 
	static Icon icon = new ImageIcon("images/logo.png");
	static Font font1 = new Font("Tahoma", Font.BOLD, 20);
	static Font font2 = new Font("Tahoma", Font.PLAIN, 15);
	static Font font3 = new Font(".AppleSystemUIFont", Font.PLAIN, 19);
	private static JMenuBar menuBar;
	private static JMenu settings;
	private static JMenuItem colourCSTM;
	private static JMenuItem switchAcc;
	private static JMenuItem logout;


	// declaring minor decorative details 


	Mainscreen() throws IOException{
		
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
		} catch (IOException | FontFormatException e){
			
		}
		
		Main loginpage = new Main();
	    String userDisplay = loginpage.getUser();
		
		//Main loginpage = new Main();
		//String userDisplay = loginpage.getUser();

		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame = new JFrame("Tackle"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(yellow1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		weekly = new JButton("Weekly");
		weekly.setBounds(919, 117, 135, 77);
		weekly.setFont(newfont);

		monthly = new JButton("Monthly");
		monthly.setBounds(1066, 117, 135, 77);
		monthly.setFont(newfont);

		yearly = new JButton("Yearly");
		yearly.setBounds(1213, 117, 135, 77);
		yearly.setFont(newfont);

		username = new JLabel(userDisplay); // get a different public variable to store user input
		username.setBounds(50, 105, 429, 59);
		username.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 33));
		
		menuBar = new JMenuBar();
		menuBar.setBounds(12, 20, 73, 22);
		menuBar.setFont(newfont);
		frame.add(menuBar);

		settings = new JMenu("Settings");
		settings.setFont(newfont);
		menuBar.add(settings);

		colourCSTM = new JMenuItem("Colour Customization");
		colourCSTM.setFont(newfont);
		settings.add(colourCSTM);

		switchAcc = new JMenuItem("Switch Accounts");
		switchAcc.setFont(newfont);
		settings.add(switchAcc);

		logout = new JMenuItem("Logout");
		logout.setFont(newfont);
		settings.add(logout);

		scheduleLabel = new JLabel("SCHEDULER");
		scheduleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scheduleLabel.setBounds(919, 54, 429, 51);
		scheduleLabel.setFont(newfont);

		colourCSTM.addActionListener(this);
		switchAcc.addActionListener(this);
		logout.addActionListener(this);
		weekly.addActionListener(this);
		monthly.addActionListener(this);
		yearly.addActionListener(this);
		frame.setLayout(null);
		frame.add(weekly);
		frame.add(monthly);
		frame.add(yearly);
		frame.add(username);
		frame.add(scheduleLabel);

	
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
		if (e.getSource()== logout) {
			new Logout();
		}
		if (e.getSource()== switchAcc) {
			new SwitchAcc();
		}
		
		if (e.getSource()== colourCSTM) {
			new ColourCSTM();
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
