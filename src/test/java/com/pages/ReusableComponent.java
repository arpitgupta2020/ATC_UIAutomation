package com.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.objectRepository.AddressScreen;
import com.objectRepository.LandingScreen;
import com.objectRepository.LoginScreen;
import com.objectRepository.HomepageScreen;

import Assignment.ApplicationFields;
import Assignment.Base;

public class ReusableComponent extends Base{
	
	static WebDriver driver;
	private LandingScreen ls;
	private LoginScreen login;
	private AddressScreen address;
	private HomepageScreen homePage;
	
	public WebDriverWait wait;
	
	public ReusableComponent() {
		try 
		{
			driver= initializeDriver();
			ls = new LandingScreen(driver);
			login= new LoginScreen(driver);
			address= new AddressScreen(driver);
			homePage= new HomepageScreen(driver);
			wait= new WebDriverWait(driver, 10);
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}	

	public void navigateToApplication() throws IOException {
		
		ls.SignInButton().click();
	}

	public void loginToApplication(String username, String password) {
		
		login.email().sendKeys(username);
		login.password().sendKeys(password);
		login.signIn().click();
		
		//Verify Title
		verifyTitle();
	}

	private void verifyTitle() {
		//Assert title after login
		Assert.assertEquals(driver.getTitle(), ApplicationFields.dashBoardPageTitle);
	}

	public void navigateToAddAddresses(){
		
		address.myAddressesButton().click();
		Assert.assertEquals(address.myAddressesHeader().getText(), ApplicationFields.myAddressesText);
	}

	public void addNewAddress(String firstName, String lastName, String company, String address1, String address2, String city,
			String state, String zipCode, String country, String homePhone, String mobilephone, String additionInfo, String alias) {
		
		//Generating ramdom string to handle Address details every time since we are using mock data
		// So duplicate address alias will not be allowed
		String randString= RandomStringUtils.randomAlphabetic(3);

		address.addNewAddressButton().click();
		address.firstName().clear();
		address.firstName().sendKeys(firstName);
		address.lastName().clear();
		address.lastName().sendKeys(lastName);
		address.company().clear();
		address.company().sendKeys(company);
		address.addressLine1().sendKeys(address1);
		address.addressLine2().sendKeys(address2);
		address.city().sendKeys(city);
		SelectState(state);
		address.postalCode().sendKeys(zipCode);
		selectCountry(country);
		address.homephone().sendKeys(homePhone);
		address.mobilephone().sendKeys(mobilephone);
		address.additionInfoTextarea().sendKeys(additionInfo);
		address.addressTitleAlias().clear();
		address.addressTitleAlias().sendKeys(alias + randString);
	}

	private void selectCountry(String country) {
		Select sel= new Select(address.countryDropdown());
		sel.selectByVisibleText(country);
	}

	private void SelectState(String state) {
		Select sel= new Select(address.stateDropdown());
		sel.selectByVisibleText(state);
	}

	public void saveAddress() {
		address.saveAddressButton().click();
	}

	public void navigateToWomen_SummerDressesAndAddItemsToCart() {
		//Since flow is same to Add item in cart. Hence looping it with number of items
		for(int i=1; i <= ApplicationFields.numberOfDressesToAdd; i++) {
			//navigate To Women Section And Select Summer Dresses
			navigateToWomenSectionAndSelectSummerDresses();
			verifySummerDressesHeader();
			selectViewAsListType();
			selectItemFromList(i);
			increaseQuantityOfItem();
			selectSizeAsLarge();
			selectColor();
			clickOnAddToCartButton();
			if(i != ApplicationFields.numberOfDressesToAdd) {
				clickOnContinueShopping();
			}			
		}
		
		clickOnProceedToCheckout();
		
	}

	private void navigateToWomenSectionAndSelectSummerDresses() {
		Actions actions= new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(homePage.womenLinkInNavTab()));
		actions.moveToElement(homePage.womenLinkInNavTab()).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.link_SummerDresses()));
		homePage.link_SummerDresses().click();
	}	
	
	private void verifySummerDressesHeader() {
		Assert.assertTrue(homePage.header_SummerDresses().isDisplayed(), "Summer Dresses header is displayed");
	}

	private void selectViewAsListType() {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.listGrid_Icon()));
		homePage.listGrid_Icon().click();
	}

	private void selectItemFromList(int i) {
		List<WebElement> itemsLink= homePage.item_Link();
		
		wait.until(ExpectedConditions.elementToBeClickable(itemsLink.get(i-1)));
		scrollToElementUsingJS(itemsLink.get(i-1));
		itemsLink.get(i-1).click();
	}
	
	private void increaseQuantityOfItem() {
		for(int j=1; j< ApplicationFields.QuantityOfItems; j++) {
			wait.until(ExpectedConditions.elementToBeClickable(homePage.addQuantityIcon()));
			homePage.addQuantityIcon().click();
		}
	}	

	private void selectSizeAsLarge() {
		Select sel= new Select(homePage.size_Dropdown());
		sel.selectByVisibleText(ApplicationFields.sizeToSelect);
	}

	private void selectColor() {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.colorToSelect()));
		homePage.colorToSelect().click();
	}

	private void clickOnAddToCartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.addToCart_Button()));
		homePage.addToCart_Button().click();
	}

	private void clickOnContinueShopping() {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.continueShoppingButton()));
		homePage.continueShoppingButton().click();
	}

	private void clickOnProceedToCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.proceedToCheckoutButton()));
		homePage.proceedToCheckoutButton().click();
	}

	public void proceedToCheckoutAndCompletePayment() {
		clickOnProceedSummary();
		clickOnProceedAddress();
		clickOnProceedShipping();
		selectPayByCheckMode();
		clickOnConfirmOrderButton();
		verifyOrderCompleteSuccessMessage();
	}

	private void clickOnProceedSummary() {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.proceedToCheckout_SummaryPage()));
		homePage.proceedToCheckout_SummaryPage().click();
	}
	
	private void clickOnProceedAddress() {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.proceedAddressButton()));
		homePage.proceedAddressButton().click();
	}

	private void clickOnProceedShipping() {
		// I agree checkbox
		selectTermsOfServiceCheckbox();
		
		wait.until(ExpectedConditions.elementToBeClickable(homePage.proceedShipping()));
		homePage.proceedShipping().click();
	}

	private void selectTermsOfServiceCheckbox() {
		homePage.IAgreeCheckbox().click();
	}

	private void selectPayByCheckMode() {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.payByCheckButton()));
		homePage.payByCheckButton().click();
	}
	
	private void clickOnConfirmOrderButton() {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.confirmMyOrderButton()));
		homePage.confirmMyOrderButton().click();
	}

	private void verifyOrderCompleteSuccessMessage() {
		Assert.assertTrue(homePage.orderConfirmationHeader().isDisplayed());
		Assert.assertEquals(homePage.orderSuccessMessage().getText(), ApplicationFields.orderCompleteSuccessMessage);
	}

	// Verify Order History and details and take screenshot
	public void verifyOrderHistoryAndDetails() {
		navigateToOrderHistoryAndDetailsPage();
		verifyOrderHistoryPageDisplayed();
		
		//Capture Screenshot
		captureScreenshot();
		signOutFromApplication();
		teardown();
	}

	private void navigateToOrderHistoryAndDetailsPage() {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.myProfileInNavTab()));
		homePage.myProfileInNavTab().click();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.orderHistoryAndDetailsButton()));
		homePage.orderHistoryAndDetailsButton().click();
	}
	
	private void verifyOrderHistoryPageDisplayed() {
		Assert.assertTrue(homePage.orderHistoryPageHeader().isDisplayed());
		scrollToElementUsingJS(homePage.orderHistoryPageHeader());
	}

	private void scrollToElementUsingJS(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void captureScreenshot() {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File srcFile= ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("OrderHistory.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void signOutFromApplication() {
		wait.until(ExpectedConditions.elementToBeClickable(homePage.signOutButton()));
		homePage.signOutButton().click();
	}
	
	//Close Browser
	private void teardown() {
		driver.close();
	}
}
