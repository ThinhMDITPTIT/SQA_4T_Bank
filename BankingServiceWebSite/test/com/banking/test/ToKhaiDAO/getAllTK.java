package com.banking.test.ToKhaiDAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.banking.dao.ToKhaiDAO;
import com.banking.entity.ToKhai;

class getAllTK {

	@Test
	void test() {
		int customerID = 1;
		ArrayList<ToKhai> tokhaiDataTest = new ArrayList<ToKhai>();
		ArrayList<ToKhai> tokhaiDataDB = new ArrayList<ToKhai>();
		ToKhai tk1 = new ToKhai();
		tk1.setID(1);
		tk1.setNghenghiep("hoc sinh");
		tk1.setChucvu("sinh vien");
		tk1.setDiachicongty("thanh xuan");
		tk1.setTencongty("PTIT");
		tk1.setMucluong("1 trieu den 5 trieu");
		tk1.setChitieuhangthang("1 Trieu den 5 trieu");
		tokhaiDataTest.add(tk1);
		ToKhai tk2 = new ToKhai();
		tk2.setID(2);
		tk2.setNghenghiep("hoc sinh");
		tk2.setChucvu("sinh vien");
		tk2.setDiachicongty("thanh xuan");
		tk2.setTencongty("PTIT");
		tk2.setMucluong("1 trieu den 5 trieu");
		tk2.setChitieuhangthang("1 Trieu den 5 trieu");
		tokhaiDataTest.add(tk2);

		ToKhai tk3 = new ToKhai();
		tk3.setID(3);
		tk3.setNghenghiep("hoc sinh");
		tk3.setChucvu("sinh vien");
		tk3.setDiachicongty("thanh xuan");
		tk3.setTencongty("PTIT");
		tk3.setMucluong("1 trieu den 5 trieu");
		tk3.setChitieuhangthang("1 Trieu den 5 trieu");
		tokhaiDataTest.add(tk3);

		ToKhaiDAO toKhaiDAO = new ToKhaiDAO();
		tokhaiDataDB = toKhaiDAO.getAllToKhai(customerID);
		assertEquals(tokhaiDataDB.size(), 6);
		for (int i = 0; i < 3; i++) {
			assertEquals(tokhaiDataTest.get(i).getID(), tokhaiDataDB.get(i).getID());
			assertEquals(tokhaiDataTest.get(i).getNghenghiep(), tokhaiDataDB.get(i).getNghenghiep());
			assertEquals(tokhaiDataTest.get(i).getChucvu(), tokhaiDataDB.get(i).getChucvu());
			assertEquals(tokhaiDataTest.get(i).getDiachicongty(), tokhaiDataDB.get(i).getDiachicongty());
			assertEquals(tokhaiDataTest.get(i).getTencongty(), tokhaiDataDB.get(i).getTencongty());
			assertEquals(tokhaiDataTest.get(i).getMucluong(), tokhaiDataDB.get(i).getMucluong());
			assertEquals(tokhaiDataTest.get(i).getChitieuhangthang(), tokhaiDataDB.get(i).getChitieuhangthang());
		}

	}

	// Test customer haven`t To Khai
	@Test
	void test2() {
		int customerID = 99;
		ArrayList<ToKhai> tokhaiDataDB = new ArrayList<ToKhai>();
		ToKhaiDAO toKhaiDAO = new ToKhaiDAO();
		tokhaiDataDB = toKhaiDAO.getAllToKhai(customerID);
		assertEquals(tokhaiDataDB.size(), 0);
	}
}
