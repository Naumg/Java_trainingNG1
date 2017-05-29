package ru.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

/**
 * Created by Naum.Ginzburg on 12.05.2017.
 */
public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("Test group"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("Test group modified").withHeader("Modified group header").withFooter("Modified group footer");
        app.group().modify(group);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size());
// Срабатывает не каждый раз, что-то с драйвером, видимо
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
//
//
//        List<GroupData> before = app.group().list();
//        int index = before.size() - 1;
//        GroupData group = new GroupData()
//                .withId(before.get(index).getId()).withName("Test group modified").withHeader("Modified group header").withFooter("Modified group footer");
//        app.group().modify(index, group);
//        List<GroupData> after = app.group().list();
//        Assert.assertEquals(after.size(), before.size());
//
//        before.remove(index);
//        before.add(group);
//        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
