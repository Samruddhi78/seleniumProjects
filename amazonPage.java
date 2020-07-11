package selenium_project;

import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
public class amazonPage {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//locating the chromedriver
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe" );
		driver = new ChromeDriver();
		 Actions actions = new Actions(driver);
		//initiating webDriverwait
	    WebDriverWait wait = new WebDriverWait(driver, 40);
	    
	    //visiting the website
		driver.get("https://www.amazon.in/");
		
		//wait  till page loads completely
		waitForLoad(driver);
		
		driver.manage().window().maximize();
		//wait until button is clickable , clicking on sign in button
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList")));
		driver.findElement(By.id("nav-link-accountList")).click();

		//wait  till page loads completely
		waitForLoad(driver);

		driver.findElement(By.id("ap_email")).sendKeys("naiksamruddhi78@gmail.com");
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
		driver.findElement(By.id("continue")).click();

		//wait  till page loads completely
		waitForLoad(driver);

		
		driver.findElement(By.id("ap_password")).sendKeys("Sam@Amazon");
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
		driver.findElement(By.id("signInSubmit")).click();
		waitForLoad(driver);
		
		String at = driver.getTitle();
		String et = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		if(at.equalsIgnoreCase(et))
		{
			System.out.println("Signed in successfully");
			String [] items= {"headphones","laptop","pendrive","mrutyunjay","speakers with bluetooth"};
			for(int k=0; k<5; k++)
			{
				driver.findElement(By.id("twotabsearchtextbox")).clear();
				System.out.println("the item is"+ items[k]);
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys(items[k]);
				driver.findElement(By.xpath("//*[@id=\"nav-search\"]//form//div[2]//div//input")).click();
				waitForLoad(driver);
				List<WebElement> listw = driver.findElements(By.xpath(".//*[@class='a-size-medium a-color-base a-text-normal']"));//("a-size-medium a-color-base a-text-normal"));
				 System.out.println("\ncount of elements "+ listw.size());
				 int h=0;
				 for(WebElement el : listw) {
					    //   System.out.println(el.getText());
					 //el.getText().contains("Sony")
						 if(h==1)
						 {
							 
							  el.click();
							  
							 waitForLoad(driver);
							 
							// title = driver.getTitle();
							 //System.out.println("\nthe before  switched window is "+ title);
							 switchToWindow(2);
							
							 waitForLoad(driver);
							  //title = driver.getTitle();
							 //System.out.println("\nthe title of switched window is "+ title);

							 driver.findElement(By.xpath("//*[@id=\"add-to-wishlist-button-submit\"]")).click();
							 waitForLoad(driver);
							driver.close();
//							 try {
//								    WebDriverWait waitAlert = new WebDriverWait(driver, 10);
//								    wait.until(ExpectedConditions.alertIsPresent());
//								    Alert alert = driver.switchTo().alert();
//								    alert.accept();
//								    System.out.println("alert text"+alert.getText());
//								    alert.accept();
//								} catch (Exception e) {
//								    //exception handling
//								}
//							 if(driver.findElement(By.xpath("//*[@id=\"a-popover-8\"]//div")) != null) {
//								 driver.findElement(By.xpath("//*[@id=\"WLHUC_continue\"]//span//span"));
//							 }
							 break;
						 }
						 h++;
						
				 }
				// driver.close();
				switchToWindow(1);
			}
				
				//going to wishlist
				//hovering over account button
				actions.moveToElement(driver.findElement(By.id("nav-link-accountList"))).perform();
				Thread.sleep(1000);
						
			 
		
			
		} else
		{
			System.out.println("Signed in failed!!!!"+"\n actual test is:  "+at);		
		}
		
		
	    //driver.findElement(By.xpath("//html[1]//body[1]//div[1]//div[1]//div[1]//div[1]//div[3]//div[1]//div[1]//div[1]//div[1]//div[1]//div[3]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//div[1]//div[1]//a[1]//div[1]//div[2]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]")).click();
		
		

	}
	 public static void waitForLoad(WebDriver driver) {
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	                
	         WebDriverWait wait = new WebDriverWait(driver, 200);
	       		 wait.until(pageLoadCondition);
	       		 
	  }
	 public static void switchToWindow(int index) {
		 String windowId = null;
		 Set<String> WindowHandles =  driver.getWindowHandles();
		 Iterator<String> itr =   WindowHandles.iterator();
		 
		 for (int i=0; i<index; i++) {
			 windowId = itr.next();
		 }
		 driver.switchTo().window(windowId);
	 }
}
