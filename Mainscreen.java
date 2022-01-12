import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Mainscreen extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	static // declaring all components to be used for the main screen 
	JFrame frame = new JFrame("Tackle");
	static JPanel panel; 
	private static JButton weekly, monthly, yearly; //buttons for week, month, year 
	private static JLabel username; 
	private static JLabel scheduleLabel;

	Font newfont;
	Font newfont1;
	Font madefont;

	static Color yellow1 = new Color(243, 215, 3); // tackle logo bg yellow color 
	static Color yellow2 = new Color(130, 113, 53); // buttons color (dark)
	static Color yellow3 = new Color(255, 229, 96); // lighter yellow 
	static Icon icon = new ImageIcon("images/logo.png");
	private static JMenuBar menuBar;
	private static JMenu settings;
	private static JMenuItem help;
	private static JMenuItem colourCSTM;
	private static JMenuItem switchAcc;
	private static JMenuItem logout;
	private JLabel timeLabel;

	int hour, second, minute;
	int day, month, year;

	String time;
	Calendar calendar;
	SimpleDateFormat formatTime;


	Mainscreen() throws IOException{

		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
			newfont1 =  Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(40f);
			madefont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/wake.otf")).deriveFont(40f);

		} catch (IOException | FontFormatException e){

		}

		Main loginpage = new Main();
		String userDisplay = loginpage.getUser();

		formatTime = new SimpleDateFormat("hh : mm: ss a");

		timeLabel = new JLabel();
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setFont(newfont1);
		timeLabel.setBounds(448, 117, 516, 102);



		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame = new JFrame("Tackle"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(yellow1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		weekly = new JButton("Weekly");
		weekly.setBounds(965, 46, 135, 77);
		weekly.setFont(newfont);

		monthly = new JButton("Monthly");
		monthly.setBounds(1112, 46, 135, 77);
		monthly.setFont(newfont);

		yearly = new JButton("Yearly");
		yearly.setBounds(1259, 46, 135, 77);
		yearly.setFont(newfont);

		username = new JLabel(userDisplay); // get a different public variable to store user input
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(385, 46, 633, 59);
		username.setFont(madefont);

		menuBar = new JMenuBar();
		menuBar.setBounds(6, 6, 69, 22);
		menuBar.setFont(newfont);
		frame.add(menuBar);

		settings = new JMenu("Settings");
		menuBar.add(settings);
		settings.setFont(newfont);


		help = new JMenuItem("Help");
		help.setFont(newfont);
		settings.add(help);

		colourCSTM = new JMenuItem("Colour Customization");
		colourCSTM.setFont(newfont);
		settings.add(colourCSTM);

		switchAcc = new JMenuItem("Switch Accounts");
		switchAcc.setFont(newfont);
		settings.add(switchAcc);

		logout = new JMenuItem("Logout");
		logout.setFont(newfont);
		settings.add(logout);

		help.addActionListener(this);
		colourCSTM.addActionListener(this);
		switchAcc.addActionListener(this);
		logout.addActionListener(this);

		scheduleLabel = new JLabel("SCHEDULER");
		scheduleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scheduleLabel.setBounds(965, 6, 429, 51);
		scheduleLabel.setFont(newfont);
		weekly.addActionListener(this);
		monthly.addActionListener(this);
		yearly.addActionListener(this);
		frame.setLayout(null);
		frame.add(weekly);
		frame.add(monthly);
		frame.add(yearly);
		frame.add(username);
		frame.add(scheduleLabel);
		frame.add(timeLabel);

		frame.setVisible(true);

		setTime();

	}

	public void setTime() {
		while (true) {
			time = formatTime.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
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
		if (e.getSource()== help) {
			new Help();
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
