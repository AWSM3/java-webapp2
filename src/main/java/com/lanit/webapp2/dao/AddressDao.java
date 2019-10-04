package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.AddressDto;
import com.lanit.webapp2.entity.Address;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveAddressException;

public class AddressDao extends AbstractDao {
    public Address create(AddressDto addressDto, User user) throws FailedToSaveAddressException {
        Address address = new Address(addressDto.getStreet(), addressDto.getBuilding(), addressDto.getApartments());
        address.setUser(user);

        try {
            insertRow(address);
        } catch (Exception e) {
            throw new FailedToSaveAddressException("Неудача при попытке сохранения адреса", e);
        }


        return address;
    }
}
