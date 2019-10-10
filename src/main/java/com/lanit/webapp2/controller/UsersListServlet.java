package com.lanit.webapp2.controller;

import com.lanit.webapp2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UsersListServlet {
    @GetMapping("/")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("users",  UserService.getInstance().getUsersList());
            request.getRequestDispatcher("/users-list.jsp").forward(request, response);
        } catch (Exception e) {
            response.getWriter().write(String.format("Something wrong :< (%s)", e.getMessage()));
        }
    }
}
