package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/Bond.jpg");
        ContactData contact = new ContactData().withFirstname("Firstname1").withLastname("Lastname1").withEmail("aaa@billing.ru")
                .withPhoto(photo);
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

}

