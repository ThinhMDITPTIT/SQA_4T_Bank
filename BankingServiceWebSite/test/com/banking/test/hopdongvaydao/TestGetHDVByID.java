package com.banking.test.hopdongvaydao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.banking.dao.HopDongVayDAO;
import com.banking.entity.GoiVay;
import com.banking.entity.HopDongVay;

class TestGetHDVByID {

	@Test
	void test_HaveInfo_1() throws ClassNotFoundException, SQLException {
		int[] testHdvID = { 10, 14 };

		ArrayList<HopDongVay> hdvTest = new ArrayList<HopDongVay>();
		ArrayList<HopDongVay> hdvDB = new ArrayList<HopDongVay>();
		int[] hdvid = { 10, 14 };
		float[] tienvay = { (float) 41414, (float) 2331 };
		String[] kihan = { "3 thang", "3 thang" };
		float[] laisuat = { (float) 0.06, (float) 0.06 };
		for (int i = 0; i < hdvid.length; i++) {
			GoiVay gv = new GoiVay();
			gv.setLaiSuat(laisuat[i]);
			HopDongVay hdv = new HopDongVay();
			hdv.setID(hdvid[i]);
			hdv.setTienVay(tienvay[i]);
			hdv.setKiHan(kihan[i]);
			hdv.setGoiVay(gv);
			hdvTest.add(hdv);
		}

		HopDongVayDAO hdvDAO = new HopDongVayDAO();
		for (int j = 0; j < testHdvID.length; j++) {
			hdvDB.add(hdvDAO.getByID(testHdvID[j]));
		}

		assertEquals(hdvTest.size(), hdvDB.size());
		for (int k = 0; k < testHdvID.length; k++) {
			assertEquals(hdvDB.get(k).getID(), hdvTest.get(k).getID());
			assertEquals(hdvDB.get(k).getTienVay(), hdvTest.get(k).getTienVay());
			assertEquals(hdvDB.get(k).getKiHan(), hdvTest.get(k).getKiHan());
			assertEquals(hdvDB.get(k).getGoiVay().getLaiSuat(), hdvTest.get(k).getGoiVay().getLaiSuat());
		}
	}

	@Test
	void test_HaveInfo_2() throws ClassNotFoundException, SQLException {
		int[] testHdvID = { 22, 23 };

		ArrayList<HopDongVay> hdvTest = new ArrayList<HopDongVay>();
		ArrayList<HopDongVay> hdvDB = new ArrayList<HopDongVay>();
		int[] hdvid = { 22, 23 };
		float[] tienvay = { (float) 22111, (float) 56677 };
		String[] kihan = { "6 thang", "3 thang" };
		float[] laisuat = { (float) 0.06, (float) 0.08 };
		for (int i = 0; i < hdvid.length; i++) {
			GoiVay gv = new GoiVay();
			gv.setLaiSuat(laisuat[i]);
			HopDongVay hdv = new HopDongVay();
			hdv.setID(hdvid[i]);
			hdv.setTienVay(tienvay[i]);
			hdv.setKiHan(kihan[i]);
			hdv.setGoiVay(gv);
			hdvTest.add(hdv);
		}

		HopDongVayDAO hdvDAO = new HopDongVayDAO();
		for (int j = 0; j < testHdvID.length; j++) {
			hdvDB.add(hdvDAO.getByID(testHdvID[j]));
		}

		assertEquals(hdvTest.size(), hdvDB.size());
		for (int k = 0; k < testHdvID.length; k++) {
			assertEquals(hdvDB.get(k).getID(), hdvTest.get(k).getID());
			assertEquals(hdvDB.get(k).getTienVay(), hdvTest.get(k).getTienVay());
			assertEquals(hdvDB.get(k).getKiHan(), hdvTest.get(k).getKiHan());
			assertEquals(hdvDB.get(k).getGoiVay().getLaiSuat(), hdvTest.get(k).getGoiVay().getLaiSuat());
		}
	}

	@Test
	void test_HaveInfo_3() throws ClassNotFoundException, SQLException {
		int[] testHdvID = { 26, 27 };

		ArrayList<HopDongVay> hdvTest = new ArrayList<HopDongVay>();
		ArrayList<HopDongVay> hdvDB = new ArrayList<HopDongVay>();
		int[] hdvid = { 26, 27 };
		float[] tienvay = { (float) 555, (float) 222 };
		String[] kihan = { "3 thang", "3 thang" };
		float[] laisuat = { (float) 0.08, (float) 0.08 };
		for (int i = 0; i < hdvid.length; i++) {
			GoiVay gv = new GoiVay();
			gv.setLaiSuat(laisuat[i]);
			HopDongVay hdv = new HopDongVay();
			hdv.setID(hdvid[i]);
			hdv.setTienVay(tienvay[i]);
			hdv.setKiHan(kihan[i]);
			hdv.setGoiVay(gv);
			hdvTest.add(hdv);
		}

		HopDongVayDAO hdvDAO = new HopDongVayDAO();
		for (int j = 0; j < testHdvID.length; j++) {
			hdvDB.add(hdvDAO.getByID(testHdvID[j]));
		}

		assertEquals(hdvTest.size(), hdvDB.size());
		for (int k = 0; k < testHdvID.length; k++) {
			assertEquals(hdvDB.get(k).getID(), hdvTest.get(k).getID());
			assertEquals(hdvDB.get(k).getTienVay(), hdvTest.get(k).getTienVay());
			assertEquals(hdvDB.get(k).getKiHan(), hdvTest.get(k).getKiHan());
			assertEquals(hdvDB.get(k).getGoiVay().getLaiSuat(), hdvTest.get(k).getGoiVay().getLaiSuat());
		}
	}

	@Test
	void test_Not_HaveInfo() throws ClassNotFoundException, SQLException {
		int[] testHdvID = { 30, 32 };

		HopDongVayDAO hdvDAO = new HopDongVayDAO();
		for (int j = 0; j < testHdvID.length; j++) {
			HopDongVay hdvDB = new HopDongVay();
			hdvDB = hdvDAO.getByID(testHdvID[j]);

			assertEquals(hdvDB.getID(), null);
			assertEquals(hdvDB.getKiHan(), null);
			assertEquals(hdvDB.getGoiVay(), null);
		}
	}

}
