package com.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.pages.patInfoPage;
import com.qa.util.ReadConfig;


//import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();	
	public static Properties prop;
	public static ReadConfig readconfig = new ReadConfig();

	private static String TargetSurefire = System.getProperty("user.dir") + "/target/surefire-reports/";

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com" + "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//changes 1
	@SuppressWarnings({ "deprecation", "static-access" })
	@BeforeMethod
	public void initialization() throws InterruptedException  {
			String browserName = prop.getProperty("Browser");
			ChromeOptions options = new ChromeOptions();
			if (browserName.equalsIgnoreCase("chrome")) {
			//	System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
				System.setProperty("webdriver.chrome.silentOutput", "true");
			//	WebDriverManager.chromedriver().setup();
//				ChromeOptions options = new ChromeOptions();
				driver.set(new ChromeDriver(options));	
			//	driver.set(new ChromeDriver());			
				Dimension dimension = new Dimension(450,600);
				getDriver().manage().window().setSize(dimension);			
				options.setCapability("timeouts", "{implicit: 30000, pageLoad: 300000, script: 90000}");
				System.out.println("TIMEOUTS FOR CHROME ARE :" + options.getCapability("timeouts"));
				DesiredCapabilities chrome = new DesiredCapabilities();
				chrome.setCapability("timeouts", "{implicit: 30000, pageLoad: 300000, script: 90000}");
				chrome.merge(options);
				System.out.println("Desired Capabilities are: "+ chrome.getCapability("timeouts"));
			
			} else {
				Assert.assertTrue(false, "No Browser type sent or Browser not Mention in this Method");
			}
			
			System.out.println("Browser setup by Thread "+Thread.currentThread().getId()+" and Driver reference is : "+ getDriver());
			getDriver().manage().window().maximize();
			getDriver().manage().deleteAllCookies();		
			getDriver().get(readconfig.getApplicationURL("Dev"));
			patInfoPage patPage=new patInfoPage(getDriver());
			patPage.endtoendcases(readconfig.getKeyword());
	}
	
	public static WebDriver getDriver() 
	{
		return driver.get();
	}
	
	
	@AfterMethod
	
	public void tearDown() {
		getDriver().quit();
	}
	
}
