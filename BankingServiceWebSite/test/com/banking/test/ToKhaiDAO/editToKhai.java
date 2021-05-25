package com.banking.test.ToKhaiDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.banking.dao.DAO;
import com.banking.dao.ToKhaiDAO;
import com.banking.entity.ToKhai;

class editToKhai extends DAO {

	@Test
	void test() throws SQLException {
		connection.setAutoCommit(false);
		boolean resultTest = true;
		try {
			ToKhai dataTest = new ToKhai();
			dataTest.setID(1);
			dataTest.setNghenghiep("hoc sinh");
			dataTest.setChitieuhangthang("1 Trieu den 5 trieu");
			dataTest.setChucvu("sinh vien");
			dataTest.setDiachicongty("PTIT");
			dataTest.setMucluong("5 trieu den 10 trieu");
			ToKhaiDAO toKhaiDAO = new ToKhaiDAO();
			boolean result = toKhaiDAO.updateToKhai(dataTest);
			assertEquals(result, resultTest);
		} finally {
			connection.rollback();
			connection.close();
		}
	}

	// test Update a Tokhai isn`t exist
	@Test
	void test1() throws SQLException {
		boolean resultTest = false;
		ToKhai dataTest = new ToKhai();
		dataTest.setID(99);
		dataTest.setNghenghiep("sinh vien");
		dataTest.setChitieuhangthang("1 Trieu den 5 trieu");
		dataTest.setChucvu("sinh vien");
		dataTest.setDiachicongty("PTIT");
		dataTest.setMucluong("5 trieu den 10 trieu");
		ToKhaiDAO toKhaiDAO = new ToKhaiDAO();
		boolean result = toKhaiDAO.updateToKhai(dataTest);
		assertEquals(result, resultTest);
	}

}
