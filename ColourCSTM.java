// import java packages
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;


public class ColourCSTM extends JFrame implements ActionListener{

	// variable declaration
	public static Color firstcolour;
	public static Color secondcolour;
	public static Color thirdcolour;

	public static int colourpicker = 0;

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JLabel colourtitle = new JLabel("Colour Customization?");
	private JLabel colourlabel, watergif, beegif, flowergif;
	private JButton pinkbtn, yellowbtn, bluebtn;

	// font declarations
	Font newfont, smallestfont, newfont1;	

	public ColourCSTM() {

		try {
			smallestfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(10f);
			newfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(20f);
			newfont1 = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/PPObjectSans-Regular.otf")).deriveFont(40f);
		} catch (IOException | FontFormatException e){

		}

		// initializing frame
		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame = new JFrame("Customize Colour?"); // title of application
		frame.setSize(WIDTH,HEIGHT);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);


		colourtitle.setFont(newfont1);
		colourtitle.setHorizontalAlignment(SwingConstants.CENTER);
		colourtitle.setBounds(295, 17, 819, 46);

		colourlabel = new JLabel("Which colour theme would you like to switch to?");
		colourlabel.setHorizontalAlignment(SwingConstants.CENTER);
		colourlabel.setFont(newfont);
		colourlabel.setBounds(6, 75, 1388, 46);

		bluebtn = new JButton("Ocean");
		bluebtn.setBackground(new Color(164, 210, 237));
		bluebtn.setBounds(152, 252, 209, 82);
		bluebtn.setFont(newfont);

		yellowbtn = new JButton("Bumble");
		yellowbtn.setBackground(new Color(255, 208, 37));
		yellowbtn.setBounds(606, 252, 209, 82);
		yellowbtn.setFont(newfont);

		pinkbtn = new JButton("Blossom");
		pinkbtn.setBackground(new Color(240, 156, 166));
		pinkbtn.setBounds(1035, 252, 209, 82);
		pinkbtn.setFont(newfont);

		Icon watericon = new ImageIcon("images/water.gif");
		watergif = new JLabel(watericon);
		watergif.setBounds(123, 346, 287, 263);

		Icon beeicon = new ImageIcon("images/bee.gif");
		beegif = new JLabel(beeicon);
		beegif.setBounds(562, 346, 287, 263);

		Icon flowericon = new ImageIcon("images/flower.gif");
		flowergif = new JLabel(flowericon);
		flowergif.setBounds(991, 346, 321, 263);

		frame.add(watergif);
		frame.add(beegif);
		frame.add(flowergif);


		// actual GUI
		frame.add(colourtitle);
		frame.add(colourlabel);
		frame.add(pinkbtn);
		frame.add(yellowbtn);
		frame.add(bluebtn);


		bluebtn.addActionListener(this);
		yellowbtn.addActionListener(this);
		pinkbtn.addActionListener(this);
		frame.setVisible(true);

		// getting current User String

	}



	/*
	 * implementing ActionListener, based on the event of user (which button clicked), different methods performed 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == pinkbtn){
			colourpicker = 1;
			JOptionPane.showMessageDialog(this, "Changing to blossom theme... ");
			setColours();
			try {
				new Mainscreen();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
		}

		if(e.getSource() == bluebtn) {
			colourpicker = 2;
			JOptionPane.showMessageDialog(this, "Changing to ocean theme... ");
			setColours();
			try {
				new Mainscreen();
				frame.dispose();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == yellowbtn) {
			colourpicker = 3;
			JOptionPane.showMessageDialog(this, "Changing to bumble theme... ");
			setColours();
			try {
				new Mainscreen();
				frame.dispose();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void setColours() {
		if(colourpicker == 1) {
			firstcolour = new Color(240, 156, 166);
			secondcolour = new Color(240, 156, 166);
			thirdcolour = new Color(138, 39, 58);

		}
		if (colourpicker == 2) {
			firstcolour = new Color(164, 210, 237);
			secondcolour = new Color(76, 150, 194);
			thirdcolour = new Color(35, 61, 77);
		}

		if(colourpicker == 3) {
			firstcolour = new Color(255, 208, 37);
			secondcolour = new Color(245, 208, 76);
			thirdcolour = new Color(69, 62, 39);
		}

	}

	public static Color getFirstColour() {
		return firstcolour;
	}
	public static Color getSecondColour() {
		return secondcolour;
	}
	public static Color getThirdColour() {
		return thirdcolour;
	}


}
