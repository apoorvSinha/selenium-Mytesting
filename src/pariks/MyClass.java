package pariks;

public class MyClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "");

	}

}


/*
 * 
passed :) :) :)

package Testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_Annotations {

  // Write your code here
  @Test
  public void GetpageTitle(){
    System.out.println("Test has been executed as no.5");
  }
  @BeforeMethod
  public void beforeMethod(){
    System.out.println("Before Method has been executed as no.4");
  }
  @AfterMethod
  public void afterMethod(){
    System.out.println("Test has been executed as no.6");
  }
  @BeforeClass
  public void beforeClass(){
    System.out.println("Before class has been executed as no.3");
  }
  @AfterClass
  public void afterClass(){
    System.out.println("After Class has been executed as no.7");
  }
  @BeforeTest
  public void beforeTest(){
    System.out.println("Before Test has been executed as no.2");
  }
  @AfterTest
  public void afterTest(){
    System.out.println("After Test has been executed as no.8");
  }
  @BeforeSuite
  public void beforeSuite(){
    System.out.println("Before suite has been executed as no.1");
  }
  @AfterSuite
  public void afterSuite(){
    System.out.println("After Suite has been executed as no.9");
  }
}package Testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_Annotations {

  // Write your code here
  @Test
  public void GetpageTitle(){
    System.out.println("Test has been executed as no.5");
  }
  @BeforeMethod
  public void beforeMethod(){
    System.out.println("Before Method has been executed as no.4");
  }
  @AfterMethod
  public void afterMethod(){
    System.out.println("Test has been executed as no.6");
  }
  @BeforeClass
  public void beforeClass(){
    System.out.println("Before class has been executed as no.3");
  }
  @AfterClass
  public void afterClass(){
    System.out.println("After Class has been executed as no.7");
  }
  @BeforeTest
  public void beforeTest(){
    System.out.println("Before Test has been executed as no.2");
  }
  @AfterTest
  public void afterTest(){
    System.out.println("After Test has been executed as no.8");
  }
  @BeforeSuite
  public void beforeSuite(){
    System.out.println("Before suite has been executed as no.1");
  }
  @AfterSuite
  public void afterSuite(){
    System.out.println("After Suite has been executed as no.9");
  }
}



second success :) :) :)
package launchBrowserTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class LaunchBrowser_TestNG {

 
	@Test
	  public void LaunchBrowser() throws InterruptedException{
		
		
		

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true); 
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/projects/challenge/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
		WebDriver driver = new PhantomJSDriver(caps);
		System.out.println("PhantomJS Headless Driver launched");
		
		// Write your script here
		
      driver.get("https://www.google.com");
      Thread.sleep(5000);
      System.out.println("Launch Browser is successful");
      System.out.println("Page Title : "+ driver.getTitle());
		  
	

		//Searching for "Fresco Play" in Google search
			
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Fresco Play");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		System.out.println("Page Title : " + driver.getTitle());
					
	}
}
pass :) :) :)
      
package crossBrowsers;


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class googleLaunch {

    public WebDriver driver;
    
    @BeforeTest
    
    @Parameters("browser")
    public void SelectBrowser(String browser)
    {
    
        // Write your script here  
        if(browser.equalsIgnoreCase("ChromeHeadless")){
          ChromeDriverManager.chromedriver().setup();
          ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.addArguments("--headless");
          driver = new ChromeDriver(chromeOptions);
          System.out.println("Chrome Headless Driver launched");
        }
        else if(browser.equalsIgnoreCase("PhantomJS")){
          DesiredCapabilities caps = new DesiredCapabilities();
          caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/projects/challenge/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
          driver = new PhantomJSDriver(caps);
          System.out.println("PhantomJs Headless Driver launched");
        }

        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }
    
    @Test
    public void GoogleSreach() throws InterruptedException{
        
        // Searching for "Fresco Play" in Google search.
        // Find the elementlocators for the below actions.
        // 1) Find locator for Google Search Box and sendkeys as Fresco Play as below.
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Fresco Play");
        
        // 2) Find locator for Google Search Box and sendkeys as Enter  as below.
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
        Thread.sleep(6000);
        System.out.println("Page Title : " + driver.getTitle());
                
        
    }
    
    @AfterTest
    public void BroswerQuit(){
        driver.quit();
    }    
    
}


Pass  :) :) :)

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import mx4j.log.Log;

public class LoginPage {

	
	WebDriver driver;
	
	// write your script here.
	
	By LoginTab = By.xpath("//a[contains(text(), 'Log')]");
  By username = By.xpath("//input[@name='wpName']");
  By password = By.xpath("//input[@name='wpPassword']");
	By login  = By.xpath("//button[@id='wpLoginAttempt']");
	
 
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickLoginTab(){
		
		driver.findElement(LoginTab).click();
	}
	
	public void typeUserName(){
		
		driver.findElement(username).sendKeys("apoorvs9");
	}
	
	public void typePassword(){
		
		driver.findElement(password).sendKeys("FJE7:qUg34mW4Gw");
	}
	
	public void clickLoginButton(){
	
		driver.findElement(login).click();
		
	}
	
}
package TestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import Pages.LoginPage;

public class verfiyLogIn {

	@Test
	public void verifyLogin() throws InterruptedException{
		

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true); 
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/projects/challenge/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
		WebDriver driver = new PhantomJSDriver(caps);
		System.out.println("PhantomJS Headless Driver launched");
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		Thread.sleep(8000);
		
		// Write your code here
		
    LoginPage lob = new LoginPage(driver);
    lob.clickLoginTab();
    lob.typeUserName();
    lob.typePassword();
    lob.clickLoginButton();
    
		
		System.out.println("Login is successful");
		driver.quit();
		System.out.println("Browser Quit is successful");
	}
}


package TestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Pages.PageFactoryLogin;
import utility.BrowserFactory;

public class verfiyLogin_PageFactory {

	WebDriver driver;
	
	@Test
	public void checkValidUser(){
		
		WebDriver driver = BrowserFactory.startBrowser("PhantomJS", "https://en.wikipedia.org/wiki/Main_Page");
		PageFactoryLogin login_page = PageFactory.initElements(driver, PageFactoryLogin.class);
		
		// Write your username and password in below line

		login_page.Login("apoorvs9","FJE7:qUg34mW4Gw");
		
	
		System.out.println("Page Title : " + driver.getTitle());
		driver.quit();
		System.out.println("Browser Quit is successful");
	}
	
	
}




package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageFactoryLogin {

	WebDriver driver;
	
	public PageFactoryLogin(WebDriver localdriver){
	this.driver=localdriver;
	}
	
	// Write your script here
	@FindBy(xpath = "//a[contains(text(), 'Log')]")WebElement loginTab;
  @FindBy(id="wpName1")WebElement username;
  @FindBy(how = How.ID, using = "wpPassword1")WebElement password;
  @FindBy(how = How.XPATH, using = "//button[@id='wpLoginAttempt']")WebElement logIn;

	
	
	public void Login(String uid, String pass){
		
		loginTab.click();
		username.sendKeys(uid);
		password.sendKeys(pass);
		logIn.click();
	}
	
}

package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url ){
		
		
		if (browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "/root/selenium/chromedriver");
			driver=new ChromeDriver();	
		}
		
		else if (browserName.equalsIgnoreCase("HtmlUnitDriver")){
			 driver = new HtmlUnitDriver(true);
		}
		
		else if (browserName.equalsIgnoreCase("PhantomJS"))
		{
			 DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setJavascriptEnabled(true); 
			 caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/projects/challenge/phantomjs-2.1.1-linux-x86_64/bin/phantomjs");
			 driver = new PhantomJSDriver(caps);
			System.out.println("PhantomJS Headless Driver launched");
		}
		
		// Write your script here
    driver.manage().window().maximize();
    driver.get(url);
    
		
		return driver;
	}
}



*/