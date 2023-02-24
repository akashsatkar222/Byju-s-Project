package Facebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Facebook_POMclasses.ForgotPasswordPage;
import Facebook_POMclasses.LoginOrSignUpPage;

public class Facebook_ForgotPassword {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AKASH\\Desktop\\Software testing class\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.clickOnForgotPasswordLink();
		
		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
		forgotPasswordPage.getForgotWindowMessage();
		forgotPasswordPage.enterEmailOrPhoneNo();
//		forgotPasswordPage.clickOnCancelButton();
		forgotPasswordPage.clickOnSearchButton();
		
	}

}
