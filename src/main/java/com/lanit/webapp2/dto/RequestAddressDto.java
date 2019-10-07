package com.lanit.webapp2.dto;

public class RequestAddressDto {
    private final String street;
    private final String building;
    private final String apartments;
    private final String userId;

    public RequestAddressDto(String street, String building, String apartments, String userId) {
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
