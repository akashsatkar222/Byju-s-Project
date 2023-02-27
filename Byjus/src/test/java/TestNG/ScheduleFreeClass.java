package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POM_Classes.HomePage_POM;
import browser.BrowserSetup;

public class ScheduleFreeClass {
	WebDriver driver;
	HomePage_POM homePage_POM;
	@Parameters("browser")
	@BeforeTest
	public void launchTheBrowser(String browser) {
		if (browser.equals("Chrome")) {
			driver=BrowserSetup.openChromeBrowser();
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\AKASH\\Desktop\\Software testing class\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");
//			driver = new ChromeDriver();
			
		}
		if (browser.equals("Edge")) {
			driver=BrowserSetup.openEdgeBrowser();
//			System.setProperty("webdriver.edge.driver", "C:\\Users\\AKASH\\Desktop\\Software testing class\\Automation\\Selenium\\edgedriver_win64\\msedgedriver.exe");
//			driver = new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@BeforeClass
	public void enterURL() {
		driver.get("https://byjus.com/");
		
    }
    
	@BeforeMethod
	public void createPOMObject() {
		homePage_POM = new HomePage_POM(driver);
		
	}
	@Test 
	public void clickOnScheduleFreeClassButton() throws InterruptedException {
		homePage_POM.enterName("Akash");
		homePage_POM.enterMobileNumber("7972238153");
		homePage_POM.enterEmail("akashsatkar222@gmail.com");
		homePage_POM.selectState("Maharashtra");
//		homePage_POM.clickOnSendOTPButton();
//		Thread.sleep(10000);
//		homePage_POM.selectYourClass("Class 3");
		homePage_POM.clickOnScheduleFreeClassButton();
//		Thread.sleep(10000);
	}
	
	@AfterMethod
	public void clearPOMObject() {
		homePage_POM = null;
	}
	@AfterClass
	public void closeTheBrowser() {
		driver.quit();
	}
	@AfterTest
	public void clearSystem() {
		driver = null ;
		System.gc();// Garbage collector
	}


}
