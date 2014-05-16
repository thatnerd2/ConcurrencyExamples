package standalone;

import javax.swing.JButton;
import javax.swing.JFrame;


public class SwingGuiMulti {
	private static SwingGuiMulti factory = new SwingGuiMulti();
	private static JFrame frame;
	
	public static void main (String[] args) {
		setupFrame();
		setupButtons();
		renderButtons();
	}
	
	private static void setupFrame () {
		frame = new JFrame("Swing GUI Example");
		frame.setSize(400, 400);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public static void setupButtons () {
		JButton actionButton = new JButton ("Click to count to 5000");
		JButton responseButton = new JButton ("Click to get an alert");
		JButton[] buttonGroup = {actionButton, responseButton};
		for (int i = 0; i < buttonGroup.length; i++) {
			buttonGroup[i].setSize(200, 100);
			buttonGroup[i].setLocation(100 * i*50, 200);
			frame.add(buttonGroup[i]);
		}
		
		
	}
	
	
}
