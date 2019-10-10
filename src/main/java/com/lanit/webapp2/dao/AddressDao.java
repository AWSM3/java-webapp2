package com.lanit.webapp2.dao;

import com.lanit.webapp2.dto.RequestAddressDto;
import com.lanit.webapp2.entity.Address;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveAddressException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AddressDao extends AbstractDao {
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
