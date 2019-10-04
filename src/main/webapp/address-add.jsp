<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.lanit.webapp2.servlet.CreateUserAddressServlet" %>
<%@ page import="com.lanit.webapp2.mapper.AddressDtoMapper" %>
<%@ page isELIgnored="false" %>

<jsp:include page="partials/head.jsp"/>

<div class="jumbotron">
    <h1 class="display-4">Creating user address form</h1>
    <hr>

    <form method="POST" action="<%= CreateUserAddressServlet.URL %>">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">User</label>
            <div class="col-sm-10">
                <select class="form-control" required name="<%= AddressDtoMapper.PARAMETER_USER_ID %>">
                    <c:forEach items="${requestScope.users}" var="user">
                        <option value="${user.id}">${user.fullname}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Street</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" required name="<%= AddressDtoMapper.PARAMETER_STREET %>">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Building</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" required name="<%= AddressDtoMapper.PARAMETER_BUILDING %>">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Apartments</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" required name="<%= AddressDtoMapper.PARAMETER_APARTMENTS %>">
            </div>
        </div>
        <button type="submit" class="btn btn-success">Create address</button>
    </form>
</div>

<jsp:include page="partials/foot.jsp"/>