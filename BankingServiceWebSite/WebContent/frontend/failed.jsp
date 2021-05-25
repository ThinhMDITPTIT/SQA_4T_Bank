<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page contentType="text/html; charset=UTF-8" %> 
<title>Thất bại</title>
<style type="text/css">
table, th, td {
	  border: 1px solid black;
	  padding: 5px;
	}
	table {
	  border-spacing: 3px;
	}
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box
}

/* Full-width input fields */
input[type=text], input[type=password] {
	padding: 15px 0px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}
</style>
</head>
<body>
<%
	int hdvid = Integer.parseInt(session.getAttribute("hdvid").toString());
	int userid = Integer.parseInt(session.getAttribute("userid").toString());
	String cusName = session.getAttribute("cusname").toString(); 
	session.removeAttribute("hdvid");
	session.removeAttribute("userid");
	session.removeAttribute("cusname");
%>
	<h3>Thêm phiếu nộp tiền thất bại</h3>
	<a href="themPhieuNop.jsp?hdvid=<%=hdvid %>&userid=<%=userid %>&cusname=<%=cusName %>"><button>Quay lại</button></a>
</body>
</html>