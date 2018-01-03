<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>Login Page</h1>
	<form action="login" method="post">
		<input name="username"/>
		<input name="password">
		<input type="submit"/>
		<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
	</form>
</body>
</html>