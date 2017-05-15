package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ShortContactData;

/**
 * Created by Naum.Ginzburg on 13.05.2017.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ShortContactData("Firstname", "Middlename", "Lastname",
                    "aaa@billing.ru", "groupname2"));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        // Понятно, что не надо, но... для порядка
        app.getNavigationHelper().gotoHomePage();
    }
}
