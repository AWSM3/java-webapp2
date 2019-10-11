package com.lanit.webapp2.controller;

import com.lanit.webapp2.dao.UserDaoInterface;
import com.lanit.webapp2.dto.RequestUserDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.exception.FailedToSaveUserException;
import com.lanit.webapp2.mapper.RequestUserDtoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

@Controller
public class CreateUserController {
    public static final String URL = "/user/create";

    private RequestUserDtoMapper requestUserDtoMapper;
    private UserDaoInterface userDao;

    public CreateUserController(RequestUserDtoMapper requestUserDtoMapper, UserDaoInterface userDao) {
        this.requestUserDtoMapper = requestUserDtoMapper;
        this.userDao = userDao;
    }

    @PostMapping(URL)
    protected RedirectView doPost(@RequestParam Map<String, String> requestParams) throws IOException, FailedToSaveUserException, ParseException {
        RequestUserDto requestUserDto = requestUserDtoMapper.mapFromRequestParams(requestParams);
        User createdUser = userDao.create(requestUserDto);

        return new RedirectView("/");
    }
}