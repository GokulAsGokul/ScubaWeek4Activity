package com.scubaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.scubaPages.HomePage;
import com.scubaPages.LoginPage;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);

		System.out.println("***** Valid Login *****");
		loginPage.userLogin("standard_user", "secret_sauce");
		homePage.verifyTitle();
		homePage.logout();

		System.out.println("***** Invalid Login *****");
		loginPage.userLogin("standard_user", "secret");
		loginPage.errorVerify();

		driver.quit();
	}

}
