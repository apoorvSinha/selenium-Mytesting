package pariks;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;


public class RemoteWebDriverTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		String strHub="http://192.168.43.140:4444/wd/hub";
		WebDriver driver= new RemoteWebDriver(new URL(strHub), options);
		
		driver.get("https://www.google.com/");
			System.out.println("Before search: "+driver.getTitle());
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Java tutorial");
		driver.findElement(By.name("q")).submit();
		System.out.println("After search: "+driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), "Java tutorial - Google Search");

	}

}

//java -jar selenium-server-standalone-3.141.59.jar -role hub

//java –Dwebdriver.chrome.driver="chromedriver.exe" –jar selenium-server-standalone-3.141.59.jar –role node –hub http://192.168.43.140:4444/grid/register/