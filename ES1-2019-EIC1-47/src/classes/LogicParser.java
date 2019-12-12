package classes;
/**
 * Date: Dec 12, 2019
 * This class manages the logic comparison the user selects in the UI, and compares the two booleans.
 * @author Tomás Ferreira
 */
public class LogicParser {
	public static final int AND  = 0;
	public static final int OR   = 1;
	public static final int NAND = 2;
	public static final int NOR  = 3;
	private int currentStatus = -1;
	
	/**
	 * LogicParser constructor, which defines the comparison mode (with number values).
	 * @param i Comparison mode, in Integer.
	 * @throws Exception Throws an exception if the mode isn't recognized as valid.
	 */
	LogicParser(int i) throws Exception{
		if(i >= 0 && i <= 3)
			this.currentStatus = i;
		else throw new Exception("Invalid comparison mode");
	}
	/**
	 * LogicParser constructor, which defines the comparison mode (with string comparisons).
	 * @param i Comparison mode, in String.
	 * @throws Exception Throws an exception if the mode isn't recognized as valid.
	 */
	LogicParser(String i) throws Exception{
		if(i.equalsIgnoreCase("AND"))       currentStatus = 0;
		else if(i.equalsIgnoreCase("OR"))   currentStatus = 1;
		else if(i.equalsIgnoreCase("NAND")) currentStatus = 2;
		else if(i.equalsIgnoreCase("NOR"))  currentStatus = 3;
		else throw new Exception("Invalid comparison mode");
	}
	
	/**
	 * Returns the current comparison mode.
	 * @return
	 */
	public int getCurrentStatus() {
		return currentStatus;
	}
	
	/**
	 * Runs the comparison between the two booleans with the selected mode.
	 * @param a The first boolean.
	 * @param b The second boolean.
	 * @return The result from the comparison.
	 */
	public boolean compare(boolean a, boolean b){
		switch (currentStatus) {
			case 0: return  (a && b);
			case 1: return  (a || b);
			case 2: return !(a && b);
			case 3: return !(a || b);
		}
		return false;
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
