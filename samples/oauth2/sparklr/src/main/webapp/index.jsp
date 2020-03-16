<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sparklr</title>
<link type="text/css" rel="stylesheet"
	href="webjars/bootstrap/3.0.3/css/bootstrap.min.css" />
<script type="text/javascript" src="webjars/jquery/1.9.0/jquery.min.js"></script>
<script type="text/javascript"
	src="webjars/bootstrap/3.0.3/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">

		<h1>授权服务器sparklr</h1>

		<h2>用户信息页面</h2>

		<p></p>

		<authz:authorize access="hasRole('ROLE_USER')">
            <div class="form-horizontal">
                <form action="<c:url value="/logout"/>" role="form" method="post">
                    <input type="hidden" name="${_csrf.parameterName}"
                        value="${_csrf.token}" />
                    <button class="btn btn-primary" type="submit">Logout</button>
                </form>
            </div>
            <div class="form-horizontal">
                <form action="<c:url value="/update"/>" method="post" role="form">
                    <fieldset>
                        <legend>
                            <h2>Update</h2>
                        </legend>
                        <div class="form-group">
                            <label for="username">Username:</label> <input id="username"
                                class="form-control" type='text' name='username' readonly/>
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label> <input id="email"
                                class="form-control" type='text' name='email' readonly/>
                        </div>
                        <div class="form-group">
                            <input id="password"
                                class="form-control" type='hidden' name='password' value='placeholder'/>
                        </div>
                        <div class="form-group">
                            <label for="firstName">First Name:</label> <input id="firstName"
                                class="form-control" type='text' name='firstName' readonly/>
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name:</label> <input id="lastName"
                                class="form-control" type='text' name='lastName' readonly/>
                        </div>
                        <div class="form-group">
                            <label for="funFact">Fun Fact:</label> <input id="funFact"
                                class="form-control" type='text' name='funFact' />
                        </div>
                        <button class="btn btn-primary" type="submit">Update</button>
                    </fieldset>
                </form>

                <script type='text/javascript'>
                    $
                        .ajax("user?format=json")
                        .complete(
                            function(response) {
                                data = JSON.parse(response.responseText);
                                $("#username").val(data.username);
                                $("#email").val(data.email);
                                $("#firstName").val(data.firstName);
                                $("#lastName").val(data.lastName);
                                $("#funFact").val(data.funFact);
                            });
                </script>
            </div>
		</authz:authorize>

		<div class="footer">
			Sample application for <a
				href="https://github.com/zwan2016/spring-security-oauth/tree/master/samples"
				target="_blank">Spring Security OAuth</a>
		</div>

	</div>

</body>
</html>
