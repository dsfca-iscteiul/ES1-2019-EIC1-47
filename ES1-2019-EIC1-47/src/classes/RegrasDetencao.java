package classes;
import java.util.ArrayList;

/**
 * Date: Dec 12, 2019
 * @author engin
 *
 */
public class RegrasDetencao {
	/**
	 * lista dos metodos
	 */
	private ArrayList<Metodo>lista;
	/**
	 * RuleChecker
	 */
	private RuleChecker rc = new RuleChecker();
	
	/**
	 * Preset do feature envy e do long method
	 */
	public void Verificacao() {
		//lista com a serializacao dos dados do excel
		lista = LeituraFicheiro.getDados();
		//percorre os metodos
		for(Metodo m: lista) {
			rc.featureEnvyCheck((int)m.getAtfd(), (float)m.getLaa());
			rc.longMethodCheck((int)m.getLoc(), (float)m.getCyclo());
			System.out.println("FeatureEnvyCheck = " + rc.featureEnvyCheck((int)m.getAtfd(), (float)m.getLaa()) + " LongMethodCheck = " + rc.longMethodCheck((int)m.getLoc(), (float)m.getCyclo()));
		}
	}
	
	/**
	 * metodo verificao do feature envy e long method, com dados postos pelo utilizador
	 * @param ATFDLimit
	 * @param LAALimit
	 * @param LOCLimit
	 * @param CYCLOLimit
	 * @throws Exception
	 */
	public void Verificacao(int ATFDLimit, int LAALimit, int LOCLimit, int CYCLOLimit) throws Exception {
		//lista com a serializacao dos dados do excel
		lista = LeituraFicheiro.getDados();
		//percorre os metodos
		for(Metodo m: lista) {
			rc.featureEnvyCheck((int)m.getAtfd(), (float)m.getLaa(), ATFDLimit, LAALimit);
			rc.longMethodCheck((int)m.getLoc(), (int)m.getCyclo(), LOCLimit, CYCLOLimit);		
		}
	}
	
	/**
	 * metodo verificao do feature envy e long method, com dados postos pelo utilizador mais logic parser
	 * @param ATFDLimit
	 * @param LAALimit
	 * @param LOCLimit
	 * @param CYCLOLimit
	 * @param lp
	 * @throws Exception
	 */
	public void Verificacao(int ATFDLimit, int LAALimit, int LOCLimit, int CYCLOLimit, LogicParser lp) throws Exception {
		//lista com a serializacao dos dados do excel
		lista = LeituraFicheiro.getDados();
		//percorre os metodos
		for(Metodo m: lista) {
			rc.featureEnvyCheck((int)m.getAtfd(), (float)m.getLaa(), ATFDLimit, CYCLOLimit,lp);
			rc.longMethodCheck((int)m.getLoc(), (int)m.getCyclo(),LOCLimit,CYCLOLimit,lp);		
										//perguntar este int
		} 
	}
	
	/**
	 * metodo para ver o DCI na comparacao iPlasma e PMD com Is_long_method
	 * 
	 */
	public void DCI() {
		lista = LeituraFicheiro.getDados();
		for(Metodo m: lista) {
			if((m.isPMD() || m.isiPlasma()) && m.isIs_long_method())
				System.out.println("DCI = " + m);

		}
	}
	
	/**
	 * metodo para ver o DII na comparacao iPlasma e PMD com Is_long_method
	 */
	public void DII() {
		//lista com a serializacao dos dados do excel
		lista = LeituraFicheiro.getDados();
		//percorre os metodos
		for(Metodo m: lista) {
			if((m.isPMD() || m.isiPlasma()) && !m.isIs_long_method()) 
				System.out.println("DII =  " + m);
		}
	}
	
	/**
	 * metodo para ver o ADCI na comparacao iPlasma e PMD com Is_long_method
	 */
	public void ADCI() {
		//lista com a serializacao dos dados do excel
		lista = LeituraFicheiro.getDados();
		//percorre os metodos
		for(Metodo m: lista) {
			if((!m.isPMD() || !m.isiPlasma()) && m.isIs_long_method()) 
				System.out.println("ADCI = " + m);
		}
	}
	
	/**
	 * metodo para ver o ADII na comparacao iPlasma e PMD com Is_long_method
	 */
	public void ADII() {
		//lista com a serializacao dos dados do excel
		lista = LeituraFicheiro.getDados();
		//percorre os metodos
		for(Metodo m: lista) {
			if((!m.isPMD() || !m.isiPlasma()) && !m.isIs_long_method()) 
				System.out.println("ADII = " + m);
		}
	}
	
}







