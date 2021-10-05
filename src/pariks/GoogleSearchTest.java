package pariks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")


public class GoogleSearchTest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Apoorv Sinha\\Downloads\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		WebElement select = driver.findElement(By.xpath("//input[@type='text']"));
		select.sendKeys("mission im");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//unconditional wait
		//Thread.sleep(3000);
		BackendProcess();
		driver.close();
	}

	public static void BackendProcess() throws InterruptedException { // using descendant
		List<WebElement> results = driver.findElements(By.xpath("//ul[@class='G43f7e']/li/descendant::div[@class='eIPGRd']"));
		//explicit wait
		//WebDriverWait wait = new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.visibilityOf(tempArr[0]));
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='G43f7e']/li/descendant::div[@class='eIPGRd']"))));
		
		
		System.out.println("Size of the search result: " + results.size());
		for (WebElement result : results) {
			System.out.println(result.getText());
		}

	}

}
