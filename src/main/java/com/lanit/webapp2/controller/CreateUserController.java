package com.lanit.webapp2.controller;

import com.lanit.webapp2.dao.UserDao;
import com.lanit.webapp2.dto.RequestUserDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.mapper.RequestUserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CreateUserController {
    public static final String URL = "/user/create";

    private RequestUserDtoMapper requestUserDtoMapper;

    public CreateUserController(RequestUserDtoMapper requestUserDtoMapper) {
        this.requestUserDtoMapper = requestUserDtoMapper;
    }

    @PostMapping(URL)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            RequestUserDto requestUserDto = this.requestUserDtoMapper.mapFromRequest(request);
            User createdUser = UserDao.getInstance().create(requestUserDto);
            response.sendRedirect(String.format("/%s", request.getContextPath()));
        } catch (Exception e) {
            response.getWriter().write(String.format("Something wrong :< (%s)", e.getMessage()));
        }
    }
}