package com.lanit.webapp2.controller;

import com.lanit.webapp2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UsersListController {
    private UserService userService;

    public UsersListController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    protected String doGet(Model model) throws IOException {
        model.addAttribute("users", userService.getUsersList());

        return "/users-list";
    }
}
