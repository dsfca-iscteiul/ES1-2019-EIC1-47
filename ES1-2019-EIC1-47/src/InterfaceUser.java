import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InterfaceUser {
	
	private JFrame frame;
	private JLabel menu;
	private Button openFile;
	private Button showFile;
	private Button editThresholds;
	private Button testPlatform;
	private JPanel center;

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
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//teste Git
		//teste git2
		//teste git3
		//teste git4

	}

}
