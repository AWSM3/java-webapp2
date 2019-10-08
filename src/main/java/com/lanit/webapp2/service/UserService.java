package com.lanit.webapp2.service;

import com.lanit.webapp2.dao.UserDao;
import com.lanit.webapp2.dto.AddressDto;
import com.lanit.webapp2.dto.UserDto;
import com.lanit.webapp2.entity.Address;
import com.lanit.webapp2.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    protected static final UserService instance = new UserService();

    protected UserService() {}

    public static UserService getInstance() {
        return instance;
    }

    public List<UserDto> getUsersList() {
        List<User> users = UserDao.getInstance().getListWithFetchingLazy(); // todo: pagination
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