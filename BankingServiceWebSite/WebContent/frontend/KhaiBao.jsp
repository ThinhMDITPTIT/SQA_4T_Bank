<%@page import="java.util.ArrayList"%>
<%@page import="com.banking.entity.Users"%>
<%@page import="com.banking.dao.UsersDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}
* {
	box-sizing: border-box
}
/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}
input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
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
/* Extra styles for the cancel button */
.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}
/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
	float: left;
	width: 50%;
}
/* Add padding to container elements */
.container {
	padding: 16px;
}
/* Clear floats */
.clearfix::after {
	content: "";
	clear: both;
	display: table;
}
/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
	.cancelbtn, .signupbtn {
		width: 100%;
	}
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Khai báo thông tin</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<%
		String username = (String) session.getAttribute("username");
	if (session.getAttribute("username") == null) {
	%>
	<c:redirect url="./login.jsp"></c:redirect>
	<%
		}
	%>
	<%
		String customerIDStr = request.getParameter("customerid");
	String cusName = request.getParameter("cusname");
	Users user = new Users();
	if (customerIDStr != null && customerIDStr.length() > 0) {
		int customerID = Integer.parseInt(customerIDStr.trim());
		UsersDAO usersDAO = new UsersDAO();
		user = usersDAO.searchUsersID(customerID);
	}
	%>
	<div style='margin-top: 20px; margin-bottom: 20px'>
		<button onclick="location.href='DSKhaiBao.jsp?customerid=<%=customerIDStr%>&cusname=<%=cusName%>';">Quay lại</button>
	</div>
	
	<h2>Khai báo thông tin</h2>
	<form name="khaibao" action="doKhaiBao.jsp" method="post"
		style="border: 1px solid #ccc">
		<div class="container">
			<p>Thông tin Khách hàng</p>
			<table>
				<thead>
					<tr>
						<td>Họ tên</td>
						<td>Email</td>
						<td>CMND/CCCD</td>
						<td>Phone</td>
						<td>Address</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=user.getFullName()%></td>
						<td><%=user.getEmail()%></td>
						<td><%=user.getCccd()%></td>
						<td><%=user.getPhone()%></td>
						<td><%=user.getAddress()%></td>
					</tr>
					
				</tbody>

			</table>
			<p>Nhập đầy đủ các thông tin bên dưới:</p>
			<hr>
			<input type="hidden" name="customerid" value="<%=customerIDStr%>">
			<label for="Nghenghiep"><b>Nghề nghiệp </b><a
				style="color: red;">(*)</a></label> <input type="text" name="Nghenghiep"
				id="Nghenghiep" required> <label for="Nghenghiep"><b>Chức
					vụ </b><a style="color: red;">(*)</a></label> <input type="text" name="Chucvu"
				id="Chucvu" required> <label for="Nghenghiep"><b>Tên
					công ty </b><a style="color: red;">(*)</a></label> <input type="text"
				name="Tencongty" id="Tencongty" required> <label
				for="Diachicongty"><b>Địa chỉ công ty </b><a
				style="color: red;">(*)</a></label> <input type="text" name="Diachicongty"
				id="Diachicongty" required>
			<div>
				<label for="psw-repeat"><b>Mức thu nhập </b><a
					style="color: red;">(*)</a></label> <input required type="radio" name="Mucluong"
					value="1 Trieu den 5 trieu"> <label for="Mucluong">1
					triệu - 5 triệu</label> <input type="radio" name="Mucluong"
					value="tu 5 den 10 trieu "> <label for="Mucluong">từ
					5 triệu đến 10 triệu</label> <input type="radio" name="Mucluong"
					value="tu 10 den 20 trieu"> <label for="Mucluong">từ
					10 triệu đến 20 triệu</label> <input type="radio" name="Mucluong"
					value="tren 20 trieu "> <label for="Mucluong">trên
					20 triệu</label>
			</div>
			<br>
			<div>
				<label for="psw-repeat"><b>Mức chi tiêu hằng tháng </b><a
					style="color: red;">(*)</a></label> <input required type="radio"
					name="Chitieuhangthang" value="1 trieu den 5 trieu"> <label
					for="Chitieuhangthang">1 triệu - 5 triệu</label> <input
					type="radio" name="Chitieuhangthang" value="tu 5 den 10 trieu">
				<label for="Chitieuhangthang">từ 5 triệu đến 10 triệu</label> <input
					type="radio" name="Chitieuhangthang" value="tu 10 den 20 trieu">
				<label for="Chitieuhangthang">từ 10 triệu đến 20 triệu</label> <input
					type="radio" name="Chitieuhangthang" value="tren 20 trieu">
				<label for="Chitieuhangthang">trên 20 triệu</label>
			</div>

			<div class="clearfix">
					<input type="hidden" name="cusname" value="<%=cusName%>">
				<button type="button" class="cancelbtn" onclick="cancel()">Cancel</button>
				<button type="submit" class="signupbtn">Submit</button>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	function cancel() {
		window.location.href = "./userInfo.jsp";
	}
</script>
</html>