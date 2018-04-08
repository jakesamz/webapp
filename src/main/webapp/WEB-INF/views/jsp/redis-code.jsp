<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redis mobile code</title>
<script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
</head>
<body>
phone number:
<input name="phoneNumber" id="phoneNumber"/>
<a href="javascript:;" id="send">send</a>
<div id="myDiv">message: ${respStr}</div>

</body>
<script type="text/javascript">

	$(document).ready(function() {
		$("#send").click(function() {
			htmlobj = $.ajax({
				url : "/WebApp/reset_pwd",
				async : false,
				data : { phoneNumber : $("#phoneNumber").val() },
				success: function() {
					window.location.href=window.location.href;
				}
			});
		});
	});
</script>
</html>