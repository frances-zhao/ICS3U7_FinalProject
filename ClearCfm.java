// import java packages
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

/**
 * class that clears everything in the txt files of the events and reintializes it to its original state
 * @author Frances Zhao
 *
 */
public class ClearCfm extends JFrame implements ActionListener{

	// variable declaration
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel cleartitle = new JLabel("Clear?");
	private JLabel clearlabel, clearlabel1;
	private JButton confirmbtn;
	private JButton cancelbtn;

	String filename1 = Main.getfile1();
	String filename2 = Main.getfile2();

	// font declarations
	Font newfont;
	Font newfont1;

	static String [] monname, mondesc, tuename, tuedesc, wedname, weddesc, thuname, thudesc, friname, fridesc, satname, satdesc, sunname, sundesc;
	static int monlen = 0, tuelen = 0, wedlen = 0, thulen = 0, frilen = 0, satlen = 0, sunlen = 0;

	// declaring the writers 

	public static String[][] aen = new String[8][50]; 
	public static String[][] aed = new String[7][50]; 

	/**
	 * constructor that implements GUI interface and methods
	 */
	public ClearCfm() {

		// trying font
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(13f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
		} catch (IOException | FontFormatException e){
			System.out.println("ClearCfm - Cannot import font.");

		}


		// initializing frame
		final int HEIGHT = 250;
		final int WIDTH = 400;
		frame = new JFrame("Logout?"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);


		// implementing java components
		cleartitle.setFont(newfont1);
		cleartitle.setHorizontalAlignment(SwingConstants.CENTER);
		cleartitle.setBounds(155, 6, 90, 46);

		clearlabel = new JLabel("Are you sure you want ");
		clearlabel.setHorizontalAlignment(SwingConstants.CENTER);
		clearlabel.setFont(newfont);
		clearlabel.setBounds(42, 43, 321, 46);

		clearlabel1 = new JLabel("to CLEAR EVERYTHING?");
		clearlabel1.setHorizontalAlignment(SwingConstants.CENTER);
		clearlabel1.setFont(newfont);
		clearlabel1.setBounds(42, 58, 321, 46);

		confirmbtn = new JButton("Confirm");
		confirmbtn.setFont(newfont);
		confirmbtn.setBounds(226, 120, 117, 56);
		confirmbtn.addActionListener(this);

		cancelbtn = new JButton("Cancel");
		cancelbtn.setFont(newfont);
		cancelbtn.setBounds(42, 120, 117, 56);
		cancelbtn.addActionListener(this);


		// actual GUI
		frame.add(cleartitle);
		frame.add(clearlabel);
		frame.add(clearlabel1);
		frame.add(confirmbtn);
		frame.add(cancelbtn);
		frame.setVisible(true);
	}

	/**
	 * method that clears up the entire txt file and reintializes it to its original state
	 * @throws IOException
	 */
	public void cleartxt() throws IOException {

		PrintWriter pw = new PrintWriter(filename1);
		pw.print("");
		pw.close();

		PrintWriter pw1 = new PrintWriter(filename2);
		pw1.print("");
		pw1.close();

		// new buffered writer
		BufferedWriter out_t = new BufferedWriter(new FileWriter(filename1)); // title+time of event 
		BufferedWriter out_d = new BufferedWriter(new FileWriter(filename2)); // event description 

		// writing Sample, into new files
		for(int i = 0; i < 8; i++) {
			out_t.write("Sample, ");
			out_t.newLine();
		}
		for(int i = 0; i < 7; i++) {
			out_d.write("Sample, ");
			out_d.newLine();

		}
		// closing writers
		out_t.flush();
		out_d.flush();
		out_t.close();
		out_d.close();

	}

	/**
	 * method that reads in the file name 
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
		monlen = monname.length;
		tuelen = tuename.length;
		wedlen = wedname.length;
		thulen = thuname.length;
		frilen = friname.length;
		satlen = satname.length;
		sunlen = sunname.length;

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

	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == confirmbtn) { // if confirm button clicked
			try {
				JOptionPane.showMessageDialog(this, "Clearing scheduler...");
				cleartxt();
				frame.dispose();
				new Weekly(); // redirect to main class
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}

		if (e.getSource() == cancelbtn) { // if cancel button clicked
			frame.dispose(); // dispose of current frame
			try {
				new Weekly();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}




}
