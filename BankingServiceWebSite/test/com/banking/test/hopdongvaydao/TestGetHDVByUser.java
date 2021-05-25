package com.banking.test.hopdongvaydao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.banking.dao.HopDongVayDAO;
import com.banking.entity.HopDongVay;

class TestGetHDVByUser {

	@Test
	void test_GetSuccess() throws ClassNotFoundException, SQLException {
		int testUserID = 2;

		ArrayList<HopDongVay> hdvTest = new ArrayList<HopDongVay>();
		ArrayList<HopDongVay> hdvDB = new ArrayList<HopDongVay>();
		int[] hdvid = { 10, 14, 22, 23, 26, 27 };
		float[] tienvay = { (float) 41414, (float) 2331, (float) 22111, (float) 56677, (float) 555, (float) 222 };
		String[] kihan = { "3 thang", "3 thang", "6 thang", "3 thang", "3 thang", "3 thang" };
		float[] laisuat = { (float) 0.06, (float) 0.06, (float) 0.06, (float) 0.08, (float) 0.08, (float) 0.08 };
		for (int i = 0; i < hdvid.length; i++) {
			HopDongVay hdv = new HopDongVay();
			hdv.setID(hdvid[i]);
			hdv.setTienVay(tienvay[i]);
			hdv.setKiHan(kihan[i]);
			hdv.setLaiSuat(laisuat[i]);
			hdvTest.add(hdv);
		}

		HopDongVayDAO hdvDAO = new HopDongVayDAO();
		hdvDB = hdvDAO.getHDVByUser(testUserID);

		assertEquals(hdvTest.size(), hdvDB.size());
		for (int j = 0; j < hdvDB.size(); j++) {
			assertEquals(hdvDB.get(j).getID(), hdvTest.get(j).getID());
			assertEquals(hdvDB.get(j).getTienVay(), hdvTest.get(j).getTienVay());
			assertEquals(hdvDB.get(j).getKiHan(), hdvTest.get(j).getKiHan());
			assertEquals(hdvDB.get(j).getLaiSuat(), hdvTest.get(j).getLaiSuat());
		}
	}

	@Test
	void test_NotHaveHDV() throws ClassNotFoundException, SQLException {
		int testUserID = 1;

		ArrayList<HopDongVay> hdvDB = new ArrayList<HopDongVay>();

		HopDongVayDAO hdvDAO = new HopDongVayDAO();
		hdvDB = hdvDAO.getHDVByUser(testUserID);

		assertEquals(hdvDB.size(), 0);
	}

}
