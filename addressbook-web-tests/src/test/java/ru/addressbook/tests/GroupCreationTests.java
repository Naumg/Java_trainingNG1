package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("groupname3", "groupheader3", "groupfooter3"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }


}
