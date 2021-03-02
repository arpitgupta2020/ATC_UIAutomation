package com.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingScreen {
	
	WebDriver driver;
	
	public LandingScreen(WebDriver driver) {
		this.driver= driver;
	}
	
	By SignInButton= By.cssSelector("a[class='login']");
	
	public WebElement SignInButton() {
		return driver.findElement(SignInButton);
	}
	
}
