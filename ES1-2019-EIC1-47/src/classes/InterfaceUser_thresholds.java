package classes;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

public class InterfaceUser_thresholds {

	private JFrame frame;
	private JPanel zona1;
	private JPanel zona2;
	JLabel avisoUser;
			
	private JList<String> list;
	private String[] listRules;
	private Rule[] listRulz;
	private int nextPos;
	
	private int mode;
	private JComboBox<LogicParser> logicsym;
	
	private File file;
	
	public InterfaceUser_thresholds(File file) {
		avisoUser = new JLabel("");
		avisoUser.setFont(new Font("Courier", Font.ITALIC, 15));
		avisoUser.setForeground(Color.red);
		this.file = file;
		mode = 1;
		listRules = new String[15];
//		listRules[0]="iPlasma;;;;is_long_method";
//		listRules[1]="PMD;;;;is_long_method";
		listRulz = new Rule[15];
		showUI();
	}

	public InterfaceUser_thresholds() {
		avisoUser = new JLabel("");
		avisoUser.setFont(new Font("Courier", Font.ITALIC, 15));
		avisoUser.setForeground(Color.red);
		mode = 1;
		listRules = new String[15];
		listRulz = new Rule[15];
		showUI();
	}

	
/**
 * Open User interface for Threshold addition and for Rule comparison
 */
	public void showUI() {
		zona1 = new JPanel();
		zona1.setLayout(new BorderLayout());
		zona1.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));
		zona2 = new JPanel();
		zona2.setLayout(new GridLayout(6, 1));
		frame = new JFrame();
		frame.setLayout(new GridLayout(1, 2));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addFrameContent();
		frame.setSize(700, 400);
		frame.setLocation(500, 100);
	}

	
/**
 * Add panels to frame
 */
	public void addFrameContent() {
		frame.add(zona1, BorderLayout.WEST);
		frame.add(zona2, BorderLayout.EAST);
		try {
			panelZona1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		panelZona2();
	}
	
	
/**
 * Sets frame in visible state
 */
	public void open() {
		frame.setVisible(true);
	}

	

/**
 * Adds content to left panel ("Create Rule")
 * @throws Exception
 */

	/* CONTEUDO PAINEL ZONA1 */
	private void panelZona1() throws Exception {
		JLabel createRule = new JLabel("Create Rule:");
		JLabel name = new JLabel("Name:");
		JTextField nametext = new JTextField(10);
		String[] options = { "Long Method", "Feature Envy" };
		JComboBox<String> comboBox = new JComboBox<String>(options);
		JLabel metric1 = new JLabel("LOC >");
		JLabel metric2 = new JLabel(" CYCLO >");
		JTextField metric1text = new JTextField(1);
		JTextField metric2text = new JTextField(1);

		LogicParser[] lp = { new LogicParser(0), new LogicParser(1), new LogicParser(2), new LogicParser(3) };
		logicsym = new JComboBox<LogicParser>(lp);
		logicsym.setSelectedIndex(0);

		Button add = new Button("Add Rule");

		JPanel zona11 = new JPanel();
		zona11.setLayout(new GridLayout(3, 1));
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout());

		zona1.add(createRule, BorderLayout.NORTH);
		zona1.add(zona11, BorderLayout.CENTER);
		zona1.add(add, BorderLayout.SOUTH);
		zona11.add(p2);
		zona11.add(comboBox);
		zona11.add(p5);

		p2.add(name);
		p2.add(nametext);
		p5.add(metric1);
		p5.add(metric1text);
		p5.add(logicsym);
		p5.add(metric2);
		p5.add(metric2text);

		alComboBox(comboBox, metric1, metric2);
		alAddRule(add, nametext, metric1text, metric2text, new LogicParser(logicsym.getSelectedIndex()));
	}

	
	
/**
 * Action Listener of ComboBox (enables to choose between creating a is_long_method or feature_envy comparing rule)
 * @param cb
 * @param m1
 * @param m2
 */
	/* ACTION LISTENER DA COMBOBOX */
	private void alComboBox(JComboBox<String> cb, JLabel m1, JLabel m2) {

		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String s = (String) cb.getSelectedItem();
				switch (s) {
				case "Long Method":
					m1.setText("LOC >");
					m2.setText("CYCLO >");
					mode = 1;
					break;
				case "Feature Envy":
					m1.setText("ATFD >");
					m2.setText("LAA <");
					mode = 0;
					break;
				default:
					System.out.println("Sem opcao selecionada"); /* RESOLVER NICAS */
				}
			}
		});
	}

	
/**
 * Action Listener of Button "Add Rule" that adds rule created by user (if valid) to Rules List
 * @param b
 * @param name
 * @param m1
 * @param m2
 * @param lp
 */
	/* ACTION LISTENER DO BOTAO ADD RULE */
	private void alAddRule(Button b, JTextField name, JTextField m1, JTextField m2, LogicParser lp) {

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* ADICIONAR VERIFICACAO SIMBOLO LOGICO */
				if (!name.getText().equals("") && checkIfNumber(m1) && checkIfNumber(m2)) {
					try {
						listRulz[nextPos] = new Rule(name.getText(), Integer.parseInt(m1.getText()),
								Integer.parseInt(m2.getText()), new LogicParser(logicsym.getSelectedIndex()), mode);
						listRules[nextPos] = new Rule(name.getText(), Integer.parseInt(m1.getText()),
								Integer.parseInt(m2.getText()), new LogicParser(logicsym.getSelectedIndex()), mode)
										.toString();
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					nextPos++;
					list.updateUI();
					setTextAviso("");
				} else {
					setTextAviso("Nothing added: Select valid values");
				}
			}
		});
	}

	
/**
 * Verifies if JTextField input given by user is a number
 * @param x
 * @return
 */
	/* FUNCAO AUXILIAR: VERIFICAR SE O CONTEUDO TEXTFIELD É UM NUMERO */
	private boolean checkIfNumber(JTextField x) {
		String s = x.getText();
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {

		}
		return false;
	}
	

/**
 *  Adds content to right panel ("Compare")
 */

	/* CONTEUDO PAINEL ZONA2 */
	private void panelZona2(){
		JLabel compare = new JLabel("Compare (if Long Method):");
		JRadioButton r1 = new JRadioButton("None");
		JRadioButton r2 = new JRadioButton("iPlasma");
		JRadioButton r3 = new JRadioButton("PMD");
		JLabel with = new JLabel("With rule:");
		
		list = new JList<String>(listRules);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Button makeComparison = new Button("Compare");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		r1.setSelected(true);
		ActionListener changedRadioButton = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listRulz[list.getSelectedIndex()].setResult(null);
			}
		};
		r1.addActionListener(changedRadioButton);
		r2.addActionListener(changedRadioButton);
		r3.addActionListener(changedRadioButton);
		makeComparison.addActionListener(new ActionListener() {
			LeituraFicheiro leitorDeFicheiros = new LeituraFicheiro(null);
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(file!=null) {
					leitorDeFicheiros = new LeituraFicheiro(file);
				}
				if(file==null) {
					leitorDeFicheiros = new LeituraFicheiro();
					file = leitorDeFicheiros.openFile();
				}

				try {
					leitorDeFicheiros.setFile(file);
					leitorDeFicheiros.CorreFicheiro();	
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				ArrayList<Metodo> ar = leitorDeFicheiros.createList();
				
				if(listRulz[list.getSelectedIndex()].getResult()==null) {
					
					listRulz[list.getSelectedIndex()].setResult(new ResultRepresenter());
					
					if(r1.isSelected()) {
						
			            System.out.println("Selected Radio Button: " + bg.getSelection().getActionCommand());
						listRulz[list.getSelectedIndex()].getResult().grabResults(ar,listRulz[list.getSelectedIndex()],0);
						
					}
					
					if(r2.isSelected())
						listRulz[list.getSelectedIndex()].getResult().grabResults(ar,listRulz[list.getSelectedIndex()],1);
					
					if(r3.isSelected())
						listRulz[list.getSelectedIndex()].getResult().grabResults(ar,listRulz[list.getSelectedIndex()],2);
					
				}
				
				listRulz[list.getSelectedIndex()].getResult().showWindow();
			}
		} );
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,1));
		
//		zona2.add(avisoUser);
		zona2.add(compare);
		zona2.add(p1);
		zona2.add(with);
		zona2.add(list);
		zona2.add(makeComparison);
		
		p1.add(r1);
		p1.add(r2);
		p1.add(r3);
	}
	
	
	private void setTextAviso(String s){
		avisoUser.setText(s);
	}

	public static void main(String[] args) {
		InterfaceUser_thresholds ui = new InterfaceUser_thresholds();
		ui.open();
	}

}
