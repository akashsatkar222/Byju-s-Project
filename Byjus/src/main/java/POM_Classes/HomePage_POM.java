package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage_POM {
	
	@FindBy(xpath = "abc") private WebElement xyz;
	
	@FindBy(xpath = "(//a[@role='button'])[6]") private WebElement buyACourse;
	@FindBy(xpath = "(//input[@type='text'])[1]") private WebElement name;
	@FindBy(xpath = "(//input[@type='text'])[2]") private WebElement mobileNo;
	@FindBy(xpath = "(//button[@type='button'])[3]") private WebElement sendOTP;
	@FindBy(xpath = "//input[@type='email']") private WebElement email;
	@FindBy(xpath = "(//select[@class='form-control'])[2]") private WebElement stateListBox;
	@FindBy(xpath = "//button[contains(text(),'Schedule')]") private WebElement scheduleFreeClass;
	@FindBy(xpath = "//select[@name='grade']") private WebElement selectClass;
    
	public HomePage_POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBuyACourse() {
		buyACourse.click();
	}
	public void enterName(String nameOfChild) {
		name.sendKeys(nameOfChild);
	}
	public void enterMobileNumber(String mobileNumber) {
		mobileNo.sendKeys(mobileNumber);
	}
	public void clickOnSendOTPButton() {
		sendOTP.click();
	}
	public void enterEmail(String emailID) {
		email.sendKeys(emailID);
	}
	public void selectState(String state) {
		Select s = new Select(stateListBox);
		s.selectByVisibleText(state);
	}
	public void selectYourClass(String className) {
		Select s = new Select(selectClass);
		s.selectByVisibleText(className);
	}
	public void clickOnScheduleFreeClassButton() {
		scheduleFreeClass.click();
	}
	
}
