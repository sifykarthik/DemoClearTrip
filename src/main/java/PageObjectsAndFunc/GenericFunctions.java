package PageObjectsAndFunc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class GenericFunctions {

	public static void initializeDriver(String url)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Driver\\chromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		
		ClearTripHmPage ct = new ClearTripHmPage(driver);
		
		ClearTripPage2 ct2 = new ClearTripPage2(driver);	
		
		
		ClearTripHmPage.openUrl(url);
		
		driver.manage().window().maximize();	
	}
	
}
