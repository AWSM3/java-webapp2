package com.lanit.webapp2.mapper;

import com.lanit.webapp2.dto.AddressDto;

import javax.servlet.http.HttpServletRequest;

public class AddressDtoMapper {
    public static final String PARAMETER_STREET = "street";
    public static final String PARAMETER_BUILDING = "building";
    public static final String PARAMETER_APARTMENTS = "apartments";
    public static final String PARAMETER_USER_ID = "user_id";

    public AddressDto mapFromRequest(HttpServletRequest request){
        return new AddressDto(
                request.getParameter(PARAMETER_STREET),
                request.getParameter(PARAMETER_BUILDING),
                request.getParameter(PARAMETER_APARTMENTS),
                request.getParameter(PARAMETER_USER_ID)
        );
    }
}
