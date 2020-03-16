<%@ page contentType="text/html; charset=UTF-8" %>
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

		<h1>授权服务器</h1>
		<p>您当前处在授权服务器sparklr注册页面</p>

        <div class="form-horizontal">
            <form action="<c:url value="/register"/>" method="post" role="form">
                <fieldset>
                    <legend>
                        <h2>Register</h2>
                    </legend>
                    <div class="form-group">
                        <label for="username">Username:</label> <input id="username"
                            class="form-control" type='text' name='username' />
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label> <input id="email"
                            class="form-control" type='text' name='email' />
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label> <input id="password"
                            class="form-control" type='password' name='password' />
                    </div>
                    <div class="form-group">
                        <label for="firstName">First Name:</label> <input id="firstName"
                            class="form-control" type='text' name='firstName' />
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name:</label> <input id="lastName"
                            class="form-control" type='text' name='lastName' />
                    </div>
                    <div class="form-group">
                        <label for="funFact">Fun Fact:</label> <input id="funFact"
                            class="form-control" type='text' name='funFact' />
                    </div>
                    <button class="btn btn-primary" type="submit">Register</button>
                </fieldset>
            </form>

        </div>

		<div class="footer">
			Sample application for <a
				href="https://github.com/zwan2016/spring-security-oauth/tree/master/samples"
				target="_blank">Spring Security OAuth</a>
		</div>


	</div>

</body>
</html>
