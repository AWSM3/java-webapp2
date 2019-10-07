package com.lanit.webapp2.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class UserDto {
    private UUID id;
    private final String fullname;
    private final LocalDate birthdate;
    private List<AddressDto> addresses;

    public UserDto(UUID id, String fullname, LocalDate birthdate) {
        this.id = id;
        this.fullname = fullname;
        this.birthdate = birthdate;
    }

    public UUID getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public List<AddressDto> getAddresses() {
        return addresses;
    }

    public UserDto setAddresses(List<AddressDto> addresses) {
        this.addresses = addresses;

        return this;
    }
}
