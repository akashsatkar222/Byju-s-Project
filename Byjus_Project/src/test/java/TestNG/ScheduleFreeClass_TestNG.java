package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Byjus_POMClasses.HomePage_POM_Class;
import browser.BrowserSetup;

public class ScheduleFreeClass_TestNG {
	
	WebDriver driver;
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite");
	}
	@Parameters("browser")
	@BeforeTest
	public void launchTheBrowser(String browser) {
		System.out.println("Before Test");
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\AKASH\\Desktop\\Software testing class\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();
		if (browser.equals("Chrome")) {
			driver=BrowserSetup.openChromeBrowser();
		}
		if (browser.equals("Edge")) {
			driver=BrowserSetup.openEdgeBrowser();
		}
		driver.get("https://byjus.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
	}
	HomePage_POM_Class homePage_POM_Class;
	@BeforeClass
	public void createPOMObject() {
		System.out.println("Before Class");
		homePage_POM_Class = new HomePage_POM_Class(driver);
	}
	@BeforeMethod
	public void enterYourDetails() {
		System.out.println("Before Method");
	}
	@Test
	public void clickOnScheduleFreeClassButton() {
		homePage_POM_Class.enterYourNameAndMobile("Akash Satkar", "7972238153");
		homePage_POM_Class.enterYourEmailAndState("akashsatkar222@gmail.com", "Maharashtra");
		homePage_POM_Class.clickOnSendOTPButton();
		homePage_POM_Class.clickOnScheduleFreeClass();
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		driver.navigate().refresh();
	}
	@AfterClass
	public void clearPOMObject() {
		System.out.println("After Class");
		homePage_POM_Class= null;
	}
	@AfterTest
	public void closeTheBrowser() {
		System.out.println("After Test");
		driver.quit();
		driver=null;
		System.gc();// Garbage collector
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}

}
