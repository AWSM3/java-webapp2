package com.lanit.webapp2.entity;

import java.time.LocalDate;
import java.util.UUID;

public class User {
    private UUID id;
    private String firstname;
    private String middlename;
    private String lastname;
    private LocalDate birthdate;

    public User(String firstname, String middlename, String lastname, LocalDate birthdate) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public User(UUID id, String firstname, String middlename, String lastname, LocalDate birthdate) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    public UUID getId() {
        return id;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }
}
