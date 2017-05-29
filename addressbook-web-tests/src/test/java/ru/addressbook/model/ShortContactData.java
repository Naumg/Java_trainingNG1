package ru.addressbook.model;

import java.util.Comparator;

public class ShortContactData implements Comparable<ShortContactData> {

    private int id;
    private static String group;
    private String firstname;
    private String middlename;
    private String lastname;
    private String email;

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShortContactData that = (ShortContactData) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
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

    public ShortContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ShortContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ShortContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ShortContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ShortContactData withEmail(String email) {
        this.email = email;
        return this;
    }


    public static String getGroup() {
        return group;
    }

    public void setId(int id) {
        this.id = id;
    }






    @Override
    public int compareTo(ShortContactData otherShortContactData) {
//        System.out.println("this.getId()= " + this.getId() + " otherShortContactData.getId()= " + otherShortContactData.getId());
        return -otherShortContactData.getId() + this.getId();
//        return -(otherGroupData.getName().compareTo(this.getName()));

    }

    /*
    * Comparator to sort employees list or array in order of name
    */
    public static Comparator<ShortContactData> nameComparator = new Comparator<ShortContactData>() {
        public int compare(ShortContactData g1, ShortContactData g2) {
            return g1.getId() - g2.getId();
        }
    };
}
