package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ShortContactData;

/**
 * Created by Naum.Ginzburg on 13.05.2017.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();

        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ShortContactData("Firstname", "Middlename", "Lastname",
                    "aaa@billing.ru", null));
        }


        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ShortContactData("Firstnamemod", "Middlenamemod", "Lastnamemod",
                "aaamod@billing.ru", null), false);
        app.getContactHelper().updateContactInfo();
        app.getNavigationHelper().gotoHomePage();
    }
}

