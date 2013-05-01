<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>EMRCoding</title>
</head>
<script src="js/jquery-1.9.1.min.js"></script>
<script language="JavaScript">
	// jQuery handle XMLHttpRequest with callback which works cross-browsers 
	$(document).ready(function() {

		$('#Submit').click(function(event) {
			//var emr = $('#EMR-field').val();

			$('#processing').show();

			/*$.post('JD', {
				emrData : emr
			}, 
			,function(responseXML) {
				$('#processing').hide();

				// call parseMessage to parse responded XML file. This method is regular Javascript, not jQuery
				var emrContent = parseMessage(responseXML, "content");
				var icdCode = parseMessage(responseXML, "icd");

				//console.log("jQuery " + emrContent);

				// show emr content in <div id="result"></div>
				$("#result").text(emrContent);

				// show icd in <div id="icd"></div>
				$("#icd").text(icdCode);

			});*/

		});

	});
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
				<td align="center" bgcolor="#88ef7a">
					<h4>
						<font color="#FFFFFF">EMR</font>
					</h4> <textarea name="EMRIN" rows="20" cols="80"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#88ef7a"><br> <br>
					<div id="processing" style="display: none">
						<img src="img/processing_icon.gif" alt="processing_image"
							width="30" height="30">
					</div>
					<input type="Submit" name="Submit" value="PROCESS" id="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>