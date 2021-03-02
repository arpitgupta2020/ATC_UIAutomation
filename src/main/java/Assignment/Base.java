package Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop= new Properties();
		
		FileInputStream fis= new FileInputStream("config.properties");
		
		prop.load(fis);
		
		String browserName= prop.getProperty("browser");
		String url= prop.getProperty("ApplicationUrl");
		
		//If Browser is Chrome
		if(browserName.equalsIgnoreCase(ApplicationFields.chromeBrowserText)) {
			WebDriverManager.chromedriver().setup();				
			driver= new ChromeDriver();
		}
		
		//If Browser is Firefox
		if(browserName.equalsIgnoreCase(ApplicationFields.firefoxBrowserText)) {
			WebDriverManager.firefoxdriver().setup();				
			driver= new FirefoxDriver();
		}
		
		//If Browser is Internet Explorer
		if(browserName.equalsIgnoreCase(ApplicationFields.ieBrowserText)) {
			WebDriverManager.iedriver().setup();			
			driver= new InternetExplorerDriver();
		}
		
		driver.get(url);
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
}
