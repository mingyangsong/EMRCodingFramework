<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>EMRCoding</title>
</head>
<body>
	<br>
	<form name="loginForm" method="post" action="EMRCoding">
		<table>
			<tr>
				<td><div align="right">UserName:</div></td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td><div align="right">Password:</div></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><div align="right">YourName:</div></td>
				<td><%= request.getAttribute("USER") %></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="Submit" name="Submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>