<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đăng nhập</title>
<style>
table, th, td {
	border: 1px solid black;
	padding: 5px;
}

table {
	border-spacing: 3px;
}

div.table {
	margin-bottom: 20px;
}

div.table1 {
	display: inline-block;
	margin-right: 50px;
}

div.table2 {
	display: inline-block;
	margin-left: 50px;
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

	<div
		style='display: flex; justify-content: center; align-items: center; flex-direction: column'>
		<h2>Ngân hàng 4T</h2>
		<h2>Vui lòng đăng nhập:</h2>
		<a href="frontend/login.jsp" id="log_in_button">
			<Button>Đăngnhập</Button>
		</a>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>