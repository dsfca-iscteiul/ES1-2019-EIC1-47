package classes;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;


public class ResultRepresenter {
	private JFrame frame;
	private JTable table;
	private static String[] column = {"MethodID", "Obeys Rule"};
	private String[][] data = new String[420][2];
	private JScrollPane sp;
	private boolean ran = false;
	private Rule rule;
	private String mode = "";
	private int[] counter = {0,0,0,0};
	
	
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
			resetCounters();
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
						if(!this.mode.equals(""))this.mode = "";
					}
					else if(mode==1) {
						data[(int)m.getMethodID()-1][1] = DefectComparison(rule.runRule((int)m.getLoc(), (int)m.getCyclo()), m.isiPlasma());
						if(!this.mode.equals(" compared with iPlasma"))this.mode = " compared with iPlasma"; //addToCounter
					}
					else if(mode==2) {
						data[(int)m.getMethodID()-1][1] = DefectComparison(rule.runRule((int)m.getLoc(), (int)m.getCyclo()), m.isPMD());
						if(!this.mode.equals(" compared with PMD"))this.mode = " compared with PMD";
					}
					
				}
				
				addToCounter(data[(int)m.getMethodID()-1][1]);
			}
			ran = true;
		}
	}
	
	private void resetCounters() {
		counter[0] = 0;
		counter[1] = 0;
		counter[2] = 0;
		counter[3] = 0;
	}
	private void addToCounter(String toBeAdded) {
		if(mode.equals("")) {
			if(toBeAdded.equals("false"))counter[0]++;
			else if(toBeAdded.equals("true"))counter[1]++;
		}
		else {
			if(toBeAdded.equals("DCI"))counter[0]++;
			else if(toBeAdded.equals("DII"))counter[1]++;
			else if(toBeAdded.equals("ADCI"))counter[2]++;
			else if(toBeAdded.equals("ADII"))counter[3]++;
		}
	}
	
	private int countStrings(String tbCounted) {
		int j = 0;
		for (int i = 0; i < 420; i++) {
			if(data[i][1].equals(tbCounted)) j = j+1;
		}
		return j;
	}
	public void showWindow() {
		frame = new JFrame(rule.getName()+mode);
		table=new JTable(data,column);    
		table.setBounds(30,40,200,300);       


		sp=new JScrollPane(table);
		sp.setSize(300,400);
		
		JLabel jta = new JLabel();
		if(mode.equals(""))jta.setText("<html><div style='text-align: center;'>" + "False: " + countStrings("false") + "  True: " + countStrings("true") + "</div></html>");
		if(!mode.equals(""))jta.setText("<html><div style='text-align: center;'>" + "DCI: " + countStrings("DCI") + " DII: " + countStrings("DII") + " ADCI: " + countStrings("ADCI") + " ADII: " + countStrings("ADII") + "</div></html>");
		jta.setVisible(true);

		BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		frame.setLayout(boxLayout);
		frame.add(sp);
		frame.add(jta);
		frame.pack();
		frame.setSize(300,500);    
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		resetCounters();
		this.rule = rule;
	}
}
