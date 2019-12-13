package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.LogicParser;
import classes.ResultRepresenter;
import classes.Rule;

class RuleTest {

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
	final void testRuleStringIntIntLogicParserInt() {
		try {
			Rule rule = new Rule("name", 10, 10, new LogicParser(0), 0);
			Rule rule2 = new Rule("name", 10, 10, new LogicParser(0), 1);
			Rule rule3 = new Rule("name", 10, 10, new LogicParser(0), 2);
		} catch (Exception e) {
		}
	}

	@Test
	final void testRuleStringIntIntLogicParserString() {
		try {
			Rule rule = new Rule("name", 10, 10, new LogicParser(0), "is_long_method");
			Rule rule2 = new Rule("name", 10, 10, new LogicParser(0), "is_feature_envy");
			Rule rule3 = new Rule("name", 10, 10, new LogicParser(0), "aaaaaa");
		} catch (Exception e) {
		}
	}

	@Test
	final void testRunRule() {
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			rule.runRule(2, 2);
			rule.runRule(11, 11);
			rule = new Rule("name", 10, 10, new LogicParser(0),1);
			rule.runRule(2, 2);
			rule.runRule(11, 11);
			rule = new Rule("name", 10, 10, new LogicParser(0),1);
			rule.setMode(2);
			rule.runRule(2, 2);
			rule.runRule(11, 11);
		} catch (Exception e) {
		}
		
	}

	@Test
	final void testToString() {
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			rule.toString();
			rule = new Rule("name", 10, 10, new LogicParser(0),1);
			rule.toString();
			rule.setMode(-1);
			rule.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Test
	final void testGetName() {	
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			rule.getName();
		} catch (Exception e) {
		}
	}

	@Test
	final void testSetName() {
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			rule.setName("new name");
		} catch (Exception e) {
		}
	}

	@Test
	final void testGetLimit1() {
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			assertTrue(rule.getLimit1()==10);
		}catch(Exception e) {
		}
	}

	@Test
	final void testSetLimit1() {
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			rule.setLimit1(11);
			assertTrue(rule.getLimit1()==11);
		}catch(Exception e) {
		}
	}

	@Test
	final void testGetLimit2() {
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			assertTrue(rule.getLimit2()==10);
		}catch(Exception e) {
		}
	}

	@Test
	final void testSetLimit2() {
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			rule.setLimit2(11);
			assertTrue(rule.getLimit2()==11);
		}catch(Exception e) {
		}
	}

	@Test
	final void testGetMode() {
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			assertTrue(rule.getMode().equals("Feature Envy"));
			rule = new Rule("name", 10, 10, new LogicParser(0),1);
			assertTrue(rule.getMode().equals("Long Method"));
		}catch(Exception e) {
		}
	}

	@Test
	final void testSetMode() {
		try{
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			assertTrue(rule.getMode().equals("Feature Envy"));
			rule.setMode(1);
			assertTrue(rule.getMode().equals("Long Method"));
			rule.setMode("is_feature_envy");
			assertTrue(rule.getMode().equals("Feature Envy"));
			rule.setMode("is_long_method");
			assertTrue(rule.getMode().equals("Long Method"));
			rule.setMode("");
			assertTrue(rule.getMode().equals("Long Method"));
			
		}catch(Exception e) {
			
		}
		
		
	}

	@Test
	final void testGetLp() {
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			assertTrue(rule.getLp().toString().equals("AND"));
		} catch (Exception e) {
		}
	}

	@Test
	final void testSetLp() {
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			assertTrue(rule.getLp().toString().equals("AND"));
			rule.setLp(new LogicParser(1));
			assertTrue(rule.getLp().toString().equals("OR"));
		} catch (Exception e) {
		}
	}

	@Test
	final void testGetResult() {
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			assertTrue(rule.getResult() == null);
		} catch (Exception e) {
		}
	}

	@Test
	final void testSetResult() {
		try {
			Rule rule;
			rule = new Rule("name", 10, 10, new LogicParser(0),0);
			rule.setResult(new ResultRepresenter());
			assertTrue(rule.getResult() != null);
		} catch (Exception e) {
		}
	}

}
