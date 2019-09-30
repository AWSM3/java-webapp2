package com.lanit.webapp2.mapper;

import com.lanit.webapp2.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class UserDtoMapper {
    public static final String PARAMETER_FIRSTNAME = "firstname";
    public static final String PARAMETER_MIDDLENAME = "middlename";
    public static final String PARAMETER_LASTNAME = "lastname";
    public static final String PARAMETER_BIRTHDATE = "birthdate";

    public UserDto mapFromRequest(HttpServletRequest request) throws ParseException {
        return new UserDto(
            request.getParameter(PARAMETER_MIDDLENAME),
            request.getParameter(PARAMETER_MIDDLENAME),
            request.getParameter(PARAMETER_LASTNAME),
            LocalDate.parse(request.getParameter(PARAMETER_BIRTHDATE))
        );
    }
}
