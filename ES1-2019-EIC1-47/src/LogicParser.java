public class LogicParser {
	/*
		Esta classe serve para interpretar do resultado do input
		do utilizador na interface gráfica, para que o RuleChecker consiga
		diferenciar qual regra correr.
	*/
	
	public static final int AND  = 0;
	public static final int OR   = 1;
	public static final int NAND = 2;
	public static final int NOR  = 3;
	private int currentStatus = -1;
	
	LogicParser(int i) throws Exception{
		if(i >= 0 && i <= 3)
			this.currentStatus = i;
		else throw new Exception();
	}
	
	LogicParser(String i) throws Exception{
		if(i.equalsIgnoreCase("AND"))       currentStatus = 0;
		else if(i.equalsIgnoreCase("OR"))   currentStatus = 1;
		else if(i.equalsIgnoreCase("NAND")) currentStatus = 2;
		else if(i.equalsIgnoreCase("NOR"))  currentStatus = 3;
		else throw new Exception();
	}
	
	public int getCurrentStatus() {
		return currentStatus;
	}
	
	@Override
	public String toString() {
		switch (currentStatus) {
			case AND:  return "AND";
			case OR:   return "OR";
			case NAND: return "NAND";
			case NOR:  return "NOR";
		}
		return "NOT SET";
	}
}
