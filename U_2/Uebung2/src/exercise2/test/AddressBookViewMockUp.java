/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Julia Martini
 * Technische Universität Berlin
 */
package exercise2.test;

import exercise2.addressbook.controller.AddressBookController;
import exercise2.addressbook.model.AddressBookAccess;
import exercise2.addressbook.view.AddressBookView;

/**
 * Uebung 2 - Komponenten und Integrationstest Mock-Up für den AddressBookView
 *
 * Bitte Nummer der Gruppe eintragen: 2
 * @author Jovine Kamegne Foka
 * @author Marcel Marks
 * @author Florian Duchow
 * @author Fida Ahmadi
 */
public class AddressBookViewMockUp implements AddressBookView {

    @Override
    public void create(AddressBookAccess model, AddressBookController controller) {
    	System.out.println("AddressBookView created");
    }

    @Override
    public void refresh() {
    	System.out.println("AddressBookView refreshed");
    }
 }
