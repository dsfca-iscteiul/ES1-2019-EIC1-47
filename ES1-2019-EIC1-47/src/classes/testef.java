package classes;
import java.io.IOException;

import javax.swing.JFrame;

public class testef {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			JFrame j = new JFrame("Ficheiro");
			LeituraFicheiro t = new LeituraFicheiro();
			RegrasDetencao rd = new RegrasDetencao();
			
			t.CorreFicheiro();
			rd.Verificacao();
			rd.ADCI();
			rd.ADII();
			rd.DCI();
			rd.DII();
			j.setSize(775, 655);
			j.setVisible(true);
			j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			j.add(t);
			j.setResizable(false);
		}

}
