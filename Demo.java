//package selenium_project;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.JavascriptExecutor;
//
//public class Demo {
//	  public void waitForLoad(WebDriver driver) {
//	        ExpectedCondition<Boolean> pageLoadCondition = new
//	                ExpectedCondition<Boolean>() {
//	                    public Boolean apply(WebDriver driver) {
//	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
//	                    }
//	                };
//	                
//	         WebDriverWait wait = new WebDriverWait(driver, 30);
//	       		 wait.until(pageLoadCondition);
//	  }
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Demo d = new Demo();
//		
//		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32 (1)\\chromedriver.exe" );
//		
//		
//		WebDriver driver = new ChromeDriver();
//		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); // just after you have initiated browser
//		//browser.implicitly_wait(3)
//	    WebDriverWait wait = new WebDriverWait(driver, 50);
//		driver.get("https://www.facebook.com/");
//		d.waitForLoad(driver);
//		driver.manage().window().maximize();
//		driver.findElement(By.id("email")).sendKeys("9763309257");
//		driver.findElement(By.id("pass")).sendKeys("Sam@1571998");
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("u_0_b")));
//		driver.findElement(By.id("u_0_b")).click();
//		d.waitForLoad(driver);
//		String at = driver.getTitle();
//		String et = "Facebook";
//		//wait.until(ExpectedConditions.elementToBeClickable(By.id("u_0_b")));
//		driver.findElement(By.xpath("//html[1]//body[1]//div[1]//div[1]//div[1]//div[1]//div[3]//div[1]//div[1]//div[1]//div[1]//div[1]//div[3]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//div[1]//div[1]//a[1]//div[1]//div[2]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]")).click();
//		driver.close();
//		if(at.contains(et))
//		{
//			System.out.println("Test Successfull!!!");
//		}
//		else
//		{
//			System.out.println("Test failed!!!!"+"\n actual test is "+at);
//
//		}
//	}
//
//}
