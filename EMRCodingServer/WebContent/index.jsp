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
		<table align="center" width="70%">
			<tr>
				<td align="center">DESCRIPTOR: <input name="descriptor"
					type="text" value="/descriptors/MappingCPE.xml"></td>
			</tr>
			<tr>
				<td align="center"><input type="Submit" name="Submit"
					value="PROCESS" id="Submit"></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<table align="center" width="70%">
		<tr>
			<td align="center">REPORT</td>
		</tr>
		<tr>
			<td align="center"><textarea name="output" rows="20" cols="80"
					readonly="readonly"><%=request.getAttribute("REPORT")%></textarea>
			</td>
		</tr>
	</table>
</body>
</html>