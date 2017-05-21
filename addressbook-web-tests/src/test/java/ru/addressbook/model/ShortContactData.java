package ru.addressbook.model;

import java.util.Comparator;

public class ShortContactData implements Comparable<ShortContactData> {

    private int id;
    private static String group;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String email;

    public ShortContactData(Integer id, String firstname, String middlename, String lastname, String email, String group) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.email = email;
        this.group = group;
    }

    public ShortContactData(String firstname, String middlename, String lastname, String email, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.email = email;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShortContactData that = (ShortContactData) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
//        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public static String getGroup() {
        return group;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(ShortContactData otherShortContactData) {
        System.out.println("this.getId()= " + this.getId() + " otherShortContactData.getId()= " + otherShortContactData.getId());
        return -otherShortContactData.getId() + this.getId();
//        return -(otherGroupData.getName().compareTo(this.getName()));

    }

    /*
    * Comparator to sort employees list or array in order of name
    */
    public static Comparator<ShortContactData> nameComparator = new Comparator<ShortContactData>() {
        public int compare(ShortContactData g1, ShortContactData g2) {
            System.out.println("g1.getId()= " + g1.getId() + " g2.getId()= " + g2.getId());
            return g1.getId() - g2.getId();
        }
    };
}
