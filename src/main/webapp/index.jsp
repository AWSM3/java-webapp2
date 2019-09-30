<%@ page import="com.lanit.webapp2.servlet.CreateUserServlet" %>
<%@ page import="com.lanit.webapp2.mapper.UserDtoMapper" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JDBC WebApp</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Creating user form:</h1>
        <hr>

        <form method="POST" action="<%= CreateUserServlet.URL %>">
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Firstname</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required name="<%= UserDtoMapper.PARAMETER_FIRSTNAME %>">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Middlename</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required name="<%= UserDtoMapper.PARAMETER_MIDDLENAME %>">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Lastname</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" required name="<%= UserDtoMapper.PARAMETER_LASTNAME %>">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Date of birth</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" required name="<%= UserDtoMapper.PARAMETER_BIRTHDATE %>">
                </div>
            </div>

            <button type="submit" class="btn btn-success">Create user</button>
        </form>
    </div>
</div>
</body>
</html>