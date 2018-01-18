<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>XXS(Cross-site Scripting) 跨站脚本攻击</title>
</head>
<body>
	<h1>XXS(Cross-site Scripting) 跨站脚本攻击</h1>

	<form action="submitXXS" method="post"> 
		<input type="text" name="xssInput" id="xssInput"> 
		<input type="submit" onclick="getInput()">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>         
	</form>
	<c:out value=""></c:out>
	你输入的字符是${xssInput }
	&lt;script&gt;alert(&#39;handsome boy&#39;)&lt;/script&gt
</body>
