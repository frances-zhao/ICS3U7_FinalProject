import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;



public class AddEvent_ extends JFrame implements ActionListener{

	// -------------- declare the GUI variables --------------------------------
	JPanel panel;
	JFrame frame; 

	JCheckBox importance;
	JLabel class_title, importance_, event_name_, event_desc_, day_;
	JTextField event_name, h, m, colon, day; 
	JTextArea event_desc;
	JButton add_event, discard_event, prev1, next1;


	//  -------------- declare the misc. variables --------------------------------
	Boolean important = false; 
	String filename1 = "eventName.txt";
	String filename2 = "eventInfo.txt";
	public static BufferedWriter out; 
	public static String[][] aen = new String[8][50]; // add event name
	public static String[][] aed = new String[7][50]; // add event desc. 
	public static String[][] at = new String[24][60]; // add time 
	public static int num_event_n, num_event_d; 
	public static String event_n, event_d, time_; 
	public String en_string, ed_string, time_string;
	String [] monname, mondesc, tuename, tuedesc, wedname, weddesc, thuname, thudesc, friname, fridesc, satname, satdesc, sunname, sundesc;

	int monlen, tuelen, wedlen, thulen, frilen, satlen, sunlen;
	static int mon = 0, tue = 0, wed = 0, thu = 0, fri = 0, sat = 0, sun = 0;

	//	String[] hours = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
	//			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
	//	
	//	String[] minutes = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
	//			"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
	//			"23", "24", "25", "26", "27", "28", "28", "29", "30", "31", "32", "33", "34", 
	//			"35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47",
	//			"48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"};

	//TODO: buffered readers 
	BufferedReader input_t = new BufferedReader(new FileReader(filename1));
	BufferedReader input_d = new BufferedReader(new FileReader(filename2));
	


	// Action a;

	// -------------- declaring the fonts --------------------------------------
	static Font newfont, newfont1, newfont2, newfont3, newfont4, newfont5, newfont6, newfont7; 

	// -------------- declaring the colours -------------------------------------
	static Color bumble1 = new Color(255, 208, 37);   // button background colour 
	static Color bumble2 = new Color(245, 208, 76);   // panel background colour 
	static Color bumble3 = new Color(252, 248, 219);  // outline 2 (yellowish gray)
	static Color bumble4 = new Color(202, 194, 150);  // button outline colour 
	static Color bumble5 = new Color(69, 62, 39);     // outline 2 (dark stale brown)
	static Color bumble6 = new Color(255, 248, 171);  // textfield fill colour 


	AddEvent_() throws IOException{

		// -------------- adding the attributes of the fonts --------------------
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(15f);
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(18f);
			newfont2 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
			newfont3 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(25f);
			newfont4 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(30f);
			newfont5 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(35f);
			newfont6 =  Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(40f);
			newfont7 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(60f);


		} catch (IOException | FontFormatException e){

		}
		
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
		
		input_t.close();
		input_d.close();
		// -------------- setting the basic outline of the GUI tab --------------
		final int HEIGHT = 420; 
		final int WIDTH = 690; 
		frame = new JFrame("Tackle");
		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane().setBackground(bumble2);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// -------------- declaring the characteristics of the components -------
		class_title = new JLabel("Add Event");
		class_title.setHorizontalAlignment(SwingConstants.CENTER);
		class_title.setBounds(28, 20, 160, 30);
		class_title.setFont(newfont3);
		class_title.setForeground(bumble5);

		event_name_ = new JLabel("Event Name");
		event_name_.setHorizontalAlignment(SwingConstants.CENTER);
		event_name_.setBounds(35, 65, 160, 30);
		event_name_.setFont(newfont2);
		event_name_.setForeground(bumble5);
		event_name_.setBorder(BorderFactory.createLineBorder(bumble3));

		event_name = new JTextField();
		event_name.setBounds(194, 65, 200, 30);
		event_name.setFont(newfont);
		event_name.setBackground(bumble6);
		event_name.setBorder(BorderFactory.createLineBorder(bumble3));

		event_desc_ = new JLabel("Event Info");
		event_desc_.setHorizontalAlignment(SwingConstants.CENTER);
		event_desc_.setBounds(35, 130, 160, 30);
		event_desc_.setFont(newfont2);
		event_desc_.setForeground(bumble5);
		event_desc_.setBorder(BorderFactory.createLineBorder(bumble3));

		event_desc = new JTextArea();
		event_desc.setBounds(35, 159, 350, 180);
		event_desc.setFont(newfont);
		event_desc.setBackground(bumble6);
		event_desc.setLineWrap(true);
		event_desc.setBorder(BorderFactory.createLineBorder(bumble3));

		importance = new JCheckBox("important");
		importance.setBounds(425, 71, 160, 20);
		importance.setFont(newfont2);
		importance.setForeground(bumble5);
		importance.setBackground(bumble2);

		day_ = new JLabel("Day of Event");
		day_.setBounds(425, 160, 150, 30);
		day_.setForeground(bumble5);
		day_.setFont(newfont2);
		day_.setHorizontalAlignment(SwingConstants.CENTER);
		day_.setBorder(BorderFactory.createLineBorder(bumble3));

		day = new JTextField(); 
		day.setBounds(425, 190, 150, 30);
		day.setFont(newfont1);
		day.setBackground(bumble6);
		day.setHorizontalAlignment(SwingConstants.CENTER);
		day.setBorder(BorderFactory.createLineBorder(bumble3));

		add_event = new JButton("ADD");
		add_event.setBounds(425, 245, 150, 40);
		add_event.setHorizontalAlignment(SwingConstants.CENTER);
		add_event.setFont(newfont3);
		add_event.setForeground(bumble5);
		add_event.setBackground(bumble6);
		add_event.setBorder(BorderFactory.createLineBorder(bumble3));

		discard_event = new JButton("Discard");
		discard_event.setBounds(425, 300, 150, 40);
		discard_event.setHorizontalAlignment(SwingConstants.CENTER);
		discard_event.setFont(newfont3);
		discard_event.setForeground(bumble5);
		discard_event.setBackground(bumble6);
		discard_event.setBorder(BorderFactory.createLineBorder(bumble3));

		// making time picker 
		//		next1 = new JButton("+");
		//		next1.setBounds(425, 105, 20, 16);
		//		next1.setFont(newfont);
		//		next1.setForeground(bumble5);
		//		next1.setBackground(bumble6);
		//		next1.setBorder(BorderFactory.createLineBorder(bumble6));
		//
		//		prev1 = new JButton("-");
		//		prev1.setBounds(425, 120, 20, 16);
		//		prev1.setFont(newfont);
		//		prev1.setForeground(bumble5);
		//		prev1.setBackground(bumble6);
		//		prev1.setBorder(BorderFactory.createLineBorder(bumble6));

		h = new JTextField();
		h.setBounds(437, 105, 60, 32);
		h.setFont(newfont2);
		h.setForeground(bumble5);
		h.setBackground(bumble6);

		m = new JTextField();
		m.setBounds(507, 105, 60, 32);
		m.setFont(newfont2);
		m.setForeground(bumble5);
		m.setBackground(bumble6);

		colon = new JTextField(":");
		colon.setBounds(496, 105, 12, 32);
		colon.setFont(newfont2);
		colon.setForeground(bumble5);
		colon.setBackground(bumble6);
		colon.setHorizontalAlignment(SwingConstants.CENTER);
		colon.setBorder(BorderFactory.createLineBorder(bumble6));
		colon.setEditable(false);


		// getting rid of the sound that jtextarea and field makes when backspace is out of range 
		// a = event_desc.getActionMap().get(DefaultEditorKit.beepAction);
		// a.setEnabled(false);	

		// ------------- add the actionlisteners --------------------------------
		importance.addActionListener(this);
		add_event.addActionListener(this);
		discard_event.addActionListener(this);

		// ------------- frame on screen location null --------------------------
		frame.setLayout(null);

		// ------------- add the components -------------------------------------
		frame.add(class_title);
		frame.add(event_name_);
		frame.add(event_name);
		frame.add(event_desc_);
		frame.add(event_desc);
		frame.add(importance);
		frame.add(add_event);
		frame.add(discard_event);
		frame.add(day_);
		frame.add(day);
		//		frame.add(next1);
		//		frame.add(prev1);
		frame.add(h);
		frame.add(m);
		frame.add(colon);

		// ------------- frame visibility toggle --------------------------------
		frame.setVisible(true);

	}

	public void addEventName() throws IOException{
		if (day.getText().equalsIgnoreCase("monday")) {
			mon++;
			num_event_n = mon;
			num_event_d = mon;

			addE(0);
		}

		else if (day.getText().equalsIgnoreCase("tuesday")) {
			tue++;
			num_event_n = tue;
			num_event_d = tue;

			addE(1);
		}

		else if (day.getText().equalsIgnoreCase("wednesday")) {
			wed++;
			num_event_n = wed;
			num_event_d = wed;

			addE(2);
		}

		else if (day.getText().equalsIgnoreCase("thursday")) {
			thu++;
			num_event_n = thu;
			num_event_d = thu;

			addE(3);
		}

		else if (day.getText().equalsIgnoreCase("friday")) {
			fri++;
			num_event_n = fri;
			num_event_d = fri;

			addE(4);
		}

		else if (day.getText().equalsIgnoreCase("saturday")) {
			sat++;
			num_event_n = sat;
			num_event_d = sat;

			addE(5);
		}

		else if (day.getText().equalsIgnoreCase("sunday")) {
			sun++;
			num_event_n = sun;
			num_event_d = sun;

			addE(6);
		}

		else {
			new Invalid();
			frame.dispose();
		}

	}


	public void addE(int n) throws IOException { // n and m represents the row of aen, aed arrays 
		// out_t, out_d 
		
		BufferedWriter out_t = new BufferedWriter(new FileWriter(filename1)); // title+time of event 
		BufferedWriter out_d = new BufferedWriter(new FileWriter(filename2)); // event description 
		
		event_n = event_name.getText();
		event_d = event_desc.getText();
		time_ = ", ".concat(h.getText().concat(":"));
		time_ = time_.concat(m.getText());

		aen[n][num_event_n] = event_n;
		aen[7][num_event_n] = time_;
		aed[n][num_event_d] = event_d;

		for(int i = 0; i <= mon; i++ ) {
			out_t.write(aen[0][i] + ", ");
			out_d.write(aed[0][i] + ", ");
		}
		out_t.newLine();
		out_d.newLine();

		for(int i = 0; i <= tue; i++ ) {
			out_t.write(aen[1][i] + ", ");
			out_d.write(aed[1][i] + ", ");
		}
		out_t.newLine();
		out_d.newLine();

		for(int i = 0; i <= wed; i++ ) {
			out_t.write(aen[2][i] + ", ");
			out_d.write(aed[2][i] + ", ");

		}
		out_t.newLine();
		out_d.newLine();

		for(int i = 0; i <= thu; i++ ) {
			out_t.write(aen[3][i] + ", ");
			out_d.write(aed[3][i] + ", ");

		}
		out_t.newLine();
		out_d.newLine();

		for(int i = 0; i <= fri; i++ ) {
			out_t.write(aen[4][i] + ", ");
			out_d.write(aed[4][i] + ", ");

		}
		out_t.newLine();
		out_d.newLine();

		for(int i = 0; i <= sat; i++ ) {
			out_t.write(aen[5][i] + ", ");
			out_d.write(aed[5][i] + ", ");

		}
		out_t.newLine();
		out_d.newLine();

		for(int i = 0; i <= sun; i++ ) {
			out_t.write(aen[6][i] + ", ");
			out_d.write(aed[6][i] + ", ");

		}
		out_t.newLine();
		out_d.newLine();

		
		out_t.close();
		out_d.close();

	}


	@Override
	public void actionPerformed(ActionEvent e) {


		// setting the importance of the event as true 
		if (e.getSource() == importance) {
			important = true;
		}

		if (e.getSource() == discard_event) {

			frame.dispose();

		}

		if (e.getSource() == add_event) {
			String empty = "";
			if (day.getText().equals(empty) || event_name.equals(empty) || event_desc.equals(empty) || h.equals(empty) || m.equals(empty)) {
				JOptionPane.showMessageDialog(this, "Cannot have empty spaces!");
			}

			else{
				try {

					addEventName();
					frame.dispose();
				} 

				catch (IOException e1) {
					e1.printStackTrace();

				} }


		}

	}

}

