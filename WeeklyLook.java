import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class WeeklyLook extends JPanel {
	String filename1 = "eventName.txt";
	String filename2 = "eventInfo.txt";
	BufferedReader input_t = new BufferedReader(new FileReader(filename1));
	BufferedReader input_d = new BufferedReader(new FileReader(filename2));
	
	public static String[][] aen = new String[8][50]; // add event name
	public static String[][] aed = new String[7][50]; // add event desc. 
	
	JPanel panel = new JPanel();
	static String [] monname, mondesc, tuename, tuedesc, wedname, weddesc, thuname, thudesc, friname, fridesc, satname, satdesc, sunname, sundesc;
	static Font newfont, newfont1, newfont2, newfont3, newfont4, newfont5; //declaring all fonts 
	static int monlen, tuelen, wedlen, thulen, frilen, satlen, sunlen;
	static int mon = 0, tue = 0, wed = 0, thu = 0, fri = 0, sat = 0, sun = 0;
	
	static JPanel wdp11, wdp2, wdp3, wdp4, wdp5; // weekdays panels
	static JPanel wep1, wep2; // weekends panels 
	
	Color colour1 = ColourCSTM.getFirstColour();
	Color colour2 = ColourCSTM.getSecondColour();
	Color colour3 = ColourCSTM.getThirdColour();

	
	
	WeeklyLook() throws IOException {
		
		setLayout(null);
		panel.setBounds(90, 115, 175, 300);
		JPanel wdp1 = new JPanel();
		wdp1.setLayout(new BoxLayout(wdp1, BoxLayout.Y_AXIS));
		wdp1.add(Box.createRigidArea(new Dimension(10, 30)));
		wdp1.setBounds(90, 115, 175, 300);
		wdp1.setBackground(colour2);
		wdp1.setBorder(BorderFactory.createLineBorder(colour3, 2, true));

		wdp2 = new JPanel();
		wdp2.setLayout(new BoxLayout(wdp2, BoxLayout.Y_AXIS));
		wdp2.add(Box.createRigidArea(new Dimension(10,30)));
		wdp2.setBounds(264, 115, 175, 300);
		wdp2.setBackground(colour2);
		wdp2.setBorder(BorderFactory.createLineBorder(colour3, 2, true));

		wdp3 = new JPanel();
		wdp3.setBounds(439, 115, 175, 300);
		wdp3.setBackground(colour2);
		wdp3.setBorder(BorderFactory.createLineBorder(colour3, 2, true));

		wdp4 = new JPanel();
		wdp4.setBounds(614, 115, 175, 300);
		wdp4.setBackground(colour2);
		wdp4.setBorder(BorderFactory.createLineBorder(colour3, 2, true));

		wdp5 = new JPanel();
		wdp5.setBounds(789, 115, 175, 300);
		wdp5.setBackground(colour2);
		wdp5.setBorder(BorderFactory.createLineBorder(colour3, 2, true));

		wep1 = new JPanel();
		wep1.setBounds(90, 414, 175, 300);
		wep1.setBackground(colour2);
		wep1.setBorder(BorderFactory.createLineBorder(colour3, 2, true));


		wep2 = new JPanel();
		wep2.setBounds(264, 414, 175, 300);
		wep2.setBackground(colour2);
		wep2.setBorder(BorderFactory.createLineBorder(colour3, 2, true));
		reading();
		input_t.close();
		input_d.close();
		
		for(int i = 1; i < monlen; i++) {
			int x = 125;
			System.out.println(aen[0][i]);
			JLabel check = new JLabel(aen[0][i]);
			check.setForeground(Color.black);
			check.setBounds(100, x, 175, 300);
			check.setFont(newfont);
			wdp1.add(check);
			x += 20;
		}
		
		for(int i = 1; i < tuelen; i++) {
			int x = 125;
			System.out.println(aen[1][i]);
			JLabel check = new JLabel(aen[2][i]);
			check.setForeground(Color.black);
			check.setBounds(100, x, 175, 300);
			check.setFont(newfont);
			wdp2.add(check);
			x += 20;
		}
		for(int i = 1; i < wedlen; i++) {
			int x = 125;
			System.out.println(aen[2][i]);
			JLabel check = new JLabel(aen[2][i]);
			check.setForeground(Color.black);
			check.setBounds(100, x, 175, 300);
			check.setFont(newfont);
			wdp3.add(check);
			x += 20;
		}
		for(int i = 1; i < thulen; i++) {
			int x = 125;
			System.out.println(aen[3][i]);
			JLabel check = new JLabel(aen[3][i]);
			check.setForeground(Color.black);
			check.setBounds(100, x, 175, 300);
			check.setFont(newfont);
			wdp4.add(check);
			x += 20;
		}
		for(int i = 1; i < frilen; i++) {
			int x = 125;
			System.out.println(aen[4][i]);
			JLabel check = new JLabel(aen[4][i]);
			check.setForeground(Color.black);
			check.setBounds(100, x, 175, 300);
			check.setFont(newfont);
			wdp5.add(check);
			x += 20;
		}
		for(int i = 1; i < satlen; i++) {
			int x = 125;
			System.out.println(aen[5][i]);
			JLabel check = new JLabel(aen[5][i]);
			check.setForeground(Color.black);
			check.setBounds(100, x, 175, 300);
			check.setFont(newfont);
			wep1.add(check);
			x += 20;
		}
		for(int i = 1; i < sunlen; i++) {
			int x = 125;
			System.out.println(aen[6][i]);
			JLabel check = new JLabel(aen[6][i]);
			check.setForeground(Color.black);
			check.setBounds(100, x, 175, 300);
			check.setFont(newfont);
			wep2.add(check);
			x += 20;
		}
		
		panel.add(wdp1);
		add(panel);
		add(wdp2);
		add(wdp3);

		add(wdp4);

	
	}

	public void reading() throws IOException {
		monname = input_t.readLine().split(", ");
		tuename = input_t.readLine().split(", ");
		wedname = input_t.readLine().split(", ");
		thuname = input_t.readLine().split(", ");
		friname = input_t.readLine().split(", ");
		satname = input_t.readLine().split(", ");
		sunname = input_t.readLine().split(", ");

		mondesc = input_d.readLine().split(", ");
		tuedesc = input_d.readLine().split(", ");
		weddesc = input_d.readLine().split(", ");
		thudesc = input_d.readLine().split(", ");
		fridesc = input_d.readLine().split(", ");
		satdesc = input_d.readLine().split(", ");
		sundesc = input_d.readLine().split(", ");

		monlen = monname.length;
		tuelen = tuename.length;
		wedlen = wedname.length;
		thulen = thuname.length;
		frilen = friname.length;
		satlen = satname.length;
		sunlen = sunname.length;

		for(int i = 0; i < monlen; i++) {
			aen[0][i] = monname[i];
			aed[0][i] = mondesc[i];
		}
		for(int i = 0; i < tuelen; i++) {
			aen[1][i] = tuename[i];
			aed[1][i] = tuedesc[i];
		}
		for(int i = 0; i < wedlen; i++) {
			aen[2][i] = wedname[i];
			aed[2][i] = weddesc[i];
		}
		for(int i = 0; i < thulen; i++) {
			aen[3][i] = thuname[i];
			aed[3][i] = thudesc[i];
		}
		for(int i = 0; i < frilen; i++) {
			aen[4][i] = friname[i];
			aed[4][i] = fridesc[i];
		}
		for(int i = 0; i < satlen; i++) {
			aen[5][i] = satname[i];
			aed[5][i] = satdesc[i];
		}
		for(int i = 0; i < sunlen; i++) {
			aen[6][i] = sunname[i];
			aed[6][i] = sundesc[i];
		}
		
	}
public static void main(String[]args) throws IOException {
	new WeeklyLook();
}
	
}
