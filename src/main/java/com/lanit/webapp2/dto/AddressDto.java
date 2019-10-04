package com.lanit.webapp2.dto;

public class AddressDto {
    private String street;
    private String building;
    private String apartments;
    private String userId;

    public AddressDto(String street, String building, String apartments, String userId) {
        this.street = street;
        this.building = building;
        this.apartments = apartments;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }
}
