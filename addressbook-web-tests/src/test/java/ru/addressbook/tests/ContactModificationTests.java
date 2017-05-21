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
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ShortContactData("Firstname", null/*"Middlename"*/, "Lastname",
                    "aaa@billing.ru", null));
        }
        List<ShortContactData> before = app.getContactHelper().getShortContactList();
        app.getContactHelper().initContactModification(before.size() - 1);
        ShortContactData contact = new ShortContactData(before.get(before.size() - 1).getId(), "Firstname", null/*"Middlename"*/, "Lastname",
                "aaa@billing.ru", null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().updateContactInfo();
        app.getNavigationHelper().gotoHomePage();
        List<ShortContactData> after = app.getContactHelper().getShortContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size() - 1);
        before.add(contact);
        Collections.sort(before, ShortContactData.nameComparator);
        System.out.println("before= "+before.toString());
        Collections.sort(after, ShortContactData.nameComparator);
        System.out.println("after = "+after.toString());
        Assert.assertEquals(before, after);
    }
}

