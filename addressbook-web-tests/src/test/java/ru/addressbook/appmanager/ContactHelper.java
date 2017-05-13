package ru.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ru.addressbook.model.ShortContactData;

/**
 * Created by Naum.Ginzburg on 13.05.2017.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(InternetExplorerDriver wd) {
        super(wd);
    }

    public void submitContactInfo() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

     public void gotoEditContactPage() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ShortContactData shortContactData) {
        type(By.name("firstname"),shortContactData.getFirstname());
        type(By.name("middlename"),shortContactData.getMiddlename());
        type(By.name("lastname"),shortContactData.getLastname());
        type(By.name("email"),shortContactData.getEmail());
    }


}
