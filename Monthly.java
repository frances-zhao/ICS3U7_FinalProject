// import packages
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Monthly extends JFrame implements ActionListener {

	// variable declarations 
	private static final long serialVersionUID = 1L;
	static JFrame frame = new JFrame("Monthly Calendar");

	// declaring calendars
	static Calendar calendar1 = new GregorianCalendar();
	static CalendarView currentcalendar = new CalendarView(new GregorianCalendar(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), 1)); // calendar on screen

	private JButton last = new JButton("<<"); // move to previous month button
	private JButton next = new JButton(">>"); // move to next month button

	static Font newfont; // declaring font
	private JButton home;

	static Color yellow1 = new Color(255, 208, 37); // tackle logo bg yellow color 
	static Color yellow2 = new Color(232, 180, 2); // buttons color (dark)
	static Color yellow3 = new Color(255, 255, 255); // white

	Monthly() {

		// try/catch importing the font
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);

		} catch (IOException | FontFormatException e){

		}

		// importing mini logo as icon
		Icon icon = new ImageIcon("images/image.png");
		home = new JButton(icon);

		// screen declarations
		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(yellow1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.enable();

		// declaring a new panel
		JPanel panel = new JPanel();

		// setting font for buttons
		last.setFont(newfont);
		home.setFont(newfont);
		next.setFont(newfont);

		// setting panel colour and adding buttons
		panel.setBackground(yellow1);
		panel.add(last);
		panel.add(home);
		panel.add(next);

		// adding action listener to the buttons
		home.addActionListener(this);
		next.addActionListener(this);	
		last.addActionListener(this);
		
		// adding the calendar to the JFrame
		frame.add(currentcalendar, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.NORTH);
		frame.setVisible(true); // set frame visible



	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource()== next) { // if next month button clicked
			frame.remove(currentcalendar); // remove the current calendar shown
			currentcalendar = currentcalendar.nextMonth(); // make the new current calendar the next month
			frame.add(currentcalendar, BorderLayout.CENTER); // add the calendar to the current frame
			frame.repaint();
			frame.revalidate(); // revalidate the frame
		}

		if (e.getSource() == last) {  // if last month button clicked
			frame.remove(currentcalendar); // remove the current calendar shown
			currentcalendar = currentcalendar.lastMonth(); // make the new current calendar the last month
			frame.add(currentcalendar, BorderLayout.CENTER); // add the calendar to the current frame
			frame.repaint();
			frame.revalidate(); // revalidate the frame

		}

		if (e.getSource() == home) { // if the home button is clicked
			try {
				new Mainscreen();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
			

		}
	}

	// for trial and error only: main program
	public static void main(String[]args) {
		new Monthly();
	}

}

