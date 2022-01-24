import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.Graphics;

public class Weekly extends JFrame implements ActionListener{
	JFrame frame = new JFrame("Weekly Calendar");
	JPanel panel; 
	JButton addEvent;
	JLabel weekly, todo, notes; 
	
	
	static Font newfont, newfont1, newfont2, newfont3, newfont4; 
	static Color yellow1 = new Color(255, 208, 37); // tackle logo bg yellow color 
	static Color yellow2 = new Color(232, 180, 2); // buttons color (dark)
	static Color yellow3 = new Color(255, 255, 255); // white

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

		} 
		
		catch (IOException | FontFormatException e){

		}

		// setting the basic outline of the gui tab 
		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame.setSize(WIDTH,HEIGHT);
		frame.getContentPane().setBackground(new Color(243, 215, 3));
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		// declaring the characteristics of the components
		
		addEvent = new JButton("add picture for +event");
		addEvent.setBounds(90, 90, 200, 18);
		addEvent.setBackground(yellow3);
		addEvent.setFont(newfont);
		addEvent.setForeground(yellow2);
		addEvent.setBorder(BorderFactory.createLineBorder(yellow2));
		
		weekly = new JLabel("WEEKLY");
		weekly.setBounds(8, 14, 240, 36);
		
		// add the actionlisteners
		addEvent.addActionListener(this);
		
		// frame location on screen null
		
		// add the components

		frame.add(addEvent);
		
		// frame visibility toggle 
		frame.setVisible(true);
		
	}


	private void drawScheduler(Graphics g) {
		Graphics2D chart = (Graphics2D) g;
		final int WIDTH1 = 875; // when setting the locations for these rectangles make sure their x values are spaced by 4 pixels. 
		final int WIDTH2 = 350;
		final int HEIGHT = 300; 

		
		chart.drawRect(44, 25, WIDTH1, HEIGHT);
		chart.drawRect(44, 325, WIDTH1, HEIGHT);
		
		for (int i = 219; i < 594; i += 175) {
			chart.drawLine(i, 25, i, 325);
		}
		
		chart.drawLine(219, 325, 219, 725);
		
		
		

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
		
	}
}
