package com.scubaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.scubaPages.CheckoutPages;
import com.scubaPages.HomePage;
import com.scubaPages.LoginPage;

public class PurchaseProducts {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		CheckoutPages checkoutPages = new CheckoutPages(driver);

		loginPage.userLogin("standard_user", "secret_sauce");
		homePage.selectProduct();
		checkoutPages.orderOneProduct("Gokul", "Palanisamy", "4012");
		homePage.selectMultipleProducts();
		homePage.verifyCount();
		checkoutPages.orderMultipleProducts("Gokul", "Palanisamy", "4012");
		homePage.logout();
		
		driver.quit();

	}

}
