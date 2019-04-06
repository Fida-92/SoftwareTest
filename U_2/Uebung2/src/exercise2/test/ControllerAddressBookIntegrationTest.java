/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Julia Martini
 * Technische Universität Berlin
 */
package exercise2.test;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.controller.AddressBookControllerImpl;
import exercise2.addressbook.controller.ParameterException;
import exercise2.addressbook.model.AddressBookModel;
import exercise2.addressbook.model.AddressBookModelImpl;
import exercise2.addressbook.model.SizeLimitReachedException;
import java.io.File;
import org.junit.Before;
import org.junit.Test;

/**
 * Uebung 2 - Komponenten und Integrationstest Integration Test für Addressbook
 * und Controller.
 *
 * Bitte Nummer der Gruppe eintragen: 2
 *
 * @author Jovine Kamegne Foka
 * @author Marcel Marks
 * @author Florian Duchow
 * @author Fida Ahmadi
 *
 */
public class ControllerAddressBookIntegrationTest {

    // Location of the address book file
    private static final File addressBookFile = new File("contacts.xml");

    /**
     * Aufgabe 4. Programmieren Sie einen Integrationstest für AddressBookModel
     * und AddressBookController. Testen Sie ob die Methoden des
     * exercise2.addressbook.controller.AddressBookController Interface zu den
     * erwarteten Resultate im Addressbuch führen. Testen Sie intensiv und
     * schreiben Sie MINDESTENS einen Testfall pro Methode des interfaces. Es
     * sind Fehler zu finden.
     */
     
    // Model component for the test
    AddressBookModel model;

    // View component for the test
    AddressBookViewMockUp view;

    // Controller component for the test
    AddressBookController controller;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // Instantiate and wire components
        this.model = new AddressBookModelImpl(addressBookFile);
        this.view = new AddressBookViewMockUp();
        this.controller = new AddressBookControllerImpl(model,
                view);
    }

    @Test
    public void testcaseAdd() {
        try {
            for (int i = 0; i < 10; i++) {
                controller.add("Mida" + i, "Ahmadi  " + i, "M", null,
                        "fida.ahmadi@test.de" + i);
            }

        } catch (ParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SizeLimitReachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void testcaseRemove() {
        try {
            controller.add("Mida", "Ahmadi  ", "M", null,
                    "fida.ahmadi@test.de");
            controller.remove(0);
            //        controller.remove(0);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testcaseErase() {
        //	controller.erase();
        try {
            for (int i = 0; i < 7; i++) {
                controller.add("Mida" + i, "Ahmadi  " + i, "M", null, "fida.ahmadi@test.de" + i);
            }
            controller.erase();
            System.err.println("getEntries() " + model.getEntries().size());
//            for (int i = 10; i < 20; i++) {
//                controller.add("Mida" + i, "Ahmadi  " + i, "M", null,
//                        "fida.ahmadi@test.de" + i);
//            }
        } catch (SizeLimitReachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
