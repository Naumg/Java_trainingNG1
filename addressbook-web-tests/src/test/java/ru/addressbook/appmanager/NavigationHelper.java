package ru.addressbook.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Naum.Ginzburg on 12.05.2017.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void groupPage() {
//        if (isElementPresent(By.tag))
        if (isElementPresent(By.xpath("//div[@id='content']//h1[.='Groups']"))
//
//            isElementPresent(By.tagName("h1"))
//              Данное условие не работает: возвращается пустая строка ""
//          &&  wd.findElements(By.tagName("h1")).getText().equals("Groups")
//              Если найден правильный элемент - все работает
//          &&  wd.findElement(By.xpath("//div[@id='content']//h1[.='Groups']")).getText().equals("Groups")
//
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));

    }

    public void gotoEditContactPage() {
        // Ситуация экзотична, но... для единообразия
        if (isElementPresent(By.xpath("//div[@id='content']//h1[.='Edit / add address book entry']"))) {
            return;
        }
        click(By.linkText("add new"));
    }

    public void gotoHomePage() {
//        System.out.println("Nav helper 40" + isElementPresent(By.id("maintable")));
//        if (isElementPresent(By.id("maintable"))) {
//            return;
//        }
        click(By.linkText("home"));
    }
}
