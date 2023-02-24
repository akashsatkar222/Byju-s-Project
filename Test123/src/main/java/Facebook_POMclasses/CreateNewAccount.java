package Facebook_POMclasses;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAccount {
	
	@FindBy (xpath = "(//input[@type='text'])[2]")
	private WebElement firstName;
	
	@FindBy (xpath = "//input[contains(@name , 'lastname')]")
	private WebElement surname;
	
	@FindBy (xpath = "//input[@name='reg_email__']")
	private WebElement mobileNoOrEmail;
	
	@FindBy (xpath = "//input[@id='password_step_input']")
	private WebElement newPassword;
	
	@FindBy (xpath = "//select[@id='day']")
	private WebElement dayOfBirth;
	
	@FindBy (xpath = "//select[@id='month']")
	private WebElement monthOfBirth;
	
	@FindBy (xpath = "//select[@title='Year']")
	private WebElement yearOfBirth;
	
	@FindBy (xpath = "//label[text()='Male']")
	private WebElement gender;
	
	@FindBy (xpath = "(//button[text()='Sign Up'])[1]")
	private WebElement signUp;
	
	@FindBy (xpath = "//a[@id='terms-link']")
	private WebElement terms;
	
	@FindBy (xpath = "//a[@id='privacy-link']")
	private WebElement privacyPolicy;
	
	@FindBy (xpath = "//a[@id='cookie-use-link']")
	private WebElement cookiesPolycy;
	
	private WebDriver driver;
	private Actions action;
    
	public CreateNewAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
//		action = new Actions(this.driver);   //  1 or
		this.driver = driver ;
		action = new Actions(driver);       //   2
		}
	
	public void enterFirstName(String name) {
		firstName.sendKeys(name);
	}
	public void enterSurname(String surname) {
		this.surname.sendKeys(surname);
	}
	public void enterMobileOrEmail(String mobileOrEmail) {
		mobileNoOrEmail.sendKeys(mobileOrEmail);
	}
	public void enterNewPassword(String password) {
		newPassword.sendKeys(password);
	}
	public void selectDayOfBirth(String day) {
		Select s = new Select(dayOfBirth);
		s.selectByVisibleText(day);
	}
	public void selectMonthOfBirth(String month) {
		Select s = new Select(monthOfBirth);
		s.selectByVisibleText(month);
	}
	public void selectYearOfBirth(String year) {
		Select s = new Select(yearOfBirth);
		s.selectByVisibleText(year);
	}
	public void clickOnGender() {
		gender.click();
	}
	public void clickOnSignUpButton() {
//		Actions action = new Actions(driver);  // or
		action.moveToElement(signUp).click().build().perform();
	}
	public void clickOnTerms() {
		terms.click();
//		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(addr.get(3));
//		String url = driver.getCurrentUrl();
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
	public void clickOnPrivacyPolicy() {
		privacyPolicy.click();
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(2));
		String url = driver.getCurrentUrl();
		if (url.equals("https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0"))
		{
			System.out.println("pass");
		}
		else
		{
		
			System.out.println("Fail");
		}
	}
	public void clickOnCookiesPolicy() {
		cookiesPolycy.click();
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		String url = driver.getCurrentUrl();
		if (url.equals("https://www.facebook.com/privacy/policies/cookies/?entry_point=cookie_policy_redirect&entry=0"))
		{
			System.out.println("pass");
		}
		else
		{
		
			System.out.println("Fail");
		}
	}
	public void returnToHomePage() {
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(0));
	}
	

}
