package com.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginScreen {
	
	WebDriver driver;
	
	public LoginScreen(WebDriver driver) {
		this.driver= driver;
	}
	
	By email= By.cssSelector("#email");
	By password= By.cssSelector("#passwd");
	By signInButton= By.cssSelector("#SubmitLogin");
	
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement signIn() {
		return driver.findElement(signInButton);
	}
}
