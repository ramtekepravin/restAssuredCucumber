package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ScreenshotUtility {
	
private static String emptyString = "empty string";
	
	public static byte[] getScreeshot() {
		
		byte[] imagecontent = emptyString.getBytes();
		
		imagecontent = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.BYTES);
		
		return imagecontent;
		
	}

}
