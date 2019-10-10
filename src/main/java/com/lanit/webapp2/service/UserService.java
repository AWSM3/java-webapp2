package com.lanit.webapp2.service;

import com.lanit.webapp2.dao.UserDao;
import com.lanit.webapp2.dto.AddressDto;
import com.lanit.webapp2.dto.UserDto;
import com.lanit.webapp2.entity.Address;
import com.lanit.webapp2.entity.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class UserService {
    protected UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserDto> getUsersList() {
        List<User> users = userDao.getListWithFetchingLazy(); // todo: pagination
        List<UserDto> list = new ArrayList<>();

        for (User user : users) {
            UserDto userDto = new UserDto(user.getId(), user.getFullname(), user.getBirthdate());
            List<AddressDto> addressesList = new ArrayList<>();
            for (Address address : user.getAddresses()) {
                addressesList.add(new AddressDto(address.getStreet(), address.getBuilding(), address.getApartments()));
            }

            userDto.setAddresses(addressesList);
            list.add(userDto);
        }
        return list;
    }
}