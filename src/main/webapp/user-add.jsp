<%@ page import="com.lanit.webapp2.controller.CreateUserController" %>
<%@ page import="com.lanit.webapp2.mapper.RequestUserDtoMapper" %>

<jsp:include page="partials/head.jsp"/>

<div class="jumbotron">
    <h1 class="display-4">Creating user form</h1>
    <hr>

    <form method="POST" action="<%= CreateUserController.URL %>">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Firstname</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" required name="<%= RequestUserDtoMapper.PARAMETER_FIRSTNAME %>">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Middlename</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" required name="<%= RequestUserDtoMapper.PARAMETER_MIDDLENAME %>">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Lastname</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" required name="<%= RequestUserDtoMapper.PARAMETER_LASTNAME %>">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Date of birth</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" required name="<%= RequestUserDtoMapper.PARAMETER_BIRTHDATE %>">
            </div>
        </div>

        <button type="submit" class="btn btn-success">Create user</button>
    </form>
</div>

<jsp:include page="partials/foot.jsp"/>