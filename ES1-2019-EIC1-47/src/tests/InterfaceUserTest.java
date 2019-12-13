/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.InterfaceUser;

/**
 * @author Catarina Teodoro
 *
 */
class InterfaceUserTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link classes.InterfaceUser#main(java.lang.String[])}.
	 */
	@Test
	final void testMain() {
		InterfaceUser iu = new InterfaceUser();
		try {
			iu.open();
		} catch (Exception e) {

		}
		assertNotNull(iu);
	}

	/**
	 * Test method for {@link classes.InterfaceUser#setAviso(String s)}.
	 */
	@Test
	final void testSetTextAviso() {
		InterfaceUser gui = new InterfaceUser();
		try {
			gui.setTextAviso("");
		} catch (Exception e) {
			
		}
		assertEquals("", gui.getAviso());
	}
	
	/**
	 * Test method for {@link classes.InterfaceUser#getAviso()}.
	 */
	@Test
	final void testGetTextAviso() {
		InterfaceUser menu = new InterfaceUser();
		try {
			menu.setTextAviso("");
		} catch (Exception e) {
			
		}
		assertEquals("", menu.getAviso());
	}

}
