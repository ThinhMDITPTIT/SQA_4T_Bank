<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trang chủ</title>
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
	<jsp:include page="header.jsp"></jsp:include>
	<div align="center" style='margin-top: 50px'>
		<h2>
			<a href="searchUserForKhaiBao.jsp"><button>Vay lãi</button></a>
		</h2>
		<h2>
			<a href="searchUser.jsp"><button>Trả tiền</button></a>
		</h2>
		<h2>
			<a id="tinh_lai_button" href="searchUser.jsp">
				<button>Tính lãi</button>
			</a>
		</h2>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>