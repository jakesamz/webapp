<%@page import="com.jake.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/webapptaglib" prefix="webapp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>sign in</title>
<script src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
</head>
<body>

	<webapp:select id="s1" linkSelectId="s2" linking="true" sql="select address_Id as value, address_name as detail from address where parent_id is null" 
		linkSql="select address_Id as value, address_name as detail from address where parent_id = '2' " />
	<webapp:select id="s2" linked="true"/>
<input type="text" value="asdfsdsdfffffffffffffffffffasd"/>
<input id="i" type="text" value=""/>
<table>
<tr>
	<td>asdfsad</td>
</tr>
</table>
<textarea>sdd"s'f</textarea>
<a href="javascript:;" onclick="ajax()">ajax</a>
<a href="javascript:;" onclick="ajaxLogin()">login in</a>
<script type="text/javascript">
	var v = document.getElementById("i").value;
	console.log(v);
	var testValue = '${testValue}';
	var v1 = {'a': testValue};
	//debugger;
	console.log(v1);
	
	
	function ajaxLogin(){
		console.log('--;');
		$.ajax({
			url : 'dologin',
			type : 'post',
			dataType : 'json',
			success : function(data) {
				console.log(data.flag);
				if(data.flag == true){
					if('${url}' != ''){
						window.location.href='${url}';
					}else{
						window.location.href="your default path";
					}
				}else{
					console.log('--------false');
				}
				
			}
		});
	}
</script>
</body>
</html>