package com.scubaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By title = By.className("title");
	By menu = By.xpath("//button[text()='Open Menu']");
	By logout = By.xpath("(//a[@id='about_sidebar_link']//following::a)[1]");

	By itemName = By.linkText("Sauce Labs Backpack");
	By item1 = By.xpath("(//button[contains(@class,\"btn_primary\")])[1]");
	By item2 = By.xpath("(//button[contains(@class,\"btn_primary\")])[2]");
	By item3 = By.xpath("(//button[contains(@class,\"btn_primary\")])[3]");
	By addToCartButton = By.xpath("//button[contains(@name,\"add-to-cart\")]");
	By cartButton = By.xpath("//a[starts-with(@class,\"shopping\")]");
	By cartCount = By.className("shopping_cart_badge");

	public void logout() throws InterruptedException {
		driver.findElement(menu).click();
		Thread.sleep(500);
		driver.findElement(logout).click();
	}

	public void selectProduct() {
		driver.findElement(itemName).click();
		driver.findElement(addToCartButton).click();
		driver.findElement(cartButton).click();
	}

	public void verifyTitle() {
		String expectedText = "Products";
		String actualText = driver.findElement(title).getText();
		if (actualText.equalsIgnoreCase(expectedText)) {
			System.out.println("Entered valid credentials");
		}
	}

	public void selectMultipleProducts() throws InterruptedException {
		driver.findElement(item1).click();
		driver.findElement(item2).click();
		driver.findElement(item3).click();
		driver.findElement(item1).click();
		driver.findElement(item2).click();
	}

	public void verifyCount() {
		String expectedCount = "5";
		String actualCount = driver.findElement(cartCount).getText();
		if (actualCount.equals(expectedCount)) {
			driver.findElement(cartButton).click();
		}
	}

}
