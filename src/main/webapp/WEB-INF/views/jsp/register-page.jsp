<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="register" method="post">
		<div>
			username: <input type="text" name="username" />
		</div>
		<div>
			password: <input type="password" name="password" />
		</div>
		<div>
			phone: <input type="text" name="phoneNumber" />
		</div>
		<div>
			code: <input type="text" name="code" />
			<button>get code</button>
		</div>
		<input type="submit" value="submit"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
	</form>
</body>
</html>