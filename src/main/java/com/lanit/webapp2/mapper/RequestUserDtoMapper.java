package com.lanit.webapp2.mapper;

import com.lanit.webapp2.dto.RequestUserDto;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.time.LocalDate;

public class RequestUserDtoMapper {
    public static final String PARAMETER_FIRSTNAME = "firstname";
    public static final String PARAMETER_MIDDLENAME = "middlename";
    public static final String PARAMETER_LASTNAME = "lastname";
    public static final String PARAMETER_BIRTHDATE = "birthdate";

    public RequestUserDto mapFromRequest(HttpServletRequest request) throws ParseException {
        return new RequestUserDto(
            request.getParameter(PARAMETER_MIDDLENAME),
            request.getParameter(PARAMETER_MIDDLENAME),
            request.getParameter(PARAMETER_LASTNAME),
            LocalDate.parse(request.getParameter(PARAMETER_BIRTHDATE))
        );
    }
}