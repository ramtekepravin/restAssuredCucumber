package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;




import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	public WebDriver driver;

	
	public static ThreadLocal<WebDriver> webDriver= new ThreadLocal<WebDriver>();
		

		
	public static synchronized void setWebDriver(WebDriver driver) {
		
			webDriver.set(driver);
		}
		
	public static void initiateBrowser(String BrowserName) {
		//String file=System.getProperty("user.dir")
		if(BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			opt.addArguments("--no-sandbox");
//			opt.addArguments("--headless");
			opt.addArguments("window-size=1400,800");
			webDriver.set(new ChromeDriver(opt));
			getWebDriver().manage().window().maximize();
		}
		
		else if(BrowserName.equalsIgnoreCase("mozilla")||BrowserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--headless");
			options.addArguments("window-size=1400,800");
			webDriver.set(new FirefoxDriver(options));
			getWebDriver().manage().window().maximize();
			
		}
		else if(BrowserName.equalsIgnoreCase("edge")||BrowserName.equalsIgnoreCase("edgedriver")) {
			
			WebDriverManager.edgedriver().setup();
			EdgeOptions opt = new EdgeOptions();
			opt.addArguments("--disable-notifications");
			opt.addArguments("--headless");
			opt.addArguments("window-size=1400,800");
			webDriver.set(new EdgeDriver(opt));
			getWebDriver().manage().window().maximize();
		}

		else {
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
			opt.addArguments("--headless");
			opt.addArguments("window-size=1400,800");
			webDriver.set(new ChromeDriver(opt));
			getWebDriver().manage().window().maximize();
		}

			
		
		}
		
	public synchronized static WebDriver getWebDriver() {
			
			return webDriver.get();
		
		}

	public static synchronized void closeDriver() {
		
			DriverManager.getWebDriver().close();
		
	}
		
		



}
