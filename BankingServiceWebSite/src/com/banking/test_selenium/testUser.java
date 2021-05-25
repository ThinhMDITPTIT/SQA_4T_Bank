package com.banking.test_selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import com.banking.dao.DAO;

public class testUser extends TestDriver {
	ChromeDriver driver = getDriver();
	DAO dao = new DAO();

	@Test
	public void log_in()  {
		
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		String title = driver.getTitle();
		String expectedTitle = "Trang chủ";
		assertEquals(title, expectedTitle);
		driver.close();
	}
	@Test
	public void themmoi_khachhang_success() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("them_kh_button")).click();
			driver.findElement(By.id("hoten")).sendKeys("Truong Dinh Tien");
			driver.findElement(By.id("dob")).sendKeys("16/03/1997");
			driver.findElement(By.id("sdt")).sendKeys("0385676597");
			driver.findElement(By.id("cmnd")).sendKeys("01735121111111");
			driver.findElement(By.id("ngaycap")).sendKeys("04/02/2012");
			driver.findElement(By.id("noicap")).sendKeys("Ha noi");
			driver.findElement(By.id("dcthuongtru")).sendKeys("Thanh Xuan nam - Ha noi");
			driver.findElement(By.id("dchientai")).sendKeys("495 Nguyen Trai - Thanh xuan - Ha noi");
			driver.findElement(By.id("email")).sendKeys("shadowking1603@gmail.com");
			driver.findElement(By.id("doAddUser")).click();
			
			String notifyMess = driver.switchTo().alert().getText();
			System.out.println(notifyMess);
			String expectedMes = "Thêm mới khách hàng thành công !";
			assertEquals(notifyMess, expectedMes);
			driver.switchTo().alert().accept();
			
			String title = driver.getTitle();
			String expectedTitle = "Tìm kiếm khách hàng";
			assertEquals(title, expectedTitle);
			
			driver.close();
		}finally {
			dao.connection.rollback();
			//dao.connection.close();
		}
	}
	
	@Test
	public void huy_themmoi_khachhang_success() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("them_kh_button")).click();
			driver.findElement(By.id("hoten")).sendKeys("Truong Dinh Tien");
			driver.findElement(By.id("dob")).sendKeys("16/03/1997");
			driver.findElement(By.id("sdt")).sendKeys("0385676597");
			driver.findElement(By.id("cmnd")).sendKeys("0173512111111");
			driver.findElement(By.id("ngaycap")).sendKeys("04/02/2012");
			driver.findElement(By.id("noicap")).sendKeys("Ha noi");
			driver.findElement(By.id("dcthuongtru")).sendKeys("Thanh Xuan nam - Ha noi");
			driver.findElement(By.id("dchientai")).sendKeys("495 Nguyen Trai - Thanh xuan - Ha noi");
			driver.findElement(By.id("email")).sendKeys("shadowking1603@gmail.com");
			driver.findElement(By.id("cancel_button")).click();
			
			
			String title = driver.getTitle();
			String expectedTitle = "Tìm kiếm khách hàng";
			assertEquals(title, expectedTitle);
			
			driver.close();
		}finally {
			dao.connection.rollback();
			//dao.connection.close();
		}
	}

	@Test
	public void tim_kiem_khachhang() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("name")).sendKeys("t");
			driver.findElement(By.id("tim_kiem_khach_hang")).click();
			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
			String expectedTenKH ="Ta Xuan Toan";
			
			assertEquals(tenKH, expectedTenKH);
			
			driver.close();
		}finally {
			dao.connection.rollback();
			//dao.connection.close();
		}
	}
	@Test
	public void kiem_tra_thongtinHK() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("name")).sendKeys("t");
			driver.findElement(By.id("tim_kiem_khach_hang")).click();
			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
			String expectedTenKH ="Ta Xuan Toan";
			
			if(tenKH == expectedTenKH) {
				driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
				String SoCMND = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
				String expectedSoCMND = "001088011195";
				assertEquals(SoCMND, expectedSoCMND);
				String noKhaiBaoText = driver.findElement(By.id("no_khaibao_text")).getText();
				String expectedNoKBText = "Khách hàng chưa khai báo thông tin vay";
				assertEquals(noKhaiBaoText, expectedNoKBText);
			}
			
			driver.close();
		}finally {
			dao.connection.rollback();
			//dao.connection.close();
		}
	}
	@Test
	public void khaibao() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("name")).sendKeys("t");
			driver.findElement(By.id("tim_kiem_khach_hang")).click();
			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
			String expectedTenKH ="Ta Xuan Toan";
			
			if(tenKH == expectedTenKH) {
				driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
				String SoCMND = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
				String expectedSoCMND = "001088011195";
				assertEquals(SoCMND, expectedSoCMND);
				if(SoCMND == expectedSoCMND) {
					driver.findElement(By.id("them_khachhang_button")).click();
					driver.findElement(By.id("Nghenghiep")).sendKeys("Hoc Sinh");
					driver.findElement(By.id("Chucvu")).sendKeys("Sinh Vien");
					driver.findElement(By.id("Tencongty")).sendKeys("PTIT");
					driver.findElement(By.id("Diachicongty")).sendKeys("Tran Phu - Ha Dong");
					driver.findElement(By.id("mucluong2")).click();
					driver.findElement(By.id("Chitieuhangthang1")).click();
					driver.findElement(By.id("add_tk_button")).click();
					String notifyMess = driver.switchTo().alert().getText();
					System.out.println(notifyMess);
					String expectedMes = "Thêm tờ khai thành Công!!!";
					assertEquals(notifyMess, expectedMes);
					driver.switchTo().alert().accept();
					String title = driver.getTitle();
					String expectedTitle = "Danh sách Tờ Khai";
					assertEquals(title, expectedTitle);
				}
				
			}
			
			driver.close();
		}finally {
			dao.connection.rollback();
			//dao.connection.close();
		}
	}

	@Test
	public void delete_thongtinKhaiBao() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("name")).sendKeys("t");
			driver.findElement(By.id("tim_kiem_khach_hang")).click();
			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
			String expectedTenKH ="Ta Xuan Toan";
			
			if(tenKH == expectedTenKH) {
				driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
				String SoCMND = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
				String expectedSoCMND = "001088011195";
				assertEquals(SoCMND, expectedSoCMND);
				
				String nghenghiep = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[9]")).getText();
				String expectedNN = "Developer Java";
				if(nghenghiep == expectedNN) {
					driver.findElement(By.id("delete_tk_button")).click();
					String notifyMess = driver.switchTo().alert().getText();
					String expectedMes = "Xóa tờ khai thành Công!!!";
					assertEquals(notifyMess, expectedMes);
					driver.switchTo().alert().accept();
					String title = driver.getTitle();
					String expectedTitle = "Danh sách Tờ Khai";
					assertEquals(title, expectedTitle);
				}
			}
			
			driver.close();
		}finally {
			dao.connection.rollback();
			//dao.connection.close();
		}
	}
	@Test
	public void kiem_tra_thongtinKhaiBao() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("name")).sendKeys("t");
			driver.findElement(By.id("tim_kiem_khach_hang")).click();
			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
			String expectedTenKH = "Ta Xuan Toan";

			driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
			String SoCMND = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
			String expectedSoCMND = "001088011195";
			assertEquals(SoCMND, expectedSoCMND);
			String nghenghiep = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[2]")).getText();
			String expectedNN = "Developer Java";
			assertEquals(expectedNN, nghenghiep);
			driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[11]")).click();
			String title = driver.getTitle();
			String expectedTitle = "Vay Lãi";
			assertEquals(title, expectedTitle);
			String tenKHInVayLai = driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td[1]")).getText();
			assertEquals(expectedTenKH, tenKHInVayLai);
			String ngheNghiepInVayLai = driver.findElement(By.xpath("//table[2]/tbody/tr[1]/td[1]")).getText();
			assertEquals(expectedNN, ngheNghiepInVayLai);

			driver.close();
		} finally {
			dao.connection.rollback();
			//dao.connection.close();
		}
	}
	@Test
	public void sua_thongtinKhaiBao() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("name")).sendKeys("t");
			driver.findElement(By.id("tim_kiem_khach_hang")).click();
			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
			String expectedTenKH = "Ta Xuan Toan";

			driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
			String SoCMND = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
			String expectedSoCMND = "001088011195";
			assertEquals(SoCMND, expectedSoCMND);
			String ngheNghiep = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[2]")).getText();
			String chucVu = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[3]")).getText();
			String tenCT = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[4]")).getText();
			String dcCongTy = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[5]")).getText();
			String expectedNN = "Developer Java";
			assertEquals(expectedNN, ngheNghiep);
			driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[10]")).click();
			String title = driver.getTitle();
			String expectedTitle = "Sửa thông tin khai báo";
			assertEquals(title, expectedTitle);
			String ngheNghiepED = driver.findElement(By.id("Nghenghiep")).getAttribute("value");
			String chucVuED = driver.findElement(By.id("Chucvu")).getAttribute("value");
			String tenCTED = driver.findElement(By.id("Tencongty")).getAttribute("value");
			String dcCongTyED = driver.findElement(By.id("Diachicongty")).getAttribute("value");
			assertEquals(ngheNghiep, ngheNghiepED);
			assertEquals(chucVu, chucVuED);
			assertEquals(tenCT, tenCTED);
			assertEquals(dcCongTy, dcCongTy);
			driver.findElement(By.id("Chucvu")).sendKeys("Project Leader");
			driver.findElement(By.id("mucluong4")).click();
			driver.findElement(By.id("chitieu3")).click();
			driver.findElement(By.id("submit_button")).click();
			String notifyMess = driver.switchTo().alert().getText();
			String expectedMes = "Sửa tờ khai thành Công!!!";
			assertEquals(notifyMess, expectedMes);
			driver.switchTo().alert().accept();
			String title1 = driver.getTitle();
			String expectedTitle1 = "Danh sách Tờ Khai";
			assertEquals(title1, expectedTitle1);
			
			driver.close();
		} finally {
			dao.connection.rollback();
			//dao.connection.close();
		}
	}
	@Test
	public void huysua_thongtinKhaiBao() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("name")).sendKeys("t");
			driver.findElement(By.id("tim_kiem_khach_hang")).click();
			String tenKH = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
			String expectedTenKH = "Ta Xuan Toan";

			driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).click();
			String SoCMND = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
			String expectedSoCMND = "001088011195";
			assertEquals(SoCMND, expectedSoCMND);
			String ngheNghiep = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[2]")).getText();
			String chucVu = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[3]")).getText();
			String tenCT = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[4]")).getText();
			String dcCongTy = driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[5]")).getText();
			String expectedNN = "Developer Java";
			assertEquals(expectedNN, ngheNghiep);
			driver.findElement(By.xpath("//table[2]/tbody[1]/tr[1]/td[10]")).click();
			String title = driver.getTitle();
			String expectedTitle = "Sửa thông tin khai báo";
			assertEquals(title, expectedTitle);
			String ngheNghiepED = driver.findElement(By.id("Nghenghiep")).getAttribute("value");
			String chucVuED = driver.findElement(By.id("Chucvu")).getAttribute("value");
			String tenCTED = driver.findElement(By.id("Tencongty")).getAttribute("value");
			String dcCongTyED = driver.findElement(By.id("Diachicongty")).getAttribute("value");
			assertEquals(ngheNghiep, ngheNghiepED);
			assertEquals(chucVu, chucVuED);
			assertEquals(tenCT, tenCTED);
			assertEquals(dcCongTy, dcCongTy);
			
			driver.findElement(By.id("cancel_kb_button")).click();
			String title1 = driver.getTitle();
			String expectedTitle1 = "Danh sách Tờ Khai";
			assertEquals(title1, expectedTitle1);
			
			driver.close();
		} finally {
			dao.connection.rollback();
			//dao.connection.close();
		}
	}
	@Test
	public void them_moi_khachhang_fail() throws SQLException {
		dao.connection.setAutoCommit(false);
		try {
			driver.get("http://localhost:8080/BankingServiceWebSite/");
			driver.findElement(By.id("log_in_button")).click();
			driver.findElement(By.id("username")).sendKeys("thinhme99");
			driver.findElement(By.id("password")).sendKeys("thinh12345");
			driver.findElement(By.id("dologin")).click();
			driver.findElement(By.id("vay_lai_button")).click();
			driver.findElement(By.id("them_kh_button")).click();
			driver.findElement(By.id("hoten")).sendKeys("Truong Dinh Tien");
			driver.findElement(By.id("dob")).sendKeys("16/03/1997");
			driver.findElement(By.id("sdt")).sendKeys("0385676597");
			driver.findElement(By.id("cmnd")).sendKeys("0173512111111");
			driver.findElement(By.id("ngaycap")).sendKeys("04/02/2012");
			driver.findElement(By.id("noicap")).sendKeys("Ha noi");
			driver.findElement(By.id("dcthuongtru")).sendKeys("Thanh Xuan nam - Ha noi");
			driver.findElement(By.id("dchientai")).sendKeys("495 Nguyen Trai - Thanh xuan - Ha noi");
			driver.findElement(By.id("email")).sendKeys("shadowking1603@gmail.com");
			driver.findElement(By.id("doAddUser")).click();
			
			String notifyMess = driver.switchTo().alert().getText();
			String expectedMes = "Khách hàng đã tồn tại!!!";
			assertEquals(notifyMess, expectedMes);
			driver.switchTo().alert().accept();
			
			String title = driver.getTitle();
			String expectedTitle = "Thêm khách hàng";
			assertEquals(title, expectedTitle);
			
			driver.close();
		}finally {
			dao.connection.rollback();
			//dao.connection.close();
		}
	}

}
