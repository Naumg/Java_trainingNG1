package ru.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by Naum.Ginzburg on 12.05.2017.
 */
public class NavigationHelper extends HelperBase {
//    private InternetExplorerDriver wd;

    public NavigationHelper(InternetExplorerDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }
}
