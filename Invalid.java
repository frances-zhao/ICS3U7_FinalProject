import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class Invalid extends JFrame implements ActionListener{
	
	// declaring major GUI components 
	JFrame frame = new JFrame("error");
	JPanel panel; 
	JButton ok; 
	JLabel error_title, error_msg, example;
	
	// declaring misc. variables 
	Font title, desc; 
	
	public Invalid() throws IOException{
		
		// declaring the fonts 
		try {
			title = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(25f);
			desc = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(15f);

		}
		catch (IOException | FontFormatException e) {
			
		}
		
		// setting the basic outline of the GUI tab
		final int HEIGHT = 300; 
		final int WIDTH = 400;
		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane(); 
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		error_title = new JLabel("Invalid Day Input"); 
		error_title.setBounds(140, 40, 160, 30);
		error_title.setFont(title);
		
		error_msg = new JLabel("You need to enter a valid day of the week ");
		error_msg.setBounds(60, 95, 350, 20);
		error_msg.setFont(desc);
		
		example = new JLabel("e.g. Monday, Tuesday, Wednesday ...");
		example.setBounds(54, 145, 300, 20);
		example.setFont(desc);
		
		ok = new JButton("OK");
		ok.setBounds(165, 170, 70, 40);
		ok.setFont(title);
		
		
		// add the componentseii
		frame.add(error_title);
		frame.add(error_msg);
		frame.add(example);
		frame.add(ok);
		
	} 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 
}
	
	


