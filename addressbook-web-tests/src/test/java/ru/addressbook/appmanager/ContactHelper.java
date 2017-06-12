package ru.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by Naum.Ginzburg on 13.05.2017.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager app) {
        super(app);
    }

    public void submitContactInfo() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
//        type(By.name("middlename"), shortContactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        if (ContactData.getGroup() != null) {
            if (creation) {
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(ContactData.getGroup());
            } else {
                Assert.assertFalse(isElementPresent(By.name("new_group")));
            }
        }
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteContact() {
        click(By.cssSelector("input[value='Delete']"));
//          В одну строку wd.switchTo().alert().accept(); не проходит
        Alert alert = wd.switchTo().alert();
        alert.accept();
    }

    public void initContactModification(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    public void updateContactInfo() {
        click(By.name("update"));
    }


    public void create(ContactData shortContact) {
        app.goTo().gotoEditContactPage();
        fillContactForm(shortContact, true);
        submitContactInfo();
        contactCache = null;
        app.goTo().homePage();
    }

    public void modify(ContactData contact) {
        app.contact().initContactModification(contact.getId());
        app.contact().fillContactForm(contact, false);
        app.contact().updateContactInfo();
        contactCache = null;
        app.goTo().homePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        click(By.cssSelector("input[value='Delete']"));
        Alert alert = wd.switchTo().alert();
        alert.accept();
        app.goTo().homePage();
    }

    //    // Check
//    public Contacts all() {
//        Contacts contacts = new Contacts();
//        List<WebElement> elements = wd.findElements(By.cssSelector("input[name='selected[]']"));
//        for (WebElement element : elements) {
//            int id = Integer.parseInt(element.getAttribute("value"));
//            String title = element.getAttribute("title").substring(7);
//            String firstname = title.substring(1, title.indexOf(' '));
////            String middlename = title.substring(title.indexOf(' ') + 1, title.length() - 1);    //!!!!!!
//            String lastname = title.substring(title.indexOf(' ') + 1, title.length() - 1);
//            String email = element.getAttribute("accept");
//
//            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withEmail(email);
//            contacts.add(contact);
//        }
//        return contacts;
//    }
    public ContactData infoFromEditForm(ContactData contact) {
        app.contact().initContactModification(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withAddress(address)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
                .withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAddress(address)
                    .withAllEmails(allEmails).withAllPhones(allPhones);
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }

    public void createContactWithTestData() {
        app.contact().create(new ContactData().withFirstname("Александр").withLastname("Соколов")
                .withAddress("г. Тверь ул. Желябова 36 кв. 12")
                .withEmail("email@mail.ru").withEmail2("email2@mail.ru").withEmail3("email3@mail.ru")
                .withHomePhone("+7(4822)261299").withMobilePhone("+7(920)9213355").withWorkPhone("+7(4822)835554"));
    }

}

