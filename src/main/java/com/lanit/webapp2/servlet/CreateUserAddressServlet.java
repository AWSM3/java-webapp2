package com.lanit.webapp2.servlet;

import com.lanit.webapp2.dao.AddressDao;
import com.lanit.webapp2.dao.UserDao;
import com.lanit.webapp2.dto.RequestAddressDto;
import com.lanit.webapp2.entity.User;
import com.lanit.webapp2.mapper.RequestAddressDtoMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {CreateUserAddressServlet.URL})
public class CreateUserAddressServlet extends HttpServlet {
    public static final String URL = "/create/user/address";

    private RequestAddressDtoMapper requestAddressDtoMapper;

    @Override
    public void init() throws ServletException {
        this.requestAddressDtoMapper = (RequestAddressDtoMapper) getServletContext().getAttribute(RequestAddressDtoMapper.class.getSimpleName());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("users", UserDao.getInstance().getList());
            request.getRequestDispatcher("/address-add.jsp").forward(request, response);
        } catch (Exception e) {
            response.getWriter().write(String.format("Something wrong :< (%s)", e.getMessage()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
