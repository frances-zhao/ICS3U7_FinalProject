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
	ImageIcon logo = new ImageIcon("images/logo.png");
	
		
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
		return_main.setBorder(BorderFactory.createLineBorder(bumble5));
		
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
			try {
				new Mainscreen();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
	
	// method for adding the day sections of the weekly calendar 
	public class TablePanel extends JPanel{
		public TablePanel(int cx, int cy, int w, int h) {
			JPanel monPanel = new JPanel();
			monPanel.setBounds(cx, cy, w, h);
			monPanel.setBorder(BorderFactory.createLineBorder(bumble5) );
		}

	}
}





