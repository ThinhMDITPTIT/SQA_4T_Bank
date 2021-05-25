<%-- 
    Document   : doDelete
    Created on : May 14, 2021, 2:02:33 PM
    Author     : thuan
--%>
<%@page import="com.banking.dao.HDVaydao"%>
<%@page import="com.banking.entity.HDVay"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
String id = request.getParameter("id");

          HDVaydao dao = new HDVaydao();
          dao.xoa(id);
          response.sendRedirect("xemHD.jsp");
%>