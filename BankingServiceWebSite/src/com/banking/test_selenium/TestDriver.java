package com.banking.test_selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {
	private String driverUrl = "C:\\Users\\Thinh_Me\\Downloads\\chromedriver_win32\\chromedriver.exe";

	public TestDriver() {
	}

	public ChromeDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", driverUrl);
		return new ChromeDriver();
	}
}
