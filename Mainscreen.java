import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Mainscreen extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	// declare all components to be used for the main screen 
	static JFrame frame = new JFrame("Tackle");
	static JPanel panel; 
	private static JButton weekly, monthly, yearly, testluck, onlymotiv; //buttons for week, month, year 
	private static JLabel username; 
	private static JLabel scheduleLabel, warninglbl;

	String filename = "motivation.txt";
	String filename1 = "lucktester.txt";
	Mainscreen page;
	Color colour1 = ColourCSTM.getFirstColour();
	Color colour2 = ColourCSTM.getSecondColour();
	Color colour3 = ColourCSTM.getThirdColour();
	static Color yellow1 = new Color(255, 208, 37); // tackle logo bg yellow color 
	static Color yellow2 = new Color(232, 180, 2); // buttons color (dark)
	static Color yellow3 = new Color(255, 255, 255); // white
	static Font newfont, newfontsmall, newfont1,newfont2, madefont, newfont3, newfont4;

	static Icon icon = new ImageIcon("images/logo.png");
	Icon duckicon = new ImageIcon("images/duckwaddle.gif");
	private static JMenuBar menuBar;
	private static JMenu settings;
	private static JMenuItem help;
	private static JMenuItem colourCSTM;
	private static JMenuItem switchAcc;
	private static JMenuItem logout;
	private static JLabel duckdance;
	JLabel timeLabel, dayLabel, dateLabel;

	int hour, second, minute;

	String time, day, date;
	Calendar calendar;
	SimpleDateFormat formatTime;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	String userDisplay;

	String[][]randomline = new String[15][1];
	
	public Mainscreen() throws IOException{

		try {
			newfontsmall = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(15f);
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(30f);
			newfont2 =  Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(40f);
			newfont3 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(60f);
			newfont4 = Font.createFont(Font.TRUETYPE_FONT,  new File("fonts/PPObjectSans-Regular.otf")).deriveFont(25f);
			madefont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/wake.otf")).deriveFont(20f);

		} catch (IOException | FontFormatException e){

		}
		String f1 = Main.getfile1();
		String f2 = Main.getfile2();
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


		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame = new JFrame("Tackle"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(colour1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

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


		setTime(); 
	}

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



	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == weekly) {
			try {
				new Weekly();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == onlymotiv) {
			try {
				returnmotiv();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	public void returnmotiv() throws IOException {
		try {
			BufferedReader input = new BufferedReader(new FileReader(filename));
			Random r = new Random();

			int rand = Math.abs(r.nextInt()) % 11;
			
			for (int i = 0; i < 15; i ++) {
				randomline[i][0] = input.readLine();
			}
			JOptionPane.showMessageDialog(this, randomline[rand][0]);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void returnluck() throws IOException {
		try {
			BufferedReader input = new BufferedReader(new FileReader(filename1));
			Random r = new Random();

			int rand = Math.abs(r.nextInt()) % 11;
			
			for (int i = 0; i < 15; i ++) {
				randomline[i][0] = input.readLine();
			}
			JOptionPane.showMessageDialog(this, randomline[rand][0]);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args) throws IOException {
		new Mainscreen();
	}
	
}
