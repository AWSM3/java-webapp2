package com.lanit.webapp2.controller;

import com.lanit.webapp2.dao.AddressDao;
import com.lanit.webapp2.dao.UserDao;
import com.lanit.webapp2.dto.RequestAddressDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.mapper.RequestAddressDtoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CreateUserAddressController {
    public static final String URL = "/create/user/address";

    private RequestAddressDtoMapper requestAddressDtoMapper;
    private UserDao userDao;
    private AddressDao addressDao;

    public CreateUserAddressController(RequestAddressDtoMapper requestAddressDtoMapper, UserDao userDao, AddressDao addressDao) {
        this.requestAddressDtoMapper = requestAddressDtoMapper;
        this.userDao = userDao;
        this.addressDao = addressDao;
    }

    @GetMapping(URL)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("users", userDao.getList());
            request.getRequestDispatcher("/address-add.jsp").forward(request, response);
        } catch (Exception e) {
            response.getWriter().write(String.format("Something wrong :< (%s)", e.getMessage()));
        }
    }

    @PostMapping(URL)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            RequestAddressDto requestAddressDto = requestAddressDtoMapper.mapFromRequest(request);
            User user = userDao.get(requestAddressDto.getUserId());
            addressDao.create(requestAddressDto, user);
            response.sendRedirect(String.format("/%s", request.getContextPath()));
        } catch (Exception e) {
            response.getWriter().write(String.format("Something wrong :< (%s)", e.getMessage()));
        }
    }
}
