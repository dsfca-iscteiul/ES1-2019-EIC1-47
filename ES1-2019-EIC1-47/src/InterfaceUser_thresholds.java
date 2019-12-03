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
	private JPanel zona1;
	private JPanel zona2;
	private JComboBox logicsym;
	private String [] listRules;
	private int nextPos;
	private String selectedComboBox;
	

	
	public InterfaceUser_thresholds() {
		selectedComboBox = "";
		listRules = new String[15];
		listRules[0]="iPlasma;;;;is_long_method";
		listRules[1]="PMD;;;;is_long_method";
		nextPos = 2;
		zona1 = new JPanel();
		zona1.setLayout(new BorderLayout());
		zona1.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));
		zona2 = new JPanel();
		zona2.setLayout(new GridLayout(5,1));
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
		frame.add(zona1, BorderLayout.WEST);
		frame.add(zona2, BorderLayout.EAST);
		try {
			panelZona1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelZona2();
	}
	
	
	/*CONTEUDO PAINEL ZONA1*/
	private void panelZona1() throws Exception{
		JLabel createRule = new JLabel("Create Rule:");
		JLabel name = new JLabel("Name:");
		JTextField nametext = new JTextField(10);
		String [] options = {"LOC CYCLO", "ATFD LAA"};
		JComboBox<String> comboBox = new JComboBox<String>(options);		
		JLabel metric1 = new JLabel("LOC >");
		JLabel metric2 = new JLabel(" CYCLO >");
		JTextField metric1text = new JTextField(1);
		JTextField metric2text = new JTextField(1);
		
		LogicParser[] lp = {new LogicParser(0),new LogicParser(1),new LogicParser(2),new LogicParser(3)};
		logicsym = new JComboBox<LogicParser>(lp);
		logicsym.setSelectedIndex(0);
		
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
		alAddRule(add, nametext, metric1text, metric2text, new LogicParser(logicsym.getSelectedIndex()));
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
						selectedComboBox="is_long_method";
					break;
					case "ATFD LAA":
						m1.setText("ATFD >");
						m2.setText("LAA <");
						selectedComboBox="is_feature_envy";
					break;
				default:
					System.out.println("Sem opcao selecionada"); /*RESOLVER NICAS*/
				}
			}
		});
	}
	
	
	
	/*ACTION LISTENER DO BOTAO ADD RULE*/
	private void alAddRule(Button b, JTextField name, JTextField m1, JTextField m2, LogicParser lp){
	
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
/*ADICIONAR VERIFICACAO SIMBOLO LOGICO*/				
				if(!name.getText().equals("") && checkIfNumber(m1) && checkIfNumber(m2)){
					listRules[nextPos] = name+";"+m1+";"+logicsym+";"+m2+";"+selectedComboBox;
					nextPos++;
				}else{
					/*NICAS ADD EXCECAO*/
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
		JRadioButton r1 = new JRadioButton("is_long_method");
		JRadioButton r2 = new JRadioButton("is_feature_envy");
		JLabel with = new JLabel("With rule:");
		JList<String> list = new JList<String>(listRules);
		Button makeComparisson = new Button("Compare");
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,1));
		
		zona2.add(compare);
		zona2.add(p1);
		zona2.add(with);
		zona2.add(list);
		zona2.add(makeComparisson);
		
		p1.add(r1);
		p1.add(r2);
	}
	

	public static void main(String[] args) {
		InterfaceUser_thresholds ui=new InterfaceUser_thresholds();
		ui.open();

	}

}
