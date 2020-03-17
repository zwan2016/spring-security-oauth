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

		<h1>授权服务器sparklr</h1>
		<p>您当前处在授权服务器sparklr客户端注册页面</p>

        <div class="form-horizontal">
            <form action="<c:url value="/apply"/>" method="post" role="form">
                <fieldset>
                    <legend>
                        <h2>Register</h2>
                    </legend>
                    <div class="form-group">
                        <label for="clientName">Client Name:</label> <input id="clientName"
                            class="form-control" type='text' name='clientName' />
                    </div>
                    <div class="form-group">
                        <label for="clientDomain">Client Domain:</label> <input id="clientDomain"
                            class="form-control" type='text' name='clientDomain' />
                    </div>
                    <div class="form-group">
                        <label for="email">Contact Email:</label> <input id="email"
                            class="form-control" type='text' name='email' />
                    </div>
                    <button class="btn btn-primary" type="submit">Request</button>
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
