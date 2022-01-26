import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class Weekly extends JFrame implements ActionListener{
	
	JFrame frame = new JFrame("Weekly Calendar");
	JPanel m_panel = new JPanel(); 
	JTable weekdays, weekends; 
	JButton addEvent, return_main;
	JLabel weekly, todo, notes; 
	ImageIcon add = new ImageIcon("images/add.png");
	ImageIcon logo = new ImageIcon("images/image.png");
	
		
	//declaring fonts 
	static Font newfont, newfont1, newfont2, newfont3, newfont4, newfont5; //declaring all fonts 
	
	// declaring the colours 
	static Color bumble1 = new Color(255, 208, 37);   // button background colour 
	static Color bumble2 = new Color(245, 208, 76);   // panel background colour 
	static Color bumble3 = new Color(252, 248, 219);  // outline 2 (yellowish gray)
	static Color bumble4 = new Color(202, 194, 150);  // button outline colour 
	static Color bumble5 = new Color(69, 62, 39);     // outline 2 (dark stale brown)
	

	public static void main(String[] args) {
		try {
			new Weekly();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


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
		
		// weekdays table constructor
		// ---------Monday-----------
		JPanel m_panel = new JPanel(); 
		m_panel.add(new TablePanel(25, 85, 175, 300));
		m_panel.setBackground(bumble2);

		// ---------Tuesday-----------
		JPanel t_panel = new JPanel();
		t_panel.add(new TablePanel(200, 85, 175, 300));
		t_panel.setBackground(bumble2);
		
		// setting the basic outline of the gui tab 
		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame.setSize(WIDTH,HEIGHT);
		frame.getContentPane().setBackground(bumble2);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		// declaring the characteristics of the components
		Image image_plus = add.getImage(); // transforming the addition sign image (for add event)
		Image image_n = image_plus.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		add = new ImageIcon(image_n);
		
		Image image_logo = logo.getImage(); // transforming the logo image 
		Image image_n2 = image_logo.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(image_n2);
		
		Icon icon = new ImageIcon("images/image.png");
		
		addEvent = new JButton(add);
		addEvent.setBounds(30, 65, 25, 25);
		addEvent.setBackground(bumble3);
		addEvent.setFont(newfont);
		addEvent.setBorder(BorderFactory.createLineBorder(bumble5));
				
		return_main = new JButton(logo);
		return_main.setBounds(1325, 15, 50, 50);
		return_main.setBackground(bumble2);
		return_main.setBorder(BorderFactory.createLineBorder(bumble3));
		
		weekly = new JLabel("WEEKLY");
		weekly.setHorizontalAlignment(SwingConstants.CENTER);
		weekly.setBounds(-40, 15, 240, 36);
		weekly.setFont(newfont5);		
		
		
		// add the actionlisteners
		addEvent.addActionListener(this);
		return_main.addActionListener(this);
		
		// frame location on screen null
		
		// add the components
		frame.add(addEvent);
		frame.add(weekly);
		frame.add(return_main);
		frame.add(m_panel);
		frame.add(t_panel);

		// frame visibility toggle 
		frame.setVisible(true);
		
	}


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
			try {import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Weekly extends JFrame implements ActionListener{
	
	// declaring the major components 
	JFrame frame = new JFrame("Weekly Calendar");
	JPanel m_panel = new JPanel(new FlowLayout()); 
	JPanel wdp1, wdp2, wdp3, wdp4, wdp5; // weekdays panels
	JPanel wep1, wep2; // weekends panels 
	JButton addEvent, return_main, clear;
	JLabel mon, tue, wed, thu, fri, sat, sun; 
	JLabel weekly, todo, notes; 
	ImageIcon add = new ImageIcon("images/add.png");
	ImageIcon logo = new ImageIcon("images/image.png");
	
	//  -------------- declare the misc. variables --------------------------------
	
	// declaring the writers
	BufferedWriter et_write = new BufferedWriter (new FileWriter("eventName.txt"));
		
	//declaring fonts 
	static Font newfont, newfont1, newfont2, newfont3, newfont4, newfont5; //declaring all fonts 
	
	// declaring the colours 
	static Color bumble1 = new Color(255, 208, 37);   // button background colour 
	static Color bumble2 = new Color(245, 208, 76);   // panel background colour 
	static Color bumble3 = new Color(252, 248, 219);  // outline 2 (yellowish gray)
	static Color bumble4 = new Color(202, 194, 150);  // button outline colour 
	static Color bumble5 = new Color(69, 62, 39);     // outline 2 (dark stale brown)
	

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
		
		wdp1 = new JPanel();
		wdp1.setBounds(30, 85, 175, 300);
		wdp1.setBackground(bumble3);
		wdp1.setBorder(BorderFactory.createLineBorder(bumble5));
		
		wdp2 = new JPanel();
		wdp2.setBounds(205, 85, 175, 300);
		wdp2.setBackground(bumble3);
		wdp2.setBorder(BorderFactory.createLineBorder(bumble5));
		
		wdp3 = new JPanel();
		wdp3.setBounds(380, 85, 175, 300);
		wdp3.setBackground(bumble3);
		wdp3.setBorder(BorderFactory.createLineBorder(bumble5));
		
		wdp4 = new JPanel();
		wdp4.setBounds(555, 85, 175, 300);
		wdp4.setBackground(bumble3);
		wdp4.setBorder(BorderFactory.createLineBorder(bumble5));
		
		wdp5 = new JPanel();
		wdp5.setBounds(730, 85, 175, 300);
		wdp5.setBackground(bumble3);
		wdp5.setBorder(BorderFactory.createLineBorder(bumble5));
		
		wep1 = new JPanel();
		wep1.setBounds(30, 385, 175, 300);
		wep1.setBackground(bumble3);
		wep1.setBorder(BorderFactory.createLineBorder(bumble5));
		
		
		wep2 = new JPanel();
		wep2.setBounds(205, 385, 175, 300);
		wep2.setBackground(bumble3);
		wep2.setBorder(BorderFactory.createLineBorder(bumble5));
		
		
		mon = new JLabel("Monday"); 
		mon.setBounds(30, 85, 175, 21);
		mon.setFont(newfont);
		mon.setForeground(bumble5);
		mon.setHorizontalAlignment(SwingConstants.CENTER);
		mon.setBorder(BorderFactory.createLineBorder(bumble5));
		
		tue = new JLabel("Tuesday"); 
		tue.setBounds(205, 85, 175, 21);
		tue.setFont(newfont);
		tue.setForeground(bumble5);
		tue.setHorizontalAlignment(SwingConstants.CENTER);
		tue.setBorder(BorderFactory.createLineBorder(bumble5));

		wed = new JLabel("Wednesday");   
		wed.setBounds(380, 85, 175, 21);
		wed.setFont(newfont);
		wed.setForeground(bumble5);
		wed.setHorizontalAlignment(SwingConstants.CENTER);
		wed.setBorder(BorderFactory.createLineBorder(bumble5));

		thu = new JLabel("Thursday"); 
		thu.setBounds(555, 85, 175, 21);
		thu.setFont(newfont);
		thu.setForeground(bumble5);
		thu.setHorizontalAlignment(SwingConstants.CENTER);
		thu.setBorder(BorderFactory.createLineBorder(bumble5));

		fri = new JLabel("Friday"); 
		fri.setBounds(730, 85, 175, 21);
		fri.setFont(newfont);
		fri.setForeground(bumble5);
		fri.setHorizontalAlignment(SwingConstants.CENTER);
		fri.setBorder(BorderFactory.createLineBorder(bumble5));

		sat = new JLabel("Saturday"); 
		sat.setBounds(30, 385, 175, 21);
		sat.setFont(newfont);
		sat.setForeground(bumble5);
		sat.setHorizontalAlignment(SwingConstants.CENTER);
		sat.setBorder(BorderFactory.createLineBorder(bumble5));
		
		sun = new JLabel("Sunday"); 
		sun.setBounds(205, 385, 175, 21);
		sun.setFont(newfont);
		sun.setForeground(bumble5);
		sun.setHorizontalAlignment(SwingConstants.CENTER);
		sun.setBorder(BorderFactory.createLineBorder(bumble5));
		
		
		// declaring the characteristics of the components
		Image image_plus = add.getImage(); // transforming the addition sign image (for add event)
		Image image_n = image_plus.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		add = new ImageIcon(image_n);
		
		Image image_logo = logo.getImage(); // transforming the logo image 
		Image image_n2 = image_logo.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		logo = new ImageIcon(image_n2);
		
		Icon icon = new ImageIcon("images/image.png");
		
		addEvent = new JButton("Add Event");
		addEvent.setBounds(1200, 660, 140, 40);
		addEvent.setBackground(bumble3);
		addEvent.setFont(newfont5);
		addEvent.setBorder(BorderFactory.createLineBorder(bumble5));
		
		return_main = new JButton(logo);
		return_main.setBounds(160, 11, 50, 50);
		return_main.setBackground(bumble1);
		return_main.setBorder(BorderFactory.createLineBorder(bumble2));
		
		weekly = new JLabel("WEEKLY");
		weekly.setHorizontalAlignment(SwingConstants.CENTER);
		weekly.setBounds(-25, 25, 240, 36);
		weekly.setFont(newfont5);		
		
		clear = new JButton("Clear");
		clear.setHorizontalAlignment(SwingConstants.CENTER);
		clear.setBounds(1200, 700, 140, 40);
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

		// frame visibility toggle 
		frame.setVisible(true);
		
	}

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
}



