package pariks;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WebSiteTest {
		
	static WebDriver driver;
	static Actions action;
	static JavascriptExecutor js;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Apoorv Sinha\\Downloads\\chromedriver\\chromedriver.exe");
		driver= new ChromeDriver();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--ignore-certificate-errors");
		
		//Locating test
		locatingWesite("amazon");
		
		//searching and window test
		SearchingProduct("3080 Laptop");
		
		//assigning name to parent window
		String parenWin = driver.getWindowHandle();	
		//getting control on child tab
		Set<String> tabs =driver.getWindowHandles();
		for(String window: tabs) {
			if(!window.equalsIgnoreCase(parenWin)) {
				driver.switchTo().window(window);
			}
		}
		//adding to cart
		driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();
		
		//switching back to parent window
		driver.switchTo().window(parenWin);
		
		//searching other product
		SimonGoBackNSearchFor("Recliner");
		
		
	}
	
	public static void locatingWesite(String Website) throws InterruptedException {
		
		driver.get("https://www.google.co.in/");
		String label = driver.getTitle();
		System.out.println("Title of page is: "+ label);
		
		driver.findElement(By.name("q")).sendKeys(Website);
		Thread.sleep(2000);
		List<WebElement> results =  driver.findElements(By.xpath("//ul[@class='G43f7e']/li/descendant::div[@class='eIPGRd']"));
		for(WebElement result: results) {
			if(result.getText().equalsIgnoreCase("amazon india")) {
				result.click();
				break;
			}
		}
		driver.findElement(By.xpath("//h3[contains(text(),'Online Shopping')]")).click();
		
	}
	
	public static void SearchingProduct(String product) {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(product);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		js= (JavascriptExecutor)driver;
			
		WebElement laptop =driver.findElement(By.xpath("//*[contains(text(), 'ASUS ROG Strix Scar 15')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", laptop);
		laptop.click();
		System.out.println("Found the Product :)");
		
		
	}
	
	public static void SimonGoBackNSearchFor(String product) {
		WebElement laptop =driver.findElement(By.xpath("//*[contains(text(), 'ASUS ROG Strix Scar 15')]"));
		laptop.sendKeys(Keys.PAGE_UP);
		WebElement desire = driver.findElement(By.xpath("input[@id='twotabsearchtextbox']"));
		desire.clear();
		desire.sendKeys(product);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		
	}
}
