package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.RequestAddressDto;
import com.lanit.webapp2.entity.Address;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveAddressException;

public class AddressDao extends AbstractDao {
    private static AddressDao instance = new AddressDao();

    protected AddressDao() {}

    public static AddressDao getInstance() {
        return instance;
    }

    public Address create(RequestAddressDto requestAddressDto, User user) throws FailedToSaveAddressException {
        Address address = new Address(requestAddressDto.getStreet(), requestAddressDto.getBuilding(), requestAddressDto.getApartments());
        address.setUser(user);

        try {
            insertRow(address);
        } catch (Exception e) {
            throw new FailedToSaveAddressException("Неудача при попытке сохранения адреса", e);
        }


        return address;
    }
}
