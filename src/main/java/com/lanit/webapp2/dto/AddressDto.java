package com.lanit.webapp2.dto;

public class AddressDto {
    private final String street;
    private final String building;
    private final String apartments;

    public AddressDto(String street, String building, String apartments) {
        this.street = street;
        this.building = building;
        this.apartments = apartments;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding() {
        return building;
    }

    public String getApartments() {
        return apartments;
    }
}
