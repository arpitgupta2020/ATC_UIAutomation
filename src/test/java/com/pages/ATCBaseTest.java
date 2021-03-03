package com.pages;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.objectRepository.LandingScreen;
import com.objectRepository.LoginScreen;

import Assignment.Base;

public class ATCBaseTest extends Base{
	
	WebDriver driver;
	ReusableComponent reusableComponent= new ReusableComponent();
	
	@Test
	public void basePageNavigation() throws IOException {
		reusableComponent.navigateToApplication();
	}
	
	@Test(dependsOnMethods = "basePageNavigation", dataProvider = "getUserCredentials")
	public void loginApplication(String username, String password) {
		
		reusableComponent.loginToApplication(username, password);		
	}
	
	@Test(dependsOnMethods="loginApplication", dataProvider = "getAddressDetails")
	public void navigateMyAddressesAndAddAddress(String firstName, String lastName, String company, String address1, String address2, String city,
			String state, String zipCode, String country,String homePhone, String mobilephone, String additionInfo, String alias) {
		reusableComponent.navigateToAddAddresses();
		reusableComponent.addNewAddress(firstName, lastName, company, address1, address2, city, state, zipCode, 
				country, homePhone, mobilephone, additionInfo, alias);
		reusableComponent.saveAddress();
	}
	
	@Test(dependsOnMethods= "navigateMyAddressesAndAddAddress")
	public void purchaseItems() {
		reusableComponent.navigateToWomen_SummerDressesAndAddItemsToCart();
		reusableComponent.proceedToCheckoutAndCompletePayment();
		reusableComponent.verifyOrderHistoryAndDetails();
	}
	
	
	@DataProvider
	public Object[][] getUserCredentials(){
		
		Object[][] data= new Object[1][2];
		
		data[0][0] = "automationtest1@gmail.com";
		data[0][1] = "Arpit@123";
		
		return data;
		
	}
	
	@DataProvider
	public Object[][] getAddressDetails(){
		
		Object[][] data= new Object[1][13];
		
		data[0][0] = "Arpit";
		data[0][1] = "Gupta";
		data[0][2] = "IQVIA";
		data[0][3] = "AddLine1";
		data[0][4] = "AddLine2";
		data[0][5] = "AddCity";
		data[0][6] = "Alabama";
		data[0][7] = "12345";
		data[0][8] = "United States";
		data[0][9] = "0001111000";
		data[0][10] = "9991114444";
		data[0][11] = "AdditionalText";
		data[0][12] = "My Address Alias";
		
		return data;
		
	}

}
