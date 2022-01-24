import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;



public class AddEvent_ extends JFrame implements ActionListener{
	
	public static void main(String[] args) {
		try {
			new AddEvent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// declare the GUI variables 
	JPanel panel;
	JFrame frame; 
	JCheckBox importance; 
	JLabel importance_;
	JTextField event_name; 
	JLabel event_name_;
	JTextField event_info;
	JLabel event_info_;
	JButton add_event; 
	JButton discard_event; 
	static Font newfont; 
	
	static Color yellow1 = new Color(255, 208, 37); // tackle logo bg yellow color 
	static Color yellow2 = new Color(232, 180, 2); // buttons color (dark)
	static Color yellow3 = new Color(255, 255, 255); // white
	
	AddEvent_() throws IOException{
		
		// declare font that'll be used in this class
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(15f);

		} catch (IOException | FontFormatException e){

		}
		
		// setting the basic outline of the gui tab 
		final int HEIGHT = 500; 
		final int WIDTH = 850; 
		frame = new JFrame("Tackle");
		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane().setBackground(yellow1);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		// declaring the characteristics of the components
		event_name_ = new JLabel("EVENT NAME: ");
		event_name_.setHorizontalAlignment(SwingConstants.CENTER);
		event_name_.setBounds(35, 35, 130, 16);
		event_name_.setFont(newfont);
		
		// add the actionlisteners 
		
		// frame on screen location null
		frame.setLayout(null);
		
		// add the components
		frame.add(event_name_);
		
		// frame visibility toggle 
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
