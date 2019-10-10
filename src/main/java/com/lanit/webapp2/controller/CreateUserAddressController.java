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

    public CreateUserAddressController(RequestAddressDtoMapper requestAddressDtoMapper) {
        this.requestAddressDtoMapper = requestAddressDtoMapper;
    }

    @GetMapping(URL)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("users", UserDao.getInstance().getList());
            request.getRequestDispatcher("/address-add.jsp").forward(request, response);
        } catch (Exception e) {
            response.getWriter().write(String.format("Something wrong :< (%s)", e.getMessage()));
        }
    }

    @PostMapping(URL)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            RequestAddressDto requestAddressDto = requestAddressDtoMapper.mapFromRequest(request);
            User user = UserDao.getInstance().get(requestAddressDto.getUserId());
            AddressDao.getInstance().create(requestAddressDto, user);
            response.sendRedirect(String.format("/%s", request.getContextPath()));
        } catch (Exception e) {
            response.getWriter().write(String.format("Something wrong :< (%s)", e.getMessage()));
        }
    }
}
