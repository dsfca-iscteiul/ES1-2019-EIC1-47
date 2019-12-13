package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.LeituraFicheiro;
import classes.Metodo;

class LeituraFicheiroTest {

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
	final void testGetDados() {
		LeituraFicheiro lf= new LeituraFicheiro();
		try {
			lf.CorreFicheiro();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fail("Not yet implemented"); // TODO
		
	}

	@Test
	final void testLeituraFicheiroFile() {
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	final void construtor() {
		File f = new File("C:\\Users\\Kira\\Downloads\\Long-Method.xlsx");
		LeituraFicheiro lf= new LeituraFicheiro(f);
		//fail("Not yet implemented"); // TODO
	}


	@Test
	final void testLeituraFicheiro() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testOpenFile() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetFile() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetFile() {
		File f = new File("C:\\Users\\Kira\\Downloads\\rd2tygx");
		LeituraFicheiro lf= new LeituraFicheiro();
		lf.setFile(f);
		lf.getFile();
	
		
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testCorreFicheiro() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testShowTable() {
		//File f = new File("C:\\Users\\Kira\\Downloads\\Long-Method.xlsx");
		LeituraFicheiro lf= new LeituraFicheiro();
		try {
			lf.CorreFicheiro();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			lf.ShowTable();
			ArrayList<Metodo> c= lf.getDados();
			lf.getFis();
		//fail("Not yet implemented"); // TODO
	}

	@Test
	final void testGetFis() {
		LeituraFicheiro lf= new LeituraFicheiro();
		try {
			lf.CorreFicheiro();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			lf.getFis();
			ArrayList<Metodo> c= lf.getDados();
	}

	@Test
	final void testCreateList() {
		File f = new File("C:\\Users\\Kira\\Downloads\\Long-Method.xlsx");
		LeituraFicheiro lf= new LeituraFicheiro(f);
		try {
			lf.CorreFicheiro();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			lf.createList();
		
		
	}

	@Test
	final void testCreateListXSSFSheet() {
		LeituraFicheiro lf= new LeituraFicheiro();
		try {
			lf.CorreFicheiro();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			lf.ShowTable();
			lf.createList();
	}

}
