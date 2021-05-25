package com.banking.test.ToKhaiDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.banking.dao.DAO;
import com.banking.dao.ToKhaiDAO;

class deleteTokhai extends DAO {

	// test delete Tokhai change enable prop to false
	@Test
	void test() throws SQLException {

		boolean result = true;

		int tkID = 1;
		ToKhaiDAO toKhaiDAO = new ToKhaiDAO();
		boolean resultTest = toKhaiDAO.deleteToKhai(tkID);
		assertEquals(resultTest, result);

	}

	// delete Tokhai isn`t exist
	@Test
	void test2() throws SQLException {
		boolean result = false;
		int tkID = 99;
		ToKhaiDAO toKhaiDAO = new ToKhaiDAO();
		boolean resultTest = toKhaiDAO.deleteToKhai(tkID);
		assertEquals(resultTest, result);

	}

}
