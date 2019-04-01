/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Julia Martini
 * Technische Universität Berlin
 */
package exercise2.test;

import exercise2.addressbook.model.AddressBookModel;
import exercise2.addressbook.model.Entry;
import exercise2.addressbook.model.SizeLimitReachedException;
import java.io.IOException;
import java.util.Collection;

/**
 * Uebung 2 - Komponenten und Integrationstest Mock-Up für das AddressBookModel
 *
 * Bitte Nummer der Gruppe eintragen: 2
 *
 * @author Jovine Kamegne Foka
 * @author Marcel Marks
 * @author Florian Duchow
 * @author Fida Ahmadi
 */
public class AddressBookModelMockUp implements AddressBookModel {

    @Override
    public boolean addEntry(Entry entry) throws SizeLimitReachedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entry getEntry(String surName, String firstName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Entry> getEntries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteEntry(Entry entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void erase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // TODO: Mock-Up erstellen
}
