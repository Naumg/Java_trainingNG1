package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ShortContactData;

import java.util.Collections;
import java.util.List;

/**
 * Created by Naum.Ginzburg on 13.05.2017.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.goTo().gotoHomePage();
        if (!app.contact().isThereAContact()) {
            app.contact().createContact(new ShortContactData("Firstname", null/*"Middlename"*/, "Lastname",
                    "aaa@billing.ru", null));
        }
        List<ShortContactData> before = app.contact().getShortContactList();
        app.contact().initContactModification(before.size() - 1);
        ShortContactData contact = new ShortContactData(before.get(before.size() - 1).getId(), "Firstname4", null/*"Middlename"*/, "Lastname4",
                "aaa@billing.ru", null);
        app.contact().fillContactForm(contact, false);
        app.contact().updateContactInfo();
        app.goTo().gotoHomePage();
        List<ShortContactData> after = app.contact().getShortContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size() - 1);
        before.add(contact);
        Collections.sort(before, ShortContactData.nameComparator);
        Collections.sort(after, ShortContactData.nameComparator);
        Assert.assertEquals(before, after);
    }
}

