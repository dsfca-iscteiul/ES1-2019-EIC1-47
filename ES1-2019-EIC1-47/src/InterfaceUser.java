import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class InterfaceUser {
	
	private JFrame frame;
	private JLabel menu;
	private Button openFile;
	private Button showFile;
	private Button editThresholds;
	private Button testPlatform;
	private JPanel center;
	
	public static void main(String[] args) {
		
		InterfaceUser menu = new InterfaceUser();
		menu.open();
		
	}

	public InterfaceUser() {
		
		frame = new JFrame("Menu");
		frame.setLayout(new BorderLayout());
		
		center = new JPanel();
		center.setLayout(new GridLayout(4,1,3,3));
		
		menu = new JLabel("MENU", SwingConstants.CENTER);
		openFile = new Button("Select file to analize");
		showFile = new Button("Show file");
		editThresholds = new Button("Edit thresholds");
		testPlatform = new Button("Show results");
		
		center.add(openFile);
		center.add(showFile);
		center.add(editThresholds);
		center.add(testPlatform);
		
		frame.add(menu, BorderLayout.NORTH);
		frame.add(center, BorderLayout.CENTER);
	}
	
	private void open(){
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

}
