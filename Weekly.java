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
	JButton addEvent;
	JLabel weekly, todo, notes; 
	ImageIcon add = new ImageIcon("images/add.png");
		
	//declaring fonts 
	static Font newfont, newfont1, newfont2, newfont3, newfont4, newfont5; //declaring all fonts 
	
	// declaring the colours 
	static Color bumble1 = new Color(255, 208, 37);   // button background colour 
	static Color bumble2 = new Color(245, 208, 76);   // outline 1 (lighter yellow)
	static Color bumble3 = new Color(252, 248, 219);  // outline 2 (yellowish gray)
	static Color bumble4 = new Color(202, 194, 150);  // text colour (dark stale brown)
	static Color bumble5 = new Color(69, 62, 39);     // panel background colour 
	

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
		frame.getContentPane().setBackground(bumble5);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		// declaring the characteristics of the components
		Image image = add.getImage(); // transforming the icon
		Image image_n = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		add = new ImageIcon(image_n);
		
		addEvent = new JButton(add);
		addEvent.setBounds(30, 65, 25, 25);
		addEvent.setBackground(bumble3);
		addEvent.setFont(newfont);
		addEvent.setBorder(BorderFactory.createLineBorder(bumble3));
		
		weekly = new JLabel("WEEKLY");
		weekly.setHorizontalAlignment(SwingConstants.CENTER);
		weekly.setBounds(-40, 15, 240, 36);
		weekly.setFont(newfont5);		
		
		
		// add the actionlisteners
		addEvent.addActionListener(this);
		
		// frame location on screen null
		
		// add the components
		frame.add(addEvent);
		frame.add(weekly);
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

