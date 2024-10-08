// importing packages
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
/**
 * class that shows the weekly scheduler with addevent option and clear scheduler option 
 * @author Lucia Kim, Frances Zhao
 *
 */
public class Weekly extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	// declaring the major components 
	JFrame frame = new JFrame("Weekly Calendar");
	JPanel m_panel = new JPanel(new FlowLayout()); 
	static JPanel wdp1, wdp2, wdp3, wdp4, wdp5; // weekdays panels
	static JPanel wep1, wep2; // weekends panels 
	JPanel deco1, deco2; 
	JButton addEvent, return_main, clear;
	JLabel mon, tue, wed, thu, fri, sat, sun; 
	JLabel todo, notes, week_yearLabel, general_dateLabel; 
	JTextField weekly;

	ImageIcon add = new ImageIcon("images/add.png");
	ImageIcon logo = new ImageIcon("images/image.png");
	Date d1 = new Date();
	Calendar calendar = Calendar.getInstance();
	public static String[][] aen = new String[8][50]; // 
	public static String[][] aed = new String[7][50]; 
	public static String event_n, event_d, time_; 
	SimpleDateFormat week_year; 
	SimpleDateFormat general_date; 
	String filename1 = Main.getfile1();
	String filename2 = Main.getfile2();


	//  -------------- declare the misc. variables --------------------------------	

	public static String[][] aen1 = new String[8][50]; // add event name
	public static String[][] aed1 = new String[7][50]; // add event desc. 
	static String [] monname, mondesc, tuename, tuedesc, wedname, weddesc, thuname, thudesc, friname, fridesc, satname, satdesc, sunname, sundesc;
	static int monlen = 0, tuelen = 0, wedlen = 0, thulen = 0, frilen = 0, satlen = 0, sunlen = 0;

	// declaring the writers 
	BufferedReader input_en = new BufferedReader(new FileReader(filename1));
	BufferedReader input_ei = new BufferedReader(new FileReader(filename2));	

	//declaring fonts 
	static Font newfont, newfont1, newfont2, newfont3, newfont4, newfont5; //declaring all fonts 

	// declaring the colours 
	Color colour1 = ColourCSTM.getFirstColour();
	Color colour2 = ColourCSTM.getSecondColour();
	Color colour3 = ColourCSTM.getThirdColour();

	/**
	 * constructor of Weekly.java, uses methods and implements GUI interface
	 * @throws IOException
	 */
	public Weekly() throws IOException{

		// declare fonts that'll be used in this class
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(15f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(30f);
			newfont2 =  Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(40f);
			newfont3 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(60f);
			newfont4 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(35f);
			newfont5 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(25f);
		} 

		catch (IOException | FontFormatException e){
			System.out.println("Weekly - cannot import font.");
		}

		readin();
		// setting the basic outline of the GUI tab 
		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame.setSize(WIDTH,HEIGHT);
		frame.getContentPane().setBackground(colour1);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// designing GUI components
		deco1 = new JPanel();
		deco1.setBounds(0, 0, 25, 800);
		deco1.setBackground(colour3);
		deco1.setBorder(BorderFactory.createLineBorder(colour3, 2, true));

		wdp1 = new JPanel();
		wdp1.setLayout(null);
		wdp1.setBounds(90, 115, 175, 300);
		wdp1.setOpaque(false);
		wdp1.setBorder(BorderFactory.createLineBorder(colour3, 2, true));

		wdp2 = new JPanel();
		wdp2.setLayout(null);
		wdp2.setBounds(264, 115, 175, 300);
		wdp2.setOpaque(false);
		wdp2.setBorder(BorderFactory.createLineBorder(colour3, 2, true));

		wdp3 = new JPanel();
		wdp3.setLayout(null);
		wdp3.setBounds(439, 115, 175, 300);
		wdp3.setOpaque(false);
		wdp3.setBorder(BorderFactory.createLineBorder(colour3, 2, true));

		wdp4 = new JPanel();
		wdp4.setLayout(null);
		wdp4.setBounds(614, 115, 175, 300);
		wdp4.setOpaque(false);
		wdp4.setBorder(BorderFactory.createLineBorder(colour3, 2, true));

		wdp5 = new JPanel();
		wdp5.setLayout(null);
		wdp5.setBounds(789, 115, 175, 300);
		wdp5.setOpaque(false);
		wdp5.setBorder(BorderFactory.createLineBorder(colour3, 2, true));

		wep1 = new JPanel();
		wep1.setLayout(null);
		wep1.setBounds(90, 414, 175, 300);
		wep1.setOpaque(false);
		wep1.setBorder(BorderFactory.createLineBorder(colour3, 2, true));


		wep2 = new JPanel();
		wep2.setLayout(null);
		wep2.setBounds(264, 414, 175, 300);
		wep2.setOpaque(false);
		wep2.setBorder(BorderFactory.createLineBorder(colour3, 2, true));
		

		mon = new JLabel("Monday"); 
		mon.setBounds(90, 115, 175, 21);
		mon.setFont(newfont);
		mon.setForeground(Color.black);
		mon.setBackground(colour2);
		mon.setHorizontalAlignment(SwingConstants.CENTER);
		mon.setBorder(BorderFactory.createLineBorder(colour3));

		tue = new JLabel("Tuesday"); 
		tue.setBounds(264, 115, 175, 21);
		tue.setFont(newfont);
		tue.setForeground(Color.black);
		tue.setBackground(colour1);
		tue.setHorizontalAlignment(SwingConstants.CENTER);
		tue.setBorder(BorderFactory.createLineBorder(colour3));

		wed = new JLabel("Wednesday");   
		wed.setBounds(439, 115, 175, 21);
		wed.setFont(newfont);
		wed.setForeground(Color.black);
		wed.setBackground(colour1);
		wed.setHorizontalAlignment(SwingConstants.CENTER);
		wed.setBorder(BorderFactory.createLineBorder(colour3));

		thu = new JLabel("Thursday"); 
		thu.setBounds(614, 115, 175, 21);
		thu.setFont(newfont);
		thu.setForeground(Color.black);
		thu.setBackground(colour1);
		thu.setHorizontalAlignment(SwingConstants.CENTER);
		thu.setBorder(BorderFactory.createLineBorder(colour3));

		fri = new JLabel("Friday"); 
		fri.setBounds(789, 115, 175, 21);
		fri.setFont(newfont);
		fri.setForeground(Color.black);
		fri.setBackground(colour1);
		fri.setHorizontalAlignment(SwingConstants.CENTER);
		fri.setBorder(BorderFactory.createLineBorder(colour3));

		sat = new JLabel("Saturday"); 
		sat.setBounds(90, 414, 175, 21);
		sat.setFont(newfont);
		sat.setForeground(Color.black);
		sat.setBackground(colour1);
		sat.setHorizontalAlignment(SwingConstants.CENTER);
		sat.setBorder(BorderFactory.createLineBorder(colour3));

		sun = new JLabel("Sunday"); 
		sun.setBounds(264, 414, 175, 21);
		sun.setFont(newfont);
		sun.setForeground(Color.black);
		sun.setBackground(colour1);
		sun.setHorizontalAlignment(SwingConstants.CENTER);
		sun.setBorder(BorderFactory.createLineBorder(colour3));

		// declaring the characteristics of the components
		general_date = new SimpleDateFormat("");
		general_dateLabel = new JLabel();
		general_dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		general_dateLabel.setFont(newfont3);
		general_dateLabel.setBounds(95, 95, 516, 102);

		Image image_plus = add.getImage(); // transforming the addition sign image (for add event)
		Image image_n = image_plus.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		add = new ImageIcon(image_n);

		Image image_logo = logo.getImage(); // transforming the logo image 
		Image image_n2 = image_logo.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(image_n2);

		return_main = new JButton(logo);
		return_main.setBounds(90, 25, 50, 50);
		return_main.setBackground(colour2);
		return_main.setBorder(BorderFactory.createLineBorder(colour3));

		weekly = new JTextField("WEEKLY");
		weekly.setHorizontalAlignment(SwingConstants.CENTER);
		weekly.setBounds(140, 25, 240, 50);
		weekly.setBackground(colour2);
		weekly.setFont(newfont5);		
		weekly.setBorder(BorderFactory.createLineBorder(colour3));
		weekly.setEditable(false);

		addEvent = new JButton("Add Event");
		addEvent.setBounds(1140, 625, 140, 40);
		addEvent.setBackground(colour2);
		addEvent.setFont(newfont5);
		addEvent.setBorder(BorderFactory.createLineBorder(colour3));

		clear = new JButton("Clear");
		clear.setHorizontalAlignment(SwingConstants.CENTER);
		clear.setBounds(1140, 675, 140, 40);
		clear.setFont(newfont5);
		clear.setBackground(colour2);
		clear.setBorder(BorderFactory.createLineBorder(colour3));


		// add the actionlisteners
		addEvent.addActionListener(this);
		return_main.addActionListener(this);
		clear.addActionListener(this);
		
		// actual GUI
		frame.add(addEvent);
		frame.add(weekly);
		frame.add(return_main);
		frame.add(clear);
		frame.add(mon);
		frame.add(tue);
		frame.add(wed);
		frame.add(thu);
		frame.add(fri);
		frame.add(sat);
		frame.add(sun);
		frame.setVisible(true);

		// adding in checkboxes for each of the events in the array, based on day of the week 
		
		int x = 20;
		for(int i = 1; i < monlen; i++) { // monday
			JCheckBox check = new JCheckBox(aen[0][i]); // the string/label of the checkbox is the first item (excluding Sample)
			check.setText(aen[0][i] + ""); // setting the text to the first item of the line (excluding sample)
			check.setForeground(Color.black); // setting font of text to black
			check.setBounds(6, x, 160, 24); // setting bounds
			check.setFont(newfont); // setting font of text
			wdp1.add(check); // adding the checkbox to the panel of the day
			x += 22; // add to the integer so the next checkbox is below the first
		}
		frame.add(wdp1);
		
		
		x = 20;
		for(int i = 1; i < tuelen; i++) { // tuesday
			JCheckBox check = new JCheckBox(aen[1][i]);
			check.setText(aen[1][i] + "");
			check.setForeground(Color.black);
			check.setBounds(6, x, 160, 24);
			check.setFont(newfont);
			wdp2.add(check);
			x += 22;
		}
		frame.add(wdp2);

		
		x = 20;
		for(int i = 1; i < wedlen; i++) { // wednesday
			JCheckBox check = new JCheckBox(aen[2][i]);
			check.setText(aen[2][i] + "");
			check.setForeground(Color.black);
			check.setBounds(6, x, 160, 24);
			check.setFont(newfont);
			wdp3.add(check);
			x += 22;
		}
		frame.add(wdp3);

		
		x = 20;
		for(int i = 1; i < thulen; i++) { // thursday
			JCheckBox check = new JCheckBox(aen[3][i]);
			check.setText(aen[3][i] + "");
			check.setForeground(Color.black);
			check.setBounds(6, x, 160, 24);
			check.setFont(newfont);
			wdp4.add(check);
			x += 22;
		}
		
		frame.add(wdp4);
		x = 20;
		for(int i = 1; i < frilen; i++) { // friday
			JCheckBox check = new JCheckBox(aen[4][i]);
			check.setText(aen[4][i] + "");
			check.setForeground(Color.black);
			check.setBounds(6, x, 160, 24);
			check.setFont(newfont);
			wdp5.add(check);
			x += 22;
		}
		frame.add(wdp5);

		x = 20;
		for(int i = 1; i < satlen; i++) { // saturday
			JCheckBox check = new JCheckBox(aen[5][i]);
			check.setText(aen[5][i] + "");
			check.setForeground(Color.black);
			check.setBounds(6, x, 160, 24);
			check.setFont(newfont);
			wep1.add(check);
			x += 22;
		}
		frame.add(wep1);
		
		x = 20;
		for(int i = 1; i < sunlen; i++) { // sunday
			JCheckBox check = new JCheckBox(aen[6][i]);
			check.setText(aen[6][i] + "");
			check.setForeground(Color.black);
			check.setBounds(6, x, 160, 24);
			check.setFont(newfont);
			wep2.add(check);
			x += 22;
		}
		
		// revalidate and set visible
		frame.add(wep2);
		frame.add(deco1);	
		frame.repaint();
		frame.revalidate();

		frame.setVisible(true);

	}
	
	/**
	 * method that reads in the txt files 
	 * @throws IOException
	 */
	public void readin() throws IOException {
		try (BufferedReader input_t = new BufferedReader(new FileReader(filename1))) {
			try (BufferedReader input_d = new BufferedReader(new FileReader(filename2))) {
				monname = input_t.readLine().split(", ");
				tuename = input_t.readLine().split(", ");
				wedname = input_t.readLine().split(", ");
				thuname = input_t.readLine().split(", ");
				friname = input_t.readLine().split(", ");
				satname = input_t.readLine().split(", ");
				sunname = input_t.readLine().split(", ");

				mondesc = input_d.readLine().split(", ");
				tuedesc = input_d.readLine().split(", ");
				weddesc = input_d.readLine().split(", ");
				thudesc = input_d.readLine().split(", ");
				fridesc = input_d.readLine().split(", ");
				satdesc = input_d.readLine().split(", ");
				sundesc = input_d.readLine().split(", ");
			}
		}
		// refer to AddEvent_ for comments
		monlen = monname.length;
		tuelen = tuename.length;
		wedlen = wedname.length;
		thulen = thuname.length;
		frilen = friname.length;
		satlen = satname.length;
		sunlen = sunname.length;

		for(int i = 0; i < monlen; i++) {
			aen[0][i] = monname[i];
			aed[0][i] = mondesc[i];
		}
		for(int i = 0; i < tuelen; i++) {
			aen[1][i] = tuename[i];
			aed[1][i] = tuedesc[i];
		}
		for(int i = 0; i < wedlen; i++) {
			aen[2][i] = wedname[i];
			aed[2][i] = weddesc[i];
		}
		for(int i = 0; i < thulen; i++) {
			aen[3][i] = thuname[i];
			aed[3][i] = thudesc[i];
		}
		for(int i = 0; i < frilen; i++) {
			aen[4][i] = friname[i];
			aed[4][i] = fridesc[i];
		}
		for(int i = 0; i < satlen; i++) {
			aen[5][i] = satname[i];
			aed[5][i] = satdesc[i];
		}
		for(int i = 0; i < sunlen; i++) {
			aen[6][i] = sunname[i];
			aed[6][i] = sundesc[i];
		}

	}
	
	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == addEvent) {
			try {
				new AddEvent_();
				frame.dispose();
			} catch (IOException e1) {
				System.out.println("cannot add event");
			}
		}
		
		if (e.getSource() == clear) {
			frame.dispose();
			new ClearCfm();
		}

		if (e.getSource() == return_main) {
			try {
				new Mainscreen();
				frame.dispose();
			} catch (IOException e1) {
				System.out.println("cannot return to main screen");
			}
		}
	}

}



