package ru.addressbook.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Naum.Ginzburg on 12.05.2017.
 */
public class SessionHelper extends HelperBase {

    public SessionHelper(ApplicationManager app) {
        super(app);
    }

    public void login(String username, String password) {
        type(By.name("user"), username);
        type(By.name("pass"), password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
