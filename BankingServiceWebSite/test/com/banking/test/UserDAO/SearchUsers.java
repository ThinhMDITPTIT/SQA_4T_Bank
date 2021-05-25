package com.banking.test.UserDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.banking.dao.UsersDAO;
import com.banking.entity.Users;

class SearchUsers {

	@Test
	void test() throws ClassNotFoundException, SQLException {
		String name = "Ta Xuan Toan";
		Users user = new Users();
		ArrayList<Users> userlistTest1 = new ArrayList<Users>();
		ArrayList<Users> userlistTest2 = new ArrayList<Users>();
		user.setUserId(2);
		user.setEmail("toanta@gmail.com");
		user.setFullName("Ta Xuan Toan");
		userlistTest1.add(user);
		UsersDAO usersDAO = new UsersDAO();
		userlistTest2 = usersDAO.searchUsers(name);
		assertEquals(userlistTest2.size(), userlistTest1.size());
		for (int i = 0; i < userlistTest2.size(); i++) {
			assertEquals(userlistTest2.get(i).getFullName(), userlistTest1.get(i).getFullName());
			assertEquals(userlistTest2.get(i).getEmail(), userlistTest1.get(i).getEmail());
		}

	}

	// Test search user not exist
	@Test
	void test1() throws ClassNotFoundException, SQLException {
		String name = "Truong Van Nam";
		Users user = new Users();
		ArrayList<Users> userListFromDB = new ArrayList<Users>();
		UsersDAO usersDAO = new UsersDAO();
		userListFromDB = usersDAO.searchUsers(name);
		assertEquals(userListFromDB.size(), 0);
	}
}
