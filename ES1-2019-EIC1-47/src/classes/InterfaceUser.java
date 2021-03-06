package classes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * Date: Nov 9, 2019
 * This is a simple menu for the user to select the different actions of this application :) 
 * @author Catarina Teodoro
 * 
 */

public class InterfaceUser {
	
	/**
	 * JFrame for the main menu.
	 */
	private JFrame frame;
	/**
	 * JLabel "Menu".
	 */
	private JLabel menu;
	/**
	 * JLabel to show error message to User
	 */
	private JLabel avisoUser;
	/**
	 * JButton to select the file we want to analyze.
	 */
	private JButton openFile;
	/**
	 * JButton to open the file we selected.
	 */
	private JButton showFile;
	/**
	 * JButton to edit thresholds;
	 */
	private JButton editThresholds;
	/**
	 * JPanel for center of JFrame.
	 */
	private JPanel center;
	/**
	 * JPanel for openFile button.
	 */
	private JPanel b1;
	/**
	 * JPanel for showFile button.
	 */
	private JPanel b2;
	/**
	 * JPanel for editThresholds button.
	 */
	private JPanel b3;
	/**
	 * File we want to analyze.
	 */
	private File file;
	
	public static void main(String[] args) {
		
		InterfaceUser menu = new InterfaceUser();
		menu.open();
		
	}

	/**
	 * Constructor for InterfaceUser.
	 */
	public InterfaceUser() {
		
		frame = new JFrame("Menu");
		frame.setLayout(new BorderLayout());
		
		center = new JPanel();
		b1 = new JPanel();
		b2 = new JPanel();
		b3 = new JPanel();
		center.setLayout(new GridLayout(5,1,0,0));
		b1.setLayout(new FlowLayout());
		b2.setLayout(new FlowLayout());
		b3.setLayout(new FlowLayout());
		
		menu = new JLabel("MENU", SwingConstants.CENTER);
		avisoUser = new JLabel("", SwingConstants.CENTER);
		openFile = new JButton("Select file to analize");
		showFile = new JButton("Show file");
		editThresholds = new JButton("Edit thresholds");
		
		openFile.setPreferredSize(new Dimension(240,60));
		showFile.setPreferredSize(new Dimension(240,60));
		editThresholds.setPreferredSize(new Dimension(240,60));
		
		menu.setPreferredSize(new Dimension(100,100));
		menu.setFont(new Font("Courier", Font.BOLD, 40));
		avisoUser.setFont(new Font("Courier", Font.ITALIC, 15));
		avisoUser.setForeground(Color.red);
		
		
		b1.add(openFile);
		b2.add(showFile);
		b3.add(editThresholds);
		center.add(b1);
		center.add(b2);
		center.add(b3);
		center.add(avisoUser);
		
		frame.add(menu, BorderLayout.NORTH);
		frame.add(center, BorderLayout.CENTER);
		
		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				file=new LeituraFicheiro().openFile();
				setTextAviso("");
			}
		});
		
		showFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(file!=null){
					try {
						JFrame j = new JFrame("Ficheiro");
						LeituraFicheiro t = new LeituraFicheiro(file);
						t.CorreFicheiro();
						t.ShowTable();
						j.setSize(775, 655);
						j.setVisible(true);
						j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						j.add(t);
						j.setResizable(false);
						setTextAviso("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					setTextAviso("Select a valid file first");
				}
			}
		});
		

		editThresholds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(file!=null) {
					InterfaceUser_thresholds ui;
					try {
						ui = new InterfaceUser_thresholds(file);
						ui.open();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					setTextAviso("");
				}else{
					setTextAviso("Select a valid file first");
				}
			}
		});
		

	}
	
	/**
	 * Method to change content of JLabel "avisoUser"
	 */
	public void setTextAviso(String s){
		avisoUser.setText(s);
	}
	
	/**
	 * Method that shows warning to User
	 * @return
	 */
	public String getAviso(){
		return avisoUser.getText();
	}
	
	/**
	 * Method to open InterfaceUser.
	 */
	public void open(){
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(400, 450);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

}
