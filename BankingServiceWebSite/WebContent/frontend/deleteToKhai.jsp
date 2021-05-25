
<%@page import="com.banking.dao.ToKhaiDAO"%>
<%
	String tkIDStr= (String) request.getParameter("id");
	String customerIDStr = request.getParameter("customerid");
	String cusName = request.getParameter("cusname");
	int tkID = Integer.parseInt(tkIDStr);
	ToKhaiDAO tkDAO = new ToKhaiDAO();
	
	boolean kq = tkDAO.deleteToKhai(tkID);
	if(kq){
		response.sendRedirect("./DSKhaiBao.jsp?deletemess=success&customerid="+customerIDStr+"&cusname="+cusName);
	}else{
		response.sendRedirect("./DSKhaiBao.jsp?deletemess=fail&customerid="+customerIDStr+"&cusname="+cusName);
	}
%>