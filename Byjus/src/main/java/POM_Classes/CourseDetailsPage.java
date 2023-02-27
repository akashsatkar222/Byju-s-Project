package POM_Classes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseDetailsPage {
	
	@FindBy (xpath = "//h1[@class='product-single__title']") private WebElement courseTitle; 
	@FindBy (xpath = "//button[text()='Buy it now']") private WebElement buyNow; 
	@FindBy (xpath = "//button[@id='add-to-cart']") private WebElement addToCart; 
	@FindBy (xpath = "//select[@data-index='option1']") private WebElement tablet;
	
	private WebDriver driver;
	public static String result2;
	public CourseDetailsPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickOnBuyNowButton() {
		buyNow.click();
	}
	public void clickOnAddToCartButton() {
		addToCart.click();
	}
	public void getCourseTitle() {
		result2 = courseTitle.getText();
		System.out.println(result2);
	}
	public void selectTablet(String tabletName) {
		Select s = new Select(tablet);
		s.selectByVisibleText(tabletName);
	}
    
}
