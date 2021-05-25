package com.banking.test.model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.banking.model.TinhLaiVayMODEL;

class TestLaiVayCoDinh {

	@Test
	void test_Success_1() throws ClassNotFoundException, SQLException {
		TinhLaiVayMODEL testlvcd = new TinhLaiVayMODEL();
		float tvcd = (float) 56677.0;
		float lscd = (float) 0.08;
		int khcd = 3;

		float resultcd = (float) 1511.3866;

		assertEquals(resultcd, testlvcd.tinhLaiVayCoDinh(tvcd, lscd, khcd));
	}

	@Test
	void test_Success_2() throws ClassNotFoundException, SQLException {
		TinhLaiVayMODEL testlvcd = new TinhLaiVayMODEL();
		float tvcd = (float) 555.0;
		float lscd = (float) 0.08;
		int khcd = 3;

		float resultcd = (float) 14.799999;

		assertEquals(resultcd, testlvcd.tinhLaiVayCoDinh(tvcd, lscd, khcd));
	}

	@Test
	void test_Success_3() throws ClassNotFoundException, SQLException {
		TinhLaiVayMODEL testlvcd = new TinhLaiVayMODEL();
		float tvcd = (float) 222.0;
		float lscd = (float) 0.08;
		int khcd = 3;

		float resultcd = (float) 5.9199996;

		assertEquals(resultcd, testlvcd.tinhLaiVayCoDinh(tvcd, lscd, khcd));
	}

}
