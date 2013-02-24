<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>EMRCoding</title>
</head>
<body>
	<h1 align="center">Welcome To EMR Coding Demo</h1>
	<hr align="center" width="90%" size="2" noshade>
	<br>
	<form name="MainForm" method="post" action="EMRCoding">
		<center>
			<table width="70%">
				<tr>
					<td><input type="Submit" name="Submit" value="Start"></td>
				</tr>
				<tr>
					<td><input name="input" type="text" value="\descriptors\MappingCPE.xml"></td>
				</tr>
			</table>
			<br> <br> <br>
			<table width="70%">
				<tr>
					<td>REPORT</td>
				</tr>
				<tr>
					<td><textarea name="output" rows="5" cols="50"><%=request.getAttribute("REPORT")%></textarea></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>