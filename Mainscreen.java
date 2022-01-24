import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Mainscreen extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	// declare all components to be used for the main screen 
	static JFrame frame = new JFrame("Tackle");
	static JPanel panel; 
	private static JButton weekly, monthly, yearly; //buttons for week, month, year 
	private static JLabel username; 
	private static JLabel scheduleLabel, todoLabel;

	static Color yellow1 = new Color(255, 208, 37); // tackle logo bg yellow color 
	static Color yellow2 = new Color(232, 180, 2); // buttons color (dark)
	static Color yellow3 = new Color(255, 255, 255); // white
	static Font newfont, newfontsmall, newfont1,newfont2, madefont, newfont3 ;

	static Icon icon = new ImageIcon("images/logo.png");
	private static JMenuBar menuBar;
	private static JMenu settings;
	private static JMenuItem help;
	private static JMenuItem colourCSTM;
	private static JMenuItem switchAcc;
	private static JMenuItem logout;
	JLabel timeLabel, dayLabel, dateLabel;

	int hour, second, minute;

	String time, day, date;
	Calendar calendar;
	SimpleDateFormat formatTime;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;




	public Mainscreen() throws IOException{

		try {
			newfontsmall = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(15f);
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(30f);
			newfont2 =  Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(40f);
			newfont3 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(60f);
			madefont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/wake.otf")).deriveFont(20f);

		} catch (IOException | FontFormatException e){

		}

		Main loginpage = new Main();
		String userDisplay = loginpage.getUser();

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
		frame.getContentPane().setBackground(yellow1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		weekly = new JButton("Weekly");
		weekly.setBounds(919, 117, 135, 77);
		weekly.setBackground(yellow2);
		weekly.setFont(newfont);
		weekly.setForeground(yellow3);
		weekly.setBorder(BorderFactory.createLineBorder(yellow2));

		monthly = new JButton("Monthly");
		monthly.setBounds(1066, 117, 135, 77);
		monthly.setBackground(yellow2);
		monthly.setFont(newfont);
		monthly.setForeground(yellow3);
		monthly.setBorder(BorderFactory.createLineBorder(yellow2));

		yearly = new JButton("Yearly");
		yearly.setBounds(1213, 117, 135, 77);
		yearly.setBackground(yellow2);
		yearly.setFont(newfont);
		yearly.setForeground(yellow3);
		yearly.setBorder(BorderFactory.createLineBorder(yellow2));
		

		username = new JLabel(userDisplay); // get a different public variable to store user input
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(385, 46, 633, 59);
		username.setFont(madefont);

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

		help.addActionListener(this);
		colourCSTM.addActionListener(this);
		switchAcc.addActionListener(this);
		logout.addActionListener(this);

		scheduleLabel = new JLabel("SCHEDULER");
		scheduleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scheduleLabel.setBounds(920, 60, 429, 51);
		scheduleLabel.setFont(newfont1);
		
		todoLabel = new JLabel ("// TODO");
		todoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		todoLabel.setBounds(1030, 240, 200, 41);
		todoLabel.setFont(newfont1);
		
		weekly.addActionListener(this);
		monthly.addActionListener(this);
		yearly.addActionListener(this);
		frame.setLayout(null);
		frame.add(weekly);
		frame.add(monthly);
		frame.add(yearly);
		frame.add(username);
		frame.add(scheduleLabel);
		frame.add(todoLabel);
		frame.add(timeLabel);
		frame.add(dayLabel);
		frame.add(dateLabel);
		
		frame.setVisible(true);
		
		
		setTime(); //does not work with main program

	}

	public void setTime() {
		while (true) {
			time = formatTime.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);
			
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
		
		public static void main(String[] args) throws IOException {
			new Mainscreen();
		}
	}
