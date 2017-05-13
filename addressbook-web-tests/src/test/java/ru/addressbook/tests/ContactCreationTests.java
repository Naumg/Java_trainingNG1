package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ShortContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoEditContactPage();
        app.getContactHelper().fillContactForm(new ShortContactData("Firstname", "Middlename", "Lastname", "aaa@billing.ru"));
        app.getContactHelper().submitContactInfo();
        app.getNavigationHelper().gotoHomePage();
    }

}
