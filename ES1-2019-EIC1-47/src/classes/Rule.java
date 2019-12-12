package classes;

public class Rule {

	private String name;
	private int Limit1;
	private int Limit2;
	private int mode = -1;
	private LogicParser lp;
	public static final int featureEnvy = 0;
	public static final int longMethod = 1;
	private ResultRepresenter result;
	
	public Rule(String name, int Limit1, int Limit2, LogicParser lp, int mode) {
		this.name = name;
		this.Limit1 = Limit1;
		this.Limit2 = Limit2;
		this.mode = mode;
		this.lp = lp;
	}
	
	public Rule(String name, int Limit1, int Limit2, LogicParser lp, String mode) {
		this.name = name;
		this.Limit1 = Limit1;
		this.Limit2 = Limit2;
		this.lp = lp;
		if(mode.equals("is_long_method")) this.mode=1;
		else if(mode.equals("is_feature_envy")) this.mode=0;
	}
	
	
	
	public boolean runRule(int param1, int param2) {
		try {
			if(mode==0) return new RuleChecker().featureEnvyCheck(param1, param2,Limit1,Limit2,lp);
			else if(mode==1) return new RuleChecker().longMethodCheck(param1, param2,Limit1,Limit2,lp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(mode==0) return name + ": Feature Envy: ATFD > " + Limit1 + " " + lp.toString() + " LAA < " + Limit2;
		else if(mode==1) return name + ": Long Method: LOC > " + Limit1 + " " + lp.toString() + " CYCLO > " + Limit2;
		return "Não Definido";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLimit1() {
		return Limit1;
	}

	public void setLimit1(int limit1) {
		Limit1 = limit1;
	}

	public int getLimit2() {
		return Limit2;
	}

	public void setLimit2(int limit2) {
		Limit2 = limit2;
	}

	public String getMode() {
		if(mode==0) return "Feature Envy";
		return "Long Method";
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public LogicParser getLp() {
		return lp;
	}

	public void setLp(LogicParser lp) {
		this.lp = lp;
	}

	public ResultRepresenter getResult() {
		return result;
	}

	public void setResult(ResultRepresenter result) {
		this.result = result;
	}

	
	
	
	
	
}
