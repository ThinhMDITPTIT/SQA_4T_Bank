<%@page import="com.banking.dao.UsersDAO"%>
<%@page import="com.banking.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
session.removeAttribute("username");
	String username = (String) request.getParameter("username");
String password = (String) request.getParameter("password");

Users userlogin = new Users();
userlogin.setUserName(username);
userlogin.setPassword(password);
UsersDAO userDao= new UsersDAO();
boolean kq = userDao.checkLogin(userlogin.getUserName(),userlogin.getPassword());
session.setAttribute("username", userlogin.getUserName());

if (kq) {
	boolean isAdmin = userDao.isAdmin(username);
	if(isAdmin){
		session.setAttribute("role", "ADMIN");
		response.sendRedirect("./main.jsp?mess="+userlogin.getUserName()+"?role=ADMIN");
	}else{
		session.setAttribute("role", "CUSTOMER");
		response.sendRedirect("./login.jsp?mess="+userlogin.getUserName()+"?role=CUSTOMER");

	}
} else {
	response.sendRedirect("login.jsp?mess=fail");
}
%>