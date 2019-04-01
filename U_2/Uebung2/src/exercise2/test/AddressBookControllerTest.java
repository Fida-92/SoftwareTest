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
import org.junit.Before;
import org.junit.Test;

/**
 * Uebung 2 - Komponenten und Integrationstest Komponententests für den
 * Controller
 *
 * Bitte Nummer der Gruppe eintragen: 2
 *
 * Bitte Gruppenmitglieder eintragen:
 *
 * @author ...
 * @author ...
 * @author ...
 * @author ...
 */
public class AddressBookControllerTest {

    /*
     *  Aufgabe 3
     *  Führen Sie im Rahmen eines Komponententests der Klasse exercise2.addressbook.controller.AddressBookControllerImpl
     *   einen Test der Methode add(...) durch.
     *  Schreiben Sie für die model und view Komponenten Mock-Up Klassen und verwenden Sie dies im Komponententest
     * der AddressBookController Komponente.
     *  Testen Sie die add() Methode auf Herz und Nieren - es sind durchaus Fehler zu finden.
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
        this.controller = new AddressBookControllerImpl(model,
                view);
    }

    @Test
    public void testcase1() {

        try {
            controller.add("Mida", "Ahmadi", "M", null, "fida.ahmadi@test.de");
        } catch (ParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SizeLimitReachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testcase2() {

        try {
            controller.add(null, "Ahmadi", "M", null, "fida.ahmadi@test.de");
        } catch (ParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SizeLimitReachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testcase3() {

        try {
            controller.add("Mida", "null", "M", null, "fida.ahmadi@test.de");
        } catch (ParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SizeLimitReachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testcase4() {

        try {
            controller.add("Mida", "Ahmadi", "M", "902141255", null);
        } catch (ParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SizeLimitReachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testcase5() {

        try {
            controller.add("Mida", "Ahmadi", "", null, "fida.ahmadi@test.de");
        } catch (ParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SizeLimitReachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testcase6() {

        try {
            controller.add("Mida", "Ahmadi", "M", null, null);
        } catch (ParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SizeLimitReachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testcase7() {

        try {
            controller.add("Mida", null, "M", null, "fida.ahmadi@test.de");
        } catch (ParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SizeLimitReachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
