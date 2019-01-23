package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Booking {
	
	WebDriver driver=new ChromeDriver();
	
	@BeforeTest
	public void Launch() throws Exception
	{	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://www.msccruises.co.uk/en-gb/Homepage.aspx");
		int size=driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Thread.sleep(5000);
	}
	
	@Test
	public void Make_Booking() throws Exception
	{
		
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("#departure-date-section .qs_select")).click();
		driver.findElement(By.xpath("//div[@id='departureMonthCalendar']/div/div[5]/table/tbody/tr/td/span[3]")).click();
		driver.findElement(By.id("search")).click();
		Thread.sleep(10000);
		
	    driver.switchTo().defaultContent();
	  
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");
	    Thread.sleep(5000);
	    driver.findElement(By.name("Select")).click();
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}

}
