package ru.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Naum.Ginzburg on 13.05.2017.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        // По аналогии с тестом удаления группы
        // отсутствие записей в тесте пока не обрабатывается
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        // Понятно, что не надо, но... для порядка
        app.getNavigationHelper().gotoHomePage();
    }
}
