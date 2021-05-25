<!DOCTYPE>
<%@page import="com.banking.entity.Users"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.banking.dao.UsersDAO"%>
<%@ page contentType="text/html; charset=UTF-8" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Tìm kiếm khách hàng</title>
<style>
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
	<%	if(request.getParameter("mess") !=null && request.getParameter("mess").equalsIgnoreCase("success")){ %>
          <script>
          	window.alert("Thêm mới khách hàng thành công !");
          </script>
    <%}%>
    
	<div style='margin-top: 20px'>
		<a href="main.jsp"><button>Quay lại</button></a>
	</div>
	
	<h2>Tìm kiếm khách hàng</h2>
	<table>
		<form action="userInfo.jsp" method="POST" >
			<tr>
				<td style="padding: 15px">Nhập tên khách hàng:</td>
				<td style="padding: 15px">
					<input type="text" required id ="name" name ="name"  autofocus/><a style="color: red;">(*)</a>
				</td>
			</tr>
			<tr>
				<td style="text-align: right" colspan="2">
					<button id="tim_kiem_khach_hang" type = "submit" style="width: 100%">Tìm khách hàng</button>
				</td>
			</tr>
		</form>
	</table>
</body>
</html>