package com.banking.test.UserDAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.banking.dao.UsersDAO;
import com.banking.entity.Users;

class getUserByID {

	@Test
	void test() {
		int userID = 1;
		Users userTest = new Users();
		userTest.setFullName("Vu Chien Thang");
		userTest.setAddress("Soc Son - Ha Noi");
		userTest.setCccd("001099011185");
		userTest.setEmail("sainttroll99@gmail.com");
		userTest.setDob("1999-02-05");

		UsersDAO usersDAO = new UsersDAO();
		Users userFromDB = new Users();
		userFromDB = usersDAO.searchUsersID(userID);
		assertEquals(userFromDB.getAddress(), userTest.getAddress());
		assertEquals(userFromDB.getCccd(), userTest.getCccd());
		assertEquals(userFromDB.getDob(), userTest.getDob());
		assertEquals(userFromDB.getFullName(), userTest.getFullName());
		assertEquals(userFromDB.getEmail(), userTest.getEmail());
	}

	@Test
	void test1() {
		int userID = 99;
		UsersDAO usersDAO = new UsersDAO();
		Users userFromDB = new Users();
		userFromDB = usersDAO.searchUsersID(userID);
		assertEquals(userFromDB, null);
	}

}
