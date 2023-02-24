package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Facebook_POMclasses.CreateNewAccount;
import Facebook_POMclasses.LoginOrSignUpPage;

public class PracticeClass_1 {

	SoftAssert soft;
	@BeforeSuite
	public void beforeSuite1() {
		System.out.println("Before Suite 1");
	}
	@BeforeTest
	public void beforeTest1() {
		System.out.println("Before Test 1");
	}
	@BeforeClass
	public void beforeClass1() {
		System.out.println("Before Class 1");
	}
	@BeforeMethod
	public void beforeMethod1() {
		System.out.println("Before Method 1");
		soft = new SoftAssert();
	}
	
	@Test  
	public void test1(){
		System.out.println("Test 1");
		
		String actualurl = "https://www.facebook.com/" ;
		String expectedurl = "https://www.facebook.com/" ;
		//***Hard Assert***
		//1. To compare the data
		//2. Create the result
		//3. Apply the result on test method
		//If actual data us Equal to expected data then test case is passed
		//If actual data is not equal to expected data then test case is failed
//		Assert.assertEquals(actualurl, expectedurl, "Home page url is not found");
		boolean result = actualurl.equals(expectedurl);
//		Assert.assertTrue(result, "Home page url is not found");
//		Assert.assertFalse(result, "Home page url is not found");
		
		//***Soft assert***
//		soft = new SoftAssert();//object is created in before method
		soft.assertEquals(actualurl, expectedurl, "Home page url is not found");
		soft.assertNotEquals(actualurl, expectedurl, "Home page url is not found");
//		soft.assertAll();// this method is used compulsory at the last in soft assert
		soft.assertTrue(result,"Home page url is not found");
		soft.assertFalse(result,"Home page url is not found");
		soft.assertAll();
	}
	@Test 
	public void test2() {
		System.out.println("Test 2");
		String actualurl = "https://www.facebook.com/" ;
		String expectedurl = "https://www.facebook.com/" ;
		//1. To compare the data
		//2. Create the result
		//3. Apply the result on test method
		//If actual data us Equal to expected data then test case is passed
		//If actual data is not equal to expected data then test case is failed
//		Assert.assertNotEquals(actualurl, expectedurl, "Home page url is not found");
	    		
	}
	@Test 
	public void test3() {
		System.out.println("Test 3");
//		Assert.fail();
//		soft = new SoftAssert();
		soft.fail("forcefully fail this method");
//		soft.assertAll();
		System.out.println("Hiiiiii");
		soft.assertAll();
	}
	@Test 
	public void test4() {
//		soft = new SoftAssert();//but this pass 
		System.out.println("Test 4");
		soft.assertAll();//only this fail
	}
	@AfterMethod
	public void afterMethod1() {
		System.out.println("After Method  1");
//		soft.assertAll();//only first test will execute remaining skipped
		
	}
	@AfterClass
	public void afterClass1() {
		System.out.println("After Class  1");
	}
	@AfterTest
	public void afterTest1() {
		System.out.println("After Test 1");
	}
	@AfterSuite
	public void afterSuite1() {
		System.out.println("After Suite 1");
	}
}
