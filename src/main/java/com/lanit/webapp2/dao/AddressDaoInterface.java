package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.RequestAddressDto;
import com.lanit.webapp2.entity.Address;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveAddressException;

public interface AddressDaoInterface {
    public Address create(RequestAddressDto requestAddressDto, User user) throws FailedToSaveAddressException;
}
