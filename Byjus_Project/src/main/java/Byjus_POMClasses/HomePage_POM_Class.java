package Byjus_POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage_POM_Class {
	
	@FindBy (xpath="(//input[@type='text'])[1]")private WebElement childName;
	@FindBy (xpath="(//input[@type='text'])[2]")private WebElement mobileNumber;
	@FindBy (xpath="(//button[@type='button'])[3]")private WebElement sendOTP;
	@FindBy (xpath="//input[@type='email']")private WebElement emailAddress;
	@FindBy (xpath="(//select[@class='form-control'])[2]")private WebElement listBox;
	@FindBy (xpath="//button[contains(text(),'Schedule')]") WebElement scheduleFreeClass;
	@FindBy (xpath="//a[text()='Buy a Course ']")private WebElement buyACourse;
	@FindBy (xpath="(//a[text()='Login'])[2]")private WebElement login;
	
	private WebDriver driver;
	private Select s;
	public HomePage_POM_Class(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		s = new Select(listBox);
	}
	
	public void enterYourNameAndMobile(String name, String mobile) {
		childName.sendKeys(name);
		mobileNumber.sendKeys(mobile);
	}
	public void clickOnSendOTPButton() {
		sendOTP.click();
	}
	public void enterYourEmailAndState(String email, String state) {
		emailAddress.sendKeys(email);
		s.selectByVisibleText(state);
	}
	public void clickOnScheduleFreeClass() {
		scheduleFreeClass.click();
	}
	public void clickOnBuyACourse() {
		buyACourse.click();
	}
	public void clickOnLogin() {
		login.click();
	}
	
	
}
