import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

import java.awt.*;
import java.awt.event.*;
import java.io.*;



public class AddEvent_ extends JFrame implements ActionListener{
	
	// -------------- declare the GUI variables --------------------------------
	JPanel panel;
	JFrame frame; 
	
	JCheckBox importance; 
	JLabel class_title, importance_, event_name_, event_desc_;
	JTextField event_name, h, m, colon; 
	JTextArea event_desc;
	JButton add_event, discard_event, prev1, next1;
	
	
	//  -------------- declare the misc. variables --------------------------------
	Boolean important = false; 
	int hour = 0; 
	int minute = 0; 
	
	
	// Action a;
	
	// -------------- declaring the fonts --------------------------------------
	static Font newfont, newfont1, newfont2, newfont3, newfont4, newfont5, newfont6, newfont7; 
	
	// -------------- declaring the colours -------------------------------------
		static Color bumble1 = new Color(255, 208, 37);   // button background colour 
		static Color bumble2 = new Color(245, 208, 76);   // panel background colour 
		static Color bumble3 = new Color(252, 248, 219);  // outline 2 (yellowish gray)
		static Color bumble4 = new Color(202, 194, 150);  // button outline colour 
		static Color bumble5 = new Color(69, 62, 39);     // outline 2 (dark stale brown)
		static Color bumble6 = new Color(255, 248, 171);  // textfield fill colour 
	
	AddEvent_() throws IOException{
		
		// -------------- adding the attributes of the fonts --------------------
		try {
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(15f);
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(18f);
			newfont2 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
			newfont3 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(25f);
			newfont4 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(30f);
			newfont5 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(35f);
			newfont6 =  Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(40f);
			newfont7 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(60f);
			

		} catch (IOException | FontFormatException e){

		}
		
		// -------------- setting the basic outline of the GUI tab --------------
		final int HEIGHT = 420; 
		final int WIDTH = 690; 
		frame = new JFrame("Tackle");
		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane().setBackground(bumble2);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		// -------------- declaring the characteristics of the components -------
		class_title = new JLabel("Add Event");
		class_title.setHorizontalAlignment(SwingConstants.CENTER);
		class_title.setBounds(28, 20, 160, 30);
		class_title.setFont(newfont3);
		class_title.setForeground(bumble5);
		
		event_name_ = new JLabel("EVENT NAME ");
		event_name_.setHorizontalAlignment(SwingConstants.CENTER);
		event_name_.setBounds(35, 65, 160, 30);
		event_name_.setFont(newfont2);
		event_name_.setForeground(bumble5);
		event_name_.setBorder(BorderFactory.createLineBorder(bumble3));
		
		event_name = new JTextField();
		event_name.setBounds(194, 65, 200, 30);
		event_name.setFont(newfont);
		event_name.setBackground(bumble6);
		event_name.setBorder(BorderFactory.createLineBorder(bumble3));
		
		event_desc_ = new JLabel("Event Info");
		event_desc_.setHorizontalAlignment(SwingConstants.CENTER);
		event_desc_.setBounds(35, 130, 160, 30);
		event_desc_.setFont(newfont2);
		event_desc_.setForeground(bumble5);
		event_desc_.setBorder(BorderFactory.createLineBorder(bumble3));
		
		event_desc = new JTextArea();
		event_desc.setBounds(35, 159, 350, 180);
		event_desc.setFont(newfont);
		event_desc.setBackground(bumble6);
		event_desc.setLineWrap(true);
		event_desc.setBorder(BorderFactory.createLineBorder(bumble3));
				
		importance = new JCheckBox("important");
		importance.setBounds(420, 71, 160, 20);
		importance.setFont(newfont2);
		importance.setForeground(bumble5);
		importance.setBackground(bumble2);
	
		add_event = new JButton("ADD");
		add_event.setBounds(425, 210, 150, 40);
		add_event.setHorizontalAlignment(SwingConstants.CENTER);
		add_event.setFont(newfont3);
		add_event.setForeground(bumble5);
		add_event.setBackground(bumble6);
		add_event.setBorder(BorderFactory.createLineBorder(bumble3));
		
		discard_event = new JButton("Discard");
		discard_event.setBounds(425, 270, 150, 40);
		discard_event.setHorizontalAlignment(SwingConstants.CENTER);
		discard_event.setFont(newfont3);
		discard_event.setForeground(bumble5);
		discard_event.setBackground(bumble6);
		discard_event.setBorder(BorderFactory.createLineBorder(bumble3));

		// making time picker 
		next1 = new JButton("+");
		next1.setBounds(420, 100, 20, 16);
		next1.setFont(newfont);
		next1.setForeground(bumble5);
		next1.setBackground(bumble6);
		next1.setBorder(BorderFactory.createLineBorder(bumble5));
		
		prev1 = new JButton("-");
		prev1.setBounds(420, 115, 20, 16);
		prev1.setFont(newfont);
		prev1.setForeground(bumble5);
		prev1.setBackground(bumble6);
		prev1.setBorder(BorderFactory.createLineBorder(bumble5));
		
		h = new JTextField(hour);
		h.setBounds(440, 100, 60, 32);
		h.setFont(newfont2);
		h.setForeground(bumble5);
		h.setBackground(bumble6);
		
		m = new JTextField(minute);
		m.setBounds(510, 100, 60, 32);
		m.setFont(newfont2);
		m.setForeground(bumble5);
		m.setBackground(bumble6);
	
		colon = new JTextField(":");
		colon.setBounds(499, 100, 12, 32);
		colon.setFont(newfont2);
		colon.setForeground(bumble5);
		colon.setBackground(bumble6);
		colon.setHorizontalAlignment(SwingConstants.CENTER);
		colon.setBorder(BorderFactory.createLineBorder(bumble6));
		colon.setEditable(false);
		
		
		// getting rid of the sound that jtextarea and field makes when backspace is out of range 
		// a = event_desc.getActionMap().get(DefaultEditorKit.beepAction);
		// a.setEnabled(false);	
		
		// ------------- add the actionlisteners --------------------------------
		importance.addActionListener(this);
		
		// ------------- frame on screen location null --------------------------
		frame.setLayout(null);
		
		// ------------- add the components -------------------------------------
		frame.add(class_title);
		frame.add(event_name_);
		frame.add(event_name);
		frame.add(event_desc_);
		frame.add(event_desc);
		frame.add(importance);
		frame.add(add_event);
		frame.add(discard_event);
		frame.add(next1);
		frame.add(prev1);
		frame.add(h);
		frame.add(m);
		frame.add(colon);
		
		// ------------- frame visibility toggle --------------------------------
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == importance) {
			important = true;
		}
		
	}
	
	public void prev(int min, int n, ActionEvent e) {
		n = 0; 
		
	}

}


