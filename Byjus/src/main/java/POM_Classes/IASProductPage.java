package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class IASProductPage {
	
	@FindBy (xpath = "//select[@name='FilterTags']")private WebElement filterBy;
	@FindBy (xpath = "//select[@id='SortBy']")private WebElement sortBy;
	@FindBy (xpath = "(//a[contains(@href,'/collections/ias')])[3]")private WebElement firstCourse;
	@FindBy (xpath = "(//div[contains(@class,'h4 grid-view')])[1]")private WebElement courseTitle;
	
	private Select s;
	public static String result1;
	public IASProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void applyFilterOnIASCourse(String filter, String sort) {
		s = new Select(filterBy);
		s.selectByVisibleText(filter);
		s = new Select(sortBy);
		s.selectByVisibleText(sort);
	}
	public void getFirstCourseTitle() {
		result1 = courseTitle.getText();
		System.out.println(result1);
	}
	public void clickOnFirstCourse() {
		firstCourse.click();
	}
	
    
}
