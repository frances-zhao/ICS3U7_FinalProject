import java.awt.*;
import javax.swing.*;

public class Yearly extends JFrame {
	JFrame frame = new JFrame("Yearly Calendar");

	public static void main(String[] args) {
		try {
			new Yearly();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Yearly() {
		final int HEIGHT = 800;
		final int WIDTH = 1400;
		frame.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(243, 215, 3));
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
