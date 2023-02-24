package TestNG;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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

import Facebook_POMclasses.CreateNewAccount;
import Facebook_POMclasses.LoginOrSignUpPage;
import browser.BrowserSetup;

public class TestNGClass_Facebook_2 extends BrowserSetup{
	WebDriver driver ;
	LoginOrSignUpPage loginOrSignUpPage;
	CreateNewAccount createNewAccount;
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite 1");
	}
	@Parameters("browser")
	@BeforeTest
	public void launchTheBrowser(String browserName) {
		System.out.println("Before test");
		if (browserName.equals("Chrome")) {
			driver=BrowserSetup.openChromeBrowser();
//			driver=openChromeBrowser();//inheritance is applied
		}
		
		if (browserName.equals("Edge")) {
			driver=BrowserSetup.openEdgeBrowser();
//			driver=openEdgeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		driver.manage().window().maximize();
	}
	@BeforeClass
	public void createPOMObject() {
		System.out.println("Before class");
		driver.get("https://www.facebook.com/");
		loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.clickOnCreatNewAccountButton();
		
		
	}
	
	@BeforeMethod
	public void goToSignupForm() {
		System.out.println("Before Method");
		
	}
    SoftAssert soft;
	@Test 
	public void termsPageOpen() {
		System.out.println("Test 1");
		createNewAccount = new CreateNewAccount(driver);
		createNewAccount.clickOnTerms();
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(3));
		String urlActual = driver.getCurrentUrl();
		String urlExpected="https://www.facebook.com/legal/terms/update";
		soft = new SoftAssert();
		soft.assertEquals(urlActual, urlExpected, "Test is fail");
		soft.assertAll();
//		if (url.equals("https://www.facebook.com/legal/terms/update"))
//		{
//			System.out.println("pass");
//		}
//		else
//		{
//		
//			System.out.println("Fail");
//		}
	}
	@Test 
	public void privacyPolicyPageOpen() {
		System.out.println("Test 2");
		createNewAccount = new CreateNewAccount(driver);
		createNewAccount.clickOnPrivacyPolicy();
	}
	@Test 
	public void cookiesPolicyPageOpen() {
		System.out.println("Test 3");
		createNewAccount = new CreateNewAccount(driver);
		createNewAccount.clickOnCookiesPolicy();
	}
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("After Method");
		createNewAccount.returnToHomePage();

	}
	@AfterClass
	public void clearPOMObject() {
		System.out.println("After class");
		loginOrSignUpPage = null;
		createNewAccount = null;
	}
	@AfterTest
	public void closeTheBrowser() {
		System.out.println("After test");
		driver.quit();
		driver = null ;
		
		System.gc();// Garbage collector
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite 1");
	}

}
