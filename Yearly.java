import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Yearly extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame("Yearly Calendar");
	private JButton backbtn;
	Font newnewfont;


	public Yearly() {
		
		try {
			newnewfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
		} catch (IOException | FontFormatException e){
			
		}
		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(243, 215, 3));
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		backbtn = new JButton("Back");
		backbtn.setFont(newnewfont);
		backbtn.setBounds(1213, 117, 135, 77);
		backbtn.addActionListener(this);
		
		frame.add(backbtn);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == backbtn) {
			try {
				new Mainscreen();
				frame.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
