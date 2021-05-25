<%@page import="com.banking.dao.HDVaydao"%>
<%@page import="com.banking.entity.HDVay"%>
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
<title>Insert title here</title>
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

}
</style>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
String customerIDStr = request.getParameter("customerid");
String cusName = request.getParameter("cusname");
Users user = new Users();
ToKhai tk = new ToKhai();
Cmnd cmnds = new Cmnd();
String tkID = request.getParameter("tkid");
ArrayList<HDVay> hdVay = new ArrayList<HDVay>();
int tkid = Integer.parseInt(tkID);
if(customerIDStr != null && customerIDStr.length()>0){
	int customerID= Integer.parseInt(customerIDStr.trim());
	UsersDAO usersDAO = new UsersDAO();
	user = usersDAO.searchUsersID(customerID);
	ToKhaiDAO tkDAO = new ToKhaiDAO();
	CmndDAO cmndDAO = new CmndDAO();
	tk = tkDAO.getTKByID(tkid);
	if(user.getCccd()!=null){
		cmnds = cmndDAO.getCmnd(user.getCccd());
	}
	HDVaydao hdVayDAO = new HDVaydao();
    hdVay = hdVayDAO.searchHDVayByTKId(tkid, customerID);
}	
%>

	<div style='margin-top: 20px; margin-bottom: 20px'>
		<button onclick="location.href='DSKhaiBao.jsp?customerid=<%=customerIDStr%>&cusname=<%=cusName%>';">Quay lại</button>
	</div>


<p>Thông tin Khách hàng</p>
			<table>
				<thead>
					<tr>
						<td>Họ tên</td>
						<td>Email</td>
						<td>CMND/CCCD</td>
						<td>Nơi Cấp</td>
						<td>Ngày cấp</td>
						<td>Phone</td>
						<td>Address</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=user.getFullName()%></td>
						<td><%=user.getEmail()%></td>
						<td><%=user.getCccd()%></td>
						<td><%=cmnds.getNoiCap() %></td>
						<td><%=cmnds.getNgaycap() %></td>
						<td><%=user.getPhone()%></td>
						<td><%=user.getAddress()%></td>
					</tr>
					
				</tbody>

			</table>
<p>Thông tin khai báo vay</p>
    <table>
		<thead>
			<tr>
				
				<td>Nghề nghiệp</td>
				<td>Chức vụ</td>
				<td>Làm việc tại</td>
				<td>Địa chỉ nơi làm việc</td>
				<td>Mức lương</td>
				<td>Mức chi tiêu</td>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><%=tk.getNghenghiep()%></td>
					<td><%=tk.getChucvu() %></td>
					<td><%=tk.getTencongty() %></td>
					<td><%=tk.getDiachicongty() %></td>
					<td><%=tk.getMucluong() %></td>
					<td><%=tk.getChitieuhangthang() %></td>
				</tr>
		</tbody>
		
	</table>
                        <% if(hdVay == null || hdVay.size()<1){%>
            <h1>Giao diện thêm mới hợp đồng vay</h1>
        <form name="them" action="doAddHD.jsp" method="post">
            <table>
                <tr>
                    <td>Gói Vay</td>
                    <td>
                        <input type="radio" name="goivay" value="1" required>Lãi suất dư nợ
                        <input type="radio" name="goivay" value="2">Lãi suất cố định
                        
                    </td>
                </tr>
                <tr>
                    <td>User ID</td>
                    <td>
                        <input type="text" name="userID" value="<%=customerIDStr%>" style="background-color: grey;" readonly>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <label for="ngayvay">Ngày Vay: </label>
                    <input type="date" id="ngayvay" name="ngayvay" required>
                    
                </tr>
                <tr>
                <td>Kì Hạn</td>
                    <td>
                        <input type="radio" name="kiHan" value="1 thang" required>1 tháng
                        <input type="radio" name="kiHan" value="3 thang">3 tháng
                        <input type="radio" name="kiHan" value="6 thang">6 tháng  
                        <input type="radio" name="kiHan" value="12 thang">12 tháng
                    </td>
                </tr>
                    <tr>    
                <td>Trạng thái</td>
                    <td>
                        <input type="radio" name="trangthai" value="chua duyet" required>Chưa duyệt
                        <input type="radio" name="trangthai" value="da duyet">Đã duyệt                        
                    </td>
                    </tr>
                <tr>
                    <td>Tiền vay</td>
                    <td>
                        <input type="number" min ="0"  name="tienvay" required>
                    </td>
                </tr>
                <tr>
                    <td>Tờ khai ID</td>
                    <td>
                        <input type="text" name="tokhaiID" value="<%=tkID%>" style="background-color: grey;" readonly>
                    </td>
                </tr>
                    
                    <td><input type="submit" value="Thêm mới"></td>
                
            </table>
            
        </form>        
        <% }
        else{ %>
            <h1>Giao diện sửa hợp đồng</h1>
        <form name="capnhat" action="doUpdate.jsp" onsubmit="return check()" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td>
                        <input value="<%=hdVay.get(0).getid() %>" type="text" name="ID" style="background-color: grey;" readonly>
                    </td>
                </tr>
                <tr>
                    <td>Gói Vay</td>
                    <td>
                        <input type="radio" name="goivay" value="1" <%=hdVay.get(0).getGoivayID() == 1?"checked":""%>>Lãi suất dư nợ
                        <input type="radio" name="goivay" value="2" <%=hdVay.get(0).getGoivayID() == 2?"checked":""%>>Lãi suất cố định
                        
                    </td>
                </tr>
                <tr>
                    <td>User ID</td>
                    <td>
                        <input value="<%=hdVay.get(0).getUserID() %>" type="text" name="userID" style="background-color: grey;" readonly>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <label for="ngayvay">Ngày Vay: </label>
                    <input value="<%=hdVay.get(0).getNgayvay() %>" type="date" id="ngayvay" name="ngayvay">
                    
                </tr>
                <tr>
                <td>Kì Hạn</td>
                    <td>
                        <input type="radio" name="kiHan" value="1 thang" <% if(hdVay.get(0).getkiHan().equalsIgnoreCase("1 thang")) { %> checked <% } %>>1 tháng
                        <input type="radio" name="kiHan" value="3 thang" <% if(hdVay.get(0).getkiHan().equalsIgnoreCase("3 thang")) { %> checked <% } %>>3 tháng
                        <input type="radio" name="kiHan" value="6 thang" <% if(hdVay.get(0).getkiHan().equalsIgnoreCase("6 thang")) { %> checked <% } %>>6 tháng 
                        <input type="radio" name="kiHan" value="12 thang" <% if(hdVay.get(0).getkiHan().equalsIgnoreCase("12 thang")) { %> checked <% } %>>12 tháng
                    </td>
                </tr>
                <tr>
                <td>Trạng thái</td>
                    <td>
                        <input type="radio" name="trangthai" value="chua duyet" <% if(hdVay.get(0).getTrangthai().equalsIgnoreCase("chua duyet")) { %> checked <% } %>>Chưa duyệt
                        <input type="radio" name="trangthai" value="da duyet" <% if(hdVay.get(0).getTrangthai().equalsIgnoreCase("da duyet")) { %> checked <% } %>>Đã duyệt                        
                    </td>
                </tr>
                <tr>
                    <td>Tiền vay</td>
                    <td>
                        <input value="<%=hdVay.get(0).getTienVay() %>" type="text" name="tienvay">
                    </td>
                </tr>
                <tr>
                    <td>Tờ khai ID</td>
                    <td>
                        <input value="<%=hdVay.get(0).gettokhaiID() %>" type="text" name="tokhaiID" style="background-color: grey;" readonly>
                    </td>
                </tr>
                    
                    <td><input type="submit" value="Cập nhật"></td>
                </tr>
            </table>
                
        </form>
            <div style='margin-top: 20px'>
		<a href="xemHD.jsp"><button>Quay lại</button></a>
	</div>
        <% }
        %>
        
</body>
</html>