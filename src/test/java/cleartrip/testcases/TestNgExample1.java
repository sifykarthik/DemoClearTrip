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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectsAndFunc.ClearTripHmPage;
import PageObjectsAndFunc.ClearTripPage2;
import PageObjectsAndFunc.GenericFunctions;

//testing+Hello
public class TestNgExample1 {

	@BeforeClass
	@Parameters({"url"})
	public void callDriver(String url)
	{
		GenericFunctions.initializeDriver(url);
	}
	
	@Test
	public void verifyElementExists()
	{
		//Assert.assertEquals(actual, expected);
		Assert.assertTrue(ClearTripHmPage.FromCity.isDisplayed());;
		Assert.assertTrue(ClearTripHmPage.ToCity.isDisplayed());
		Assert.assertTrue(ClearTripHmPage.FromDate.isDisplayed());
	}
	
	@Test
	public void verifyRoundTrip()
	{
		
		for(WebElement e : ClearTripHmPage.TripOptions)
		{
			if(e.getAttribute("value").equals("RoundTrip"))
			{
				e.click();
			}
			
		}
		
		Assert.assertTrue(ClearTripHmPage.FromDate.isDisplayed());
		Assert.assertTrue(ClearTripHmPage.ToDate.isDisplayed());
		
				
	}
	
	@Test
	public void verifyFlightSearch()
	{
// 		Selecting Round Trip Radio Button -- Check redundancy and check how to implement Wait		
		ClearTripHmPage.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(ClearTripHmPage.driver,20);
		for(WebElement e : ClearTripHmPage.TripOptions)
		{
			if(e.getAttribute("value").equals("RoundTrip"))
			{
				e.click();
			}
		}

//		Selecting FromCity
	    ClearTripHmPage.FromCity.click();
		ClearTripHmPage.FromCity.sendKeys("ATL");
		ClearTripHmPage.AutoCompleteSelectFcity.click();
		
//		Selecting ToCity
		ClearTripHmPage.ToCity.click();
		ClearTripHmPage.ToCity.sendKeys("ORD"); 
		ClearTripHmPage.AutoCompleteSelectTcity.click();

//		Selecting FromDate
		ClearTripHmPage.FromDate.click();	
		WebElement dateSelected = ClearTripHmPage.DatePicker.findElement(By.xpath("../following::td/a"));
		String dateSelected1 = dateSelected.getText();
		dateSelected.click();

//		Selecting ToDate
		ClearTripHmPage.ToDate.click();
		ClearTripHmPage.driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//tr//td/a[contains(text(),'"+dateSelected1+"')]")).findElement(By.xpath("../following::td/a")).click();
		
// 		Selecting No of Adults to 1
		Select adultsNo = new Select(ClearTripHmPage.NoOfAdults);
		adultsNo.selectByValue("1");
		
//		Select No of Children to 1
		Select childsNo= new Select(ClearTripHmPage.NoOfChilds);
		childsNo.selectByValue("2");

//		Select No of Infants to 1
		Select infantsNo = new Select(ClearTripHmPage.NoOfInfants);
		infantsNo.selectByValue("1");
		
//		Click Search
		
		System.out.println(ClearTripHmPage.FlightSearch.isDisplayed());
		System.out.println(ClearTripHmPage.FlightSearch.isEnabled());
		
		ClearTripHmPage.FlightSearch.click();
		System.out.println(ClearTripHmPage.FlightSearch.getText());
		
					
//		Waiting till the next Page (Page 2) is Loaded Properly
		wait.until(ExpectedConditions.visibilityOf(ClearTripPage2.Page2Book));

		System.out.println(ClearTripPage2.Page2Book.getText());
	}
	
	@AfterClass
	public void closeAllWindows()
	{
		ClearTripHmPage.driver.quit();
	}
}
