package com.banking.test.UserDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.banking.dao.UsersDAO;

class TestIsAdmin {

	@Test
	void test() throws ClassNotFoundException, SQLException {
		boolean kq = true;
		String username = "thinhme99";
		UsersDAO usersDAO = new UsersDAO();
		assertEquals(usersDAO.isAdmin(username), kq);
	}

	
	@Test
	void test1() throws ClassNotFoundException, SQLException {
		boolean kq = false;
		String username = "toanta99";
		UsersDAO usersDAO = new UsersDAO();
		assertEquals(usersDAO.isAdmin(username), kq);
	}

	
	@Test
	void test2() throws ClassNotFoundException, SQLException {
		boolean kq = false;
		String username = "toanta99";
		UsersDAO usersDAO = new UsersDAO();
		assertEquals(usersDAO.isAdmin(username), kq);
	}

}
