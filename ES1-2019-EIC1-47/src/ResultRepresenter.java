import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ResultRepresenter {
	private JFrame frame;
	private JTable table;
	private static String[] column = {"MethodID", "Obeys Rule"};
	private String[][] data = new String[420][2];
	private JScrollPane sp;
	private int count = 0;
	private boolean ran = false;
	private Rule rule;
	public void grabResults(ArrayList<Metodo> mList) {
		if(!ran) {
			int count = 0;
			for(Metodo m: mList) {
				data[count][0] = Integer.toString((int)m.getMethodID());
				data[count][1] = Boolean.toString(m.getRuleResult());
				count++;
			}
			ran = true;
		}
	}
	
	public void grabResults(ArrayList<Metodo> ar, Rule rule) {
		if(!ran) {
			this.rule = rule;
			ArrayList<Metodo> arc = (ArrayList<Metodo>) ar.clone();
			for (Metodo m: arc) {
				data[(int)m.getMethodID()-1][0] = Integer.toString((int)m.getMethodID());
				if(rule.getMode().equals("Feature Envy")) data[(int)m.getMethodID()-1][1] = Boolean.toString(rule.runRule((int)m.getAtfd(), (int)m.getLaa()));
				if(rule.getMode().equals("Long Method")) data[(int)m.getMethodID()-1][1] = Boolean.toString(rule.runRule((int)m.getLoc(), (int)m.getCyclo()));
			}	
			ran = true;
		}
	}
	
	public void showWindow() {
		frame = new JFrame(rule.getName());
		table=new JTable(data,column);    
		table.setBounds(30,40,200,300);       
		sp=new JScrollPane(table);
		frame.add(sp);          
		frame.setSize(300,400);    
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
	}
}
