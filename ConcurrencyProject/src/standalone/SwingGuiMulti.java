package standalone;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class SwingGuiMulti {
	private static SwingGuiMulti factory = new SwingGuiMulti();
	private static JFrame frame;
	
	public static void main (String[] args) {
		setupFrame();
		setupButtons();
	}
	
	private static void setupFrame () {
		frame = new JFrame("Swing GUI Example");
		frame.setSize(400, 600);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public static void setupButtons () {
		JButton longButton = new JButton ("Multithreaded loop");
		JButton shortButton = new JButton ("Singly threaded loop");
		JButton responseButton = new JButton ("Click to get an alert");
		JButton newLineButton = new JButton ("Click to print a line");
		JButton[] buttonGroup = {longButton, shortButton, responseButton, newLineButton};
		for (int i = 0; i < buttonGroup.length; i++) {
			buttonGroup[i].setSize(200, 100);
			buttonGroup[i].setLocation(100, i * 100);
			frame.add(buttonGroup[i]);
		}
		longButton.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				Thread t = factory.new LoopingThread(1, 140, "LONG LOOP");
				t.start();
			}
		});
		shortButton.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				//Thread t = factory.new LoopingThread(1, 120, "SHORT LOOP");
				//t.start();
				System.out.println("SHORT LOOP");
				for (int i = 1; i <= 120; i++) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException exception) {
						// TODO Auto-generated catch block
						exception.printStackTrace();
					}
				}
				System.out.println("SHORT LOOP DONE");
			}
		});
		responseButton.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				System.out.println("RESPONSE");
			}
		});
		newLineButton.addActionListener (new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				System.out.println("----------------------------");
			}
		});
		
	}
	
	
	class LoopingThread extends Thread {
		int start;
		int end;
		String msg;
		
		public LoopingThread (int s, int e, String m) {
			start = s;
			end = e;
			msg = m;
		}
		
		public void run () {
			System.out.println(msg);
			
			for (int i = start; i <= end; i++) {
				try {
					sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println(msg+" DONE");
			this.interrupt();
		}
	}
	
}
