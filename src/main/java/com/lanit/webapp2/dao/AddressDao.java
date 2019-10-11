package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.RequestAddressDto;
import com.lanit.webapp2.entity.Address;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveAddressException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AddressDao extends AbstractDao implements AddressDaoInterface {
    @Override
    @Transactional
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
