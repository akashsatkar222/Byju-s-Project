package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ByjusProductPage {
	
    @FindBy(xpath = "(//span[text()='IAS, GATE & CAT'])[1]") private WebElement iasGateCat;
    @FindBy(xpath = "(//span[text()='IAS'])[1]") private WebElement ias;
    
    private Actions act;
	public ByjusProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	
	public void clickOnIAS() {
		act.moveToElement(iasGateCat).click().moveToElement(ias).click().build().perform();
	}
	

}
