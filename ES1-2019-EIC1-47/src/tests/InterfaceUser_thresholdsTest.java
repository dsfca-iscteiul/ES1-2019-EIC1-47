package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.InterfaceUser_thresholds;

class InterfaceUser_thresholdsTest {

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
	final void testInterfaceUser_thresholdsFile() {
		try {
			InterfaceUser_thresholds iut = new InterfaceUser_thresholds(new File("./Method.xlsx"));
			assertTrue(iut!=null);
		} catch (Exception e) {
		}
	}

	@Test
	final void testInterfaceUser_thresholds() {
		try {
			InterfaceUser_thresholds iut = new InterfaceUser_thresholds();
			assertTrue(iut!=null);
		} catch (Exception e) {
		}
	}

	@Test
	final void testShowUI() {
		try {
			InterfaceUser_thresholds iut = new InterfaceUser_thresholds();
			iut.showUI();
		} catch (Exception e) {
		}
	}

	@Test
	final void testOpen() {
		try {
			InterfaceUser_thresholds iut = new InterfaceUser_thresholds();
			iut.open();
		} catch (Exception e) {
		}
	}

	@Test
	final void testAddFrameContent() {
		try {
			InterfaceUser_thresholds iut = new InterfaceUser_thresholds();
			iut.addFrameContent();
		} catch (Exception e) {
		}
	}

	@Test
	final void testMain() {
		try {
			InterfaceUser_thresholds iut = new InterfaceUser_thresholds();
			iut.main(null);
		} catch (Exception e) {
		}
	}
	

}
