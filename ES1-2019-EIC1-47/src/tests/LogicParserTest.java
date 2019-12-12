package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.LogicParser;

class LogicParserTest {

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
	final void testLogicParserInt() {
		try {
			LogicParser lp;
			lp = new LogicParser(0);
			assertTrue(lp.toString().equals("AND"));
			lp = new LogicParser(1);
			assertTrue(lp.toString().equals("OR"));
			lp = new LogicParser(2);
			assertTrue(lp.toString().equals("NAND"));
			lp = new LogicParser(3);
			assertTrue(lp.toString().equals("NOR"));
			lp = new LogicParser(4);
			assertTrue(lp.toString().equals("XOR"));
		} catch (Exception e) {
			fail("failed");
		}
		
		try {
			LogicParser fake;
			fake = new LogicParser(-1);
			fail("failed");
		} catch (Exception e) {
		}
		try {
			LogicParser fake;
			fake = new LogicParser(5);
			fail("failed");
		} catch (Exception e) {
		}
	}

	@Test
	final void testLogicParserString() {
		try {
			LogicParser lp;
			lp = new LogicParser("and");
			assertTrue(lp.toString().equals("AND"));
			lp = new LogicParser("or");
			assertTrue(lp.toString().equals("OR"));
			lp = new LogicParser("nand");
			assertTrue(lp.toString().equals("NAND"));
			lp = new LogicParser("nor");
			assertTrue(lp.toString().equals("NOR"));
			lp = new LogicParser("xor");
			assertTrue(lp.toString().equals("XOR"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("failed");
		}
		
		try {
			LogicParser fake;
			fake = new LogicParser("aa");
			fail("failed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		try {
			LogicParser fake;
			fake = new LogicParser("");
			fail("failed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}

	@Test
	final void testGetCurrentStatus() {
		try {
			LogicParser lp;
			lp = new LogicParser("and");
			assertTrue(lp.getCurrentStatus()==0);
			lp = new LogicParser("or");
			assertTrue(lp.getCurrentStatus()==1);
			lp = new LogicParser("nand");
			assertTrue(lp.getCurrentStatus()==2);
			lp = new LogicParser("nor");
			assertTrue(lp.getCurrentStatus()==3);
			lp = new LogicParser("xor");
			assertTrue(lp.getCurrentStatus()==4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("failed");
		}
	}

	@Test
	final void testCompare() {
		try {
			LogicParser lp;
			lp = new LogicParser("and");
			assertFalse(lp.compare(false, false));
			assertFalse(lp.compare(false, true));
			assertFalse(lp.compare(true, false));
			assertTrue(lp.compare(true, true));
			
			lp = new LogicParser("or");
			assertFalse(lp.compare(false, false));
			assertTrue(lp.compare(false, true));
			assertTrue(lp.compare(true, false));
			assertTrue(lp.compare(true, true));
			
			lp = new LogicParser("nand");
			assertTrue(lp.compare(false, false));
			assertTrue(lp.compare(false, true));
			assertTrue(lp.compare(true, false));
			assertFalse(lp.compare(true, true));

			lp = new LogicParser("nor");
			assertTrue(lp.compare(false, false));
			assertFalse(lp.compare(false, true));
			assertFalse(lp.compare(true, false));
			assertFalse(lp.compare(true, true));
			
			lp = new LogicParser("xor");
			assertFalse(lp.compare(false, false));
			assertTrue(lp.compare(false, true));
			assertTrue(lp.compare(true, false));
			assertFalse(lp.compare(true, true));
			
			lp.setCurrentStatus(-1);
			assertFalse(lp.compare(false, false));
			assertFalse(lp.compare(false, true));
			assertFalse(lp.compare(true, false));
			assertFalse(lp.compare(true, true));
		} catch (Exception e) {
			fail("failed");
		}
	}

	@Test
	final void testToString() {
		try {
			LogicParser lp;
			lp = new LogicParser("and");
			assertTrue(lp.toString().equals("AND"));
			lp = new LogicParser("or");
			assertTrue(lp.toString().equals("OR"));
			lp = new LogicParser("nand");
			assertTrue(lp.toString().equals("NAND"));
			lp = new LogicParser("nor");
			assertTrue(lp.toString().equals("NOR"));
			lp = new LogicParser("xor");
			assertTrue(lp.toString().equals("XOR"));
			lp.setCurrentStatus(-1);
			assertTrue(lp.toString().equals("NOT SET"));
		} catch (Exception e) {
			fail("failed");
		}
		
	}

}
