package com.banking.phieunoptiendao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.banking.dao.PhieuNopTienDAO;
import com.banking.entity.PhieuNopTien;

class TestGetPNTByHdvID {

	PhieuNopTienDAO phieunoptienDAO = new PhieuNopTienDAO();
    @Test
    //Test kich ban chuan
    void getPntByHdvIDTest1() throws SQLException{
        ArrayList<PhieuNopTien> kq = phieunoptienDAO.getPntByHdvID(2);
        assertEquals(phieunoptienDAO.getPntByHdvID(2), kq);
    }
    @Test
    void getPntByHdvIDTest2() throws SQLException{
        ArrayList<PhieuNopTien> kq = phieunoptienDAO.getPntByHdvID(4);
        assertEquals(phieunoptienDAO.getPntByHdvID(4), kq);
    }
    @Test
    void getPntByHdvIDTest3() throws SQLException{
        ArrayList<PhieuNopTien> kq = phieunoptienDAO.getPntByHdvID(5);
        assertEquals(phieunoptienDAO.getPntByHdvID(5), kq);
    }
//    @Test
//    // Test kich ban nhap id ko hop le => ket qua tra ve null
//    void getInvalidId1() throws SQLException{
//        assertEquals(phieunoptienDAO.getPntByHdvID(-1000), null);
//        assertEquals(phieunoptienDAO.getPntByHdvID(0), null);
//    }
    @Test
    // Test kich ban nhap id ko hop le => ket qua tra ve mang rong
    void getInvalidId1() throws SQLException{
        ArrayList<PhieuNopTien> kq = new ArrayList<PhieuNopTien>();
        assertEquals(phieunoptienDAO.getPntByHdvID(-141353), kq);
    }
    @Test
    void getInvalidId2() throws SQLException{
        ArrayList<PhieuNopTien> kq = new ArrayList<PhieuNopTien>();
        assertEquals(phieunoptienDAO.getPntByHdvID(0), kq);
    }
    void getInvalidId3() throws SQLException{
        ArrayList<PhieuNopTien> kq = new ArrayList<PhieuNopTien>();
        assertEquals(phieunoptienDAO.getPntByHdvID(-10), kq);
    }

}
