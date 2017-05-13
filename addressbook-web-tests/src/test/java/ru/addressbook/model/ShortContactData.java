package ru.addressbook.model;

public class ShortContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String email;

    public ShortContactData(String firstname, String middlename, String lastname, String email) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.email = email;
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
}
