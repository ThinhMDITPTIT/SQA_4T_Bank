<!DOCTYPE>
<%@page import="com.banking.entity.Users"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.banking.dao.UsersDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Tim kiem khach hang</title>
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
<%
String username = (String) session.getAttribute("username");
if (session.getAttribute("username") == null) {
%>
<c:redirect url="./login.jsp"></c:redirect>
<%
}
%>
<%
String name = request.getParameter("name");
ArrayList<Users> listUser = new ArrayList<Users>();
if (name != null && name.length() > 0) {
	name = name.trim();
	UsersDAO userDAO = new UsersDAO();
	listUser = userDAO.searchUsers(name);
}
%>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style='margin-top: 20px'>
		<a href="searchUser.jsp"><button>Quay lại</button></a>
	</div>
	<%
	if (name != null && name.length() > 0) {
	%>
	<%
		if (listUser.size() == 0) {
	%>
	<h1 id="khong_ton_tai_khach_hang">Không có khách hàng</h1>
	<%
		} else {
	%>
	<h2>Danh sách khách hàng</h2>

	<table>
		<thead style="text-align: center">
			<tr>
				<td>STT</td>
				<td>Họ tên</td>
				<td>Email</td>
				<td colspan="2">Thao tác</td>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < listUser.size(); i++) {
				Users u = listUser.get(i);
			%>
			<tr>
				<td style="text-align: center"><%=i + 1%></td>
				<td id="full_name_khach_hang"><%=u.getFullName()%></td>
				<td><%=u.getEmail()%></td>
				<td>
					<button 
						id="xem_cac_khoan_vay"
						onclick="location.href='chonKhoanVay.jsp?userid=<%=u.getUserId()%>&cusname=<%=name%>';"
					>
						Xem các khoản vay
					</button>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
		<%
		}
		%>
	</table>
	<%
	}
	%>
</body>
</html>