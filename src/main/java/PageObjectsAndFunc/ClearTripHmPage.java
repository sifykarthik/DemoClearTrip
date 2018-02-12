package PageObjectsAndFunc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//d
public class ClearTripHmPage 
{
	public static WebDriver driver;
	
	public ClearTripHmPage(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[name='trip_type']")
	public static List<WebElement> TripOptions;
	
	@FindBy(id="FromTag")
	public static WebElement FromCity;
	
	//@FindBy(css="ul#ui-id-1 li:nth-child(1) > a")
	@FindBy(css="ul#ui-id-1 li>a")
	public static WebElement AutoCompleteSelectFcity;
	
	@FindBy(css="ul#ui-id-2 li>a")
	public static WebElement AutoCompleteSelectTcity;
	
	@FindBy(id="ToTag")
	public static WebElement ToCity;
	
	@FindBy(id="DepartDate")
	public static WebElement FromDate;
	
	@FindBy(xpath="//div[@id='ui-datepicker-div']//tr//td/a[contains(text(),'15')]")
	//@FindBy(xpath="//div[@id='ui-datepicker-div']//tr//td/a")
	public static WebElement DatePicker;
	
	@FindBy(id="ReturnDate")
	public static WebElement ToDate;
	
	@FindBy(id="Adults")
	public static WebElement NoOfAdults;
	
	@FindBy(id="Childrens")
	public static WebElement NoOfChilds;
	
	@FindBy(id="Infants")
	public static WebElement NoOfInfants;
	
	@FindBy(css="div.searchBtnContainer input#SearchBtn")
	public static WebElement FlightSearch;
	
	//@FindBy(css="div.loaderContainer div.progressTracker p[class^='loadState']") -- check with Siva***********
	//@FindBy(xpath="//div[@class='loaderContainer']//div[@class='progressTracker']//p[starts-with(@class,'loadState']")
	
	//@FindBy(xpath="//p[contains(text(),'ready')]")
	@FindBy(xpath="//div[@class='pageLoader']/p")
	//@FindBy(xpath="//div[@class='loaderContainer']//div[@class='progressTracker']//p[contains(text(),'Getting')]")
	
	public static WebElement ProgressBar;
	
	public static int getFromDateFunction() 
	{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		int fromDateSelect = localDate.getDayOfMonth();
		fromDateSelect = fromDateSelect+1;
		
		return fromDateSelect;
	}

	public static int getToDateFunction() 
	{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		int fromDateSelect = localDate.getDayOfMonth();
		int toDateSelect   = fromDateSelect+2;
		
		return toDateSelect;
	}
	
	public static void openUrl(String UrlLink)
	{
		String Url = UrlLink;
		driver.get(Url);
	}

	public static String getTitle()
	{
		return driver.getTitle();
 
	}
	
}

