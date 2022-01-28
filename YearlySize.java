// import packages
import java.awt.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

/**
 * class that helps design what the yearly calendar looks like (every month)
 * @author Frances Zhao
 *
 */
public class YearlySize extends JPanel {

	// variable declarations
	private static final long serialVersionUID = 1L;
	// using simpledateformat, declare format of year month and date
	SimpleDateFormat yearformat = new SimpleDateFormat("yyyy");
	SimpleDateFormat monthformat = new SimpleDateFormat("MMMM");
	SimpleDateFormat dayformat = new SimpleDateFormat("d");
	// font declarations
	Font newfont, smallfont;
	// declaring a date object
	Date date = new Date();

	Color colour1 = ColourCSTM.getFirstColour();
	Color colour2 = ColourCSTM.getSecondColour();
	Color colour3 = ColourCSTM.getThirdColour();

	/**
	 * constructor, sets the preferred size of the month
	 */
	public YearlySize() {
		// setting size and colour background of tiny calendar
		setPreferredSize(new Dimension(280, 260));
		setBackground(colour1);
	}

	/**
	 * setter method that sets the date as the current date
	 * @param date the date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * method that draws out each of the mini calendars
	 */
	public void paint(Graphics g) { // customizing the mini calendars using paintComponent
		// try/catch importing the font
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
			smallfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(12f);

		} catch (IOException | FontFormatException e){
			
			System.out.println("YearlySize - cannot import font.");
		}

		super.paint(g);
		g.setFont(newfont); // setting font
		g.drawString(monthformat.format(date), 34, 40); // setting its display in the mini 'panel'
		g.setColor(Color.black); // setting colour of month
		g.setColor(Color.black); // setting color of numbers
		g.drawString(yearformat.format(date), 200, 40); // setting where year date is displayed
		g.setFont(smallfont); // setting font of numbers


		Calendar cal = Calendar.getInstance(); // declaring new calendar object
		cal.setTime(date); // setting date of calendar
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, - cal.get(Calendar.DAY_OF_WEEK) + 1);
		for (int w = 0; w < 5; w++) { // rows of weeks
			for (int days = 0; days < 7; days++) { // column of days
				g.drawString(dayformat.format(cal.getTime()), days * 30 + 35 + 4, w * 30 + 85);
				cal.add(Calendar.DATE, + 1); // adding number to calendar
			}
		}
	}

}