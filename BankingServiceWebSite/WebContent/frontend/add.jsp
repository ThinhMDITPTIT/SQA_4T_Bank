<%-- 
    Document   : add
    Created on : May 14, 2021, 1:08:53 PM
    Author     : thuan
--%>
<%@page import="com.banking.entity.HDVay"%>
<%@page import="com.banking.dao.HDVaydao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add HD</title>
        
    </head>
    <body>
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
                        <input type="text" name="userID" required>
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
                        <input type="text" name="tokhaiID" required>
                    </td>
                </tr>
                    
                    <td><input type="submit" value="Thêm mới"></td>
                
            </table>
            
        </form>
        <div style='margin-top: 20px'>
		<a href="main.jsp"><button>Quay lại</button></a>
	</div>
    </body>
</html>
