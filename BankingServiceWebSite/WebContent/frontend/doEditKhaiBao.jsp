<%@page import="com.banking.dao.ToKhaiDAO"%>
<%@page import="com.banking.entity.ToKhai"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	String customerID = (String) request.getParameter("customerid");
	String tkIDStr = (String) request.getParameter("tkid");
	String nghenghiep = (String)request.getParameter("Nghenghiep");
	String chucvu = (String)request.getParameter("Chucvu");
	String tencongty = (String)request.getParameter("Tencongty");
	String diachicongty = (String)request.getParameter("Diachicongty");
	String mucluong = (String)request.getParameter("Mucluong");
	String chitieuhangthang = (String)request.getParameter("Chitieuhangthang");
	int userID = Integer.parseInt(customerID.trim());
	int tkID= Integer.parseInt(tkIDStr.trim());
	ToKhai tk= new ToKhai();
	tk.setID(tkID);
	tk.setChucvu(chucvu);
	tk.setNghenghiep(nghenghiep);
	tk.setTencongty(tencongty);
	tk.setDiachicongty(diachicongty);
	tk.setMucluong(mucluong);
	tk.setChitieuhangthang(chitieuhangthang);
	
	ToKhaiDAO tokhaiDao = new ToKhaiDAO();
	
	boolean kq = tokhaiDao.updateToKhai(tk);
	if(kq){
		response.sendRedirect("DSKhaiBao.jsp?customerid="+customerID+"&editstatus=200");
	}else{
		response.sendRedirect("EditKhaiBao.jsp?mess=fail");
	}
%>