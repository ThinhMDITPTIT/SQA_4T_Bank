<%@ page contentType="text/html; charset=UTF-8" %> 
<%
	String username = (String)session.getAttribute("username");	
%>
<div align="center">
	<div style='display: flex; justify-content: space-between; align-items: center; height: 30px'>
		<div style='display: block'>
			<h1 style: 'margin: 0; padding: 0'>Ngân hàng 4T<h1>
		</div>
		<div style='display: block'>
			<a>Wellcome!! <%= username %></a>
			<button id="log_out_button" onclick="location.href='../';">Đăng xuất</button>
		</div>
	</div>
</div>