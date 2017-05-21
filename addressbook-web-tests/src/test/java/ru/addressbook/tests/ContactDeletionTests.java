package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ShortContactData;

import java.util.List;

/**
 * Created by Naum.Ginzburg on 13.05.2017.
 */
public class ContactDeletionTests extends TestBase {

    @Test(enabled = false)
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ShortContactData("Firstname", null/*"Middlename"*/, "Lastname",
                    "aaa@billing.ru", "groupname2"));
        }
        List<ShortContactData> before = app.getContactHelper().getShortContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHomePage();
        List<ShortContactData> after = app.getContactHelper().getShortContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
