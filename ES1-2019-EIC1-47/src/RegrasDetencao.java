import java.util.ArrayList;


public class RegrasDetencao {
	private ArrayList<Metodo>lista;
	private RuleChecker rc = new RuleChecker();

	// Preset do feature envy e do long method
	public void Verificacao() {
		//lista com a serializacao dos dados do excel
		lista = LeituraFicheiro.getDados();
		//percorre os metodos
		for(Metodo m: lista) {
			rc.featureEnvyCheck((int)m.getAtfd(), (float)m.getLaa());
			rc.longMethodCheck((int)m.getLoc(), (float)m.getCyclo());		
		}
	}
	// verificao do feature envy e long method, com dados postos pelo utilizador
	public void Verificacao(int ATFDLimit, int LAALimit, int LOCLimit, int CYCLOLimit) throws Exception {
		//lista com a serializacao dos dados do excel
		lista = LeituraFicheiro.getDados();
		//percorre os metodos
		for(Metodo m: lista) {
			rc.featureEnvyCheck((int)m.getAtfd(), (float)m.getLaa(), ATFDLimit, LAALimit);
			rc.longMethodCheck((int)m.getLoc(), (int)m.getCyclo(), LOCLimit, CYCLOLimit);		
		}
	}
	// verificao do feature envy e long method, com dados postos pelo utilizador mais logic parser
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
}
