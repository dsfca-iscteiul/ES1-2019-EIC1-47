package classes;
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
	private boolean ran = false;
	private Rule rule;
	private String mode = "";
	public String DefectComparison(boolean rule, boolean external) {
		if(rule && external) return "DCI";
		if(rule && !external) return "ADII";
		if(!rule && external) return "DII";
		if(!rule && !external) return "ADCI";
		return null;
	}
	
	

	public void grabResults(ArrayList<Metodo> mList, int mode) {
		if(!ran) {
			int count = 0;
			for(Metodo m: mList) {
				data[count][0] = Integer.toString((int)m.getMethodID());
				if(mode==0) {
					data[count][1] = Boolean.toString(m.getRuleResult());
				}
				else if(mode==1) {
					data[count][1] = DefectComparison(m.getRuleResult(), m.isiPlasma());
				}
				else if(mode==2) {
					data[count][1] = DefectComparison(m.getRuleResult(), m.isPMD());
				}
				count++;
			}
			ran = true;
		}
	}
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
	public void grabResults(ArrayList<Metodo> ar, Rule rule, int mode) {
		if(!ran) {
			this.rule = rule;
			for (Metodo m: ar) {
				data[(int)m.getMethodID()-1][0] = Integer.toString((int)m.getMethodID());
				if(rule.getMode().equals("Feature Envy")) {
					data[(int)m.getMethodID()-1][1] = Boolean.toString(rule.runRule((int)m.getAtfd(), (int)m.getLaa()));
					this.mode = "";
				}
				if(rule.getMode().equals("Long Method")) {
					if(mode==0) {
						data[(int)m.getMethodID()-1][1] = Boolean.toString(rule.runRule((int)m.getLoc(), (int)m.getCyclo()));
						this.mode = "";
					}
					else if(mode==1) {
						data[(int)m.getMethodID()-1][1] = DefectComparison(rule.runRule((int)m.getLoc(), (int)m.getCyclo()), m.isiPlasma());
						this.mode = " compared with iPlasma";
					}
					else if(mode==2) {
						data[(int)m.getMethodID()-1][1] = DefectComparison(rule.runRule((int)m.getLoc(), (int)m.getCyclo()), m.isPMD());
						this.mode = " compared with PMD";
					}
					
				}
			}
			ran = true;
		}
	}
	
	public void showWindow() {
		frame = new JFrame(rule.getName()+mode);
		table=new JTable(data,column);    
		table.setBounds(30,40,200,300);       
		sp=new JScrollPane(table);
		frame.add(sp);          
		frame.setSize(300,400);    
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}
}
