package com.banking.test.ToKhaiDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.banking.dao.DAO;
import com.banking.dao.ToKhaiDAO;
import com.banking.entity.ToKhai;

class addToKhai extends DAO {
	@Test
	void test() throws ClassNotFoundException, SQLException {
		connection.setAutoCommit(false);
		boolean resultTest = true;
		try {
			ToKhai tk1 = new ToKhai();
			tk1.setUserID(3);
			tk1.setNghenghiep("Cong Chuc");
			tk1.setChucvu("Nhan Vien");
			tk1.setDiachicongty("Quan Uy Thanh Xuan");
			tk1.setTencongty("UBND Quan Thanh Xuan");
			tk1.setMucluong("tu 10 den 20 trieu");
			tk1.setChitieuhangthang("tu 5 den 10 trieu");
			ToKhaiDAO toKhaiDAO = new ToKhaiDAO();
			boolean result = toKhaiDAO.addTokhai(tk1);
			assertEquals(result, resultTest);

		}
		finally {
			connection.rollback();
		}

	}

	@Test
	void test2() throws ClassNotFoundException, SQLException {
		boolean resultTest = false;
		ToKhai tk1 = new ToKhai();
		tk1.setNghenghiep("Cong Chuc");
		tk1.setChucvu("Nhan Vien");
		tk1.setDiachicongty("Quan Uy Thanh Xuan");
		tk1.setTencongty("UBND Quan Thanh Xuan");
		tk1.setMucluong("tu 10 den 20 trieu");
		tk1.setChitieuhangthang("tu 5 den 10 trieu");
		ToKhaiDAO toKhaiDAO = new ToKhaiDAO();
		boolean result = toKhaiDAO.addTokhai(tk1);
		assertEquals(result, resultTest);
		connection.close();
	}
}
