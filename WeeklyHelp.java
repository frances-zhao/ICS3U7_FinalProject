import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class WeeklyHelp extends JFrame implements ActionListener {
	
	// declaring the major components
	JFrame frame = new JFrame("Help || Weekly");
	JPanel panel = new JPanel();
	JButton return_main, next_monthly;
	JLabel title; 
	JTextField desc;
	
	//declaring fonts 
	static Font newfont, newfont1, newfont2, newfont3, newfont4, newfont5; //declaring all fonts 
		
	// declaring the colours 
	static Color bumble1 = new Color(255, 208, 37);   // button background colour 
	static Color bumble2 = new Color(245, 208, 76);   // panel background colour 
	static Color bumble3 = new Color(252, 248, 219);  // outline 2 (yellowish gray)
	static Color bumble4 = new Color(202, 194, 150);  // button outline colour 
	static Color bumble5 = new Color(69, 62, 39);     // outline 2 (dark stale brown)
	
	public WeeklyHelp() throws IOException{
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
			
			// setting the basic outline of the GUI tab 
			final int HEIGHT = 500;
			final int WIDTH = 800;
			frame.setSize(WIDTH,HEIGHT);
			frame.getContentPane().setBackground(bumble2);
			frame.setLayout(null);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			
			// declaring the characteristics of the components
			title = new JLabel("Help: Weekly");
			title.setBounds(290, 25, 220, 32);
			title.setFont(newfont1);
			title.setForeground(bumble5);
						
			
			// add the actionlisteners
			
			
			// add the components 
			frame.add(title);
			
			// frame visibility toggle 
			frame.setVisible(true);
			
			
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

		
	
}
