package com.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressScreen {

	WebDriver driver;
	
	public AddressScreen(WebDriver driver) {
		this.driver= driver;
	}
	By myAccount= By.xpath("//h1[normalize-space()='My account']");
	By myAddressesButton= By.xpath("//span[text()='My addresses']/ancestor::a");
	By myAddressesHeader= By.xpath("//h1[normalize-space()='My addresses']");
	By addNewAddressButton= By.cssSelector("a[title='Add an address']");
	By firstName= By.cssSelector("#firstname");
	By lastName= By.cssSelector("#lastname");
	By company= By.id("company");
	By addressLine1= By.id("address1");
	By addressLine2= By.id("address2");
	By city= By.id("city");
	By stateDropdown= By.id("id_state");
	By postalCode= By.id("postcode");
	By countryDropdown= By.id("id_country");
	By homephone= By.id("phone");
	By mobilephone= By.id("phone_mobile");
	By additionInfoTextarea= By.id("other");
	By addressTitleAlias= By.id("alias");
	By saveAddressButton= By.cssSelector("button[id='submitAddress']");
	
	public WebElement myAddressesButton() {
		return driver.findElement(myAddressesButton);
	}
	
	public WebElement myAddressesHeader() {
		return driver.findElement(myAddressesHeader);
	}
	
	public WebElement addNewAddressButton() {
		return driver.findElement(addNewAddressButton);
	}
	
	public WebElement firstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement lastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement company() {
		return driver.findElement(company);
	}
	
	public WebElement addressLine1() {
		return driver.findElement(addressLine1);
	}
	
	public WebElement addressLine2() {
		return driver.findElement(addressLine2);
	}
	
	public WebElement city() {
		return driver.findElement(city);
	}
	
	public WebElement stateDropdown() {
		return driver.findElement(stateDropdown);
	}
	
	public WebElement postalCode() {
		return driver.findElement(postalCode);
	}
	
	public WebElement countryDropdown() {
		return driver.findElement(countryDropdown);
	}
	
	public WebElement homephone() {
		return driver.findElement(homephone);
	}
	
	public WebElement mobilephone() {
		return driver.findElement(mobilephone);
	}
	
	public WebElement additionInfoTextarea() {
		return driver.findElement(additionInfoTextarea);
	}
	
	public WebElement addressTitleAlias() {
		return driver.findElement(addressTitleAlias);
	}
	
	public WebElement saveAddressButton() {
		return driver.findElement(saveAddressButton);
	}
	
	public WebElement myAccount() {
		return driver.findElement(myAccount);
	}
}
