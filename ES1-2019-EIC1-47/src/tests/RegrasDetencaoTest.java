package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.LogicParser;
import classes.RegrasDetencao;
import classes.RuleChecker;

class RegrasDetencaoTest {
	private RuleChecker rc = new RuleChecker();

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
	final void testVerificacao() {
		RegrasDetencao rd= new RegrasDetencao();
		rd.Verificacao();
	
		
	}

	@Test
	final void testVerificacaoIntIntIntInt() {
		RegrasDetencao rd= new RegrasDetencao();
		try {
			rd.Verificacao(2,3,4,6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		//fail("Not yet implemented"); // TODO
	}

	@Test
	final void testVerificacaoIntIntIntIntLogicParser() {
		RegrasDetencao rd= new RegrasDetencao();
		LogicParser lp;
		try {
			lp = new LogicParser(0);
			rd.Verificacao(2,3,4,6,lp);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		//fail("Not yet implemented"); // TODO
	}

	@Test
	final void testDCI() {
		RegrasDetencao rd= new RegrasDetencao();
		rd.DCI();
		//fail("Not yet implemented"); // TODO
	}

	@Test
	final void testDII() {
		RegrasDetencao rd= new RegrasDetencao();
		rd.DII();
	}

	@Test
	final void testADCI() {
		RegrasDetencao rd= new RegrasDetencao();
		rd.ADCI();
	}

	@Test
	final void testADII() {
		RegrasDetencao rd= new RegrasDetencao();
		rd.ADII();
	}

}
