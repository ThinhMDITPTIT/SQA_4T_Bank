package com.banking.test.UserDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.banking.dao.UsersDAO;

class checkLogin {

	@Test
	void test1() throws ClassNotFoundException, SQLException {
		boolean kq = true;
		String username = "thangvu99";
		String password = "thang12345";
		UsersDAO usersDAO = new UsersDAO();
		assertEquals(usersDAO.checkLogin(username, password), kq);
	}

	@Test
	void test2() throws ClassNotFoundException, SQLException {
		boolean kq = true;
		String username = "toanta99";
		String password = "toan12345";
		UsersDAO usersDAO = new UsersDAO();
		assertEquals(usersDAO.checkLogin(username, password), kq);
	}

	@Test
	void testLoginFail() throws ClassNotFoundException, SQLException {
		boolean kq = false;
		String username = "bnasdasd";
		String password = "ádasdasd";
		UsersDAO usersDAO = new UsersDAO();
		assertEquals(usersDAO.checkLogin(username, password), kq);
	}
}
