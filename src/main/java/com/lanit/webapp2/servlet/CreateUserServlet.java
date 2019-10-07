package com.lanit.webapp2.servlet;

import com.lanit.webapp2.dao.UserDao;
import com.lanit.webapp2.dto.RequestUserDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.mapper.RequestUserDtoMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {CreateUserServlet.URL})
public class CreateUserServlet extends HttpServlet {
    public static final String URL = "/user/create";

    private RequestUserDtoMapper requestUserDtoMapper;

    @Override
    public void init() throws ServletException {
        this.requestUserDtoMapper = (RequestUserDtoMapper) getServletContext().getAttribute(RequestUserDtoMapper.class.getSimpleName());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RequestUserDto requestUserDto = this.requestUserDtoMapper.mapFromRequest(request);
            User createdUser = UserDao.getInstance().create(requestUserDto);
            response.sendRedirect(String.format("/%s", request.getContextPath()));
        } catch (Exception e) {
            response.getWriter().write(String.format("Something wrong :< (%s)", e.getMessage()));
        }
    }
}