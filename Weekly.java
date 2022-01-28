import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.*;

public class Weekly extends JPanel implements ActionListener{
	
	// declaring the major components 
	JFrame frame = new JFrame("Weekly Calendar");
	JPanel m_panel = new JPanel(new FlowLayout()); 
	JPanel wdp1, wdp2, wdp3, wdp4, wdp5; // weekdays panels
	JPanel wep1, wep2; // weekends panels 
	JPanel deco1, deco2; 
	JButton addEvent, return_main, clear;
	JLabel mon, tue, wed, thu, fri, sat, sun; 
	JLabel todo, notes, week_yearLabel, general_dateLabel; 
	JTextField weekly; 
//	JCheckBox tm1, tm2, tm3, tm4, tm5, tm6, tm7, tm8, tm9, tm0, // monday tasks
//	tt1, tt2, tt3, tt4, tt5, tt6, tt7, tt8, tt9, tt0,           // tuesday tasks
//	tw1, tw2, tw3, tw4, tw5, tw6, tw7, tw8, tw9, tw0,           // wednesday tasks 
//	ttt1, ttt2, ttt3, ttt4, ttt5, ttt6, ttt7, ttt8, ttt9, ttt0, // thursday tasks 
//	tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf0,           // friday tasks 
//	ts1, ts2, ts3, ts4, ts5, ts6, ts7, ts8, ts9, ts0,           // saturday taks  
//	tss1, tss2, tss3, tss4, tss5, tss6, tss7, tss8, tss9, tss0; // sunday tasks 

	ImageIcon add = new ImageIcon("images/add.png");
	ImageIcon logo = new ImageIcon("images/image.png");
	Date d1 = new Date();
	Calendar calendar = Calendar.getInstance();
	public static String[][] aen = new String[8][50]; // 
	public static String[][] aed = new String[7][50]; 
	public static String event_n, event_d, time_; 
	SimpleDateFormat week_year; 
	SimpleDateFormat general_date; 
	String filename1 = "eventName.txt";
	String filename2 = "eventInfo.txt";

	
	//  -------------- declare the misc. variables --------------------------------
	
	// declaring the writers 
	BufferedReader input_en = new BufferedReader(new FileReader(filename1));
	BufferedReader input_ei = new BufferedReader(new FileReader(filename2));	
	
	//declaring fonts 
	static Font newfont, newfont1, newfont2, newfont3, newfont4, newfont5; //declaring all fonts 
	
	// declaring the colours 
	static Color bumble1 = new Color(255,212, 64);    // main yellow colour
	static Color bumble2 = new Color(250, 229, 131);  // panel background colour 
	static Color bumble3 = new Color(252, 245, 181);  // panels bg colour 
	static Color bumble4 = new Color(255, 200, 99);   // header fill colour 
	static Color bumble5 = new Color(69, 62, 39);     // outline 2 (dark stale brown)
	static Color bumble6 = new Color(115, 77, 26);    // border colour 1 
	static Color bumble7 = new Color(122, 93, 60);    // deco colour 1 


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

		}
		
		// setting the basic outline of the GUI tab 
		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame.setSize(WIDTH,HEIGHT);
		frame.getContentPane().setBackground(bumble1);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		deco1 = new JPanel();
		deco1.setBounds(0, 0, 25, 800);
		deco1.setBackground(bumble6);
		deco1.setBorder(BorderFactory.createLineBorder(bumble6, 2, true));
		
		
		wdp1 = new JPanel();
		wdp1.setLayout(new BoxLayout(wdp1, BoxLayout.Y_AXIS));
		wdp1.add(Box.createRigidArea(new Dimension(10, 30)));
		wdp1.setBounds(90, 115, 175, 300);
		wdp1.setBackground(bumble2);
		wdp1.setBorder(BorderFactory.createLineBorder(bumble6, 2, true));
		
		wdp2 = new JPanel();
		wdp2.setLayout(new BoxLayout(wdp2, BoxLayout.Y_AXIS));
		wdp2.add(Box.createRigidArea(new Dimension(10,30)));
		wdp2.setBounds(264, 115, 175, 300);
		wdp2.setBackground(bumble2);
		wdp2.setBorder(BorderFactory.createLineBorder(bumble6, 2, true));
		
		wdp3 = new JPanel();
		wdp3.setBounds(439, 115, 175, 300);
		wdp3.setBackground(bumble2);
		wdp3.setBorder(BorderFactory.createLineBorder(bumble6, 2, true));
		
		wdp4 = new JPanel();
		wdp4.setBounds(614, 115, 175, 300);
		wdp4.setBackground(bumble2);
		wdp4.setBorder(BorderFactory.createLineBorder(bumble6, 2, true));
		
		wdp5 = new JPanel();
		wdp5.setBounds(789, 115, 175, 300);
		wdp5.setBackground(bumble2);
		wdp5.setBorder(BorderFactory.createLineBorder(bumble6, 2, true));
		
		wep1 = new JPanel();
		wep1.setBounds(90, 414, 175, 300);
		wep1.setBackground(bumble2);
		wep1.setBorder(BorderFactory.createLineBorder(bumble6, 2, true));
				
		
		wep2 = new JPanel();
		wep2.setBounds(264, 414, 175, 300);
		wep2.setBackground(bumble2);
		wep2.setBorder(BorderFactory.createLineBorder(bumble6, 2, true));
		
		mon = new JLabel("Monday"); 
		mon.setBounds(90, 115, 175, 21);
		mon.setFont(newfont);
		mon.setForeground(bumble5);
		mon.setBackground(bumble4);
		mon.setHorizontalAlignment(SwingConstants.CENTER);
		mon.setBorder(BorderFactory.createLineBorder(bumble6));
		
		//TODO: skip to here; temporary ez access 
//		String[] content = input_en.readLine().split(", ");
//		String checkeu = content[1];
//		
//		taskm = new JCheckBox(checkeu);
//		
		
		// adding the tasks 
		
//		String[] content = input_en.readLine().split(", ");
//		for (int i = 1; i < AddEvent_.mon; i++) {
//			JCheckBox chek = new JCheckBox(content[i]);
//			wdp1.add(chek);
//		}
//		
		String[] content = input_en.readLine().split(", ");
		
		String cm = content[1];
		tm1 = new JCheckBox();
		tm1.setBackground(bumble2);
		
//		String ct = content[2];
//		tm2 = new JCheckBox();
//		tm2.setBackground(bumble2);
//		
//		String cw = content[3];
//		tm3 = new JCheckBox();
//		tm3.setBackground(bumble2); 
//		
//		String ctt = content[4];
//		tm4 = new JCheckBox();
//		tm4.setBackground(bumble2);
	
		
		tue = new JLabel("Tuesday"); 
		tue.setBounds(264, 115, 175, 21);
		tue.setFont(newfont);
		tue.setForeground(bumble5);
		tue.setBackground(bumble4);
		tue.setHorizontalAlignment(SwingConstants.CENTER);
		tue.setBorder(BorderFactory.createLineBorder(bumble6));

		wed = new JLabel("Wednesday");   
		wed.setBounds(439, 115, 175, 21);
		wed.setFont(newfont);
		wed.setForeground(bumble5);
		wed.setBackground(bumble4);
		wed.setHorizontalAlignment(SwingConstants.CENTER);
		wed.setBorder(BorderFactory.createLineBorder(bumble6));

		thu = new JLabel("Thursday"); 
		thu.setBounds(614, 115, 175, 21);
		thu.setFont(newfont);
		thu.setForeground(bumble5);
		thu.setBackground(bumble4);
		thu.setHorizontalAlignment(SwingConstants.CENTER);
		thu.setBorder(BorderFactory.createLineBorder(bumble6));

		fri = new JLabel("Friday"); 
		fri.setBounds(789, 115, 175, 21);
		fri.setFont(newfont);
		fri.setForeground(bumble5);
		fri.setBackground(bumble4);
		fri.setHorizontalAlignment(SwingConstants.CENTER);
		fri.setBorder(BorderFactory.createLineBorder(bumble6));

		sat = new JLabel("Saturday"); 
		sat.setBounds(90, 414, 175, 21);
		sat.setFont(newfont);
		sat.setForeground(bumble5);
		sat.setBackground(bumble4);
		sat.setHorizontalAlignment(SwingConstants.CENTER);
		sat.setBorder(BorderFactory.createLineBorder(bumble6));
		
		sun = new JLabel("Sunday"); 
		sun.setBounds(264, 414, 175, 21);
		sun.setFont(newfont);
		sun.setForeground(bumble5);
		sun.setBackground(bumble4);
		sun.setHorizontalAlignment(SwingConstants.CENTER);
		sun.setBorder(BorderFactory.createLineBorder(bumble6));
		
		
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
		
		Icon icon = new ImageIcon("images/image.png");
		
		return_main = new JButton(logo);
		return_main.setBounds(90, 25, 50, 50);
		return_main.setBackground(bumble3);
		return_main.setBorder(BorderFactory.createLineBorder(bumble6));
		
		weekly = new JTextField("WEEKLY");
		weekly.setHorizontalAlignment(SwingConstants.CENTER);
		weekly.setBounds(140, 25, 240, 50);
		weekly.setBackground(bumble3);
		weekly.setFont(newfont5);		
		weekly.setBorder(BorderFactory.createLineBorder(bumble6));
		weekly.setEditable(false);

		addEvent = new JButton("Add Event");
		addEvent.setBounds(1140, 625, 140, 40);
		addEvent.setBackground(bumble3);
		addEvent.setFont(newfont5);
		addEvent.setBorder(BorderFactory.createLineBorder(bumble6));
		
		clear = new JButton("Clear");
		clear.setHorizontalAlignment(SwingConstants.CENTER);
		clear.setBounds(1140, 675, 140, 40);
		clear.setFont(newfont5);
		clear.setBackground(bumble3);
		clear.setBorder(BorderFactory.createLineBorder(bumble5));
		
		
		// add the actionlisteners
		addEvent.addActionListener(this);
		return_main.addActionListener(this);
		clear.addActionListener(this);
	
		
		// add the components
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
		frame.add(wdp1);
		frame.add(wdp2);
		frame.add(wdp3);
		frame.add(wdp4);
		frame.add(wdp5);
		frame.add(wep1);
		frame.add(wep2);
		frame.add(deco1);
		
		wdp1.add(tm1);
		

		
		
		// frame visibility toggle 
		frame.setVisible(true);
		
	}
	
	
	
//	public void writeEventM() {
//		
//		String[] content;
//
//		content = new String[AddEvent_.mon];
//		try {
//			content = input_en.readLine().split(", ");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		for(int i = 1; i < AddEvent_.mon + 1; i++) {
//			taskm = new JCheckBox(content[i]);
//			wdp1.add(taskm);
//		}
//	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == addEvent) {
			try {
				new AddEvent_();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == return_main) {
			try {
				new Mainscreen();
				frame.dispose();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String[]args) throws IOException {
		new Weekly();
	}
}



