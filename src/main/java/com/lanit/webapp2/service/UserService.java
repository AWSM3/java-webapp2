package com.lanit.webapp2.service;

import com.lanit.webapp2.dao.UserDaoInterface;
import com.lanit.webapp2.dto.AddressDto;
import com.lanit.webapp2.dto.UserDto;
import com.lanit.webapp2.entity.Address;
import com.lanit.webapp2.entity.User;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    protected UserDaoInterface userDao;

    public UserService(UserDaoInterface userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public List<UserDto> getUsersList() {
        List<User> users = userDao.getList(); // todo: pagination
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