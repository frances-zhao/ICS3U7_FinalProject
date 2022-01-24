
	//import the packages
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class ColourPallette extends JFrame implements ActionListener{
	
	// declare the colours 
	
	// ---- ocean colours ---------------------------- what they're mainly used for --
	static Color ocean1 = new Color(164, 210, 237);   // button background colour 
	static Color ocean2 = new Color(76, 150, 194);    // outline 1 (lighter blue)
	static Color ocean3 = new Color(35, 61, 77);      // outline 2 (darker blue) 
	static Color ocean4 = new Color(61, 64, 66);      // text colour (dark indigo)
	static Color ocean5 = new Color(164, 210, 237);   // panel background colour 
	
	// ---- bumble colours ------------------------- what they're mainly used for -- 
	static Color bumble1 = new Color(255, 208, 37);   // button background colour 
	static Color bumble2 = new Color(245, 208, 76);   // outline 1 (lighter yellow)
	static Color bumble3 = new Color(252, 248, 219);  // outline 2 (yellowish gray)
	static Color bumble4 = new Color(202, 194, 150);  // text colour (dark stale brown)
	static Color bumble5 = new Color(69, 62, 39);     // panel background colour 
	
	// ---- blossom colours ------------------------ what they're mainly used for --
	static Color blossom1 = new Color(255, 232, 245); // button background colour
	static Color blossom2 = new Color(240, 156, 166); // outline 1 (lighter pink)
	static Color blossom3 = new Color(138, 39, 58);   // outline 2 (darker pink)
	static Color blossom4 = new Color(48, 2, 6);	    // text colour (auburn)
	static Color blossom5 = new Color(252, 194, 220); // panel background colour 
	
	// constructor for ColourPallette class
	public ColourPallette(String colorInfo) {
		getColorInfo(colorInfo);
		
	}
	
	
	private void getColorInfo(String colorInfo) {	//TODO: make the return statements work :'D
	
		// color values theme: ocean 
		if (colorInfo.equals("ocean1")) {
			return ocean1;
		}
		
		if (colorInfo.equals("ocean2")) {
			return ocean2;
		}
		
		if (colorInfo.equals("ocean3")) {
			return ocean3;
		}
		
		if (colorInfo.equals("ocean4")) {
			return ocean4;
		}
		
		if (colorInfo.equals("ocean5")) {
			return ocean5;
		}
		
		
		// colour values theme: bumble 
		if (colorInfo.equals("bumble1")) {
			return bumble1;
		}
		
		if (colorInfo.equals("bumble2")) {
			return bumble2;
		}
		
		if (colorInfo.equals("bumble3")) {
			return bumble3;
		}
		
		if (colorInfo.equals("bumble4")) {
			return bumble4;
		}
		
		if (colorInfo.equals("bumble5")) {
			return bumble5;
		}
		
		
		// colour values theme: blossom
		if (colorInfo.equals("blossom1")) {
			return blossom1;
		}
		
		if (colorInfo.equals("blossom2")) {
			return blossom2;
		}
		
		if (colorInfo.equals("blossom3")) {
			return blossom3;
		}
		
		if (colorInfo.equals("blossom4")) {
			return blossom4;
		}
		
		if (colorInfo.equals("blossom5")) {
			return blossom5;
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
