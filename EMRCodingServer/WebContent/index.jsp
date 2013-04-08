<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>EMRCoding</title>
</head>
<script language="JavaScript">
	function openwindow() {
		var result =364006;
		OpenWindow = window.showModalDialog("newBox.jsp?p1=" + result, window,
				"status:no;scroll:no;dialogWidth:235px;dialogHeight:100px");
	}
	function openwindow1() {
		OpenWindow = window.open("", "newwin",
				"height=250, width=250,toolbar=no,scrollbars=" + scroll
						+ ",menubar=no");
		OpenWindow.document.write("<BODY BGCOLOR=#ffffff>");
		OpenWindow.document.write("<h1>Hello!</h1>");
		OpenWindow.document.write("New window opened!");
		OpenWindow.document.write("</BODY>");
		OpenWindow.document.write("</HTML>");
		OpenWindow.document.close();
	}
</script>
<body>
	<h1 align="center">Welcome To EMR Coding Demo</h1>
	<hr align="center" width="90%" size="2" noshade>
	<h3 align="center">Input Area</h3>
	<form name="MainForm" method="post" action="EMRCoding">
		<table align="center" width="70%">
			<tr>
				<td align="center"></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#C91622"><h4>
						<font color="#FFFFFF">DESCRIPTOR</font>
					</h4> <input name="DESCRIPTOR" type="text"
					value="/descriptors/MappingCPE.xml"></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#C91622">
					<h4>
						<font color="#FFFFFF">EMR DOC</font>
					</h4> <textarea name="EMRIN" rows="20" cols="80"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#C91622">
					<h4>
						<font color="#FFFFFF">SNOWMED CHECK</font>
					</h4> <input name="SNOWMEDIN">
				</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#C91622">
					<h4>
						<font color="#FFFFFF">RATIO (k=precision/recall)</font>
					</h4> <input name="RATIOIN">
				</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#C91622"><br> <br> <input
					type="Submit" name="Submit" value="PROCESS" id="Submit"
					onclick="openwindow();"></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<h3 align="center">Report Area</h3>
	<table align="center" width="70%">
		<tr>
			<td align="center" bgcolor="#C91622"><textarea name="OUTPUT"
					rows="20" cols="80" readonly="readonly"><%=request.getAttribute("REPORT")%></textarea>
			</td>
		</tr>
	</table>
</body>
</html>