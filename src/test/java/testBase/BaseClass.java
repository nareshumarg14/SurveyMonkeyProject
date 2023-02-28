package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//1
	public WebDriver driver;
	public Properties prop;
	
	public Logger logger = LogManager.getLogger(this.getClass());
		
	@BeforeMethod
	@Parameters("browser")
	public void setup(String bname) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Training\\Selenium\\SeleniumTraining_2023\\SurveyMonkey\\resources\\config.properties");
		prop.load(fis);
		String appurl = prop.getProperty("url");
		
		if (bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome browser is launched");
		} else if(bname.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge browser is launched");
		}
				
		driver.manage().window().maximize();
		driver.get(appurl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//System.out.println("Survey Monkey application is opened");
		logger.info("Survey Monkey application is opened");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		//System.out.println("Survey Monkey application is closed");
		logger.info("Survey Monkey application is closed");
	}
}
