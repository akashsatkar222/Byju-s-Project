package Facebook_POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	// Variable : WebElement : Forgot Password Page
	
	@FindBy (xpath = "//div[@class='_9nq2 marginBottom16px']")
	private WebElement forgotMessage ;
	
	@FindBy (xpath = "//input[@id='identify_email']")
	private WebElement emailOrMobileNo ;
	
	@FindBy (xpath = "//a[text()='Cancel']")
	private WebElement cancel ;
	
	@FindBy (xpath = "//button[text()='Search']")
	private WebElement search ;
	
	// Constructor : Initialization of WebElement : Forgot Password Page
	
	public ForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Methods : Action on WebElement : Forgot Password Page
	
	public void getForgotWindowMessage() {
		String text = forgotMessage.getText();
		System.out.println(text);
	}
	
	public void enterEmailOrPhoneNo() {
		emailOrMobileNo.sendKeys("akashsatkar@gmail.com");
	}
	
	public void clickOnCancelButton() {
		cancel.click();
	}
	
	public void clickOnSearchButton() {
		search.click();
	}
	
}
