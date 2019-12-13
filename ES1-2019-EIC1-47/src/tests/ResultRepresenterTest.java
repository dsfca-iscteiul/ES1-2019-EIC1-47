package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.LeituraFicheiro;
import classes.LogicParser;
import classes.Metodo;
import classes.ResultRepresenter;
import classes.Rule;

class ResultRepresenterTest {

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
	final void testGrabResultsArrayListOfMetodo() {
		ResultRepresenter rr = new ResultRepresenter();
		Rule rule;
		try {
			rule = new Rule("name", 5, 5, new LogicParser("and"), 0);

			ArrayList ar = new ArrayList<Metodo>();
			Metodo a = new Metodo();
			a.setLoc(3);
			a.setAtfd(3);
			a.setCyclo(3);
			a.setLaa(3);
			a.setiPlasma(true);
			a.setPMD(true);
			a.setMethodID(1);
			ar.add(a);
			Metodo b = new Metodo();
			b.setLoc(3);
			b.setAtfd(3);
			b.setCyclo(3);
			b.setLaa(3);
			b.setMethodID(2);
			b.setiPlasma(true);
			b.setPMD(false);
			ar.add(b);
			Metodo c = new Metodo();
			c.setLoc(3);
			c.setAtfd(3);
			c.setCyclo(3);
			c.setLaa(3);
			c.setMethodID(3);
			c.setiPlasma(false);
			c.setPMD(true);
			ar.add(c);
			Metodo d = new Metodo();
			d.setLoc(3);
			d.setAtfd(3);
			d.setCyclo(3);
			d.setLaa(3);
			d.setMethodID(4);
			d.setiPlasma(false);
			d.setPMD(false);
			ar.add(d);
			
			rule.setMode(Rule.longMethod);
			rr.grabResults(ar, rule, 2);
			rr.resetRan();
			
			rule.setMode(Rule.featureEnvy);
			rr.grabResults(ar, rule, 0);
			rr.resetRan();
			
			rr.grabResults(ar, rule, 0);
			rr.resetRan();
			rule.setMode(Rule.longMethod);
			rr.grabResults(ar, rule, 2);
			rr.resetRan();
			rr.grabResults(ar, rule, 1);
			rr.resetRan();
			rr.grabResults(ar, rule, 1);
			rr.resetRan();
			rule = new Rule("name", 1, 1, new LogicParser("and"), Rule.longMethod);
			rr.grabResults(ar, rule, 0);
			rr.resetRan();
			rule = new Rule("name", 5, 5, new LogicParser("or"), Rule.longMethod);
			rr.grabResults(ar, rule, 0);
			rr.resetRan();
			rr.grabResults(ar, rule, 1);
			rule = new Rule("name", 1, 1, new LogicParser("and"), Rule.longMethod);
			rr.resetRan();
			rr.grabResults(ar, rule, 1);
			rule = new Rule("name", 5, 5, new LogicParser("or"), Rule.longMethod);
			rr.resetRan();
			rr.grabResults(ar, rule, 2);
			rule = new Rule("name", 1, 1, new LogicParser("and"), Rule.longMethod);
			rr.resetRan();
			rr.grabResults(ar, rule, 2);
			rule = new Rule("name", 5, 5, new LogicParser("or"), Rule.longMethod);
			rr.resetRan();
			rr.grabResults(ar, rule, 3);
			rr.grabResults(ar, rule, 3);


		} catch (Exception e) {

		}

		
	}

	@Test
	final void testShowWindow() {
		try {
			ResultRepresenter rr = new ResultRepresenter();
			Rule rule = new Rule("name", 5, 5, new LogicParser(0), 0);
			rr.setRule(rule);

			
			LeituraFicheiro leitorDeFicheiros = new LeituraFicheiro(new File("./Method.xlsx"));
			leitorDeFicheiros.CorreFicheiro();
			ArrayList<Metodo> ar = leitorDeFicheiros.createList();
			rule.setLp(new LogicParser(LogicParser.AND));
			rule.setMode(Rule.longMethod);
			rr.grabResults(ar, rule, 2);
			rr.showWindow();
			rule.setLp(new LogicParser(LogicParser.NAND));
			rule.setMode(Rule.longMethod);
			rr.grabResults(ar, rule, 1);
			rr.showWindow();
			rule.setLp(new LogicParser(LogicParser.AND));
			rule.setMode(Rule.longMethod);
			rr.grabResults(ar, rule, 0);
			rr.showWindow();
			rule.setLp(new LogicParser(LogicParser.AND));
			rule.setMode(Rule.featureEnvy);
			rr.grabResults(ar, rule, 0);
			rr.showWindow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	final void testSetRule() {
		try {
			ResultRepresenter rr = new ResultRepresenter();
			Rule rule = new Rule("name", 5, 5, new LogicParser(0), 0);
			rr.setRule(rule);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	final void testGetRule() {
		try {
			ResultRepresenter rr = new ResultRepresenter();
			Rule rule = new Rule("name", 5, 5, new LogicParser(0), 0);
			rr.setRule(rule);
			Rule newRule = rr.getRule();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
