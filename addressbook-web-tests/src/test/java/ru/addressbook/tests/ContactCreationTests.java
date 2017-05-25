package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ShortContactData;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().gotoHomePage();
        List<ShortContactData> before = app.contact().getShortContactList();
        ShortContactData contact = new ShortContactData("Firstname", null/*"Middlename"*/, "Lastname",
                "aaa@billing.ru", null);
        app.contact().createContact(contact);
        List<ShortContactData> after = app.contact().getShortContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (ShortContactData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }

        contact.setId(max);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

        Collections.sort(before);
        Collections.sort(after);
        Assert.assertEquals(before, after);
    }
}
