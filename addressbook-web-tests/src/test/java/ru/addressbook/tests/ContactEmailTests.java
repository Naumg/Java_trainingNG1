package ru.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Naum.Ginzburg on 12.05.2017.
 */
public class ContactEmailTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().createContactWithTestData();
        }
    }

    @Test
    public void testContactEmails() {
        ContactData contact = app.contact().all().iterator().next();
        ContactData emailInfoFromEditForm = app.contact().infoFromEditForm(contact);

//        assertThat(contact.getAllEmails(), equalTo(mergeEmails(emailInfoFromEditForm)));
        String tempReplacedStr = contact.getAllEmails().replaceAll("\n", "");
        assertThat(tempReplacedStr, equalTo(mergeEmails(emailInfoFromEditForm)));
    }

    private String mergeEmails(ContactData contact) {
//        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
//                .stream().filter((s) -> !s.equals(""))
//                .map(ContactEmailTests::cleaned)
//                .collect(Collectors.joining("\n"));
        return contact.getEmail() + contact.getEmail2() + contact.getEmail3();
    }

    public static String cleaned(String email) {
        return email.replaceAll("\\s", "");
    }

}
