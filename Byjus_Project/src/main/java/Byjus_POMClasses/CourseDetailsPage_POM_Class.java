package Byjus_POMClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseDetailsPage_POM_Class {
	
	@FindBy(xpath="//h1[@class='product-single__title']")private WebElement courseTitle;
	@FindBy(xpath="//button[text()='Buy it now']")private WebElement buyNow;
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")private WebElement addToCart;
	@FindBy(xpath="//select[@id='SingleOptionSelector-0']")private WebElement selectTablet;
    
	public String text;
	private Select tablet;
	private WebDriver driver;
	public CourseDetailsPage_POM_Class(WebDriver driver) {
		PageFactory.initElements(driver, this); 
		this.driver=driver;
		tablet = new Select(selectTablet);
		
	}
	
	public void getCourseTitle() {
		text = courseTitle.getText();
		System.out.println(text);
	}
	public void clickOnBuyNowButton() {
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		buyNow.click();
	}
	public void clikOnAddToCartButton() {
		addToCart.click();
	}
	public void selectTheTablet(String tabletName) {
		tablet.selectByVisibleText(tabletName);
	}
}
