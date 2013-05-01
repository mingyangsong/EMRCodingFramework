<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>EMRCoding</title>
</head>
<script language="JavaScript">
	function checkAll() {
		for ( var j = 1; j <= 10; j++) {
			box = eval("document.newBox.SNOWMEDS" + j);
			if (box.checked == false)
				box.checked = true;
		}
	}
	function uncheckAll() {
		for ( var j = 1; j <= 10; j++) {
			box = eval("document.newBox.SNOWMEDS" + j);
			if (box.checked == true)
				box.checked = false;
		}
	}
	function opensub() {
		document.newBox.submit();
	}
	function bconfirm() {
		dialogArguments.addNameform.newBox.value = document.newBox.SNOWMEDS.value;
		dialogArguments.opensub();
		window.close();
	}
	function bcancel() {
		window.close();
	}
	function finish(){
		var test=<%=request.getParameter("p1")%>;
		if(test==null) bcancel();
	}
</script>
<body onload="finish()">
Result: <%=request.getParameter("p1") %>
	<form name=newBox method=post action="Feedback">
		<input type="checkbox" name="SNOWMEDS" id="SNOWMEDS2" value="74960003">74960003<br>
		<input type="checkbox" name="SNOWMEDS" id="SNOWMEDS3" value="219006">219006<br>
		<input type="checkbox" name="SNOWMEDS" id="SNOWMEDS4" value="317006">317006<br>
		<input type="checkbox" name="SNOWMEDS" id="SNOWMEDS5" value="355001">355001<br>
		<input type="checkbox" name="SNOWMEDS" id="SNOWMEDS6"
			value="199930000">199930000<br> <input type="checkbox"
			name="SNOWMEDS" id="SNOWMEDS7" value="596004">596004<br>
		<input type="checkbox" name="SNOWMEDS" id="SNOWMEDS8" value="815008">815008<br>
		<input type="checkbox" name="SNOWMEDS" id="SNOWMEDS9"
			value="401314000">401314000<br> <input type="checkbox"
			name="SNOWMEDS" id="SNOWMEDS10" value="275498002">275498002<br>

		<input type=button value="Select All" onClick="checkAll()"> <input
			type=button value="Unselect All" onClick="uncheckAll()"> <input
			type="Submit" name="Feedback" value="Feedback" id="Feedback"
			onclick="bconfirm();"> <input type="Submit" name="Cancel"
			value="Cancel" id="Cancel" onclick="bcancel();">
	</form>
</body>
</html>