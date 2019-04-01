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
public class AddressBookModelMockUp implements
        AddressBookModel {

    // true,wenn adressbuch voll
    public boolean full;

    @Override
    public boolean addEntry(Entry entry) throws
            SizeLimitReachedException {
        System.out.println("add");
        return true;
    }

    /* (non-Javadoc)
     * @see exercise2.addressbook.model.AddressBookAccess#getEntry(java.lang.String, java.lang.String)
     */
    @Override
    public Entry getEntry(String surName, String firstName) {
        System.out.println("get");
        return null;
    }

    /* (non-Javadoc)
     * @see exercise2.addressbook.model.AddressBookAccess#deleteEntry(exercise2.addressbook.model.Entry)
     */
    @Override
    public boolean deleteEntry(Entry entry) {
        System.out.println("del");
        return true;
    }

    /* (non-Javadoc)
     * @see exercise2.addressbook.model.AddressBookAccess#erase()
     */
    @Override
    public void erase() {
        System.out.println("erase");
    }

    /*
     * (non-Javadoc)
     * @see exercise2.addressbook.model.AddressBookAccess#getEntries()
     */
    @Override
    public Collection< Entry> getEntries() {
        System.out.println("getEntries");
        return null;
    }

    /*
     * (non-Javadoc)
     * @see exercise2.addressbook.model.PersistenceAccess#load()
     */
    public void load() throws IOException {
        System.out.println("load");
    }

    /*
     * (non-Javadoc)
     * @see exercise2.addressbook.model.PersistenceAccess#save()
     */
    public void save() throws IOException {
        System.out.println("save");
    }

}
