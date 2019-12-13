package classes;

/**
 * Date: Dec 12, 2019
 * This is a class that receives a Rule, with thresholds and a mode (being it Feature Envy or Long Method), 
 * and creates and runs a new RuleChecker accordingly.
 * @author Tomás Ferreira
 */

public class Rule {

	private String name;
	private int Limit1;
	private int Limit2;
	private int mode = -1;
	private LogicParser lp;
	public static final int featureEnvy = 0;
	public static final int longMethod = 1;
	private ResultRepresenter result;
	
	/**
	 * This Constructor creates a rule, and does it with the Rule.featureEnvy or Rule.longMethod in the mode parameter.
	 * @param name The name of the Rule, for user recognition.
	 * @param Limit1 The value of the first limit.
	 * @param Limit2 The value of the second limit.
	 * @param lp The selected logic comparison between the two thresholds
	 * @param mode The selected of the rule.
	 * @throws Exception If the mode isn't recognized, the constructor will throw an exception.
	 */
	public Rule(String name, int Limit1, int Limit2, LogicParser lp, int mode) throws Exception {
		if(mode!=1 && mode!=0) throw new Exception("unrecognized mode");
		this.name = name;
		this.Limit1 = Limit1;
		this.Limit2 = Limit2;
		this.mode = mode;
		this.lp = lp;
	}
	
	/**
	 * This Constructor creates a rule, and does it string comparison with the mode parameter.
	 * @param name The name of the Rule, for user recognition.
	 * @param Limit1 The value of the first limit.
	 * @param Limit2 The value of the second limit.
	 * @param lp The selected logic comparison between the two thresholds
	 * @param mode The selected of the rule.
	 * @throws Exception If the mode isn't recognized, the constructor will throw an exception.
	 */
	public Rule(String name, int Limit1, int Limit2, LogicParser lp, String mode) throws Exception {
		if(mode.equals("is_long_method")) this.mode=1;
		else if(mode.equals("is_feature_envy")) this.mode=0;
		if(!mode.equals("is_long_method") && !mode.equals("is_feature_envy")) throw new Exception("unrecognized mode");
		this.name = name;
		this.Limit1 = Limit1;
		this.Limit2 = Limit2;
		this.lp = lp;
	}
	
	
	
	/**
	 * This function runs the before created rule, that is to return a RuleChecker that compares the parameters given in this function
	 * with the limits before given.
	 * @param param1 The value of the first parameter (LOC or ATFD).
	 * @param param2 The value of the second parameter (CYCLO or LAA).
	 * @return The obedience of the parameters given to the rule.
	 */
	public boolean runRule(int param1, int param2) {
		try {
			if(mode==0) return new RuleChecker().featureEnvyCheck(param1, param2,Limit1,Limit2,lp);
			else if(mode==1) return new RuleChecker().longMethodCheck(param1, param2,Limit1,Limit2,lp);
		} catch(Exception e) {
		}
		return false;
	}
	
	/**
	 * The toString() method was changed for better readability, and it returns the given name of the rule, followed by the preset
	 * of the mode, filled with the limits in their correct places.
	 *
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(mode==0) return name + ": Feature Envy: ATFD > " + Limit1 + " " + lp.toString() + " LAA < " + Limit2;
		else if(mode==1) return name + ": Long Method: LOC > " + Limit1 + " " + lp.toString() + " CYCLO > " + Limit2;
		return "Não Definido";
	}

	/**
	 * Returns the given name of the rule.
	 * @return The given name of the rule.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of the rule.
	 * @param name The new name of the rule.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the first limit (LOC or ATFD).
	 * @return The first limit. 
	 */
	public int getLimit1() {
		return Limit1;
	}

	/**
	 * Changes the first limit (LOC or ATFD).
	 * @param limit1 The new first limit. 
	 */
	public void setLimit1(int limit1) {
		Limit1 = limit1;
	}

	/**
	 * Returns the second limit (CYCLO or LAA).
	 * @return The second limit. 
	 */
	public int getLimit2() {
		return Limit2;
	}
	
	/**
	 * Changes the second limit(CYCLO or LAA).
	 * @param limit1 The new second limit.
	 */
	public void setLimit2(int limit2) {
		Limit2 = limit2;
	}

	/**
	 * Returns the selected mode.
	 * @return The selected mode. 
	 */
	public String getMode() {
		if(mode==0) return "Feature Envy";
		return "Long Method";
	}

	/**
	 * Changes the mode (Rule.featureEnvy or Rule.longMethod).
	 * @param limit1 The new mode.
	 */
	public void setMode(int mode) {
		this.mode = mode;
	}
	
	
	/**
	 * Changes the mode ("is_long_method" or "is_feature_envy").
	 * @param limit1 The new mode.
	 */
	public void setMode(String mode) {
		if(mode.equals("is_long_method")) this.mode=1;
		else if(mode.equals("is_feature_envy")) this.mode=0;
	}

	/**
	 * Returns the LogicParser mode.
	 * @return The LogicParser mode.
	 */
	public LogicParser getLp() {
		return lp;
	}

	/**
	 * Changes the LogicParser.
	 * @param lp The new LogicParser.
	 */
	public void setLp(LogicParser lp) {
		this.lp = lp;
	}

	/**
	 * Returns the ResultRepresenter object associated with the rule.
	 * @return The ResultRepresenter object associated with the rule.
	 */
	public ResultRepresenter getResult() {
		return result;
	}

	/**
	 * Associates a ResultRepresenter object.
	 * @param result The ResultRepresenter object to be associated.
	 */
	public void setResult(ResultRepresenter result) {
		this.result = result;
	}

	
	
	
	
	
}
