// import packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * class with the main screen and all functionalities in the program originate from this screen
 * @author Frances Zhao, Lucia Kim
 *
 */
public class Mainscreen extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	// declare all components to be used for the main screen 
	static JFrame frame = new JFrame("Tackle");
	static JPanel panel; 
	private static JButton weekly, monthly, yearly, testluck, onlymotiv; //buttons for week, month, year 
	private static JLabel username; 
	private static JLabel scheduleLabel, warninglbl;
	private static JMenuBar menuBar;
	private static JMenu settings;
	private static JMenuItem help;
	private static JMenuItem colourCSTM;
	private static JMenuItem switchAcc;
	private static JMenuItem logout;
	private static JLabel duckdance;

	// txt file variables
	String filename = "motivation.txt";
	String filename1 = "lucktester.txt";

	// colour declarations 
	Color colour1 = ColourCSTM.getFirstColour();
	Color colour2 = ColourCSTM.getSecondColour();
	Color colour3 = ColourCSTM.getThirdColour();
	// font declarations
	static Font newfont, newfontsmall, newfont1,newfont2, madefont, newfont3, newfont4;

	// icon declarations
	static Icon icon = new ImageIcon("images/logo.png");
	Icon duckicon = new ImageIcon("images/duckwaddle.gif");

	// time and date variables
	JLabel timeLabel, dayLabel, dateLabel;
	int hour, second, minute;
	String time, day, date;
	Calendar calendar;
	SimpleDateFormat formatTime;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	String userDisplay;

	String[][]randomline = new String[15][1];

	/**
	 * constructor that implements different methods and GUI interface
	 * @throws IOException
	 */
	public Mainscreen() throws IOException{

		try { // trying fonts
			newfontsmall = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(15f);
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(30f);
			newfont2 =  Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(40f);
			newfont3 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(60f);
			newfont4 = Font.createFont(Font.TRUETYPE_FONT,  new File("fonts/PPObjectSans-Regular.otf")).deriveFont(25f);
			madefont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/wake.otf")).deriveFont(20f);

		} catch (IOException | FontFormatException e){

			System.out.println("Mainscreen - Cannot import font.");
		}

		// adding java components
		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame = new JFrame("Tackle"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(colour1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		userDisplay = Main.getUser();
		formatTime = new SimpleDateFormat("hh : mm: ss a");
		timeLabel = new JLabel();
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setFont(newfont3);
		timeLabel.setBounds(95, 95, 516, 102);

		dayFormat = new SimpleDateFormat("EEEE");
		dayLabel = new JLabel();
		dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dayLabel.setFont(newfont2);		
		dayLabel.setBounds(43, 131, 622, 141);

		dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		dateLabel = new JLabel();

		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(newfont2);		
		dateLabel.setBounds(43, 170, 622, 141);

		weekly = new JButton("Weekly");
		weekly.setBounds(919, 117, 135, 77);
		weekly.setBackground(colour2);
		weekly.setFont(newfont);
		weekly.setForeground(colour3);
		weekly.setBorder(BorderFactory.createLineBorder(Color.black));

		monthly = new JButton("Monthly");
		monthly.setBounds(1066, 117, 135, 77);
		monthly.setBackground(colour2);
		monthly.setFont(newfont);
		monthly.setForeground(colour3);
		monthly.setBorder(BorderFactory.createLineBorder(Color.black));

		yearly = new JButton("Yearly");
		yearly.setBounds(1213, 117, 135, 77);
		yearly.setBackground(colour2);
		yearly.setFont(newfont);
		yearly.setForeground(colour3);
		yearly.setBorder(BorderFactory.createLineBorder(Color.black));

		username = new JLabel("Welcome, " + userDisplay); // get a different public variable to store user input
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(385, 46, 633, 59);
		username.setFont(newfont4);

		menuBar = new JMenuBar();
		menuBar.setBounds(12, 12, 80, 22);
		menuBar.setFont(madefont);
		frame.add(menuBar);

		settings = new JMenu("Settings");
		menuBar.add(settings);
		settings.setFont(newfontsmall);

		help = new JMenuItem("Help");
		help.setFont(newfontsmall);
		settings.add(help);

		colourCSTM = new JMenuItem("Colour Customization");
		colourCSTM.setFont(newfontsmall);
		settings.add(colourCSTM);

		switchAcc = new JMenuItem("Switch Accounts");
		switchAcc.setFont(newfontsmall);
		settings.add(switchAcc);

		logout = new JMenuItem("Logout");
		logout.setFont(newfontsmall);
		settings.add(logout);

		scheduleLabel = new JLabel("SCHEDULER");
		scheduleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scheduleLabel.setBounds(920, 60, 429, 51);
		scheduleLabel.setFont(newfont1);

		testluck = new JButton ("WHAT DOES YOUR DAY LOOK LIKE!");
		testluck.setHorizontalAlignment(SwingConstants.CENTER);
		testluck.setBackground(colour2);
		testluck.setForeground(colour3);
		testluck.setBorder(BorderFactory.createLineBorder(Color.black));
		testluck.setBounds(919, 239, 429, 193);
		testluck.setFont(newfont);

		warninglbl = new JLabel("(cannot guarantee it's positive)");
		warninglbl.setHorizontalAlignment(SwingConstants.CENTER);
		warninglbl.setFont(newfont);
		warninglbl.setBounds(919, 436, 429, 37);

		onlymotiv = new JButton("WANT ONLY MOTIVATION?");
		onlymotiv.setHorizontalAlignment(SwingConstants.CENTER);
		onlymotiv.setBackground(colour2);
		onlymotiv.setForeground(colour3);
		onlymotiv.setBorder(BorderFactory.createLineBorder(Color.black));
		onlymotiv.setFont(newfont1);
		onlymotiv.setBounds(919, 508, 429, 193);

		duckdance = new JLabel(duckicon);
		duckdance.setBounds(107, 300, 410, 445);

		// adding action listeners
		testluck.addActionListener(this);
		onlymotiv.addActionListener(this);
		help.addActionListener(this);
		colourCSTM.addActionListener(this);
		switchAcc.addActionListener(this);
		logout.addActionListener(this);
		weekly.addActionListener(this);
		monthly.addActionListener(this);
		yearly.addActionListener(this);
		frame.setLayout(null);

		// actual GUI
		frame.add(weekly);
		frame.add(monthly);
		frame.add(yearly);
		frame.add(username);
		frame.add(scheduleLabel);
		frame.add(testluck);
		frame.add(timeLabel);
		frame.add(dayLabel);
		frame.add(dateLabel);
		frame.add(duckdance);
		frame.add(onlymotiv);
		frame.add(warninglbl);
		frame.setVisible(true);


		setTime(); // set time method
	}

	/**
	 * setting the current time and date, with help from Demeng Chen
	 */
	public void setTime() {

		Timer timer = new Timer(1000, e -> {
			time = formatTime.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);

			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
		});

		timer.setInitialDelay(0);
		timer.start();
	}


	/**
	 * method that reads in motivation and shows a pop up message with it
	 * @throws IOException for readers
	 */
	public void returnmotiv() throws IOException {
		try {
			try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
				Random r = new Random();

				int rand = Math.abs(r.nextInt()) % 11;

				for (int i = 0; i < 15; i ++) {
					randomline[i][0] = input.readLine();
				}
				JOptionPane.showMessageDialog(this, randomline[rand][0]);
			} catch (FileNotFoundException e) {
				throw e;
			} catch (HeadlessException e) {
				System.out.println("Error.");
			}

		} catch (FileNotFoundException e) {
			System.out.println("file not found.");
		}
	}

	/**
	 * method that reads in luck and shows a pop up message with it
	 * @throws IOException for readers
	 */
	public void returnluck() throws IOException {
		try {
			try (BufferedReader input = new BufferedReader(new FileReader(filename1))) {
				Random r = new Random();

				int rand = Math.abs(r.nextInt()) % 11;

				for (int i = 0; i < 15; i ++) {
					randomline[i][0] = input.readLine();
				}
				JOptionPane.showMessageDialog(this, randomline[rand][0]);
			} catch (FileNotFoundException e) {
				System.out.println("file cannot be found.");
			} catch (HeadlessException e) {
				System.out.println("cannot read file.");
			}

		} catch (FileNotFoundException e) {
			System.out.println("file not found.");
		}
	}


	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == weekly) {
			try {
				new Weekly();
			} catch (IOException e1) {
				System.out.println("unable to run");
			}
			frame.dispose(); // dispose of current frame
		}
		if (e.getSource() == monthly) {
			new Monthly();
			frame.dispose();
		}
		if (e.getSource() == yearly) {
			new Yearly();
			frame.dispose(); // dispose of current frame
		}
		if (e.getSource()== logout) {
			frame.dispose();
			new Logout();
		}
		if (e.getSource()== switchAcc) {
			frame.dispose();
			new SwitchAcc();
		}

		if (e.getSource()== colourCSTM) {
			new ColourCSTM();
			frame.dispose();

		}
		if (e.getSource()== help) {
			new Help();
		}

		if (e.getSource() == testluck) {
			try {
				returnluck();
			} catch (IOException e1) {
				System.out.println("unable to run.");
			}
		}

		if (e.getSource() == onlymotiv) {
			try {
				returnmotiv();
			} catch (IOException e1) {
				System.out.println("unable to run.");
			}
		}
	}


}
