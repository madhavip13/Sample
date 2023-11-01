package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();   //for locators
	public static FileReader fr;
	public static FileReader fr1;

  @BeforeMethod
	public void setUp() throws IOException {

		if(driver==null) {
			
			 fr= new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\config.properties");
			 fr1= new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) 
		{
          WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		   driver.get(prop.getProperty("testurl"));
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		    driver.get(prop.getProperty("testurl"));
        }
  }
  @AfterMethod
	public void teardown() {

		driver.close();
	}

}
