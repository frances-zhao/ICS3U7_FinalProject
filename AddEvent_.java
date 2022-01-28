import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/**
 * This class AddEvent_ adds an event to the correct day of the week in the weekly scheduler
 * @author Lucia Kim, Frances Zhao
 *
 */
public class AddEvent_ extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
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
	String filename1 = Main.getfile1();
	String filename2 = Main.getfile2();
	public static BufferedWriter out; 
	/**
	 * more variable declarations for arrays
	 */
	public static String[][] aen = new String[8][50]; // add event name
	public static String[][] aed = new String[7][50]; // add event description
	public static String[][] at = new String[24][60]; // add time 
	public static int num_event_n, num_event_d; 
	public static String event_n, event_d, time_; 
	public String en_string, ed_string, time_string;
	static String [] monname, mondesc, tuename, tuedesc, wedname, weddesc, thuname, thudesc, friname, fridesc, satname, satdesc, sunname, sundesc;

	static int monlen = 0, tuelen = 0, wedlen = 0, thulen = 0, frilen = 0, satlen = 0, sunlen = 0;
	static int mon = 0, tue = 0, wed = 0, thu = 0, fri = 0, sat = 0, sun = 0;

	BufferedReader input_t = new BufferedReader(new FileReader(filename1));
	BufferedReader input_d = new BufferedReader(new FileReader(filename2));



	// Action a;

	// -------------- declaring the fonts --------------------------------------
	static Font newfont, newfont1, newfont2, newfont3, newfont4, newfont5, newfont6, newfont7; 

	// -------------- declaring the colours -------------------------------------
	Color colour1 = ColourCSTM.getFirstColour();
	Color colour2 = ColourCSTM.getSecondColour();
	Color colour3 = ColourCSTM.getThirdColour();

	/**
	 * constructor implements GUI interface and adds event to weekly scheduler
	 * @throws IOException
	 */
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
			System.out.println("AddEvent_ - Cannot import font.");

		}
		readin();
		input_t.close();
		input_d.close();

		// -------------- setting the basic outline of the GUI tab --------------
		final int HEIGHT = 420; 
		final int WIDTH = 690; 
		frame = new JFrame("Tackle");
		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane().setBackground(colour1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		// -------------- declaring the characteristics of the components -------


		class_title = new JLabel("Add Event");
		class_title.setHorizontalAlignment(SwingConstants.CENTER);
		class_title.setBounds(28, 20, 160, 30);
		class_title.setFont(newfont3);
		class_title.setForeground(Color.black);

		event_name_ = new JLabel("Event Name");
		event_name_.setHorizontalAlignment(SwingConstants.CENTER);
		event_name_.setBounds(35, 65, 160, 30);
		event_name_.setFont(newfont2);
		event_name_.setForeground(Color.black);
		event_name_.setBorder(BorderFactory.createLineBorder(colour3));

		event_name = new JTextField();
		event_name.setBounds(194, 65, 200, 30);
		event_name.setFont(newfont);
		event_name.setBackground(colour2);
		event_name.setBorder(BorderFactory.createLineBorder(colour3));

		event_desc_ = new JLabel("Event Info");
		event_desc_.setHorizontalAlignment(SwingConstants.CENTER);
		event_desc_.setBounds(35, 130, 160, 30);
		event_desc_.setFont(newfont2);
		event_desc_.setForeground(Color.black);
		event_desc_.setBorder(BorderFactory.createLineBorder(colour3));

		event_desc = new JTextArea();
		event_desc.setBounds(35, 159, 350, 180);
		event_desc.setFont(newfont);
		event_desc.setBackground(colour2);
		event_desc.setLineWrap(true);
		event_desc.setBorder(BorderFactory.createLineBorder(colour3));

		importance = new JCheckBox("important");
		importance.setBounds(425, 71, 160, 20);
		importance.setFont(newfont2);
		importance.setForeground(Color.black);
		importance.setBackground(colour1);

		day_ = new JLabel("Day of Event");
		day_.setBounds(425, 160, 150, 30);
		day_.setForeground(Color.black);
		day_.setFont(newfont2);
		day_.setHorizontalAlignment(SwingConstants.CENTER);
		day_.setBorder(BorderFactory.createLineBorder(colour3));

		day = new JTextField(); 
		day.setBounds(425, 190, 150, 30);
		day.setFont(newfont1);
		day.setBackground(colour2);
		day.setHorizontalAlignment(SwingConstants.CENTER);
		day.setBorder(BorderFactory.createLineBorder(colour3));

		add_event = new JButton("ADD");
		add_event.setBounds(425, 245, 150, 40);
		add_event.setHorizontalAlignment(SwingConstants.CENTER);
		add_event.setFont(newfont3);
		add_event.setForeground(Color.black);
		add_event.setBackground(colour2);
		add_event.setBorder(BorderFactory.createLineBorder(colour3));

		discard_event = new JButton("Discard");
		discard_event.setBounds(425, 300, 150, 40);
		discard_event.setHorizontalAlignment(SwingConstants.CENTER);
		discard_event.setFont(newfont3);
		discard_event.setForeground(Color.black);
		discard_event.setBackground(colour2);
		discard_event.setBorder(BorderFactory.createLineBorder(colour3));

		h = new JTextField();
		h.setBounds(437, 105, 60, 32);
		h.setFont(newfont2);
		h.setForeground(Color.black);
		h.setBackground(colour2);

		m = new JTextField();
		m.setBounds(507, 105, 60, 32);
		m.setFont(newfont2);
		m.setForeground(Color.black);
		m.setBackground(colour2);

		colon = new JTextField(":");
		colon.setBounds(496, 105, 12, 32);
		colon.setFont(newfont2);
		colon.setForeground(Color.black);
		colon.setBackground(colour3);
		colon.setHorizontalAlignment(SwingConstants.CENTER);
		colon.setBorder(BorderFactory.createLineBorder(colour3));
		colon.setEditable(false);

		// ------------- add the actionlisteners --------------------------------
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
		frame.add(h);
		frame.add(m);
		frame.add(colon);

		// ------------- frame visibility toggle --------------------------------
		frame.setVisible(true);

	}

	/**
	 * reading in each line of the txt file
	 * @throws IOException for readers
	 */
	public void readin() throws IOException {
		// reading in the name of the event into array
		monname = input_t.readLine().split(", ");
		tuename = input_t.readLine().split(", ");
		wedname = input_t.readLine().split(", ");
		thuname = input_t.readLine().split(", ");
		friname = input_t.readLine().split(", ");
		satname = input_t.readLine().split(", ");
		sunname = input_t.readLine().split(", ");

		// reading in the description of the event into array
		mondesc = input_d.readLine().split(", ");
		tuedesc = input_d.readLine().split(", ");
		weddesc = input_d.readLine().split(", ");
		thudesc = input_d.readLine().split(", ");
		fridesc = input_d.readLine().split(", ");
		satdesc = input_d.readLine().split(", ");
		sundesc = input_d.readLine().split(", ");

		// setting variable as the length of array
		monlen = monname.length;
		tuelen = tuename.length;
		wedlen = wedname.length;
		thulen = thuname.length;
		frilen = friname.length;
		satlen = satname.length;
		sunlen = sunname.length;

		// setting 2d array as array names and descriptions per day of week

		for(int i = 0; i < monlen; i++) { // monday
			aen[0][i] = monname[i];
			aed[0][i] = mondesc[i];
		}
		for(int i = 0; i < tuelen; i++) { // tuesday
			aen[1][i] = tuename[i];
			aed[1][i] = tuedesc[i];
		}
		for(int i = 0; i < wedlen; i++) { // wednesday
			aen[2][i] = wedname[i];
			aed[2][i] = weddesc[i];
		}
		for(int i = 0; i < thulen; i++) { // thursday
			aen[3][i] = thuname[i];
			aed[3][i] = thudesc[i];
		}
		for(int i = 0; i < frilen; i++) { // friday
			aen[4][i] = friname[i];
			aed[4][i] = fridesc[i];
		}
		for(int i = 0; i < satlen; i++) { // saturday
			aen[5][i] = satname[i];
			aed[5][i] = satdesc[i];
		}
		for(int i = 0; i < sunlen; i++) { // sunday
			aen[6][i] = sunname[i];
			aed[6][i] = sundesc[i];
		}

	}

	/**
	 * method that leads to adding the event into the weekly calendar
	 * @throws IOException for addE()
	 */
	public void addEventName() throws IOException{
		if (day.getText().equalsIgnoreCase("monday")) {
			monlen++;
			num_event_n = monlen-1;
			num_event_d = monlen-1;

			addE(0);
		}

		else if (day.getText().equalsIgnoreCase("tuesday")) {
			tuelen++;
			num_event_n = tuelen-1;
			num_event_d = tuelen-1;

			addE(1);
		}

		else if (day.getText().equalsIgnoreCase("wednesday")) {
			wedlen++;
			num_event_n = wedlen-1;
			num_event_d = wedlen-1;

			addE(2);
		}

		else if (day.getText().equalsIgnoreCase("thursday")) {
			thulen++;
			num_event_n = thulen-1;
			num_event_d = thulen-1;

			addE(3);
		}

		else if (day.getText().equalsIgnoreCase("friday")) {
			frilen++;
			num_event_n = frilen-1;
			num_event_d = frilen-1;

			addE(4);
		}

		else if (day.getText().equalsIgnoreCase("saturday")) {
			satlen++;
			num_event_n = satlen-1;
			num_event_d = satlen-1;

			addE(5);
		}

		else if (day.getText().equalsIgnoreCase("sunday")) {
			sunlen++;
			num_event_n = sunlen-1;
			num_event_d = sunlen-1;

			addE(6);
		}

		else {
			new Invalid();
			frame.dispose();
		}

	}


	/**
	 * method that writes out the new event into the txt files
	 * @param n integer of day of the week
	 * @throws IOException for writers
	 */
	public void addE(int n) throws IOException { // n represents the row of aen, aed arrays 

		BufferedWriter out_t = new BufferedWriter(new FileWriter(filename1)); // title of event 
		BufferedWriter out_d = new BufferedWriter(new FileWriter(filename2)); // event description 

		// getting text of textfields
		event_n = event_name.getText();
		event_d = event_desc.getText();
		time_ = ", ".concat(h.getText().concat(":"));
		time_ = time_.concat(m.getText());

		// setting the array of the event
		aen[n][num_event_n] = event_n;
		aen[7][num_event_n] = time_;
		aed[n][num_event_d] = event_d;

		// rewriting out all of the objects of array, including new array per day of the week

		for(int i = 0; i <= monlen-1; i++ ) { // monday is array[0]
			out_t.write(aen[0][i] + ", ");
			out_d.write(aed[0][i] + ", ");
		}
		out_t.newLine();
		out_d.newLine();

		for(int i = 0; i <= tuelen-1; i++ ) { // tuesday is array[1]
			out_t.write(aen[1][i] + ", ");
			out_d.write(aed[1][i] + ", ");
		}
		out_t.newLine();
		out_d.newLine();

		for(int i = 0; i <= wedlen-1; i++ ) { // wednesday is array[2]
			out_t.write(aen[2][i] + ", ");
			out_d.write(aed[2][i] + ", ");

		}
		out_t.newLine();
		out_d.newLine();

		for(int i = 0; i <= thulen-1; i++ ) { // thursday is array[3]
			out_t.write(aen[3][i] + ", ");
			out_d.write(aed[3][i] + ", ");

		}
		out_t.newLine();
		out_d.newLine();

		for(int i = 0; i <= frilen-1; i++ ) { // friday is array[4]
			out_t.write(aen[4][i] + ", ");
			out_d.write(aed[4][i] + ", ");

		}
		out_t.newLine();
		out_d.newLine();

		for(int i = 0; i <= satlen-1; i++ ) { // saturday is array[5]
			out_t.write(aen[5][i] + ", ");
			out_d.write(aed[5][i] + ", ");

		}
		out_t.newLine();
		out_d.newLine();

		for(int i = 0; i <= sunlen-1; i++ ) { // sunday is array[6]
			out_t.write(aen[6][i] + ", ");
			out_d.write(aed[6][i] + ", ");

		}
		out_t.newLine();
		out_d.newLine();


		out_t.close(); // closing buffered writers
		out_d.close();

	}


	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == discard_event) {

			frame.dispose();
			try {
				new Weekly();
			} catch (IOException e1) {
				System.out.println("cannot go to weekly.");
			}

		}

		if (e.getSource() == add_event) {
			String empty = "";
			if (day.getText().equals(empty) || event_name.equals(empty) || event_desc.equals(empty) || h.equals(empty) || m.equals(empty)) {
				JOptionPane.showMessageDialog(this, "Cannot have empty spaces!");
			}

			else{
				try {
					addEventName();
					new Weekly();
					frame.dispose();
				} 

				catch (IOException e1) {
					System.out.println("cannot add event.");

				} 
			}


		}

	}

}

