package Byjus_POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class IAS_ProductPage_POM_Class {

	@FindBy(xpath="//select[@name='FilterTags']")private WebElement filterBy;
	@FindBy(xpath="//select[@id='SortBy']")private WebElement sortBy;
	@FindBy(xpath="(//a[contains(@href,'/collections/ias')])[3]")private WebElement firstCourse;
	@FindBy(xpath="(//a[contains(@href,'/collections/ias')])[4]")private WebElement secondCourse;
	@FindBy(xpath="(//div[@aria-hidden='true'])[1]")private WebElement firstCourseTitle;
	@FindBy(xpath="(//div[@aria-hidden='true'])[2]")private WebElement secondCourseTitle;
	
	private Select filter, sort;
	public String text;
	public IAS_ProductPage_POM_Class(WebDriver driver) {
		PageFactory.initElements(driver, this);
		filter = new Select(filterBy);
		sort = new Select(sortBy);
	}
	
	public void setFilterByAndSortBy(String selectFilter, String selectSort) {
		filter.selectByVisibleText(selectFilter);
		sort.selectByVisibleText(selectSort);
	}
	public void clickOnFirstCourse() {
		firstCourse.click();
	}
	public void clickOnSecondCourse() {
		secondCourse.click();
	}
	public void getFirstCourseTitle() {
		text=firstCourseTitle.getText();
		System.out.println(text);
	}
	public void getSecondCourseTitle() {
		text=secondCourseTitle.getText();
		System.out.println(text);
	}
}
