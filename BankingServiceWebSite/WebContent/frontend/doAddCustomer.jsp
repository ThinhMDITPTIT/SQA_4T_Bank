<%@page import="com.banking.dao.UsersDAO"%>
<%@page import="com.banking.dao.CmndDAO"%>
<%@page import="com.banking.entity.Users"%>
<%@page import="com.banking.entity.Cmnd"%>
<%
	String cmnd = (String) request.getParameter("cmnd");
	String noicap = (String) request.getParameter("noicap");
	String ngaycap = (String) request.getParameter("ngaycap");
	String dcThuongTru = (String) request.getParameter("dcthuongtru");
	String dob = (String) request.getParameter("dob");
	String sdt = (String) request.getParameter("sdt");
	String dchientai = (String) request.getParameter("dchientai");
	String email = (String) request.getParameter("email");
	String hoten= (String) request.getParameter("hoten");

	Cmnd cmndEntity = new Cmnd();
	cmndEntity.setSoCmnd(cmnd);
	cmndEntity.setNoiCap(noicap);
	cmndEntity.setNgaycap(ngaycap);
	cmndEntity.setDCThuongTru(dcThuongTru);
	
	Users customer = new Users();
	customer.setFullName(hoten);
	customer.setCccd(cmnd);
	customer.setDob(dob);
	customer.setPhone(sdt);
	customer.setEmail(email);
	customer.setAddress(dchientai);
	
	CmndDAO cmndDAO= new CmndDAO();
	UsersDAO usersDAO = new UsersDAO();
	boolean kqAddCmnd = cmndDAO.addCmnd(cmndEntity);
	if(kqAddCmnd){
		boolean kqAddCustomer = usersDAO.addCustomer(customer);
		if(kqAddCustomer){
			response.sendRedirect("./searchUser.jsp?mess=success");
		}
	}else{
		response.sendRedirect("addCustomer.jsp?mess=fail");
	}
%>
