package com.banking.test.HDVaydao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.banking.dao.DAO;
import com.banking.dao.HDVaydao;

import com.banking.entity.HDVay;

public class HDVaydaoTest extends DAO{
	HDVaydao hDVaydao = new HDVaydao();
	
	
	
//	@Test
//	//test kich ban chuan
//	public void testGetHDVays() throws SQLException {
//		ArrayList<HDVay> kq = hDVaydao.getHDVays();
//		assertEquals(kq.toString(), hDVaydao.getHDVays().toString());
//	}

//	@Test
//	//Test kich ban chuan
//	public void testGetHDVaybyID() {
//		ArrayList<HDVay> kq = hDVaydao.getHDVaybyID("5");
//        assertEquals(hDVaydao.getHDVaybyID("5"), kq);
//	}
//
//	
//	@Test
//	//Test ngoai le id la so am
//	public void testGetHDVaybyID2() {
//
//		ArrayList<HDVay> kq = new ArrayList<HDVay>();
//        assertEquals(hDVaydao.getHDVaybyID("-5"), kq);
//	}
//	
//	@Test
//	//Test ngoai le id khong hop le
//	public void testGetHDVaybyID3() {
//		
//		ArrayList<HDVay> kq = new ArrayList<HDVay>();
//        assertEquals(hDVaydao.getHDVaybyID("a"), kq);
//	}	


//	@Test
//	//Test kich ban chuan
//	public void testSuaHD() throws SQLException{
//		connection.setAutoCommit(false);
//		try {
//		
//			
//			hDVaydao.suaHD(26,2, 2, Date.valueOf("2024-02-02"), "3 thang", "chua duyet", 100, 5);
//			
//		} finally {
//			// TODO: handle finally clause
//			connection.rollback();
//			connection.close();
//		}
//		
//		
//	}
	
//	@Test
//	//Test sua khong co trong db
//	public void testSuaHD2() throws SQLException{
//		connection.setAutoCommit(false);
//		try {
//			hDVaydao.suaHD(999,2, 2, Date.valueOf("2022-02-02"), "3 thang", "chua duyet", 100, 2);
//			
//		} finally {
//			// TODO: handle finally clause
//			connection.rollback();
//			connection.close();
//		}		
//		
//	}

//	@Test
//	//Test xoa du lieu co trong db
//	public void testXoa() throws SQLException{
//		connection.setAutoCommit(false);
//		boolean kq = true;
//		try {
//			int id = 26;
//			HDVaydao hdVaydao = new HDVaydao();
//			boolean kqTest = HDVaydao.xoa(id);
//		} finally {
//			connection.rollback();
//			connection.close();
//		}
//		
//	}
	
//	@Test
//	//Test xoa du lieu khong co trong db
//	public void testXoa2() throws SQLException{
//		connection.setAutoCommit(false);
//		boolean kq = false;
//		try {
//			int id = 1000;
//			HDVaydao hdVaydao = new HDVaydao();
//			boolean kqTest = HDVaydao.xoa(id);
//			assertEquals(kqTest, kq);
//		} finally {			
//			connection.rollback();
//			connection.close();
//		}
//		
//	}


//	@Test()
//	//kich ban chuan
//	public void testThem() throws ClassNotFoundException, SQLException{
//		connection.setAutoCommit(false);
//		try {
//			
//			hDVaydao.them(1, 3, Date.valueOf("2020-05-05"), "3 thang", "chua duyet", 150, 2);
//			
//			
//		} finally {
//			// TODO: handle finally clause
//			connection.rollback();
//			connection.close();
//		}
//		
//	}
	
//	@Test()
//	//Kich ban them 
//	public void testThem2() throws ClassNotFoundException, SQLException{
//		connection.setAutoCommit(false);	
//		try {
//			
//			hDVaydao.them(1, 3, Date.valueOf("2020-02-02"), "3 thang", "chua duyet", 100, 2);
//		} finally {
//			// TODO: handle finally clause
//			connection.rollback();
//			connection.close();
//		}
//	}
	
//	@Test
//	//kich ban chuan
//	public void testSearchHDVayByTKId() {
//		ArrayList<HDVay> kq = hDVaydao.searchHDVayByTKId(4,2);
//      assertEquals(hDVaydao.searchHDVayByTKId(4,2), kq);
//		
//	}
//	
//	@Test
//	// id la so am
//	public void testSearchHDVayByTKId2() {
//		ArrayList<HDVay> kq = new ArrayList<HDVay>();
//      assertEquals(hDVaydao.searchHDVayByTKId(-4,-2), kq);
//		
//	}
//
//	@Test
//	//id khong co
//	public void testSearchHDVayByTKId3() {
//		ArrayList<HDVay> kq = new ArrayList<HDVay>();
//      assertEquals(hDVaydao.searchHDVayByTKId(192,91), kq);
//		
//	}
}

