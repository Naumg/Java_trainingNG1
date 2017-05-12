package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

/**
 * Created by Naum.Ginzburg on 12.05.2017.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("groupname3ed", "groupheader3td", "groupfooter3ed"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();

    }
}
