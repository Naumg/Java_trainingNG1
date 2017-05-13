package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ShortContactData;

/**
 * Created by Naum.Ginzburg on 13.05.2017.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        // Ошибка отсутствия редактируемых записей пока не обрабатывается
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ShortContactData("Firstnamemod", "Middlenamemod", "Lastnamemod", "aaamod@billing.ru"));
        app.getContactHelper().updateContactInfo();
        app.getNavigationHelper().gotoHomePage();
    }
}

