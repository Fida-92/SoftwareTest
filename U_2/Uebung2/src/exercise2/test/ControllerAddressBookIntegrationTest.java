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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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

    // size-limit of the Collection (SortedSet)
    private static int ENTRY_MAX_SIZE = AddressBookModelImpl.sizeLimit;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // Instantiate and wire components
        this.model = new AddressBookModelImpl(addressBookFile);
        this.view = new AddressBookViewMockUp();
        this.controller = new AddressBookControllerImpl(model, view);
    }

    /**
     * noticed error: The expected SizeLimitReachedException is not thrown if
     * AddressBookModelImpl.sizeLimit is exceeded.
     */
    @Test
    public void testcaseAddMoreThanSizeLimit() {
        try {
            for (int i = 0; i < ENTRY_MAX_SIZE + 1; i++) {
                controller.add("Fida" + i, "Ahmadi  " + i, "M", null, "fida.ahmadi@test.de" + i);
            }
            // the method must fail
            fail();
        } catch (ParameterException e) {
        } catch (SizeLimitReachedException e) {
            // not OK, if reached
        }
    }

    @Test
    public void testcaseRemoveNotExistingEntry() {
        try {
            controller.add("Fida", "Ahmadi  ", "M", null, "fida.ahmadi@test.de");
            controller.add("Marcel", "Marks", "M", null, "marcel.marks@test.de");
            controller.remove(4);
            fail();

        } catch (Exception e) {
            // Ok, if reached;
        }
    }

    @Test
    public void testcaseRemoveCheckSizeAfterRemove() {
        try {
            controller.add("Fida", "Ahmadi  ", "M", null, "fida.ahmadi@test.de");
            controller.add("Marcel", "Marks", "M", null, "marcel.marks@test.de");
            controller.remove(0);
            assertEquals(this.model.getEntries().size(), 1);

        } catch (Exception e) {
            // not Ok, if reached;
            fail();
        }
    }

    @Test
    public void testcaseRemove() {
        try {
            controller.add("Fida", "Ahmadi  ", "M", null, "fida.ahmadi@test.de");
            controller.add("Marcel", "Marks", "M", null, "marcel.marks@test.de");
            int count = 0;
            while (count < 4) {
                controller.remove(count);
                count++;
            }
            fail();

        } catch (Exception e) {
            // Ok, if reached;

        }
    }

    /**
     * noticed error: the Method erase(Entry entry) is not working properly as
     * its implementation is not correct (see the line 129 => while
     * (!entryIt.hasNext()) of the AddressBookControllerImpl class).
     */
    @Test
    public void testcaseEraseAllEntries() {
        try {
            for (int i = 0; i < ENTRY_MAX_SIZE - 3; i++) {
                this.controller.add("Fida" + i, "Ahmadi  " + i, "M", null, "fida.ahmadi@test.de" + i);
            }
            this.controller.erase();

            System.err.println("getEntries() " + model.getEntries().size());

        } catch (SizeLimitReachedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParameterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
