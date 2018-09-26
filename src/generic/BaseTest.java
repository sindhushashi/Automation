package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class BaseTest implements IAutoConst {
	
	public WebDriver driver;
	public String url = Utility.getPropertyValue(CONFIG_PATH, "URL");
	String ITO = Utility.getPropertyValue(CONFIG_PATH, "ITO");
	public long duration=Long.parseLong(ITO);
	static
	{
		System.setProperty(Chrome_Key,Chrome_Value);
		System.setProperty(Gecko_Key, Gecko_value);
	}
	
	@BeforeMethod
	public void openApplication()
	{
		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);
		driver.get(url);
		
	}
	
	@AfterMethod
	public void closeApplication()
	{
		
		driver.close();
	}

}
