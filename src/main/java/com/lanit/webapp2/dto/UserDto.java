package com.lanit.webapp2.dto;

import java.time.LocalDate;
import java.util.List;

public class UserDto {
    private final String fullname;
    private final LocalDate birthdate;
    private List<AddressDto> addresses;

    public UserDto(String fullname, LocalDate birthdate) {
        this.fullname = fullname;
        this.birthdate = birthdate;
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
