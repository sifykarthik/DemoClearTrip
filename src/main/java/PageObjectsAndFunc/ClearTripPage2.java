package PageObjectsAndFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClearTripPage2 
{
	public static WebDriver driver;
	
	public ClearTripPage2(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css="ul > li tbody tr td > button")
	public static WebElement Page2Book;
}
