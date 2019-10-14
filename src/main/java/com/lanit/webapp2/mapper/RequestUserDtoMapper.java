package com.lanit.webapp2.mapper;

import com.lanit.webapp2.dto.RequestUserDto;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;

@Component
public class RequestUserDtoMapper {
    public static final String PARAMETER_FIRSTNAME = "firstname";
    public static final String PARAMETER_MIDDLENAME = "middlename";
    public static final String PARAMETER_LASTNAME = "lastname";
    public static final String PARAMETER_BIRTHDATE = "birthdate";

    public RequestUserDto mapFromParams(String firstname, String middlename, String lastname, String birthdate) throws ParseException {
        return new RequestUserDto(firstname, middlename, lastname, LocalDate.parse(birthdate));
    }
}
