package com.lanit.webapp2.controller;

import com.lanit.webapp2.dao.AddressDaoInterface;
import com.lanit.webapp2.dao.UserDaoInterface;
import com.lanit.webapp2.dto.RequestAddressDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveAddressException;
import com.lanit.webapp2.exception.UserNotFoundException;
import com.lanit.webapp2.mapper.RequestAddressDtoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.Map;

@Controller
public class CreateUserAddressController {
    public static final String URL = "/create/user/address";

    private RequestAddressDtoMapper requestAddressDtoMapper;
    private UserDaoInterface userDao;
    private AddressDaoInterface addressDao;

    public CreateUserAddressController(RequestAddressDtoMapper requestAddressDtoMapper, UserDaoInterface userDao, AddressDaoInterface addressDao) {
        this.requestAddressDtoMapper = requestAddressDtoMapper;
        this.userDao = userDao;
        this.addressDao = addressDao;
    }

    @GetMapping(URL)
    protected ModelAndView doGet(Model model) throws IOException {
        model.addAttribute("users", userDao.getList());

        return new ModelAndView("/address-add");
    }

    @PostMapping(URL)
    protected RedirectView doPost(@RequestParam Map<String,String> requestParams) throws IOException, FailedToSaveAddressException, UserNotFoundException {
        RequestAddressDto requestAddressDto = requestAddressDtoMapper.mapFromRequestParams(requestParams);
        User user = userDao.get(requestAddressDto.getUserId());
        addressDao.create(requestAddressDto, user);

        return new RedirectView("/");
    }
}
