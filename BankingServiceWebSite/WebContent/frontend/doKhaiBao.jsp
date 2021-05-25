<%@page import="com.banking.dao.ToKhaiDAO"%>
<%@page import="com.banking.entity.ToKhai"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	String customerID = (String) request.getParameter("customerid");
	String nghenghiep = (String)request.getParameter("Nghenghiep");
	String chucvu = (String)request.getParameter("Chucvu");
	String tencongty = (String)request.getParameter("Tencongty");
	String diachicongty = (String)request.getParameter("Diachicongty");
	String mucluong = (String)request.getParameter("Mucluong");
	String chitieuhangthang = (String)request.getParameter("Chitieuhangthang");
	String cusName = (String)request.getParameter("cusname");
	int userID = Integer.parseInt(customerID.trim());
	ToKhai tk= new ToKhai(userID,nghenghiep,chucvu,tencongty,diachicongty,mucluong,chitieuhangthang);
	
	ToKhaiDAO tokhaiDao = new ToKhaiDAO();
	
	boolean kq = tokhaiDao.addTokhai(tk);
	if(kq){
		response.sendRedirect("DSKhaiBao.jsp?customerid="+customerID+"&cusname="+cusName);
	}else{
		response.sendRedirect("KhaiBao.jsp");
	}
%>