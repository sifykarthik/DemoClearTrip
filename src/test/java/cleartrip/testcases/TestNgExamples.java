package cleartrip.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectsAndFunc.ClearTripHmPage;
import PageObjectsAndFunc.ClearTripPage2;
import PageObjectsAndFunc.GenericFunctions;


public class TestNgExamples 
{
	// 1. Main method not needed

	@BeforeClass
	@Parameters({"url"})
	public void initializeDriver(String url)
	{
		GenericFunctions.initializeDriver(url);
	}
	
	@Test
	@Parameters({"expectedTitle"})
	public void verifyPageTitle(String expectedTitle)
	{
		//String expectedTitle = "Cleartrip - Flights, Hotels, Local, Trains, Packages";
		String actualTitle = ClearTripHmPage.getTitle();
		
		System.out.println("expectedTitle: "+expectedTitle);
		System.out.println("actualTitle: "+actualTitle);
		
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	

	@AfterClass
	public void closeAllWindows()
	{
		ClearTripHmPage.driver.quit();
	}
}	