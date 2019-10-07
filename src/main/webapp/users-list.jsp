<%@ page import="com.lanit.webapp2.servlet.CreateUserServlet" %>
<%@ page import="com.lanit.webapp2.mapper.RequestUserDtoMapper" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<jsp:include page="partials/head.jsp"/>

<div class="jumbotron">
    <h1 class="display-4">Users list</h1>
    <hr>

    <div class="accordion" id="accordionExample">
        <c:forEach items="${requestScope.users}" var="user">
            <div class="card">
                <div class="card-header" id="headingOne">
                    <h2 class="mb-0">
                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#user-${user.id}"
                                aria-expanded="true" aria-controls="collapseOne">${user.fullname}</button>
                    </h2>
                </div>

                <div id="user-${user.id}" class="collapse" aria-labelledby="headingOne"
                     data-parent="#accordionExample">
                    <div class="card-body">
                        <table class="table table-dark">
                            <thead>
                            <tr>
                                <th scope="col">Street</th>
                                <th scope="col">Building</th>
                                <th scope="col">Apartments</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test = "${not empty user.addresses}">
                                <c:forEach items="${user.addresses}" var="address">
                                    <tr>
                                        <td>${address.street}</td>
                                        <td>${address.building}</td>
                                        <td>${address.apartments}</td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

<jsp:include page="partials/foot.jsp"/>