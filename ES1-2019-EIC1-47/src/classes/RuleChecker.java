package classes;

/**
 * Date: Dec 12, 2019
 * This is a class that does the rule checking,  with a few presets for simplification.
 * @author Tomás Ferreira
 */
public class RuleChecker {

	/**
	 * Most basic Feature Envy preset, with some preset values, in case the user doesn't specify any threshold values.
	 * @param AFTD AFTD Value of the method.
	 * @param LAA LAA Value of the method.
	 * @return Rule compliance.
	 */
	public boolean featureEnvyCheck(int AFTD, float LAA) { 
		if (AFTD > 4 && LAA < 0.42)
			return true;
		return false;
	}
	
	/**
	 * Feature Envy preset, with a preset logic comparison (in this case, AND), in case the user doesn't specify the logic comparison.
	 * @param AFTD AFTD Value of the method.
	 * @param LAA LAA Value of the method.
	 * @param AFTDLimit AFTD Limit of the rule.
	 * @param AFTDLimit LAA Limit of the rule.
	 * @return Rule compliance.
	 */
	public boolean featureEnvyCheck(int AFTD, float LAA, int AFTDLimit, int LAALimit) throws Exception {
		return featureEnvyCheck(AFTD, LAA, AFTDLimit, LAALimit, new LogicParser("AND"));
	}
	
	/**
	 * The complete Feature Envy check
	 * @param AFTD AFTD Value of the method.
	 * @param LAA LAA Value of the method.
	 * @param AFTDLimit AFTD Limit of the rule.
	 * @param AFTDLimit LAA Limit of the rule.
	 * @param logic The logic comparison to be applied (LogicParser).
	 * @return Rule compliance.
	 */
	public boolean featureEnvyCheck(int AFTD, float LAA, int AFTDLimit, int LAALimit, LogicParser logic){
		try{
			if (logic.compare((AFTD > AFTDLimit), (LAA < LAALimit)))
			return true;
		}catch (Exception e) {
		}
		return false;
	}

	/**
	 * Most basic Long Method preset, with some preset values, in case the user doesn't specify any threshold values.
	 * @param LOC LOC Value of the method.
	 * @param CYCLO CYCLO Value of the method.
	 * @return Rule compliance.
	 */
	public boolean longMethodCheck(int LOC, float CYCLO) { 
		if (LOC > 80 && CYCLO > 10)
			return true;
		return false;
	}
	
	/**
	 * Long Method preset, with a preset logic comparison (in this case, AND), in case the user doesn't specify the logic comparison.
	 * @param LOC LOC Value of the method.
	 * @param CYCLO CYCLO Value of the method.
	 * @param LOCLimit LOC Limit of the rule.
	 * @param CYCLOLimit CYCLO Limit of the rule.
	 * @return Rule compliance.
	 */
	public boolean longMethodCheck(int LOC, int CYCLO, int LOCLimit, int CYCLOLimit) throws Exception {
		return longMethodCheck(LOC, CYCLO, LOCLimit, CYCLOLimit, new LogicParser("AND"));
	}
	
	/**
	 * The complete Long Method check
	 * @param LOC LOC Value of the method.
	 * @param CYCLO CYCLO Value of the method.
	 * @param LOCLimit LOC Limit of the rule.
	 * @param CYCLOLimit CYCLO Limit of the rule.
	 * @param logic The logic comparison to be applied (LogicParser).
	 * @return Rule compliance.
	 */
	public boolean longMethodCheck(int LOC, int CYCLO, int LOCLimit, int CYCLOLimit, LogicParser logic){
		try {
			if (logic.compare((LOC > LOCLimit), (CYCLO > CYCLOLimit)))
			return true;
		} catch (Exception e) {
		}
		return false;
	}

}
