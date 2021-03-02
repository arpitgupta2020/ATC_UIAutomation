package com.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomepageScreen {
	WebDriver driver;
	
	public HomepageScreen(WebDriver driver) {
		this.driver= driver;
	}
	
	By womenLinkInNavTab= By.cssSelector("a[title='Women']");
	By link_SummerDresses= By.xpath("//a[@title='Summer Dresses']");
	By header_SummerDresses= By.xpath("//h1/span[contains(text(), 'Summer Dresses')]");
	By listGrid_Icon= By.cssSelector("a[title='List'] i");
	By quantityInputField= By.cssSelector("#quantity_wanted");
	By addQuantityIcon= By.xpath("//a[contains(@class,'product_quantity_up')]");
	By size_Dropdown= By.id("group_1");
	By colorToSelect= By.xpath("//ul[@id='color_to_pick_list']/li");
	By addToCart_Button= By.cssSelector("button[name='Submit'] span");
	By continueShoppingButton= By.xpath("//span[@title='Continue shopping']");
	By proceedToCheckoutButton= By.xpath("//a[@title='Proceed to checkout']");
	By proceedToCheckout_SummaryPage= By.xpath("(//a[@title='Proceed to checkout'])[2]");
	By proceedAddressButton= By.xpath("//button[@name='processAddress']");
	By proceedShipping= By.xpath("//button[@name='processCarrier']");
	By IAgreeCheckbox= By.xpath("//input[@type='checkbox' and @id='cgv']");
	By payByCheckButton= By.xpath("//a[contains(@title,'Pay by check')]");
	By confirmMyOrderButton= By.xpath("//span[text()='I confirm my order']/parent::button");
	By orderSuccessMessage= By.xpath("//p[@class='alert alert-success']");
	By orderConfirmationHeader= By.xpath("//h1[text()='Order confirmation']");
	
	By myProfileInNavTab= By.cssSelector("a[title='View my customer account']");
	By orderHistoryAndDetailsButton= By.cssSelector("a[title='Orders']");
	By orderHistoryPageHeader= By.xpath("//h1[normalize-space()='Order history']");
	By signOutButton= By.className("logout");

	By itemLink= By.xpath("//h5[@itemprop='name']/a");
	
	
	public List<WebElement> item_Link() {
		return driver.findElements(itemLink);
	}
	
	public WebElement womenLinkInNavTab() {
		return driver.findElement(womenLinkInNavTab);
	}
	
	public WebElement link_SummerDresses() {
		return driver.findElement(link_SummerDresses);
	}
	
	public WebElement header_SummerDresses() {
		return driver.findElement(header_SummerDresses);
	}
	
	public WebElement listGrid_Icon() {
		return driver.findElement(listGrid_Icon);
	}
	
	public WebElement quantityInputField() {
		return driver.findElement(quantityInputField);
	}
	
	public WebElement addQuantityIcon() {
		return driver.findElement(addQuantityIcon);
	}
	
	public WebElement size_Dropdown() {
		return driver.findElement(size_Dropdown);
	}
	
	public WebElement colorToSelect() {
		return driver.findElement(colorToSelect);
	}
	
	public WebElement addToCart_Button() {
		return driver.findElement(addToCart_Button);
	}
	
	public WebElement continueShoppingButton() {
		return driver.findElement(continueShoppingButton);
	}
	
	public WebElement proceedToCheckoutButton() {
		return driver.findElement(proceedToCheckoutButton);
	}
	
	public WebElement proceedAddressButton() {
		return driver.findElement(proceedAddressButton);
	}
	
	public WebElement proceedToCheckout_SummaryPage() {
		return driver.findElement(proceedToCheckout_SummaryPage);
	}
	
	public WebElement proceedShipping() {
		return driver.findElement(proceedShipping);
	}
	
	public WebElement IAgreeCheckbox() {
		return driver.findElement(IAgreeCheckbox);
	}
	
	public WebElement payByCheckButton() {
		return driver.findElement(payByCheckButton);
	}
	
	public WebElement confirmMyOrderButton() {
		return driver.findElement(confirmMyOrderButton);
	}
	
	public WebElement orderSuccessMessage() {
		return driver.findElement(orderSuccessMessage);
	}
	
	public WebElement orderConfirmationHeader() {
		return driver.findElement(orderConfirmationHeader);
	}
	
	public WebElement myProfileInNavTab() {
		return driver.findElement(myProfileInNavTab);
	}
	
	public WebElement orderHistoryAndDetailsButton() {
		return driver.findElement(orderHistoryAndDetailsButton);
	}
	
	public WebElement orderHistoryPageHeader() {
		return driver.findElement(orderHistoryPageHeader);
	}
	
	public WebElement signOutButton() {
		return driver.findElement(signOutButton);
	}
	
}
