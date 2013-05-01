<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JD Testing UI</title>
<script src="js/jquery-1.9.1.min.js"></script>
<script language="JavaScript">

	// jQuery handle XMLHttpRequest with callback which works cross-browsers 
	$(document).ready(function() {
		
		$('#submit').click(function(event) {
			var emr = $('#EMR-field').val();
			
			$('#processing').show();
			
			$.post('JD', {emrData:emr}, function(responseXML) {
				$('#processing').hide();	
				
				// call parseMessage to parse responded XML file. This method is regular Javascript, not jQue
				console.log(responseXML);
				var emrContent = parseMessage(responseXML, "content");
				var icdCode = parseMessage(responseXML, "icd");
				
				//console.log("jQuery " + emrContent);
				alert("Hello"+responseXML);
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
</head>
<body>
<form id="form1">
<div>EMR Input</div>
<div>
<textarea  id="EMR-field" name="EMR" style="width:200px;height:400px">
</textarea>
</div>
<div>
<input type="button" id="submit" value="Ajax submit" width="100" height="100">
</div>
<div id="result">
</div>
<div id="icd">
</div>
<div id="processing" style="display: none">
<img src="img/processing_icon.gif" alt="processing_image">
</div>
</form>

</body>
</html>