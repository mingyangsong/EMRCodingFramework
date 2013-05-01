<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>EMRCoding</title>

<script src="js/simple-slider.js"></script>
<link href="css/simple-slider.css" rel="stylesheet" type="text/css" />
<link href="css/simple-slider-volume.css" rel="stylesheet"
	type="text/css" />

<script>
	function checkAll() {
		for ( var j = 1; j <= 4; j++) {
			box = eval("document.newBox.SNOWMEDS" + j);
			if (box.checked == false)
				box.checked = true;
		}
	}
	function uncheckAll() {
		for ( var j = 1; j <= 4; j++) {
			box = eval("document.newBox.SNOWMEDS" + j);
			if (box.checked == true)
				box.checked = false;
		}
	}
	
	$("#slider").simple-slider();
		
</script>
</head>
<body>
	<h1 align="center">Welcome To EMR Coding Demo</h1>
	<hr align="center" width="90%" size="2" noshade>
	<h3 align="center">Report Area</h3>
	<form name="MainForm" method="post" action="EMRCoding">
		<table align="center" width="70%">
			<tr>
				<td align="center"></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#88ef7a">
					<h4>
						<font color="#FFFFFF">EMR</font>
					</h4> <textarea name="EMRIN" rows="20" cols="80"><%=request.getAttribute("REPORT")%></textarea>
				</td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#88ef7a">
					<table>
						<tr>
							<td width="10%" align="left"><font color="#FFFFFF">PRECISION</font></td>
							<td align="right"><font color="#FFFFFF">RECALL</font></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td bgcolor="#88ef7a">
					<div class="slider"
						style="position: relative; -webkit-user-select: none; box-sizing: border-box; min-height: 18px; margin-left: 9px; margin-right: 9px;"></div>

				</td>
			</tr>
			<tr>
				<td bgcolor="#88ef7a"><br></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
		</table>
	</form>

	<form name=newBox method=post action="Feedback">
		<table align="center" width="70%">
			<tr>
				<td align="left" bgcolor="#88ef7a"><font color="#FFFFFF">E03.3<br>J01.01<br>R53.0<br>M79.609
				</font></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#88ef7a"><input type="Submit"
					name="Choose Correct ICD" value="Choose Correct ICD" id="Feedback"
					onclick="bconfirm();"> <input type="Submit" name="Back"
					value="Back" id="Back"></td>
			</tr>
		</table>
	</form>

</body>
</html>