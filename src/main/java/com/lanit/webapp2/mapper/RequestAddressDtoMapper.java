package com.lanit.webapp2.mapper;

import com.lanit.webapp2.dto.RequestAddressDto;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class RequestAddressDtoMapper {
    public static final String PARAMETER_STREET = "street";
    public static final String PARAMETER_BUILDING = "building";
    public static final String PARAMETER_APARTMENTS = "apartments";
    public static final String PARAMETER_USER_ID = "user_id";

    public RequestAddressDto mapFromRequestParams(Map requestParams){
        return new RequestAddressDto(
                (String) requestParams.get(PARAMETER_STREET),
                (String) requestParams.get(PARAMETER_BUILDING),
                (String) requestParams.get(PARAMETER_APARTMENTS),
                (String) requestParams.get(PARAMETER_USER_ID)
        );
    }
}
