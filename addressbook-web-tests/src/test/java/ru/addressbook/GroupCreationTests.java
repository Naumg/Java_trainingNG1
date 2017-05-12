package ru.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("groupname3", "groupheader3", "groupfooter3"));
        submitGroupCreation();
        returnToGroupPage();
    }


}
