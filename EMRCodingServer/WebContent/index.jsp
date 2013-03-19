<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>EMRCoding</title>
</head>
<body>
	<script language="JavaScript">
		function checkAll() {
			for ( var j = 1; j <= 10; j++) {
				box = eval("document.MainForm.SNOWMEDS" + j);
				if (box.checked == false)
					box.checked = true;
			}
		}
		function uncheckAll() {
			for ( var j = 1; j <= 10; j++) {
				box = eval("document.MainForm.SNOWMEDS" + j);
				if (box.checked == true)
					box.checked = false;
			}
		}
	</script>


	<h1 align="center">Welcome To EMR Coding Demo</h1>
	<hr align="center" width="90%" size="2" noshade>
	<br>
	<form name="MainForm" method="post" action="EMRCoding">
		<table align="center" width="70%">
			<tr>
				<td align="center">CHECK INPUT:</td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td width="80%"></td>
							<td width="20%" bgcolor="#ACDDEC"><input type="checkbox"
								name="SNOWMEDS" id="SNOWMEDS1" value="364006">364006<br>
								<input type="checkbox" name="SNOWMEDS" id="SNOWMEDS2"
								value="74960003">74960003<br> <input
								type="checkbox" name="SNOWMEDS" id="SNOWMEDS3" value="219006">219006<br>
								<input type="checkbox" name="SNOWMEDS" id="SNOWMEDS4"
								value="317006">317006<br> <input type="checkbox"
								name="SNOWMEDS" id="SNOWMEDS5" value="355001">355001<br>
								<input type="checkbox" name="SNOWMEDS" id="SNOWMEDS6"
								value="199930000">199930000<br> <input
								type="checkbox" name="SNOWMEDS" id="SNOWMEDS7" value="596004">596004<br>
								<input type="checkbox" name="SNOWMEDS" id="SNOWMEDS8"
								value="815008">815008<br> <input type="checkbox"
								name="SNOWMEDS" id="SNOWMEDS9" value="401314000">401314000<br>
								<input type="checkbox" name="SNOWMEDS" id="SNOWMEDS10"
								value="275498002">275498002<br>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="center"><input type=button value="Select All"
					onClick="checkAll()"> <input type=button
					value="Unselect All" onClick="uncheckAll()"></td>
			</tr>
			<tr>

				<td align="center"><br>OTHER SNOWMED:</td>
			</tr>
			<tr>
				<td align="center"><input name="USERIN"></td>
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