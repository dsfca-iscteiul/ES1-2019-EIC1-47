public class RuleChecker {
	/*
		Esta classe realiza as verificações das regras feature Envy, 
		com presets, caso o utilizador não defina dados.
	*/
	
	// Preset do feature envy, como visto no enunciado, caso o utilizador não especifique valores
	public boolean featureEnvyCheck(int AFTD, float LAA) { 
		if (AFTD > 4 && LAA < 0.42)
			return true;
		return false;
	}
	
	// verificação do feature envy, com dados postos pelo utilizador
	public boolean featureEnvyCheck(int AFTD, float LAA, int AFTDLimit, int LAALimit) throws Exception {
		return featureEnvyCheck(AFTD, LAA, AFTDLimit, LAALimit, new LogicParser("AND"));
	}
	
	public boolean featureEnvyCheck(int AFTD, float LAA, int AFTDLimit, int LAALimit, LogicParser logic) throws Exception {
		if (logic.compare((AFTD > AFTDLimit), (LAA < LAALimit)))
			return true;
		return false;
	}

	// Preset do long method, caso o utilizador não especifique valores
	public boolean longMethodCheck(int LOC, float CYCLO) { 
		if (LOC > 80 && CYCLO > 10)
			return true;
		return false;
	}
	
	// o mesmo que antes, mas com dados postos pelo utilizador
	public boolean longMethodCheck(int LOC, int CYCLO, int LOCLimit, int CYCLOLimit) throws Exception {
		return longMethodCheck(LOC, CYCLO, LOCLimit, CYCLOLimit, new LogicParser("AND"));
	}
	
	
	public boolean longMethodCheck(int LOC, int CYCLO, int LOCLimit, int CYCLOLimit, LogicParser logic) throws Exception {
		if (logic.compare((LOC > LOCLimit), (CYCLO > CYCLOLimit)))
			return true;
		return false;
	}

}
