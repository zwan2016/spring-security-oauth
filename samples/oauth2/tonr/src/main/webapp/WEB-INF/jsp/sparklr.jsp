<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:url value="/" var="base" />
<link type="text/css" rel="stylesheet"
	href="${base}webjars/bootstrap/3.0.3/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${base}webjars/jquery/1.9.0/jquery.min.js"></script>
<script type="text/javascript"
	src="${base}webjars/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<title>tonr</title>
</head>
<body>
	<div id="navbar" class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="${base}index.jsp">
				Tonr</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${base}sparklr/user" class="selected">sparklr user profile</a></li>
			</ul>
		</div>
	</div>

	<div class="container">
		<h1>客户端tonr</h1>
		<div class="form-horizontal">
            <form action="<c:url value="/placeholder"/>" method="post" role="form">
                <fieldset>
                    <legend>
                        <h2>您在sparklr上的用户简介</h2>
                    </legend>
                    <div class="form-group">
                        <label for="username">Username:</label> <input id="username"
                            class="form-control" type='text' name='username' value='${username}' readonly/>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label> <input id="email"
                            class="form-control" type='text' name='email' value='${email}' readonly/>
                    </div>
                    <div class="form-group">
                        <input id="password"
                            class="form-control" type='hidden' name='password' value='placeholder'/>
                    </div>
                    <div class="form-group">
                        <label for="firstName">First Name:</label> <input id="firstName"
                            class="form-control" type='text' name='firstName' value='${firstName}' readonly/>
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name:</label> <input id="lastName"
                            class="form-control" type='text' name='lastName' value='${lastName}' readonly/>
                    </div>
                    <div class="form-group">
                        <label for="funFact">Fun Fact:</label> <input id="funFact"
                            class="form-control" type='text' name='funFact' value='${funFact}' readonly/>
                    </div>
                   <!-- <button class="btn btn-primary" type="submit">Update</button> -->
                </fieldset>
            </form>
        </div>
	</div>
</body>
</html>