package ru.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.addressbook.appmanager.ApplicationManager;

/**
 * Created by Naum.Ginzburg on 12.05.2017.
 */
public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.IE);

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
