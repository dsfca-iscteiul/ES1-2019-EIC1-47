import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

public class InterfaceUser_thresholds extends Thread{
	
	private JFrame frame;
	private JPanel zona1;
	private JPanel zona2;
	private JTextField logicsym; //variavel do simbolo logico
	private DefaultListModel <String> listRules;
	private DefaultListModel <String> listRulesAux;
	private String selectedComboBox;
	private String selectedButtonR;
	private int pos;
	private static final String lm = "is_long_method";
	private static final String fe = "is_feature_envy";
	
	

	
	/**DESCRICAO CLASSE:
	 * 
	 * GUI DIVIDIDA EM 2 PARTES: LADO ESQUERDO-"CRIAR REGRA"(ZONA1), LADO DIREITO-"TESTAR REGRA"(ZONA2)
	 * 
	 * FUNCOES:
	 * 
	 * panelZona1() - implementa configuracoes visuais da zona 1
	 * 				  chama: action Listener ComboBox -alComboBox(..)
	 * 					     action Listener Botao Adicionar Regra -alAddRule(..) TOMÁS ADICIONAR VERIFICACOES PARA O "SIMBOLO LOGICO" INTROD. PELO USER
	 * 
	 * panelZona2() - implementa configuracoes visuais da zona 2
	 * 
	 * listRules -> lista com todo o conteudo que aparece na JList da zona 2
	 */
	
	
	
	
	public InterfaceUser_thresholds() {
		
		selectedComboBox = lm;
		selectedButtonR = lm;
		listRules = new DefaultListModel<>();
		listRules.addElement("iPlasma"+" ; "+ lm);
		listRules.addElement("PMD" + " ; " + lm);
		listRulesAux = new DefaultListModel<>();
		pos=2;
		
		
		zona1 = new JPanel();
		zona1.setLayout(new BorderLayout());
		zona1.setBorder(BorderFactory.createEmptyBorder(60, 20, 80, 30));
		zona2 = new JPanel();
		zona2.setLayout(new BorderLayout());
		zona2.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));
		frame = new JFrame();
		frame.setLayout(new GridLayout(1,2));
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addFrameContent();
		frame.setSize(700, 400);
		frame.setLocation(500, 100);
		
	}
	
	
	public void open(){
		frame.setVisible(true);
	}
	
	
	public void addFrameContent(){
		frame.add(zona1, BorderLayout.WEST);
		frame.add(zona2, BorderLayout.EAST);
		panelZona1();
		panelZona2();
	}
	
	
	/*CONTEUDO PAINEL ZONA1*/
	private void panelZona1(){
		JLabel createRule = new JLabel("Create Rule:");
		JLabel name = new JLabel("Name:");
		JTextField nametext = new JTextField(10);
		String [] options = {"LOC CYCLO", "ATFD LAA"};
		JComboBox<String> comboBox = new JComboBox<String>(options);		
		JLabel metric1 = new JLabel("LOC >");
		JLabel metric2 = new JLabel(" CYCLO >");
		JTextField metric1text = new JTextField(1);
		JTextField metric2text = new JTextField(1);
		logicsym = new JTextField(2);
		Button add = new Button("Add Rule");
		
		JPanel zona11 = new JPanel();
		zona11.setLayout(new GridLayout(3,1));
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
		alAddRule(add, nametext, metric1text, metric2text, logicsym);
	}
	
	
	
	/*ACTION LISTENER DA COMBOBOX*/
	private void alComboBox(JComboBox<String> cb, JLabel m1, JLabel m2){
		
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = (String) cb.getSelectedItem();
				switch(s) {
					case "LOC CYCLO":
						m1.setText("LOC >");
						m2.setText("CYCLO >");
						selectedComboBox = lm;
					break;
					case "ATFD LAA":
						m1.setText("ATFD >");
						m2.setText("LAA <");
						selectedComboBox = fe;
					break;
				default:
					System.out.println("Sem opcao selecionada"); /*RESOLVER NICAS*/
				}
			}
		});
	}
	
	
	
	
	/*ACTION LISTENER DO BOTAO ADD RULE*/
	private void alAddRule(Button b, JTextField name, JTextField m1, JTextField m2, JTextField logicsym){
	
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!name.getText().equals("") && checkIfNumber(m1) && checkIfNumber(m2)){
					listRules.addElement(name.getText() + " ; " + m1.getText() + ";" + logicsym.getText() + ";" + m2.getText() + " ; "+selectedComboBox);
					pos++;
					updateButtonR();
				}else{
					/*NICAS:
					 *  ADD EXCECAO-aparecer e desaparecer msg de texto
					 *  tornar estatico os valor is_feature_envy e is_l....-feito
					 *	criar funcao so para adicionar elementos à lista
					 * 	melhorar verificacao de numeros
					 */
				}
			}
		});
	}
	
	
	
	/*FUNCAO AUXILIAR: VERIFICAR SE O CONTEUDO TEXTFIELD É UM NUMERO*/
	private boolean checkIfNumber(JTextField x){
		String s = x.getText();
		try {
			Double.parseDouble(s);
			return true;
		}catch (NumberFormatException e){

		}
		return false;
	}
	
	
	/*CONTEUDO PAINEL ZONA2*/
	private void panelZona2(){
		
		JLabel compare = new JLabel("Compare:");
		JLabel with = new JLabel("With rule:");
		JList<String> list = new JList<String>(listRulesAux);
		JRadioButton r1 = new JRadioButton(lm);
		JRadioButton r2 = new JRadioButton(fe);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		r1.setSelected(true);
		updateButtonR();
		Button makeComparisson = new Button("Compare");
		Button close = new Button ("Close");
		
		JPanel p9 = new JPanel();
		p9.setLayout(new GridLayout(3,1));
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,1));
		JPanel p8 = new JPanel();
		p8.setLayout(new GridLayout(1,2));
		
		zona2.add(compare, BorderLayout.NORTH);
		p9.add(p1);
		p9.add(with);
		p9.add(list);
		zona2.add(p9, BorderLayout.CENTER);
		zona2.add(p8, BorderLayout.SOUTH);
		p8.add(close);
		p8.add(makeComparisson);
		
		p1.add(r1);
		p1.add(r2);
		
		alButtons(r1, r2, list);
		alClose(close);
	}
	
	
	/*ACTION LISTENER DOS RADIOBUTTONS R1 E R2 - SEMPRE QUE É CLICADO APENAS MOSTRA NA JLIST AS REGRAS DO BOTAO CORRESPONDENTE*/
	private void alButtons(JRadioButton r1, JRadioButton r2, JList<String> l){
		r1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				selectedButtonR = lm;
				updateButtonR();
				
			}
		});
		r2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				selectedButtonR = fe;
				updateButtonR();
				
			}
		});
	}
	
	private void updateButtonR(){
		listRulesAux.removeAllElements();
		for(int a=0; a<pos; a++){
			if(listRules.elementAt(a).contains(selectedButtonR)){
				listRulesAux.addElement(listRules.elementAt(a));
			}
		}
	}
	
	/*ACTION LISTENER BOTAO CLOSE*/
	private void alClose(Button close){
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		InterfaceUser_thresholds ui=new InterfaceUser_thresholds();
		ui.open();

	}

}
