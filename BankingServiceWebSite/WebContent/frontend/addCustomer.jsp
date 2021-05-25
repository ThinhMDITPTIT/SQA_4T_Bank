<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm khách hàng</title>
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

input.specific {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	opacity: 0.9;
}

input.specific:hover {
	opacity: 1;
}

</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%	if(request.getParameter("mess") !=null && request.getParameter("mess").equalsIgnoreCase("fail")){
          %><script>
          	window.alert("Khách hàng đã tồn tại!!!");
          </script><%
      } 
      %>
      <div style='margin-top: 20px'>
		<a href="searchUser.jsp"><button>Quay lại</button></a>
	</div>
	<div align="center">
		<h1>Thêm Khách hàng mới</h1>
	</div>
	<div align="center">
		<h2>Vui lòng điền đầy đủ thông tin:</h2>
		<form name="addCusstomer" action="doAddCustomer.jsp" method="post" id="formAddCustomer">
			<table border="0">
				<tr>
					<td>Họ và tên:</td>
					<td><input 
						style="width: 200px" name="hoten" id="hoten" required /> <a
						style="color: red;">(*)</a></td>
				</tr>
				<tr>
					<td>Ngày Sinh:</td>
					<td><input type="date"
						placeholder="dd/mm/yyyy"
						style="width: 200px" name="dob" id="dob" required /> <a
						style="color: red;">(*)</a></td>
				</tr>
				<tr>
					<td>Số điện thoại:</td>
					<td><input 
						style="width: 200px" name="sdt" id="sdt" required /> <a
						style="color: red;">(*)</a></td>
				</tr>
				<tr>
					<td>Số CCCD/CMND:</td>
					<td><input 
						style="width: 200px" name="cmnd" id="cmnd" required /> <a
						style="color: red;">(*)</a></td>
				</tr>
				<tr>
					<td>Nơi Cấp:</td>
					<td><input 
						style="width: 200px" name="noicap" id="noicap" required /> <a
						style="color: red;">(*)</a></td>
				</tr>
				<tr>
					<td>Ngày Cấp:</td>
					<td><input type="date"
					placeholder="dd/mm/yyyy"
						style="width: 200px" name="ngaycap" id="ngaycap" required /> <a
						style="color: red;">(*)</a></td>
				</tr>
				<tr>
					<td>Địa chỉ thường trú:</td>
					<td><input
						style="width: 200px" name="dcthuongtru" id="dcthuongtru" required /> <a
						style="color: red;">(*)</a></td>
				</tr>
				<tr>
					<td>Địa chỉ hiện tại:</td>
					<td><input 
						style="width: 200px" name="dchientai" id="dchientai" required /> <a
						style="color: red;">(*)</a></td>
				</tr>
				
				<tr>
					<td>Email:</td>
					<td><input 
						type="email"
						placeholder="abcxyz@abc.xyz"
						style="width: 200px" name="email" id="email" required /> <a
						style="color: red;">(*)</a></td>
				</tr>
				

				<tr style="text-align: center">
					<td colspan="2"><input id="doAddUser" type="submit" value="Thêm khách hàng" class="specific" style="width: 100%"/></td>
				</tr>
			</table>
		</form>
	</div>
	</div>
</body>
<script type="text/javascript">
	var form = document.getElementById("formAddCustomer");
	
</script>
</html>