<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.banking.entity.HopDongVay"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.banking.dao.HopDongVayDAO"%>
<%@page import="com.banking.dao.ChiTietLaiVayDAO"%>
<%@page import="com.banking.entity.Users"%>
<%@page import="com.banking.entity.ChiTietLaiVay"%>
<%@page import="com.banking.dao.UsersDAO"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page contentType="text/html; charset=UTF-8" %> 
<title>Insert title here</title>
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
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
if(request.getParameter("hdvid") != null 
		&& request.getParameter("userid") != null 
		&& request.getParameter("cusname") != null 
		&& request.getParameter("beforedate") != null
		&& request.getParameter("afterdate") != null
		&& request.getParameter("timeid") != null
	){
		try{
	int hdvid = Integer.parseInt(request.getParameter("hdvid"));
	int userid = Integer.parseInt(request.getParameter("userid"));
	String cusName = request.getParameter("cusname").toString();
	int timeid = Integer.parseInt(request.getParameter("timeid"));
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Calendar calender1 = Calendar.getInstance();
	Calendar calender2 = Calendar.getInstance();
	calender1.setTime(formatter.parse(request.getParameter("beforedate").toString()));
	calender2.setTime(formatter.parse(request.getParameter("afterdate").toString()));
	
	String beforeDate = formatter.format(calender1.getTime());
	String afterDate = formatter.format(calender2.getTime());
	
	UsersDAO userDAO = new UsersDAO();
	ArrayList<Users> listUser = userDAO.getInfoUser(hdvid);
	ChiTietLaiVayDAO ctlvDAO = new ChiTietLaiVayDAO();
	ArrayList<ChiTietLaiVay> listLV = ctlvDAO.getCTLVByID(hdvid);
	
	HopDongVayDAO hopDongVayDAO = new HopDongVayDAO();
	if(hopDongVayDAO.checkHD(hdvid)){
		HopDongVay hdv = hopDongVayDAO.getByID(hdvid);
		String tenGoiVay = hdv.getGoiVay().getTenGoi();
		String thoiGian = hdv.getKiHan();
		String kiHan = thoiGian.substring(0,2);
		int kiHanTG = Integer.parseInt(kiHan.trim());
		String lvduno = "lai suat du no";
		String lvcodinh = "lai suat co dinh";
		float goc = 0;
		float lai = 0;
		if((tenGoiVay.trim()).equalsIgnoreCase(lvcodinh)) { 
	//lai vay co dinh
	goc = 0;
	lai = hdv.getTienVay()* (hdv.getGoiVay().getLaiSuat()/kiHanTG);
		} else {
	//lai vay du no
	goc = hdv.getTienVay()/kiHanTG;
	lai = (hdv.getTienVay() - ((hdv.getTienVay()/kiHanTG)*(timeid-1))) * hdv.getGoiVay().getLaiSuat();
		}
%>
	<div style='margin-top: 20px'>
		<a href="themPhieuNop.jsp?hdvid=<%=hdvid%>&userid=<%=userid%>&cusname=<%=cusName%>"><button>Quay lại</button></a>
	</div>
	
	<h2>Thêm phiếu nộp chi tiết</h2>
		<form action="doThemPhieuNop.jsp" method = "POST">
			<table>
				<tr>
					<td>Thời gian:</td>
					<td>[<%=beforeDate %>] - [<%=afterDate %>]</td>
					<input type="hidden" min ="0" id="timeid" value="<%=timeid %>" name="timeid">
				</tr>
				<tr>
					<td>Tiền lãi:</td>
					<td><%=lai %> VND</td>
					<input type="hidden" min ="0" id="lai" value="<%=lai %>" name="lai">
				</tr>
				<tr>
					<td>Tiền gốc:</td>
					<td><%=goc %> VND</td>
					<input type="hidden" min ="0" id="goc" value="<%=goc %>" name="goc">
				</tr>
				<tr>
					<input type="hidden" name="hdvid" value="<%=hdvid%>">
					<input type="hidden" name="userid" value="<%=userid%>">
					<input type="hidden" name="cusname" value="<%=cusName%>">
					<td colspan="2"><button type="submit" style="width: 100%">Nôp tiền</button></td>
				</tr>
			</table>
		</form>
<% 	
			}
			else{
				response.sendRedirect("index.jsp");
			}
		}catch(NumberFormatException e){
			response.sendRedirect("main.jsp");
		}
	}else response.sendRedirect("main.jsp");
	
%>
</body>
</html>