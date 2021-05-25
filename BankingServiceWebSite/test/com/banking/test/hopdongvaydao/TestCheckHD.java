package com.banking.test.hopdongvaydao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.banking.dao.HopDongVayDAO;

class TestCheckHD {

	@Test
	void test_CheckSucces_1() throws ClassNotFoundException, SQLException {
		int[] testHdvID = { 10, 14 };

		boolean result = true;

		HopDongVayDAO hdvDAO = new HopDongVayDAO();
		for (int i = 0; i < testHdvID.length; i++) {
			assertEquals(result, hdvDAO.checkHD(testHdvID[i]));
		}
	}

	@Test
	void test_CheckSucces_2() throws ClassNotFoundException, SQLException {
		int[] testHdvID = { 22, 23 };

		boolean result = true;

		HopDongVayDAO hdvDAO = new HopDongVayDAO();
		for (int i = 0; i < testHdvID.length; i++) {
			assertEquals(result, hdvDAO.checkHD(testHdvID[i]));
		}
	}

	@Test
	void test_CheckSucces_3() throws ClassNotFoundException, SQLException {
		int[] testHdvID = { 26, 27 };

		boolean result = true;

		HopDongVayDAO hdvDAO = new HopDongVayDAO();
		for (int i = 0; i < testHdvID.length; i++) {
			assertEquals(result, hdvDAO.checkHD(testHdvID[i]));
		}
	}

	@Test
	void test_CheckFail() throws ClassNotFoundException, SQLException {
		int[] testHdvID = { 30, 32 };

		boolean result = false;

		HopDongVayDAO hdvDAO = new HopDongVayDAO();
		for (int i = 0; i < testHdvID.length; i++) {
			assertEquals(result, hdvDAO.checkHD(testHdvID[i]));
		}
	}

}
