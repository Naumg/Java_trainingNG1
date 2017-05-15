package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ShortContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().createContact(new ShortContactData("Firstname", "Middlename", "Lastname",
                "aaa@billing.ru", "groupname2"));
    }
}
