package Byjus_POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage_POM_Class {
	
	@FindBy (xpath="(//span[text()='IAS, GATE & CAT'])[1]") private WebElement iasGateAndCat;
	@FindBy (xpath="(//span[text()='IAS'])[1]") private WebElement ias;
	
	public ProductPage_POM_Class(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnIASButton() {
		iasGateAndCat.click();
		ias.click();
	}
}
