<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
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
				<li><a href="${base}sparklr/user">sparklr user profile</a></li>
			</ul>
		</div>
	</div>

	<div class="container">

		<h1>客户端tonr</h1>

		<p>
			本网站可以查看你在sparklr站点的用户信息并对其进行修改，请使用sparklr账户进行登录并对本网站进行授权。
		</p>

		<authz:authorize access="!hasRole('ROLE_USER')">
			<p>
				<a href="<c:url value="login.jsp"/>">Login to Tonr</a>
			</p>
		</authz:authorize>
		<authz:authorize access="hasRole('ROLE_USER')">
			<p>
				<a href="<c:url value="/sparklr/user"/>">View my Sparklr
					photos</a>
			</p>
			<p>
				<form action="${base}logout" method="post">
					<fieldset>
						<button class="btn btn-primary" type="submit">Logout</button>
						<input type="hidden" name="${_csrf.parameterName}"
							   value="${_csrf.token}" />
					</fieldset>
				</form>
			</p>
		</authz:authorize>

	</div>
</body>
</html>