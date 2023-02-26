package com.scubaPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPages {

	WebDriver driver;

	public CheckoutPages(WebDriver driver) {
		this.driver = driver;
	}

	By cartTitle = By.className("title");
	By checkoutButton = By.xpath("//button[text()='Checkout']");
	By checkoutTitle = By.className("title");
	By firstNameText = By.id("first-name");
	By lastNameText = By.id("last-name");
	By zipCodeText = By.xpath("//div[@class='form_group']//child::input[@placeholder='Zip/Postal Code']");
	By continueButton = By.xpath("//button[@name='cancel']//following::input");
	By previewTitle = By.className("title");
	By itemName = By.className("inventory_item_name");
	By paymentDetail = By.xpath("(//div[@class='summary_value_label'])[1]");
	By shipmenDetail = By.xpath("(//div[@class='summary_value_label'])[2]");
	By itemPrice = By.className("summary_subtotal_label");
	By tax = By.className("summary_tax_label");
	By totalAmount = By.className("summary_total_label");
	By finishButton = By.id("finish");
	By confirmationText1 = By.className("title");
	By confirmationText2 = By.className("complete-header");
	By confirmationText3 = By.className("complete-text");
	By backButton = By.id("back-to-products");

	public void orderOneProduct(String firstName, String lastName, String zipCode) {
		driver.findElement(checkoutButton).click();
		checkoutValidation(firstName, lastName, zipCode);
		previewValidation();
		successValidation();
	}

	public void orderMultipleProducts(String firstName, String lastName, String zipCode) {
		String expectedTitle3 = "Your Cart";
		String actualTitle3 = driver.findElement(cartTitle).getText();
		if (actualTitle3.equalsIgnoreCase(expectedTitle3)) {
			driver.findElement(checkoutButton).click();
		}
		checkoutValidation(firstName, lastName, zipCode);
		previewValidation();
		successValidation();
	}

	public void checkoutValidation(String firstName, String lastName, String zipCode) {
		String expectedTitle = "Checkout: Your Information";
		String actualTitle = driver.findElement(checkoutTitle).getText();
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			driver.findElement(firstNameText).sendKeys(firstName);
			driver.findElement(lastNameText).sendKeys(lastName);
			driver.findElement(zipCodeText).sendKeys(zipCode);
			driver.findElement(continueButton).click();
		}
	}

	public void previewValidation() {
		String expectedTitle = "Checkout: Overview";
		String actualTitle = driver.findElement(previewTitle).getText();
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Items Names: ");
			List<WebElement> items = driver.findElements(itemName);
			for (WebElement webElement : items) {
				System.out.println(webElement.getText());
			}
			System.out.println("Payment Detail: " + driver.findElement(paymentDetail).getText());
			System.out.println("Shipment Detail: " + driver.findElement(shipmenDetail).getText());
			System.out.println(driver.findElement(itemPrice).getText());
			System.out.println(driver.findElement(tax).getText());
			System.out.println(driver.findElement(totalAmount).getText());
			driver.findElement(finishButton).click();
		}
	}

	public void successValidation() {
		String expectedText1 = "Checkout: Complete!";
		String expectedText2 = "THANK YOU FOR YOUR ORDER";
		String expectedText3 = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actualText1 = driver.findElement(confirmationText1).getText();
		String actualText2 = driver.findElement(confirmationText2).getText();
		String actualText3 = driver.findElement(confirmationText3).getText();
		if (expectedText1.equalsIgnoreCase(actualText1) && expectedText2.equalsIgnoreCase(actualText2)
				&& expectedText3.equalsIgnoreCase(actualText3)) {
			driver.findElement(backButton).click();
		}
	}

}