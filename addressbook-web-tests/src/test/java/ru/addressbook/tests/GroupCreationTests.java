package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Naum.Ginzburg on 12.05.2017.
 */
public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("Test group");
        app.group().create(group);

        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));

//   In Java 7 lambda function absents
//        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
//        before.add(group);
//        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        group.withId(max);
        System.out.println("Collections.max(before)= " + Collections.max(before));
        before.add(group);
        Assert.assertEquals(before, after);
//        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
//        assertThat(after, equalTo(
//                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


    }

    @Test
    public void testBadGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("Test group'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }


}
