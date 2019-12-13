package classes;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Date: Dec 12, 2019
 * This class represents the results of the rule the user decides to run in a window.
 * @author Tom�s Ferreira
 */
public class ResultRepresenter {
	private JFrame frame;
	private JTable table;
	private static String[] column = {"MethodID", "Obeys Rule"};
	private String[][] data = new String[420][2];
	private JScrollPane sp;
	private boolean ran = false;
	private Rule rule;
	private String mode = "";
	
	
	/**
	 * This function compares the user-defined rule result boolean with the external boolean, and returns its defect indicators.
	 * @param Rule User-defined rule result.
	 * @param External External result.
	 * @return Defect indicator.
	 */
	private String DefectComparison(boolean rule, boolean external) {
		if(rule) {
			if(external)return "DCI";
			return "ADII";
		}
		if(external) return "DII";
		return "ADCI";
	}
	
	/**
	 * This function iterates the given array, runs the given rule, and stores the results in the data array, which will be added to the JTable.
	 * The mode parameter allows for the Long Method comparison with the iPlasma and PMD tool results. 
	 * @param ar ArrayList of Metodo, which will be iterated.
	 * @param rule Rule to be checked.
	 * @param mode Mode of comparison, in case of Long Method.
	 */
	public void grabResults(ArrayList<Metodo> ar, Rule rule, int mode) {
		if(!ran) {
			this.rule = rule;
			for (Metodo m: ar) {
				data[(int)m.getMethodID()-1][0] = Integer.toString((int)m.getMethodID());
				
				if(rule.getMode().equals("Feature Envy")) {
					data[(int)m.getMethodID()-1][1] = DefectComparison(rule.runRule((int)m.getAtfd(), (int)m.getLaa()), m.isIs_feature_envy());
					if(!this.mode.equals(" compared with Feature Envy"))this.mode = " compared with Feature Envy";
				}
				
				if(rule.getMode().equals("Long Method")) {
					if(mode==1) {
						data[(int)m.getMethodID()-1][1] = DefectComparison(rule.runRule((int)m.getLoc(), (int)m.getCyclo()), m.isIs_long_method());
						if(!this.mode.equals(" compared with Long Method"))this.mode = " compared with Long Method";
					}
					else if(mode==2) {
						data[(int)m.getMethodID()-1][1] = DefectComparison(m.isiPlasma(), m.isIs_long_method());
						if(!this.mode.equals(" compared with Long Method"))this.mode = " compared with Long Method"; //addToCounter
					}
					else if(mode==3) {
						data[(int)m.getMethodID()-1][1] = DefectComparison(m.isPMD(), m.isIs_long_method());
						if(!this.mode.equals(" compared with Long Method"))this.mode = " compared with Long Method";
					}
					
				}
				
			}
			ran = true;
		}
	}
	
	/**
	 * This function counts the number of occurrences of a given string within the results part of the data array.
	 * @param tbCounted String to be counted.
	 * @return The number of occurrences.
	 */
	private int countStrings(String tbCounted) {
		int j = 0;
		for (int i = 0; i < 420; i++) {
			if(data[i][1].equals(tbCounted)) j = j+1;
		}
		return j;
	}
	
	/**
	 * This function shows the UI to the user.
	 */
	public void showWindow() {
		frame = new JFrame(rule.getName()+mode);
		table=new JTable(data,column);    
		table.setBounds(30,40,200,300);       
		sp=new JScrollPane(table);
		sp.setSize(300,400);
		JLabel jta = new JLabel();
		jta.setText("<html><div style='text-align: center;'>" + "False: " + countStrings("false") + "  True: " + countStrings("true") + "</div></html>");
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
	
	/**
	 * This function returns the rule applied to this ResultRepresenter.
	 * @return
	 */
	public Rule getRule() {
		return rule;
	}
	
	
	/**
	 * This functions resets the variable ran
	 */
	public void resetRan() {
		this.ran = false;
	}
	
	/**
	 * This function sets a different rule to this Object.
	 * @param rule
	 */
	public void setRule(Rule rule) {
		this.rule = rule;
	}
}
