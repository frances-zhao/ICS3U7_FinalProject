import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Monthly extends JFrame implements ActionListener {

	static JFrame frame = new JFrame("Monthly Calendar");
	private static final long serialVersionUID = 1L;
	Calendar calendar1 = new GregorianCalendar();
	Calendar calendar2 = new GregorianCalendar(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), 1);

	CalendarView currentcalendar = new CalendarView(calendar2);
	private JButton last = new JButton("<<");
	private JButton next = new JButton(">>");

	static Font newfont, newfontsmall, newfont1,newfont2, madefont, newfont3 ;
	private JButton home;

	static Color yellow1 = new Color(255, 208, 37); // tackle logo bg yellow color 
	static Color yellow2 = new Color(232, 180, 2); // buttons color (dark)
	static Color yellow3 = new Color(255, 255, 255); // white

	Monthly() {

		try {
			newfontsmall = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(10f);
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(30f);
			newfont2 =  Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(40f);
			newfont3 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(60f);
			madefont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/wake.otf")).deriveFont(20f);

		} catch (IOException | FontFormatException e){

		}

		Icon icon = new ImageIcon("images/image.png");
		home = new JButton(icon);
		
		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(yellow1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		last.setFont(newfont);
		home.setFont(newfont);
		next.setFont(newfont);
		JPanel panel = new JPanel();

		panel.setBackground(yellow1);
		panel.add(last);
		panel.add(home);
		panel.add(next);

		frame.add(currentcalendar, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.NORTH);
		
		frame.setVisible(true);

		home.addActionListener(this);
		next.addActionListener(this);	
		last.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource()== next) {
			frame.remove(currentcalendar);
			currentcalendar = currentcalendar.nextMonth();
			frame.getContentPane().add(currentcalendar, BorderLayout.CENTER);
			frame.repaint();
			frame.revalidate();
		}

		if (e.getSource() == last) {
			frame.remove(currentcalendar);
			currentcalendar = currentcalendar.lastMonth();
			frame.getContentPane().add(currentcalendar);
			frame.repaint();
			frame.revalidate();

		}
		
		if (e.getSource() == home) {
			try {
				new Mainscreen();
				frame.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		try {
			new Monthly();

		} catch(Exception e){
			e.printStackTrace();
		}
	}
}

