import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class InterfaceUser {
	
	private JFrame frame;
	private JLabel menu;
	private JButton openFile;
	private JButton showFile;
	private JButton editThresholds;
	private JButton testPlatform;
	private JPanel center;
	private JPanel b1;
	private JPanel b2;
	private JPanel b3;
	private JPanel b4;
	
	public static void main(String[] args) {
		
		InterfaceUser menu = new InterfaceUser();
		menu.open();
		
	}

	public InterfaceUser() {
		
		frame = new JFrame("Menu");
		frame.setLayout(new BorderLayout());
		
		center = new JPanel();
		b1 = new JPanel();
		b2 = new JPanel();
		b3 = new JPanel();
		b4 = new JPanel();
		center.setLayout(new GridLayout(4,1,0,0));
		b1.setLayout(new FlowLayout());
		b2.setLayout(new FlowLayout());
		b3.setLayout(new FlowLayout());
		b4.setLayout(new FlowLayout());
		
		menu = new JLabel("MENU", SwingConstants.CENTER);
		openFile = new JButton("Select file to analize");
		showFile = new JButton("Show file");
		editThresholds = new JButton("Edit thresholds");
		testPlatform = new JButton("Show results");
		
		openFile.setPreferredSize(new Dimension(200,50));
		showFile.setPreferredSize(new Dimension(200,50));
		editThresholds.setPreferredSize(new Dimension(200,50));
		testPlatform.setPreferredSize(new Dimension(200,50));
		
		menu.setPreferredSize(new Dimension(100,100));
		menu.setFont(new Font("Courier", Font.BOLD, 40));
		
		b1.add(openFile);
		b2.add(showFile);
		b3.add(editThresholds);
		b4.add(testPlatform);
		center.add(b1);
		center.add(b2);
		center.add(b3);
		center.add(b4);
		
		frame.add(menu, BorderLayout.NORTH);
		frame.add(center, BorderLayout.CENTER);
		
		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adicionar método de acção do botão
			}
		});
		
		showFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adicionar método de acção do botão
			}
		});
		
		editThresholds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adicionar método de acção do botão
			}
		});
		
		testPlatform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//adicionar método de acção do botão
			}
		});
	}
	
	private void open(){
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

}
