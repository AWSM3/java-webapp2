package com.lanit.webapp2.dto;

import java.time.LocalDate;

public class RequestUserDto {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final LocalDate birthdate;

    public RequestUserDto(String firstname, String middlename, String lastname, LocalDate birthdate) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.birthdate = birthdate;
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
