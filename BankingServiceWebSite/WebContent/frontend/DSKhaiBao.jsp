<%@page import="com.banking.dao.CmndDAO"%>
<%@page import="com.banking.dao.ToKhaiDAO"%>
<%@page import="com.banking.entity.Cmnd"%>
<%@page import="com.banking.entity.ToKhai"%>
<%@page import="com.banking.dao.UsersDAO"%>
<%@page import="com.banking.entity.Users"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Tờ Khai</title>
</head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
table, th, td {
	  border: 1px solid black;
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
<body>
	<jsp:include page="header.jsp"></jsp:include>
<%	if(request.getParameter("deletemess") !=null && request.getParameter("deletemess").equalsIgnoreCase("fail")){
          %><script>
          	window.alert("Lỗi xảy ra khi thực hiện xóa!!!");
          </script><%
      } 
      %>
      <% if(request.getParameter("deletemess") !=null && request.getParameter("deletemess").equalsIgnoreCase("success")){
          %><script>
          	window.alert("Xóa tờ khai thành Công!!!");
          </script><%
      } 
      %>
       <% if(request.getParameter("editstatus") !=null && request.getParameter("editstatus").equalsIgnoreCase("200")){
          %><script>
          	window.alert("Sửa tờ khai thành Công!!!");
          </script><%
      } 
      %>
<%
String customerIDStr = request.getParameter("customerid");
String cusName = request.getParameter("cusname");
Users user = new Users();
ArrayList<ToKhai> tk = new ArrayList<ToKhai>();
ArrayList<Cmnd> cmnds = new ArrayList<Cmnd>();

if(customerIDStr != null && customerIDStr.length()>0){
	int customerID= Integer.parseInt(customerIDStr.trim());
	UsersDAO usersDAO = new UsersDAO();
	user = usersDAO.searchUsersID(customerID);
	ToKhaiDAO tkDAO = new ToKhaiDAO();
	CmndDAO cmndDAO = new CmndDAO();
	tk = tkDAO.getAllToKhai(customerID);
}	

%>
	<div style='margin-top: 20px; margin-bottom: 20px'>
		<button onclick="location.href='userInfo.jsp?name=<%=cusName%>';">Quay lại</button>
	</div>

<a href="./KhaiBao.jsp?customerid=<%=customerIDStr %>&cusname=<%=cusName%>"><button>Thêm mới</button></a>
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
<p>Danh sách tờ khai</p>
    <table>
		<thead>
			<tr>
				<td>STT</td>
				<td>Nghề nghiệp</td>
				<td>Chức vụ</td>
				<td>Tên công ty</td>
				<td>Địa chỉ công ty</td>
				<td>Mức thu nhập</td>
				<td>Mức chi tiêu hằng tháng</td>
				<td>Thời gian tạo</td>
				<td colspan="3">Thao tác</td>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0 ; i < tk.size(); i++) {
				ToKhai u = tk.get(i);
			%>
				<tr>
					<td><%=i+1 %></td>
					<td><%=u.getNghenghiep() %></td>
					<td><%=u.getChucvu() %></td>
					<td><%=u.getTencongty() %></td>
					<td><%=u.getDiachicongty() %></td>
					<td><%=u.getMucluong() %></td>
					<td><%=u.getChitieuhangthang() %></td>
					<td><%=u.getCreatedAt().toString() %></td>
					<td><a href="deleteToKhai.jsp?id=<%=u.getID() %>&customerid=<%=customerIDStr %>&cusname=<%=cusName%>"><button>Xóa</button></a></td>
					<td><a href="EditToKhai.jsp?tkid=<%=u.getID() %>&customerid=<%=customerIDStr %>"><button>Sửa</button></a></td>
					<td><a href="VayLai.jsp?customerid=<%=customerIDStr%>&tkid=<%=u.getID()%>&cusname=<%=cusName%>"><button>Chọn</button></a></td>
				</tr>
			<%} %>
		</tbody>
		
	</table>
</body>
</html>