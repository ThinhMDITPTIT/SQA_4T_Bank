<%-- 
    Document   : doUpdate
    Created on : May 14, 2021, 2:02:16 PM
    Author     : thuan
--%>

<%@page import="com.banking.dao.HDVaydao"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    try {
        int id = Integer.parseInt(request.getParameter("ID"));
        int hgoivayid = Integer.parseInt(request.getParameter("goivay"));
        int huserid = Integer.parseInt(request.getParameter("userID"));        
            Date hngayvay = Date.valueOf(request.getParameter("ngayvay"));                 
        String hkihan = request.getParameter("kiHan");       
        String htrangthai = request.getParameter("trangthai");
        float htienvay = Float.parseFloat(request.getParameter("tienvay"));
        int htokhaiid = Integer.parseInt(request.getParameter("tokhaiID"));
        HDVaydao dao = new HDVaydao();
        dao.suaHD(id, hgoivayid, huserid, hngayvay, hkihan, htrangthai, htienvay, htokhaiid);
        response.sendRedirect("xemHD.jsp");
    }
    catch(Exception e){
    }
%>