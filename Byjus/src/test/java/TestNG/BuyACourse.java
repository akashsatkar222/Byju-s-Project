package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Classes.ByjusProductPage;
import POM_Classes.CourseDetailsPage;
import POM_Classes.HomePage_POM;
import POM_Classes.IASProductPage;
import browser.BrowserSetup;

public class BuyACourse {
	
	WebDriver driver;
	HomePage_POM homePage_POM;
	ByjusProductPage byjusProductPage;
	IASProductPage iASProductPage;
	CourseDetailsPage courseDetailsPage;
	@Parameters("browser")
	@BeforeTest
	public void launchTheBrowser(String browser) {
		if (browser.equals("Chrome")) {
			driver=BrowserSetup.openChromeBrowser();
			
		}
		if (browser.equals("Edge")) {
			driver=BrowserSetup.openEdgeBrowser();
			
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	@BeforeClass
	public void createPOMObject() {
		driver.get("https://byjus.com/");
		homePage_POM = new HomePage_POM(driver);
		byjusProductPage = new ByjusProductPage(driver);
		iASProductPage = new IASProductPage(driver);
		courseDetailsPage = new CourseDetailsPage(driver);
    }
    
	@BeforeMethod
	public void seeTheIASCourse() {
		homePage_POM.clickOnBuyACourse();
		byjusProductPage.clickOnIAS();
		iASProductPage.applyFilterOnIASCourse("IAS", "Price, low to high");
	}
	@Test (priority = -1)
	public void buyACourse(){
		iASProductPage.getFirstCourseTitle();
		iASProductPage.clickOnFirstCourse();
		courseDetailsPage.getCourseTitle();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(iASProductPage.result1, courseDetailsPage.result2, "Title wrong");
		soft.assertAll();
		
		courseDetailsPage.selectTablet("Samsung Tab 10”");
		courseDetailsPage.clickOnBuyNowButton();
	}
		
	@AfterMethod
	public void backToCourseDetailsPage() {
		driver.navigate().back();
	}
	@AfterClass
	public void clearPOMObject() {
		homePage_POM = null;
		byjusProductPage = null;
		iASProductPage = null;
		courseDetailsPage = null;
	}
	@AfterTest
	public void closeTheBrowser() {
		driver.quit();
		driver = null ;
		System.gc();// Garbage collector
	}



}
