package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.LogicParser;
import classes.RuleChecker;

class RuleCheckerTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testFeatureEnvyCheckIntFloat() {
		RuleChecker rc = new RuleChecker();
		rc.featureEnvyCheck(11, 11);
		rc.featureEnvyCheck(11, 0);
	}

	@Test
	final void testFeatureEnvyCheckIntFloatIntInt() {
		try {
			RuleChecker rc = new RuleChecker();
			rc.featureEnvyCheck(11, 11,11,11);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	final void testFeatureEnvyCheckIntFloatIntIntLogicParser() {
		try {
			RuleChecker rc = new RuleChecker();
			rc.featureEnvyCheck(11, 11,11,11,new LogicParser("or"));
			rc.featureEnvyCheck(11, 11,11,11,new LogicParser("nor"));
			rc.featureEnvyCheck(11, 11,11,11,new LogicParser("and"));
			rc.featureEnvyCheck(11, 11,11,11,new LogicParser("nand"));
			
		} catch (Exception e) {
		}
	}

	@Test
	final void testLongMethodCheckIntFloat() {
		RuleChecker rc = new RuleChecker();
		rc.longMethodCheck(100, 20);
		rc.longMethodCheck(1, 1);
	}

	@Test
	final void testLongMethodCheckIntIntIntInt() {
		try {
			RuleChecker rc = new RuleChecker();
			rc.longMethodCheck(1, 1,11,11);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	final void testLongMethodCheckIntIntIntIntLogicParser() {
		try {
			RuleChecker rc = new RuleChecker();
			rc.longMethodCheck(11, 11,1,1,new LogicParser("or"));
			rc.longMethodCheck(11, 11,1,1,new LogicParser("nor"));
			rc.longMethodCheck(11, 11,1,1,new LogicParser("and"));
			rc.longMethodCheck(11, 11,1,1,new LogicParser("nand"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
