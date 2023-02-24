package TestNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Facebook_POMclasses.LoginOrSignUpPage;
import browser.BrowserSetup;
import utils.Utility;

public class TestNG_Login_Facebook {

	private WebDriver driver ;
	private String testID;
	LoginOrSignUpPage loginOrSignUpPage;
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
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//		driver.manage().window().maximize();
	}
	@BeforeClass
	public void createPOMObject() {
		System.out.println("Before class");
		driver.get("https://www.facebook.com/");
	}
	
	@BeforeMethod
	public void goToSignupForm() throws IOException {
		System.out.println("Before Method");
		loginOrSignUpPage = new LoginOrSignUpPage(driver);
//		String data = Utility.getDataFromExcelSheet("FB Login", 1, 0);
		loginOrSignUpPage.enterEmailOrPhoneNo(Utility.getDataFromExcelSheet("FB Login", 1, 0));
//		data = Utility.getDataFromExcelSheet("FB Login", 1, 1);
		loginOrSignUpPage.enterPassword(Utility.getDataFromExcelSheet("FB Login", 1, 1));
	}
	@Test 
	public void termsPageOpen() {
		
		testID = "TC001";
		loginOrSignUpPage.clickOnLoginButton();
		System.out.println("Test 1");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException  {
		System.out.println("After Method");
        if (ITestResult.FAILURE==result.getStatus()) {
        	Utility.captureScreenshot(driver, testID);
        }
	}
	@AfterClass
	public void clearPOMObject() {
		System.out.println("After class");
		loginOrSignUpPage = null;
	}
	@AfterTest
	public void closeTheBrowser() {
		System.out.println("After test");
		driver.quit();
		driver = null ;
		
		System.gc();// Garbage collector
	}
}
