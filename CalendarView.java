// import packages
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

class CalendarView extends JPanel {

	// variable declaration
	private static final long serialVersionUID = 1L;
	public Calendar calendar; // importing a calendar
	private int thisYear = 0;
	private int thisMonth  = 0;
	private int daysinMonth = 0;
	private int startofDay = 0;
	private String monthstring = "";
	private int lastMonth = 0;
	private JLabel monthLabel;

	// temporary: colours
	static Color yellow1 = new Color(255, 208, 37); // tackle logo bg yellow color 
	static Color yellow2 = new Color(232, 180, 2); // buttons color (dark)
	static Color yellow3 = new Color(255, 255, 255); // white

	// days of the week labels
	private JLabel sun;
	private JLabel mon;
	private JLabel tue;
	private JLabel wed;
	private JLabel thu;
	private JLabel fri;
	private JLabel sat;

	// font declaration
	static Font newfont;

	public CalendarView(Calendar calendar) {

		// try/catch the font
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);

		} catch (IOException | FontFormatException e){

		}

		// current calendar is the calendar
		this.calendar = calendar;

		// setting layout as border
		setLayout(new BorderLayout());

		// using calendar function, get the specific needs
		thisMonth = calendar.get(Calendar.MONTH); // get the month
		thisYear = calendar.get(Calendar.YEAR); // get the year
		daysinMonth = getMax(thisMonth); // get the max days in the month
		monthstring = monthname(thisMonth); // get the string ver of the current month
		startofDay = calendar.get(Calendar.DAY_OF_WEEK); // get the start of the day of the week
		lastMonth = getPreviousMonth(thisMonth); // get the previous month

		// using the string of the current month and the current year to create a label
		monthLabel = new JLabel(monthstring +" "+ thisYear);
		monthLabel.setHorizontalAlignment(JLabel.CENTER);
		monthLabel.setFont(newfont);

		// creating a JPanel for the actual calendar
		JPanel panel = new JPanel(new GridLayout(0, 7, 0, 0));
		Border border = new LineBorder(Color.black, 1);

		// creating a JPanel for the month name
		JPanel top = new JPanel();

		// creating names for variables
		sun = new JLabel("Sunday");
		mon = new JLabel("Monday");
		tue = new JLabel("Tuesday");
		wed = new JLabel("Wednesday");
		thu = new JLabel("Thursday");
		fri = new JLabel("Friday");
		sat = new JLabel("Saturday");

		// set variables as center for horizontal alignment
		sun.setHorizontalAlignment(JLabel.CENTER);
		mon.setHorizontalAlignment(JLabel.CENTER);
		tue.setHorizontalAlignment(JLabel.CENTER);
		wed.setHorizontalAlignment(JLabel.CENTER);
		thu.setHorizontalAlignment(JLabel.CENTER);
		fri.setHorizontalAlignment(JLabel.CENTER);
		sat.setHorizontalAlignment(JLabel.CENTER);

		// add the labels into the border
		mon.setBorder(border);
		sun.setBorder(border);
		tue.setBorder(border);
		wed.setBorder(border);
		thu.setBorder(border);
		fri.setBorder(border);
		sat.setBorder(border);

		// set font for the labels
		sun.setFont(newfont);
		mon.setFont(newfont);
		tue.setFont(newfont);
		wed.setFont(newfont);
		thu.setFont(newfont);
		fri.setFont(newfont);
		sat.setFont(newfont);

		// add the month label to top JPanel
		top.add(monthLabel, BorderLayout.NORTH);
		top.setBackground(yellow1); // TEMPORARY COLOUR

		// add the labels to the JPanel for the calendar
		panel.add(sun);
		panel.add(mon);
		panel.add(tue);
		panel.add(wed);
		panel.add(thu);
		panel.add(fri);
		panel.add(sat);

		// variable declarations continued. 
		int i; // declared out of loops because it is used in more than one loop
		int daysinLastMonth = getMax(lastMonth); // the amount of days in the previous month
		int previousdays = daysinLastMonth - startofDay + 2; // determining how many days needed to be lightened


		for (i = 1; i < startofDay; i++) { // adding a JLabel for all days that are in the previous month (grey numbers before the current month)
			JLabel date = new JLabel(" " + previousdays);
			date.setBorder(border); // adding the labels in the border layout
			date.setHorizontalAlignment(JLabel.LEFT); // setting the numbers onto the left side of the box
			date.setForeground(Color.LIGHT_GRAY); // setting the colour of the numbers as light gray
			date.setFont(newfont); // setting font of labels
			panel.add(date); // adding the date to the panel
			previousdays++; // adding one to the previousdays so the next number printed is not the same
		}

		for (int j = 1 ; j <= daysinMonth; j++, i++) { // adding a JLabel for each day in the month 
			JLabel date = new JLabel(" " + j); 
			date.setBorder(border); // adding label in border layout
			date.setHorizontalAlignment(JLabel.LEFT); // setting numbers onto left side of the box
			date.setFont(newfont); // setting the font of the numbers
			panel.add(date); // adding the date to the panel
		}

		
		for (int j = 1 ; i <= 42; j++, i++) { // adding a JLabel for all days that are in the next month (grey numbers after the current month)
			JLabel date = new JLabel(" " + j);
			date.setBorder(border); // adding label in border layout
			date.setHorizontalAlignment(JLabel.LEFT); // setting numbers onto left side of the box
			date.setForeground(Color.LIGHT_GRAY); // setting colour of the numbers
			date.setFont(newfont); // setting font of the numbers
			panel.add(date); // adding date to the panel
		}

		// adding the top and panel JPanels to the BorderLayout
		add(top, BorderLayout.NORTH); 
		add(panel, BorderLayout.CENTER);

	}

	// getting the previous month
	private int getPreviousMonth(int month) {
		if (month == 0) { // if the month is december, return january
			return 11;
		}

		return month - 1; // return the month before the current month
	}

	// method to convert the month (as int) into its String version
	private String monthname(int thisMonth) {
		String name = "";
		switch(thisMonth) {
		case 0:
			name = "January";
			break;
		case 1:
			name = "February";
			break;
		case 2:
			name = "March";
			break;
		case 3:
			name = "April";
			break;
		case 4: 
			name = "May";
			break;
		case 5: 
			name = "June";
			break;
		case 6: 
			name = "July";
			break;
		case 7: 
			name = "August";
			break;
		case 8: 
			name = "September";
			break;
		case 9:
			name = "October";
			break;
		case 10: 
			name = "November";
			break;
		case 11:
			name = "December";
			break;
		}
		return name; // returning the name of month
	}

	// method to get the maximum number of days in the month
	private int getMax(int month) {
		int max = 0;
		switch (month) {
		case 0, 2, 4, 6, 7, 9, 11: 
			max = 31;
		break;
		case 1: 
			if (isLeap())
				max = 29;
			else
				max = 28;
			break;
		case 3, 5, 8, 10:
			max = 30;
		break;
		}
		
		return max; // returning the max days
	}

	// checking if the current year is a leap year or not
	private boolean isLeap() {
		return (thisYear % 4 == 0 && thisYear % 100 != 0) || 
				thisYear % 400 == 0;
	}

	// getting the last month 
	public CalendarView lastMonth() {
		return new CalendarView(new GregorianCalendar(
				thisYear, 
				thisMonth - 1, 1));
	}

	// getting the next month
	public CalendarView nextMonth() {
		return new CalendarView(new GregorianCalendar(
				thisYear, 
				thisMonth + 1, 
				1));
	}
}
