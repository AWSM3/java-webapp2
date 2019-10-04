package com.lanit.webapp2.servlet;

import com.lanit.webapp2.dao.AddressDao;
import com.lanit.webapp2.dao.UserDao;
import com.lanit.webapp2.dto.AddressDto;
import com.lanit.webapp2.entity.Address;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.factory.DaoFactory;
import com.lanit.webapp2.mapper.AddressDtoMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(urlPatterns = {CreateUserAddressServlet.URL})
public class CreateUserAddressServlet extends HttpServlet {
    public static final String URL = "/create/user/address";

    private DaoFactory daoFactory;
    private AddressDtoMapper addressDtoMapper;

    @Override
    public void init() throws ServletException {
        this.daoFactory = (DaoFactory) getServletContext().getAttribute(DaoFactory.class.getSimpleName());
        this.addressDtoMapper = (AddressDtoMapper) getServletContext().getAttribute(AddressDtoMapper.class.getSimpleName());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("users", daoFactory.build(UserDao.class).getList());
            request.getRequestDispatcher("/address-add.jsp").forward(request, response);
        } catch (Exception e) {
            response.getWriter().write(String.format("Something wrong :< (%s)", e.getMessage()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AddressDto addressDto = addressDtoMapper.mapFromRequest(request);
            AddressDao addressDao = (AddressDao) daoFactory.build(AddressDao.class);
            UserDao userDao = (UserDao) daoFactory.build(UserDao.class);
            User user = userDao.get(addressDto.getUserId());
            addressDao.create(addressDto, user);
            response.sendRedirect(String.format("/%s", request.getContextPath()));
        } catch (Exception e) {
            response.getWriter().write(String.format("Something wrong :< (%s)", e.getMessage()));
        }
    }
}
