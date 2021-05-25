package com.banking.test_selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChucNangTinhLaiVayTMD extends TestDriver {

	ChromeDriver driver = getDriver();

	@Test
	public void log_in_title() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		String title = driver.getTitle();
		String expectedTitle = "Đăng nhập";
		assertEquals(title, expectedTitle);
		driver.close();
	}

	@Test
	public void log_in() {
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
	public void log_out() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("log_out_button")).click();
		String title = driver.getTitle();
		String expectedTitle = "Đăng nhập";
		assertEquals(title, expectedTitle);
		driver.close();
	}

	@Test
	public void timkiem_khachhang() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		String title = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
		String expectedTitle = "Ta Xuan Toan";
		assertEquals(title, expectedTitle);
		driver.close();
	}
	
	@Test
	public void timkiem_khachhang_trungten() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("T");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		String khachhang1 = driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
		String khachhang2 = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
		String khachhang3 = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText();
		String expectedKH1 = "Vu Chien Thang";
		String expectedKH2 = "Ta Xuan Toan";
		String expectedKH3 = "Tran Sy Tuyen";
		assertEquals(khachhang1, expectedKH1);
		assertEquals(khachhang2, expectedKH2);
		assertEquals(khachhang3, expectedKH3);
		driver.close();
	}
	
	@Test
	public void timkiem_khachhang_null() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Alo");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		String title = driver.findElement(By.id("khong_ton_tai_khach_hang")).getText();
		String expectedTitle = "Không có khách hàng";
		assertEquals(title, expectedTitle);
		driver.close();
	}

	@Test
	public void xem_khoanvay_khachhang() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		String title = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
		String expectedTitle = "001088011195";
		assertEquals(title, expectedTitle);
		driver.close();
	}
	
	@Test
	public void xem_khoanvay_khachhang_khongtontai() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Vu Chien Thang");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		String title = driver.findElement(By.id("khach_hang_khong_co_khoan_vay")).getText();
		String expectedTitle = "Khách hàng không có khoản vay";
		assertEquals(title, expectedTitle);
		driver.close();
	}

	@Test
	public void xem_sodienthoai_khachhang() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		driver.findElement(By.xpath("//table[2]/tbody/tr/td[6]")).click();
		String title = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText();
		String expectedTitle = "0382999209";
		assertEquals(title, expectedTitle);
		driver.close();
	}
	
	@Test
	public void tinhlai_hopdongvay_laisuatcodinh() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		driver.findElement(By.xpath("//table[2]/tbody/tr[4]/td[6]")).click();
		String laicodinh_thangdau = driver.findElement(By.xpath("//table/tbody/tr/td[3]")).getText();
		String expectedLaiVayCoDinh = "1511.3866 VND";
		assertEquals(laicodinh_thangdau, expectedLaiVayCoDinh);
		driver.close();
	}
	
	@Test
	public void tinhtonglai_hopdongvay_laisuatcodinh() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		driver.findElement(By.xpath("//table[2]/tbody/tr[4]/td[6]")).click();
		String tongLaiVay_laicodinh = driver.findElement(By.id("tong_lai_vay_chi_tra_co_dinh")).getText();
		String expectedTongLaiVay_laicodinh = "* Tổng lãi vay chi trả: 4534.1597 VND";
		assertEquals(tongLaiVay_laicodinh, expectedTongLaiVay_laicodinh);
		driver.close();
	}
	
	@Test
	public void tinhtiengoc_hopdongvay_laisuatcodinh() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		driver.findElement(By.xpath("//table[2]/tbody/tr[4]/td[6]")).click();
		String tongtiengoc_laicodinh = driver.findElement(By.id("tong_tien_goc_chi_tra_co_dinh")).getText();
		String expectedTongtiengoc_laicodinh = "* Tiền gốc phải chi trả: 56677.0 VND";
		assertEquals(tongtiengoc_laicodinh, expectedTongtiengoc_laicodinh);
		driver.close();
	}
	
	@Test
	public void tinhtongtientra_hopdongvay_laisuatcodinh() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		driver.findElement(By.xpath("//table[2]/tbody/tr[4]/td[6]")).click();
		String tongtien_laicodinh = driver.findElement(By.id("tong_tien_chi_tra_co_dinh")).getText();
		String expectedTongtien_laicodinh = "=> Tổng tiền gốc và lãi chi trả: 61211.16 VND";
		assertEquals(tongtien_laicodinh, expectedTongtien_laicodinh);
		driver.close();
	}
	
	@Test
	public void tinhlai_hopdongvay_laisuatduno() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		driver.findElement(By.xpath("//table[2]/tbody/tr[1]/td[6]")).click();
		String laiduno_thangdau = driver.findElement(By.xpath("//table/tbody/tr/td[3]")).getText();
		String expectedLaiduno_thangdau = "2484.8398 VND";
		assertEquals(laiduno_thangdau, expectedLaiduno_thangdau);
		driver.close();
	}
	
	@Test
	public void tinhtiengoc_hopdongvay_laisuatduno() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		driver.findElement(By.xpath("//table[2]/tbody/tr[1]/td[6]")).click();
		String tiengoctra_thangdau = driver.findElement(By.xpath("//table/tbody/tr/td[4]")).getText();
		String expectedTiengoctra_thangdau = "13804.667 VND";
		assertEquals(tiengoctra_thangdau, expectedTiengoctra_thangdau);
		driver.close();
	}
	
	@Test
	public void tinhtongtienlai_hopdongvay_laisuatduno() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		driver.findElement(By.xpath("//table[2]/tbody/tr[1]/td[6]")).click();
		String tongtongtienlai_laiduno = driver.findElement(By.id("tong_lai_vay_chi_tra_du_no")).getText();
		String expectedTongtongtienlai_laiduno = "* Tổng lãi vay phải chi trả: 4969.6797 VND";
		assertEquals(tongtongtienlai_laiduno, expectedTongtongtienlai_laiduno);
		driver.close();
	}
	
	@Test
	public void tinhtongtientra_hopdongvay_laisuatduno() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		driver.findElement(By.xpath("//table[2]/tbody/tr[1]/td[6]")).click();
		String tongtien_laiduno = driver.findElement(By.id("tong_tien_chi_tra_du_no")).getText();
		String expectedTongtien_laiduno = "=> Tổng tiền gốc và lãi chi trả: 46383.68 VND";
		assertEquals(tongtien_laiduno, expectedTongtien_laiduno);
		driver.close();
	}
	
	@Test
	public void luongnghiepvu_tinhlai_daydu() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Ta Xuan Toan");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		driver.findElement(By.xpath("//table[2]/tbody/tr[1]/td[6]")).click();
		String tongtien_laiduno = driver.findElement(By.id("tong_tien_chi_tra_du_no")).getText();
		String expectedTongtien_laiduno = "=> Tổng tiền gốc và lãi chi trả: 46383.68 VND";
		assertEquals(tongtien_laiduno, expectedTongtien_laiduno);
		driver.findElement(By.id("quay_lai_trang_khoanvay")).click();
		driver.findElement(By.id("quay_lai_trang_danh_sach_kh")).click();
		driver.findElement(By.id("quay_lai_trang_tim_kiem_kh")).click();
		driver.findElement(By.id("quay_lai_trang_chu")).click();
		String title = driver.getTitle();
		String expectedTitle = "Trang chủ";
		assertEquals(title, expectedTitle);
		driver.close();
	}

	@Test
	public void luongnghiepvu_tinhlai_KH_khong_tontai() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Alo");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		String khongco_khachhang = driver.findElement(By.id("khong_ton_tai_khach_hang")).getText();
		String expectedKhongco_khachhang = "Không có khách hàng";
		assertEquals(khongco_khachhang, expectedKhongco_khachhang);
		driver.findElement(By.id("quay_lai_trang_tim_kiem_kh")).click();
		driver.findElement(By.id("quay_lai_trang_chu")).click();
		String title = driver.getTitle();
		String expectedTitle = "Trang chủ";
		assertEquals(title, expectedTitle);
		driver.close();
	}
	
	@Test
	public void luongnghiepvu_tinhlai_KH_khongco_khoanvay() {
		driver.get("http://localhost:8080/BankingServiceWebSite/");
		driver.findElement(By.id("log_in_button")).click();
		driver.findElement(By.id("username")).sendKeys("thinhme99");
		driver.findElement(By.id("password")).sendKeys("thinh12345");
		driver.findElement(By.id("dologin")).click();
		driver.findElement(By.id("tinh_lai_button")).click();
		driver.findElement(By.id("name")).sendKeys("Vu Chien Thang");
		driver.findElement(By.id("tim_kiem_khach_hang")).click();
		driver.findElement(By.id("xem_cac_khoan_vay")).click();
		String khong_khoanvay = driver.findElement(By.id("khach_hang_khong_co_khoan_vay")).getText();
		String expectedKhong_khoanvay = "Khách hàng không có khoản vay";
		assertEquals(khong_khoanvay, expectedKhong_khoanvay);
		driver.findElement(By.id("kkv_quay_lai_trang_danh_sach_kh")).click();
		driver.findElement(By.id("quay_lai_trang_tim_kiem_kh")).click();
		driver.findElement(By.id("quay_lai_trang_chu")).click();
		String title = driver.getTitle();
		String expectedTitle = "Trang chủ";
		assertEquals(title, expectedTitle);
		driver.close();
	}
	
}