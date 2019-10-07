package com.lanit.webapp2.mapper;

import com.lanit.webapp2.dto.RequestAddressDto;

import javax.servlet.http.HttpServletRequest;

public class RequestAddressDtoMapper {
    public static final String PARAMETER_STREET = "street";
    public static final String PARAMETER_BUILDING = "building";
    public static final String PARAMETER_APARTMENTS = "apartments";
    public static final String PARAMETER_USER_ID = "user_id";

    public RequestAddressDto mapFromRequest(HttpServletRequest request){
        return new RequestAddressDto(
                request.getParameter(PARAMETER_STREET),
                request.getParameter(PARAMETER_BUILDING),
                request.getParameter(PARAMETER_APARTMENTS),
                request.getParameter(PARAMETER_USER_ID)
        );
    }
}
