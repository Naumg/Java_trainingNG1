package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.Contacts;
import ru.addressbook.model.ShortContactData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ShortContactData contact = new ShortContactData().withFirstname("Firstname1").withLastname("Lastname1").withEmail("aaa@billing.ru");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        int max = 0;
        for (ShortContactData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        assertThat(after, equalTo(before.withAdded(contact.withId(max))));
    }
}
