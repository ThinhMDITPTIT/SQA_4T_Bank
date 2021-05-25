package com.banking.test.model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.banking.model.TinhLaiVayMODEL;

class TestLaiVayDuNo {

	@Test
	void test_Success_1() throws ClassNotFoundException, SQLException {
		TinhLaiVayMODEL testlvdn = new TinhLaiVayMODEL();
		float tvdn = (float) 41414.0;
		int timeid = 0;
		float lsdn = (float) 0.06;
		int khdn = 3;

		float resultdn = (float) 2484.8398;

		assertEquals(resultdn, testlvdn.tinhLaiVayDuNo(tvdn, timeid, khdn, lsdn));
	}

	@Test
	void test_Success_2() throws ClassNotFoundException, SQLException {
		TinhLaiVayMODEL testlvdn = new TinhLaiVayMODEL();
		float tvdn = (float) 41414.0;
		int timeid = 1;
		float lsdn = (float) 0.06;
		int khdn = 3;

		float resultdn = (float) 1656.5599;

		assertEquals(resultdn, testlvdn.tinhLaiVayDuNo(tvdn, timeid, khdn, lsdn));
	}

	@Test
	void test_Success_3() throws ClassNotFoundException, SQLException {
		TinhLaiVayMODEL testlvdn = new TinhLaiVayMODEL();
		float tvdn = (float) 41414.0;
		int timeid = 2;
		float lsdn = (float) 0.06;
		int khdn = 3;

		float resultdn = (float) 828.27997;

		assertEquals(resultdn, testlvdn.tinhLaiVayDuNo(tvdn, timeid, khdn, lsdn));
	}

}
