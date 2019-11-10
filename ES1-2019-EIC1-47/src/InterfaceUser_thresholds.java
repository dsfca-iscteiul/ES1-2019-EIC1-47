import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class InterfaceUser_thresholds {
	private JFrame frame;

	public InterfaceUser_thresholds() {
		frame = new JFrame();
		frame.setLayout(new GridLayout(1,2));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addFrameContent();
		frame.setSize(600, 300);
		frame.setLocation(500, 100);
	}
	
	public void open(){
		frame.setVisible(true);
	}
	
	public void addFrameContent(){
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
