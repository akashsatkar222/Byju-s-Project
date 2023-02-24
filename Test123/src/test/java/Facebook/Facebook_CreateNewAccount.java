package Facebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Facebook_POMclasses.CreateNewAccount;
import Facebook_POMclasses.LoginOrSignUpPage;

public class Facebook_CreateNewAccount {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AKASH\\Desktop\\Software testing class\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.clickOnCreatNewAccountButton();
		CreateNewAccount createNewAccount = new CreateNewAccount(driver);
		createNewAccount.enterFirstName("Akash");
		createNewAccount.enterSurname("Satkar");
		createNewAccount.enterMobileOrEmail("7972238153");
		createNewAccount.enterNewPassword("akash@123");
		createNewAccount.selectDayOfBirth("17");
		createNewAccount.selectMonthOfBirth("Apr");
		createNewAccount.selectYearOfBirth("1997");
		createNewAccount.clickOnGender();
		createNewAccount.clickOnSignUpButton();
		
		createNewAccount.clickOnTerms();
		createNewAccount.clickOnPrivacyPolicy();
		createNewAccount.clickOnCookiesPolicy();
		
		
	}

}
