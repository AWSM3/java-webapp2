package com.lanit.webapp2.servlet;

import com.lanit.webapp2.dto.UserDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.mapper.UserDtoMapper;
import com.lanit.webapp2.dao.UserDaoInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {CreateUserServlet.URL})
public class CreateUserServlet extends HttpServlet {
    public static final String URL = "/user/create";

    private UserDaoInterface userDao;
    private UserDtoMapper userDtoMapper;

    @Override
    public void init() throws ServletException {
        this.userDao = (UserDaoInterface) getServletContext().getAttribute(UserDaoInterface.class.getSimpleName());
        this.userDtoMapper = (UserDtoMapper) getServletContext().getAttribute(UserDtoMapper.class.getSimpleName());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserDto userDto = this.userDtoMapper.mapFromRequest(request);
            User createdUser = userDao.create(userDto);
            response.getWriter().write(String.format("All good :] \n%s", createdUser.toString()));
        } catch (Exception e) {
            response.getWriter().write(String.format("Something wrong :< (%s)", e.getMessage()));
        }
    }
}