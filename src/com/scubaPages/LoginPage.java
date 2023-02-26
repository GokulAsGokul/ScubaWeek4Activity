package com.scubaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By usernameInput = By.id("user-name");
	By passwordInput = By.id("password");
	By loginButton = By.name("login-button");
	By errorMessage = By.xpath("//h3[@data-test='error']");

	public void userLogin(String username, String password) {

		driver.findElement(usernameInput).clear();
		driver.findElement(usernameInput).sendKeys(username);
		driver.findElement(passwordInput).clear();
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginButton).click();

	}

	public void errorVerify() {
		String expectedText = "Username and password do not match any user in this service";
		String actualText = driver.findElement(errorMessage).getText();
		if (actualText.contains(expectedText)) {
			System.out.println("Entered invalid credentials");
		}
	}

}
