import java.util.ArrayList;

public class RegrasDetencao {
private ArrayList<Metodo>Lista = new ArrayList<Metodo>();
	
	public boolean Regra1() {
		for(Metodo m: Lista) {
			m.setMethodID(m.getMethodID());
			if(m.equals(m)) {
				return true;
			}
		}
		return false;	
	}
	public boolean Regra2() {
		for(Metodo m: Lista) {
			m.setIs_long_method(m.isIs_long_method());
		}
		return true;
	}

}
