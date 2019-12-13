package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Metodo;


class MetodoTest {
	Metodo m;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		m= new Metodo();
		m.setPackage1("H");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSetloc() {
		
	}

	@Test
	final void testIsiPlasma() {
		boolean b= m.isiPlasma();
		assertEquals(false,b);
	}

	@Test
	final void testSetiPlasma() {
	}

	@Test
	final void testIsIs_feature_envy() {
		boolean b=m.isIs_feature_envy();
		assertEquals(false, b);
	}

	@Test
	final void testSetIs_feature_envy() {
	}

	@Test
	final void testToString() {
	}

	@Test
	final void testMetodo() {
	}

	@Test
	final void testGetMethodID() {
		double s= m.getMethodID();
		assertTrue(s==m.getMethodID());
	}
	

	@Test
	final void testSetMethodID() {
		double s = 3;
		m.setMethodID(s);
		assertTrue(s==m.getMethodID());
	}

	@Test
	final void testGetPackage1() {
		String s= m.getPackage1();
		assertEquals(s,m.getPackage1());
	}

	@Test
	final void testSetPackage1() {
		
	}

	@Test
	final void testGetClass1() {
		String s= m.getClass1();
		assertEquals(s,m.getClass1());
	}

	@Test
	final void testSetClass1() {
		
	}

	@Test
	final void testGetMethod() {
		String s= m.getMethod();
		assertEquals(s,m.getMethod());
	}

	@Test
	final void testSetMethod() {
	}

	@Test
	final void testGetLoc() {
		double s= m.getLoc();
		assertTrue(s==m.getLoc());
	}

	@Test
	final void testSetLoc() {
	}

	@Test
	final void testGetCyclo() {
		double s= m.getCyclo();
		assertTrue(s==m.getCyclo());
	}

	@Test
	final void testSetCyclo() {
	}

	@Test
	final void testGetAtfd() {
		double s= m.getAtfd();
		assertTrue(s==m.getAtfd());
	}

	@Test
	final void testSetAtfd() {
	}

	@Test
	final void testGetLaa() {
		double s= m.getLaa();
		assertTrue(s==m.getLaa());
	}

	@Test
	final void testSetLaa() {
	}

	@Test
	final void testIsIs_long_method() {
		boolean c=m.isIs_long_method();
		assertEquals(false,c);
	}

	@Test
	final void testSetIs_long_method() {
		
	}
	@Test
	final void testIsPMD() {
		boolean c=m.isPMD();
		assertEquals(false,c);
	}

	@Test
	final void testSetPMD() {
	}

	@Test
	final void testGetRuleResult() {
		boolean c=m.getRuleResult();
		assertEquals(false,c);
	}

	@Test
	final void testSetRuleResult() {
	}

}
