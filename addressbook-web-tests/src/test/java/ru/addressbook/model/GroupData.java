package ru.addressbook.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GroupData implements Comparable<GroupData> {
    private int id;
    private final String name;
    private final String header;
    private final String footer;

    public GroupData(String name, String header, String footer) {
        this.id = 0;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public GroupData(int id, String name, String header, String footer) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        GroupDataArrayList.add(new GroupData(99, "50Test group", "Group Header", "Group Footer"));
        GroupDataArrayList.add(new GroupData(90, "60Test group", "Group Header", "Group Footer"));
        GroupDataArrayList.add(new GroupData(80, "70Test group", "Group Header", "Group Footer"));
        GroupDataArrayList.add(new GroupData(98, "55Test group", "Group Header", "Group Footer"));
        GroupDataArrayList.add(new GroupData(60, "90Test group", "Group Header", "Group Footer"));

        //Sort elements
        Collections.sort(GroupDataArrayList);
        for (int i = 0; i < GroupDataArrayList.toArray().length; i++) {
            System.out.println(GroupDataArrayList.get(i).getId() + " " + GroupDataArrayList.get(i).getName());
        }

        Collections.sort(GroupDataArrayList, nameComparator);
        for (int i = 0; i < GroupDataArrayList.toArray().length; i++) {
            System.out.println(GroupDataArrayList.get(i).getId() + " " + GroupDataArrayList.get(i).getName());
        }
    }
}