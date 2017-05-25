package ru.addressbook.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GroupData implements Comparable<GroupData> {
    private int id = Integer.MAX_VALUE;
    private String name;
    private String header;
    private String footer;

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return name != null ? name.equals(groupData.name) : groupData.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(GroupData otherGroupData) {
        return -otherGroupData.getId() + this.getId();
//        return -(otherGroupData.getName().compareTo(this.getName()));

    }

    /*
    * Comparator to sort employees list or array in order of name
    */
    public static Comparator<GroupData> nameComparator = new Comparator<GroupData>() {

        @Override
        public int compare(GroupData g1, GroupData g2) {
            return g1.getName().compareTo(g2.getName());
        }
    };

    public static void main(String[] args) {
        ArrayList<GroupData> GroupDataArrayList = new ArrayList<GroupData>();

        //Добавление элементов

        GroupDataArrayList.add(new GroupData().withId(99).withName("50Test group").withHeader("Group Header").withFooter("Group Footer"));
        GroupDataArrayList.add(new GroupData().withId(90).withName("60Test group").withHeader("Group Header").withFooter("Group Footer"));
        GroupDataArrayList.add(new GroupData().withId(80).withName("70Test group").withHeader("Group Header").withFooter("Group Footer"));
        GroupDataArrayList.add(new GroupData().withId(98).withName("55Test group").withHeader("Group Header").withFooter("Group Footer"));
        GroupDataArrayList.add(new GroupData().withId(60).withName("90Test group").withHeader("Group Header").withFooter("Group Footer"));

        //Sort elements
        Collections.sort(GroupDataArrayList);
        for (int i = 0; i < GroupDataArrayList.toArray().length; i++) {
            System.out.println(GroupDataArrayList.get(i).getId() + " " + GroupDataArrayList.get(i).getName());
        }

        Collections.sort(GroupDataArrayList, nameComparator);
    }
}