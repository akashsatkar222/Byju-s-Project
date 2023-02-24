package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeClass_2 {

	@BeforeSuite
	public void beforeSuite2() {
		System.out.println("Before Suite 2");
	}
	@BeforeTest
	public void beforeTest2() {
		System.out.println("Before Test 2");
	}
	@BeforeClass
	public void beforeClass2() {
		System.out.println("Before Class 2");
	}
	@BeforeMethod
	public void beforeMethod2() {
		System.out.println("Before Method 2");
	}
	
	@Test  
	public void testA() {
		System.out.println("Test A");
	}
	@Test 
	public void testB() {
		System.out.println("Test B");
	}
	@Test 
	public void testC() {
		System.out.println("Test C");
	}
	@Test 
	public void testD() {
		System.out.println("Test D");
	}
	@AfterMethod
	public void afterMethod1() {
		System.out.println("After Method  2");
		
	}
	@AfterClass
	public void afterClass1() {
		System.out.println("After Class  2");
	}
	@AfterTest
	public void afterTest2() {
		System.out.println("After Test 2");
	}
	@AfterSuite
	public void afterSuite2() {
		System.out.println("After Suite 2");
	}

}
