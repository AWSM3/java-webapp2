package com.lanit.webapp2.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "adressess")
public class Address {
    @Id
    @Type(type = "uuid-char")
    private UUID id;
    private String street;
    private String building;
    private String apartments;
    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    public Address() {}

    public Address(UUID id, String street, String building, String apartments) {
        this.id = id;
        this.street = street;
        this.building = building;
        this.apartments = apartments;
    }

    public Address(String street, String building, String apartments) {
        this.id = UUID.randomUUID();
        this.street = street;
        this.building = building;
        this.apartments = apartments;
    }

    public UUID getId() {
        return id;
    }

    public Address setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getBuilding() {
        return building;
    }

    public Address setBuilding(String building) {
        this.building = building;
        return this;
    }

    public String getApartments() {
        return apartments;
    }

    public Address setApartments(String apartments) {
        this.apartments = apartments;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Address setUser(User user) {
        this.user = user;
        return this;
    }
}
