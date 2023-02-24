package Facebook_POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOrSignUpPage {
	
	// Variable : WebElement : Login Or Sign Up Page
	
	@FindBy (xpath = "//input[@id='email']")
	private WebElement emailOrPhoneNo ;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password ;
	
	@FindBy (xpath = "//button[text()='Log in']")
	private WebElement login ;
	
	@FindBy (xpath = "//a[text()='Forgotten password?']")
	private WebElement forgotPassword ;
	
	@FindBy (xpath = "//a[text()='Create new account']")
	private WebElement creatNewAccount ;
	
	// Constructor : Initialization of WebElement : Login Or Sign Up Page
	private WebDriver driver;
	private WebDriverWait wait;    //  2nd 
	public LoginOrSignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	//Methods : Action on WebElement : Login Or Sign Up Page
	
	public void enterEmailOrPhoneNo(String userName) {
		emailOrPhoneNo.sendKeys(userName);
	}
	
	public void enterPassword(String passwrd) {
		password.sendKeys(passwrd);
	}
	public void clickOnLoginButton() {
		login.click();
	}
	
	public void clickOnForgotPasswordLink() {
//		WebDriverWait wait = new WebDriverWait(driver, 20);  //  1st  or
		wait.until(ExpectedConditions.visibilityOf(forgotPassword));
		forgotPassword.click();
	}
	
	public void clickOnCreatNewAccountButton() {
		creatNewAccount.click();
	}
	

}
