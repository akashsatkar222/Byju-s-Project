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
import org.testng.asserts.SoftAssert;

import Byjus_POMClasses.CourseDetailsPage_POM_Class;
import Byjus_POMClasses.HomePage_POM_Class;
import Byjus_POMClasses.IAS_ProductPage_POM_Class;
import Byjus_POMClasses.ProductPage_POM_Class;
import browser.BrowserSetup;

public class BuyACourse_TestNG {
	
	WebDriver driver;
	SoftAssert soft;
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
	ProductPage_POM_Class productPage_POM_Class;
	IAS_ProductPage_POM_Class iAS_ProductPage_POM_Class;
	CourseDetailsPage_POM_Class courseDetailsPage_POM_Class;
	@BeforeClass
	public void createPOMObject() {
		System.out.println("Before Class");
		homePage_POM_Class = new HomePage_POM_Class(driver);
		homePage_POM_Class.clickOnBuyACourse();
		productPage_POM_Class = new ProductPage_POM_Class(driver);
		productPage_POM_Class.clickOnIASButton();
		
	}
	@BeforeMethod
	public void selectCourse() {
		System.out.println("Before Method");
		iAS_ProductPage_POM_Class = new IAS_ProductPage_POM_Class(driver);
		iAS_ProductPage_POM_Class.setFilterByAndSortBy("IAS", "Price, low to high");
		
		soft = new SoftAssert();
	}
	@Test
	public void buyAFirstCourse() {
		System.out.println("Test 1");
		iAS_ProductPage_POM_Class.getFirstCourseTitle();
		iAS_ProductPage_POM_Class.clickOnFirstCourse();
		courseDetailsPage_POM_Class = new CourseDetailsPage_POM_Class(driver);
		courseDetailsPage_POM_Class.getCourseTitle();
		courseDetailsPage_POM_Class.selectTheTablet("Samsung Tab 10”");
		soft.assertEquals(courseDetailsPage_POM_Class.text, iAS_ProductPage_POM_Class.text, "Course Title Wrong");
		soft.assertAll();
		courseDetailsPage_POM_Class.clickOnBuyNowButton();
	}
	@Test
	public void buyASecondCourse() {
		System.out.println("Test 2");
		iAS_ProductPage_POM_Class.getSecondCourseTitle();
		iAS_ProductPage_POM_Class.clickOnSecondCourse();
		courseDetailsPage_POM_Class.getCourseTitle();
		courseDetailsPage_POM_Class.selectTheTablet("Samsung Tab 10”");
		soft.assertEquals(courseDetailsPage_POM_Class.text, iAS_ProductPage_POM_Class.text, "Course Title Wrong");
		soft.assertAll();
		courseDetailsPage_POM_Class.clickOnBuyNowButton();
	}
	@AfterMethod 
	public void afterMethod() throws InterruptedException {
		System.out.println("After Method");
		driver.navigate().back();
		driver.navigate().back();
	}
	@AfterClass
	public void clearPOMObject() {
		System.out.println("After Class");
		homePage_POM_Class= null;
		productPage_POM_Class= null;
		iAS_ProductPage_POM_Class= null;
		courseDetailsPage_POM_Class= null;
		
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
