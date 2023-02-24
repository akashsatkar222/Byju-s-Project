package Flipkart_POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage {

	// Variable : WebElement : Flipkart Home Page
// 	@FindBy (xpath="//button[@class='_2KpZ6l _2doB4z']")
// 	WebElement exit;
	
	
	@FindBy (xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement exit;
	
	@FindBy (xpath = "//input[contains(@title,'Search for products')]")
	private WebElement searchForProduct ;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement search ;
	
	@FindBy (xpath = "//a[text()='Login']")
	private WebElement login ;
	
	@FindBy (xpath = "(//span[text()='Become a Seller'])[1]")
	private WebElement becomeASeller ;
	
	@FindBy (xpath = "(//div[text()='More'])[1]")
	private WebElement more ;
	
	@FindBy (xpath = "//span[text()='Cart']")
	private WebElement cart ;
	
	@FindBy (xpath = "//div[text()='Grocery']")
	private WebElement grocery ;
	
	@FindBy (xpath = "//div[text()='Mobiles']")
	private WebElement mobiles ;
	
	@FindBy (xpath = "//div[text()='Fashion']")
	private WebElement fashion ;
	
	@FindBy (xpath = "//div[text()='Electronics']")
	private WebElement electronics ;
	
	@FindBy (xpath = "(//a[@class='_6WOcW9'])[5]")
	private WebElement laptopAccessories ;
	
	@FindBy (xpath = "(//a[@class='_6WOcW9 _3YpNQe'])[3]")
	private WebElement mouse ;
	
	@FindBy (xpath = "//div[text()='Home']")
	private WebElement home ;
	
	@FindBy (xpath = "//div[text()='Appliances']")
	private WebElement appliances ;
	
	@FindBy (xpath = "//div[text()='Travel']")
	private WebElement travel ;
	
	@FindBy (xpath = "//div[text()='Top Offers']")
	private WebElement topOffers ;
	
	@FindBy (xpath = "//div[text()='Beauty, Toys & More']")
	private WebElement beautyToysMore ;
	
	@FindBy (xpath = "//div[text()='Two Wheelers']")
	private WebElement twoWheelers ;
	
	// Constructor : Initialization of WebElement : Flipkart Home Page
	Actions act;
	public FlipkartHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		
	}
	
	//Method : Action on WebElement : Flipkart Home Page
	
	public void clickOnExit() {
		exit.click();
	}
	
	public void searchForProductsBrandAndMore(String a) {
		searchForProduct.sendKeys(a);
	}
	
	public void clickOnSearchBox() {
		search.click();
	}
	
	public void clickOnLoginButton() {
		login.click();
	}
	
	public void clickOnBecomeASeller() {
		becomeASeller.click();
	}
	
	public void clickOnMore() {
		more.click();
	}
	
	public void clickOnCart() {
		cart.click();
	}
	
	public void clickOnGrocery() {
		grocery.click();
	}
	
	public void clickOnMobiles() {
		mobiles.click();
	}
	
	public void clickOnMouse() {
		act.moveToElement(electronics).moveToElement(laptopAccessories)
		.moveToElement(mouse).click().build().perform();
	}
	
	public void clickOnAppliances() {
		appliances.click();
	}
	
	public void clickOnTravel() {
		travel.click();
	}
	
	public void clickOnTopOffers() {
		topOffers.click();
	}
	
	public void clickOnBeautyToysMore() {
		beautyToysMore.click();
	}
	
	public void clickOnTwoWheelers() {
		twoWheelers.click();
	}
}
