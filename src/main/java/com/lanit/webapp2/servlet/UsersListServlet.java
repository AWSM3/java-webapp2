package com.lanit.webapp2.servlet;

import com.lanit.webapp2.dao.UserDao;
import com.lanit.webapp2.dto.AddressDto;
import com.lanit.webapp2.dto.UserDto;
import com.lanit.webapp2.entity.Address;
import com.lanit.webapp2.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/"})
public class UsersListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> users = daoFactory.build(UserDao.class).getList(); // todo: pagination
            request.setAttribute("users", users);
            request.getRequestDispatcher("/users-list.jsp").forward(request, response);
        } catch (Exception e) {
            response.getWriter().write(String.format("Something wrong :< (%s)", e.getMessage()));
        }
    }
}
