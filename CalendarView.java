import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.border.*;

class CalendarView extends JPanel {

	private static final long serialVersionUID = 1L;
	public Calendar calendar;
	private int thisYear;
	private int thisMonth;
	private int daysinMonth;
	private int startofDay;
	String monthstring;
	private int lastMonth;
	private JLabel monthLabel;
	
	static Color yellow1 = new Color(255, 208, 37); // tackle logo bg yellow color 
	static Color yellow2 = new Color(232, 180, 2); // buttons color (dark)
	static Color yellow3 = new Color(255, 255, 255); // white

	private JLabel sun;
	private JLabel mon;
	private JLabel tue;
	private JLabel wed;
	private JLabel thu;
	private JLabel fri;
	private JLabel sat;

	static Font newfont, newfontsmall, newfont1,newfont2, madefont, newfont3 ;

	public CalendarView(Calendar calendar) {
		
		try {
			newfontsmall = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(10f);
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(30f);
			newfont2 =  Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(40f);
			newfont3 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(60f);
			madefont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/wake.otf")).deriveFont(20f);

		} catch (IOException | FontFormatException e){

		}
		this.calendar = calendar;

		setLayout(new BorderLayout());

		thisYear = calendar.get(Calendar.YEAR);
		thisMonth = calendar.get(Calendar.MONTH);
		daysinMonth = getMaximum(thisMonth);
		monthstring = monthname(thisMonth);
		startofDay = calendar.get(Calendar.DAY_OF_WEEK);
		lastMonth = getPreviousMonth(thisMonth);

		monthLabel = new JLabel(monthstring +" "+ thisYear);
		monthLabel.setHorizontalAlignment(JLabel.CENTER);
		monthLabel.setFont(newfont);

		JPanel panel = new JPanel(new GridLayout(0, 7, 0, 0));
		Border border = new LineBorder(Color.black, 1);
		JPanel top = new JPanel();

		sun = new JLabel("Sunday");
		mon = new JLabel("Monday");
		tue = new JLabel("Tuesday");
		wed = new JLabel("Wednesday");
		thu = new JLabel("Thursday");
		fri = new JLabel("Friday");
		sat = new JLabel("Saturday");

		sun.setHorizontalAlignment(JLabel.CENTER);
		mon.setHorizontalAlignment(JLabel.CENTER);
		tue.setHorizontalAlignment(JLabel.CENTER);
		wed.setHorizontalAlignment(JLabel.CENTER);
		thu.setHorizontalAlignment(JLabel.CENTER);
		fri.setHorizontalAlignment(JLabel.CENTER);
		sat.setHorizontalAlignment(JLabel.CENTER);

		mon.setBorder(border);
		sun.setBorder(border);
		tue.setBorder(border);
		wed.setBorder(border);
		thu.setBorder(border);
		fri.setBorder(border);
		sat.setBorder(border);

		sun.setFont(newfont);
		mon.setFont(newfont);
		tue.setFont(newfont);
		wed.setFont(newfont);
		thu.setFont(newfont);
		fri.setFont(newfont);
		sat.setFont(newfont);
		
		top.add(monthLabel, BorderLayout.NORTH);
		top.setBackground(yellow1);

		panel.add(sun);
		panel.add(mon);
		panel.add(tue);
		panel.add(wed);
		panel.add(thu);
		panel.add(fri);
		panel.add(sat);

		int i;

		int daysinLastMonth = getMaximum(lastMonth);
		int previousdays = daysinLastMonth - startofDay + 2;

		
		
		for (i = 1; i < startofDay; i++) {
			JLabel date = new JLabel(" " + previousdays);
			date.setBorder(border);
			date.setHorizontalAlignment(JLabel.LEFT);
			date.setForeground(Color.LIGHT_GRAY);
			date.setFont(newfont);
			panel.add(date);
			previousdays++;
		}

		for (int j = 1 ; j <= daysinMonth; j++, i++) {
			JLabel date = new JLabel(" " + j);
			date.setBorder(border);
			date.setHorizontalAlignment(JLabel.LEFT);
			date.setFont(newfont);
			panel.add(date);
		}

		for (int j = 1 ; i <= 42; j++, i++) {
			JLabel date = new JLabel(" " + j);
			date.setBorder(border);
			date.setHorizontalAlignment(JLabel.LEFT);
			date.setForeground(Color.LIGHT_GRAY);
			date.setFont(newfont);
			panel.add(date);
		}

		add(top, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);

	}

	private int getPreviousMonth(int month) {
		if (month == 0) {
			return 11;
		}

		return month - 1;
	}

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
		return name;
	}

	private int getMaximum(int month) {
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
		return max;
	}

	private boolean isLeap() {
		return (thisYear % 4 == 0 && thisYear % 100 != 0) || 
				thisYear % 400 == 0;
	}

	public CalendarView lastMonth() {
		return new CalendarView(new GregorianCalendar(
				thisYear, 
				thisMonth - 1, 
				1));
	}

	public CalendarView nextMonth() {
		return new CalendarView(new GregorianCalendar(
				thisYear, 
				thisMonth + 1, 
				1));
	}
}
