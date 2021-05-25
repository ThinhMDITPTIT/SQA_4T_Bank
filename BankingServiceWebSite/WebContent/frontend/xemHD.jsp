<%-- 
    Document   : themHD
    Created on : May 14, 2021, 2:38:23 AM
    Author     : thuan
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.banking.dao.HDVaydao"%>
<%@page import="com.banking.entity.HDVay"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vay Lãi</title>
    </head>
    <% 
	HDVaydao dao= new HDVaydao();
        ArrayList<HDVay> listHD = dao.getHDVays();	
	
%>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
	<%	if(request.getParameter("mess") !=null && request.getParameter("mess").equalsIgnoreCase("success")){
          %><script>
          	window.alert("Thêm mới khách hàng thành công !");
          </script><%
      } 
      %>
        <div style='margin-top: 20px'>
		<a href="main.jsp"><button>Quay lại</button></a>
	</div>
        <div style='margin-top: 20px'>
		<a href="addCustomer.jsp"><button>Thêm khách hàng</button></a>
	</div>
	<h2>Tìm kiếm khách hàng</h2>
	<table>
		<form action="userInfo.jsp" method="POST" >
			<tr>
				<td>Nhập tên khách hàng:</td>
				<td><input type="text" required id ="name" name ="name"  autofocus/></td>
			</tr>
			<tr>
				<td style="text-align: right" colspan="2"><button type = "submit">Tìm khách hàng</button></td>
			</tr>
		</form>
	</table>
        
        <h1>Danh sách hợp đồng vay</h1>
            <table border="1px solid black">
                <tr>
                    <th>ID</th>
                    <th>Gói Vay ID</th>
                    <th>user ID</th>
                    <th>Ngày vay</th>
                    <th>Kì Hạn</th>
                    <th>Trạng thái</th>
                    <th>Tiền Vay</th>
                    <th>Tờ khai ID</th>
                </tr>
                <%for (int i = 0 ; i < listHD.size(); i++) {
				HDVay u = listHD.get(i);
			%>
                        <tr>
					<td><%=u.getid() %></td>
					<td><%=u.getGoivayID() %></td>
					<td><%=u.getUserID() %></td>
					<td><%=u.getNgayvay() %></td>
					<td><%=u.getkiHan() %></td>
					<td><%=u.getTrangthai() %></td>
					<td><%=u.getTienVay() %></td>
                                        <td><%=u.gettokhaiID()%></td>
					
                                        <td>                        
                                            <%  if(u.getTrangthai().equalsIgnoreCase("da duyet") ) { %>
                                            <button disabled="true" onclick="location.href='update.jsp?id=<%=u.getid()%>';">Update</button>
                                            <button disabled="true" onclick="showMess(<%=u.getid()%>)">Delete</button> 
                                           <% }
                                             else { %>
                                            <button onclick="location.href='update.jsp?id=<%=u.getid()%>';">Update</button>
                                            <button onclick="showMess(<%=u.getid()%>)">Delete</button> 
                                            <%}
                                                 %>              
                                        </td>
				</tr>
                                <%} %>
                        
                        


        </table>            
                      
    </body>
    <script>        
        function showMess(id){
            var option = confirm('bạn chắc chắn muốn xóa ?');
            if(option === true){
                window.location.href = 'doDelete.jsp?id=' + id;
            }
            
        }
            
    </script>
</html>
