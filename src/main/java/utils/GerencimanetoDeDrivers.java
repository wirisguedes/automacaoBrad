package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class GerencimanetoDeDrivers {
	
	
	static WebDriver driver;
	
	public static WebDriver abrirBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			
			chromeOptions.addArguments("--headless=new"); 
			
			//chromeOptions.addArguments("-force-device-scale-factor=1.0");
			
			driver = new ChromeDriver(chromeOptions);	
		}else if(browser.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().window().maximize();
		return driver;
	}

}
