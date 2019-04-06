/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Julia Martini
 * Technische Universität Berlin
 */
package exercise2.test;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.controller.AddressBookControllerImpl;
import exercise2.addressbook.controller.ParameterException;
import exercise2.addressbook.model.SizeLimitReachedException;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 * Uebung 2 - Komponenten und Integrationstest Komponententests für den
 * Controller
 *
 * Bitte Nummer der Gruppe eintragen: 2
 *
 * @author Jovine Kamegne Foka
 * @author Marcel Marks
 * @author Florian Duchow
 * @author Fida Ahmadi
 */
public class AddressBookControllerTest {

	/*
	 * Aufgabe 3 Führen Sie im Rahmen eines Komponententests der Klasse
	 * exercise2.addressbook.controller.AddressBookControllerImpl einen Test der
	 * Methode add(...) durch. Schreiben Sie für die model und view Komponenten
	 * Mock-Up Klassen und verwenden Sie dies im Komponententest der
	 * AddressBookController Komponente. Testen Sie die add() Methode auf Herz und
	 * Nieren - es sind durchaus Fehler zu finden.
	 */
	// Model component for the test
	AddressBookModelMockUp model;

	// View component for the test
	AddressBookViewMockUp view;

	// Controller component for the test
	AddressBookController controller;

	/**
	 * Set up test system
	 */
	@Before
	public void setUp() {
		// Instantiate and wire components
		this.model = new AddressBookModelMockUp();
		this.view = new AddressBookViewMockUp();
		this.controller = new AddressBookControllerImpl(model, view);
	}

	/**
	 * Tests whether the Method acts as expected
	 */

	@Test
	public void testcase0() {

		try {
			controller.add("Marcel", "Marks", "F", null, "fida.ahmadi@test.de");
			System.out.println("Ok, Runs as expected");
		} catch (ParameterException e) {
			fail();
			e.printStackTrace();
		} catch (SizeLimitReachedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testcase1() {

		try {
			controller.add("Fida", "Ahmadi", "M", null, "fida.ahmadi@test.de");
			System.out.println("Ok, Runs as expected");
		} catch (ParameterException e) {
			fail();
			e.printStackTrace();
		} catch (SizeLimitReachedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests whether the Method acts as expected if phoneContactInformation == null
	 * && firstName == null ParameterException is expected
	 */
	@Test
	public void testcase2() {

		try {
			controller.add(null, "Ahmadi", "M", null, "fida.ahmadi@test.de");
			fail();
		} catch (ParameterException e) {
			System.out.println("Ok, The expected Exception was caught");
		} catch (SizeLimitReachedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests whether the Method acts as expected if phoneContactInformation == null
	 * && lastName == null ParameterException is expected
	 */
	@Test
	public void testcase3() {

		try {
			controller.add("Fida", null, "M", "902141255", null);
			fail();//
		} catch (ParameterException e) {

			System.out.println("Ok, The expected Exception was caught");
		} catch (SizeLimitReachedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests whether the Method acts as expected if emailContactInformation == null
	 * no Exception is expected
	 */
	@Test
	public void testcase4() {

		try {
			controller.add("Fida", "Ahmadi", "M", "902141255", null);
			System.out.println("Ok, Runs as expected");
		} catch (ParameterException e) {
			fail();
			e.printStackTrace();
		} catch (SizeLimitReachedException e) {
			 
			e.printStackTrace();
		}

	}

	/**
	 * Tests whether the Method acts as expected if gender != 'F' && gender != 'M'
	 * ParameterException is expected
	 */
	@Test
	public void testcase5() {

		try {
			controller.add("Fida", "Ahmadi", "", null, "fida.ahmadi@test.de");
			fail();
		} catch (ParameterException e) {
			System.out.println("Ok, The expected Exception was caught");
			// e.printStackTrace();
		} catch (SizeLimitReachedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests whether the Method acts as expected if emailContactInformation == null
	 * && phoneContactInformation == null ParameterException is expected
	 */
	@Test
	public void testcase6() {

		try {
			controller.add("Fida", "Ahmadi", "M", null, null);
			System.out.println("Ok, as of the Methods java-doc");
		} catch (ParameterException e) {
			fail();
		} catch (SizeLimitReachedException e) {
			// TODO Auto-generated catch block

		}

	}

	@Test
	public void testcase7() {

		try {
			controller.add("Fida", null, "M", "902141255", "fida.ahmadi@test.de");
			fail();
		} catch (ParameterException e) {
			System.out.println("Ok, The expected Exception was caught");

		} catch (SizeLimitReachedException e) {
			System.out.println("Ok, The expected Exception was caught");
		}

	}

}
