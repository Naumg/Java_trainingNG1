package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ShortContactData;

import java.util.List;

/**
 * Created by Naum.Ginzburg on 13.05.2017.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.goTo().gotoHomePage();
        if (!app.contact().isThereAContact()) {
            app.contact().createContact(new ShortContactData("Firstname", null/*"Middlename"*/, "Lastname",
                    "aaa@billing.ru", "groupname2"));
        }
        List<ShortContactData> before = app.contact().getShortContactList();
        app.contact().selectContact(before.size() - 1);
        app.contact().deleteContact();
        app.goTo().gotoHomePage();
        List<ShortContactData> after = app.contact().getShortContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
