package IRCTC_POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy (xpath = "(//i[@class='fa fa-align-justify'])[1]")
	private WebElement options;
	@FindBy (xpath = "//button[text()='LOGIN']")
	private WebElement login;
	@FindBy (xpath = "(//input[@role='searchbox'])[1]")
	private WebElement fromSearchBox;
	@FindBy (xpath = "(//input[@role='searchbox'])[2]")
	private WebElement toSearchBox;
	@FindBy (xpath = "(//input[@type='text'])[3]")
	private WebElement date;
	@FindBy (xpath = "((//table//tbody//tr)[4]//td)[4]")
	private WebElement date22nd;
	@FindBy (xpath = "//p-dropdown[@id='journeyClass']")
	private WebElement journyClass;
	@FindBy (xpath = "(//li[@role='option'])[3]")
	private WebElement acFirstClass;
	@FindBy (xpath = "//p-dropdown[@id='journeyQuota']")
	private WebElement journeyQuota;
	@FindBy (xpath = "(//li[@role='option'])[1]")
	private WebElement generalQuota;
	@FindBy (xpath = "//label[contains(text(),'Flexible')]")
	private WebElement flexibleWithDate;
	@FindBy (xpath = "//label[contains(text(),'Pers')]")
	private WebElement personWithDisabilityConcession;
	@FindBy (xpath = "//label[contains(text(),'Ber')]")
	private WebElement trainWithAvailableBerth;
	@FindBy (xpath = "//label[contains(text(),'Pass')]")
	private WebElement railwayPassConcession;
	@FindBy (xpath = "//button[contains(text(),'Search')]")
	private WebElement search;
	@FindBy (xpath = "(//div[@class='pre-avl'])[2]")
	private WebElement sleeper;
	@FindBy (xpath = "(//td[@class='link ng-star-inserted'])[1]")
	private WebElement firstOption;
	@FindBy (xpath = "//button[text()=' Book Now ']")
	private WebElement bookNow;
	
	@FindBy (xpath = "(//label[text()='FLIGHTS'])[2]")
	private WebElement flight;
	@FindBy (xpath = "(//label[text()='HOTELS'])[2]")
	private WebElement hotels;
	@FindBy (xpath = "(//label[text()='RAIL DRISHTI'])")
	private WebElement railDrishti;
	@FindBy (xpath = "(//label[text()='E-CATERING'])")
	private WebElement ecatering;
	@FindBy (xpath = "(//label[text()='BUS'])")
	private WebElement bus;
	@FindBy (xpath = "(//label[text()='HOLIDAY PACKAGES'])")
	private WebElement holidayPackages;
	@FindBy (xpath = "(//label[text()='TOURIST TRAIN'])")
	private WebElement touristTrain;
	@FindBy (xpath = "(//label[text()='HILL RAILWAYS'])")
	private WebElement hillRailways;
	@FindBy (xpath = "(//label[text()='CHARTER TRAIN'])")
	private WebElement charterTrain;
	@FindBy (xpath = "(//label[text()='GALLERY'])")
	private WebElement gallery;
	
	private Actions act; 
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		act=new Actions(driver);
	}
	
	public void searchTrain() {
		
	}
	public void clickOnLoginButton() {
		options.click();
		login.click();
	}
	public void enterCityFrom(String city) {
		fromSearchBox.sendKeys(city);
	}
	public void enterCityTo(String city) {
		toSearchBox.sendKeys(city);
	}
	public void selectdate() {
		date.click();
		date22nd.click();
	}
	public void selectJournyClass() {
		journyClass.click();
		acFirstClass.click();
	}
	public void selectJourneyQuota() {
		journeyQuota.click();
		generalQuota.click();
	}
	public void clickOnFlexibleWithDate() {
		flexibleWithDate.click();
	}
	public void clickOnPersonWithDisabilityConcession() {
		personWithDisabilityConcession.click();
	}
	public void clickOnTrainWithAvailableBerth() {
		trainWithAvailableBerth.click();
	}
	public void clickOnRailwayPassConcession() {
		railwayPassConcession.click();
	}
	public void clickOnSearchButton() {
		search.click();
	}
	public void clickOnFlightButton() {
		flight.click();
	}
}
