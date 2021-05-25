<!DOCTYPE html>
<%@page import="com.banking.entity.HopDongVay"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.banking.dao.HopDongVayDAO"%>
<%@page import="com.banking.dao.UsersDAO"%>
<%@page import="com.banking.entity.Users"%>
<html>
<head>
<meta charset="UTF-8">
<%@ page contentType="text/html; charset=UTF-8"%>
<title>Danh sách hợp đồng</title>
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
if (request.getParameter("userid") != null && request.getParameter("cusname") != null) {
	try {
		int userid = Integer.parseInt(request.getParameter("userid"));
		String cusName = request.getParameter("cusname").toString();
		HopDongVayDAO hopDongVayDAO = new HopDongVayDAO();
		ArrayList<HopDongVay> listHD = hopDongVayDAO.getHDVByUser(userid);
		UsersDAO userDAO = new UsersDAO();
		ArrayList<Users> listUser = userDAO.getInfoUser(userid);
%>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
	if (listHD.size() != 0) {
	%>

	<div style='margin-top: 20px'>
		<button onclick="location.href='userInfo.jsp?name=<%=cusName%>';">
			Quay lại
		</button>
	</div>

	<h1>Thông tin khách hàng và gói vay</h1>
	<%
	if (listUser.size() != 0) {
		Users u = listUser.get(0);
	%>
	<table>
		<tbody>
			<tr>
				<td>Họ và tên:</td>
				<td><%=u.getFullName()%></td>
			</tr>
			<tr>
				<td>Số CCCD:</td>
				<td><%=u.getCccd()%></td>
			</tr>
			<tr>
				<td>Số điện thoại:</td>
				<td>0<%=u.getPhone()%></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><%=u.getEmail()%></td>
			</tr>
			<tr>
				<td>Địa chỉ:</td>
				<td><%=u.getAddress()%></td>
			</tr>
		</tbody>
	</table>
	<%
	}
	%>

	<h2>Hợp đồng vay</h2>
	<table style="width: 60%">
		<thead>
			<tr>
				<th colspan="4">Các khoản vay</th>
			</tr>
			<tr style="text-align: center">
				<td>ID</td>
				<td>Thông tin</td>
				<td>Loại</td>
				<td>Kiểu vay</td>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < listHD.size(); i++) {
				HopDongVay hdv = listHD.get(i);
			%>
			<tr>
				<td style="text-align: center"><%=hdv.getID()%></td>
				<td>Số tiền vay: <%=hdv.getTienVay()%> VND <br> Thời gian
					vay: <%=hdv.getNgayVay()%> <br> Lãi suất: <%=hdv.getLaiSuat()%>
					<br> Kỳ hạn: <%=hdv.getKiHan()%>
				</td>
				<td style="text-align: center"><%=hdv.getLoaiGoiVay()%></td>
				<td style="text-align: center"><%=hdv.getGoiVay().getTenGoi()%></td>
				<td style="text-align: center">
					<button
						onclick="location.href='themPhieuNop.jsp?hdvid=<%=hdv.getID()%>&userid=<%=userid%>&cusname=<%=cusName%>';">
						Trả tiền
					</button>
				</td>
				<td style="text-align: center">
					<button 
						id="tinh_lai_vay"
						onclick="location.href='laiVay.jsp?hdvid=<%=hdv.getID()%>&userid=<%=userid%>&cusname=<%=cusName%>';">
						Tính lãi vay
					</button>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	} else {
	%>
	<div style='margin-top: 20px'>
		<button onclick="location.href='userInfo.jsp?name=<%=cusName%>';">
			Quay lại
		</button>
	</div>

	<h2>Khách hàng không có khoản vay</h2>
	<%
	}
	%>
</body>
<%
} catch (NumberFormatException e) {
response.sendRedirect("main.jsp");
}
} else
response.sendRedirect("main.jsp");
%>

</html>