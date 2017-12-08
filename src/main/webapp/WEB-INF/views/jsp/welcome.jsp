<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign out</title>
</head>
<body>
<a onclick="signout()" href="javascript:void(0)">signout</a>
<script type="text/javascript">
	function signout(){
		alert('signing out...')
		$.ajax({
			url : 'http://localhost:8090/WebApp/signout',
			type : 'post',
			success : function(data) {
				window.location.href="http://localhost:8090/WebApp/login";
			}
		});
	}
</script>
</body>
</html>