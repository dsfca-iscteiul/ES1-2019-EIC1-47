
public class RuleChecker {
	
	// Preset do feature envy, como visto no enunciado, caso o utilizador não especifique valores
	public boolean featureEnvyCheck(int AFTD, float LAA) { 
		if (AFTD > 4 && LAA < 0.42)
			return true;
		return false;
	}
	
	public boolean featureEnvyCheck(int AFTD, float LAA, int AFTDLimit, int LAALimit, LogicParser logic) throws Exception {
		switch (logic.getCurrentStatus()) {
			case 0: // AND
				if (AFTD > AFTDLimit && LAA < LAALimit)
					return true;
				return false;
	
			case 1: // OR
				if (AFTD > AFTDLimit || LAA < LAALimit)
					return true;
				return false;
	
			case 2: // NAND
				if (!(AFTD > AFTDLimit && LAA < LAALimit))
					return true;
				return false;
	
			case 3: // NOR
				if (!(AFTD > AFTDLimit || LAA < LAALimit))
					return true;
				return false;
		}
		throw new Exception();
	}

	// Preset do long method, caso o utilizador não especifique valores
	public boolean longMethodCheck(int LOC, float CYCLO) { 
		if (LOC > 80 && CYCLO > 10)
			return true;
		return false;
	}
	
	public boolean longMethodCheck(int LOC, int CYCLO, int LOCLimit, int CYCLOLimit, LogicParser logic) throws Exception {
		switch (logic.getCurrentStatus()) {
			case 0: // AND
				if (LOC > LOCLimit && CYCLO > CYCLOLimit)
					return true;
				return false;
	
			case 1: // OR
				if (LOC > LOCLimit || CYCLO > CYCLOLimit)
					return true;
				return false;
	
			case 2: // NAND return !long
				if (!(LOC > LOCLimit && CYCLO > CYCLOLimit))
					return true;
				return false;
	
			case 3: // NOR
				if (!(LOC > LOCLimit || CYCLO > CYCLOLimit))
					return true;
				return false;
		}
		throw new Exception();
	}

}
