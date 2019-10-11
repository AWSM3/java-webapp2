package com.lanit.webapp2.mapper;

import com.lanit.webapp2.dto.RequestUserDto;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Map;

@Component
public class RequestUserDtoMapper {
    public static final String PARAMETER_FIRSTNAME = "firstname";
    public static final String PARAMETER_MIDDLENAME = "middlename";
    public static final String PARAMETER_LASTNAME = "lastname";
    public static final String PARAMETER_BIRTHDATE = "birthdate";

    public RequestUserDto mapFromRequestParams(Map<String, String> requestParams) throws ParseException {
        return new RequestUserDto(
                (String) requestParams.get(PARAMETER_MIDDLENAME),
                (String) requestParams.get(PARAMETER_MIDDLENAME),
                (String) requestParams.get(PARAMETER_LASTNAME),
                LocalDate.parse((String) requestParams.get(PARAMETER_BIRTHDATE))
        );
    }
}
