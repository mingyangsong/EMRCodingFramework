<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>EMRCoding</title>
</head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script language="JavaScript">
	//jQuery handle XMLHttpRequest with callback which works cross-browsers 
	$(document).ready(function() {

		$('#Submit').click(function(event) {
			var emr = $('#EMR').val();

			$('#Processing').show();
			$('#Sub').hide();

			$.post('EMRCoding', {
				EMRIN : emr
			}, function(responseXML) {
				$('#Processing').hide();

				// call parseMessage to parse responded XML file. This method is regular Javascript, not jQue
				console.log(responseXML);
				var emrContent = parseMessage(responseXML, "content");
				var icdCode = parseMessage(responseXML, "icd");

				//console.log("jQuery " + emrContent);
				alert("Hello" + responseXML);
				// show emr content in <div id="result"></div>
				$("#result").text(emrContent);

				// show icd in <div id="icd"></div>
				$("#icd").text(icdCode);
			});
		});
	});

	// regular Javascript method to parse responded XML file
	function parseMessage(responseXML, tagName) {

		var text = responseXML.getElementsByTagName(tagName)[0].textContent;
		//console.log("parseMessage"+text);
		return text;

	}
</script>
<body>
	<h1 align="center">Welcome To EMR Coding Demo</h1>
	<hr align="center" width="90%" size="2" noshade color="#4996ff">
	<h3 align="center">Input Area</h3>
	<form id="form1">
		<table align="center" width="70%">
			<tr>
				<td align="center"></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#4996ff">
					<h4>
						<font color="#FFFFFF">EMR</font>
					</h4> <textarea id="EMR" rows="20" cols="80"></textarea> <br> <br>
				</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#4996ff">
					<div id="Processing" style="display: none">
						<img src="img/processing_icon.gif" alt="processing_image"
							width="30" height="30">
					</div>
				</td>
			</tr>
			<tr>
				<td align="center" bgcolor="#4996ff"><div id="Sub">
						<h4>
							<input type="button" value="PROCESS" id="Submit">
						</h4>
					</div></td>
			</tr>
		</table>
	</form>
	<div id="result"></div>
	<div id="icd"></div>
</body>
</html>