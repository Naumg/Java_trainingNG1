package ru.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Naum.Ginzburg on 25.05.2017.
 */
public class Groups extends ForwardingSet<GroupData> /*implements Comparable<Groups>*/ {

    private Set<GroupData> delegate;

    public Groups(Groups groups) {
        this.delegate = new TreeSet(groups.delegate());
//        this.delegate = new HashSet<GroupData>(groups.delegate());
    }

    public Groups() {
        this.delegate = new TreeSet();
//        this.delegate = new HashSet<GroupData>();
    }

    @Override
    protected Set delegate() {
        return delegate;
    }

    public Groups withAdded(GroupData group) {
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without(GroupData group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
//    @Override
//    public int compareTo(Groups otherGroups) {
//        return -otherGroupData.getId() + this.getId();
//    }
}
