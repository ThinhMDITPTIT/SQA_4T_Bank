package com.banking.test.UserDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.banking.dao.CmndDAO;
import com.banking.dao.DAO;
import com.banking.dao.UsersDAO;
import com.banking.entity.Cmnd;
import com.banking.entity.Users;

class addUser extends DAO {

	@Test
	void test() throws ClassNotFoundException, SQLException {
		boolean kq = true;
		connection.setAutoCommit(false);
		try {
			Users user = new Users();
			user.setFullName("Truong Dinh Tien");
			user.setCccd("0123124155114141");
			user.setPhone("0385676597");
			user.setEmail("tientruong@gmail.com");
			user.setAddress("Thanh Xuan - Ha Noi");
			user.setDob("1997-03-16");
			Cmnd cmnd = new Cmnd();
			cmnd.setSoCmnd("0123124155114141");
			cmnd.setNgaycap("2012-04-02");
			cmnd.setNoiCap("Ha noi");
			cmnd.setDCThuongTru("Thanh Xuan - Ha noi");
			CmndDAO cmndDAO = new CmndDAO();
			assertEquals(cmndDAO.addCmnd(cmnd), true);
			UsersDAO usersDAO = new UsersDAO();
			assertEquals(usersDAO.addCustomer(user), kq);
		} finally {
			connection.rollback();
			connection.close();
		}
	}

	// Chỉ add bảng User k add bảng CMND
	@Test
	void test2() throws ClassNotFoundException, SQLException {
		boolean kq = false;
		Users user = new Users();
		user.setFullName("Truong Dinh Tien");
		user.setCccd("017351215");
		user.setPhone("0385676597");
		user.setEmail("tientruong@gmail.com");
		user.setAddress("Thanh Xuan - Ha Noi");
		user.setDob("1997-03-16");
		UsersDAO usersDAO = new UsersDAO();
		assertEquals(usersDAO.addCustomer(user), kq);
	}
}
