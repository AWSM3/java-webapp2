package com.lanit.webapp2.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Type(type = "uuid-char")
    private UUID id;
    private String firstname;
    private String middlename;
    private String lastname;
    private LocalDate birthdate;
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "user",
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Address> addresses;

    public User() {

    }

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

    public User setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public User setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getMiddlename() {
        return middlename;
    }

    public User setMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public User setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public User setAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public String getFullname() {
        return String.format("%s %s %s (%s)", firstname, middlename, lastname, birthdate);
    }
}
