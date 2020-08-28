package ContinuumTraining.CucumberPractice.stepDefinitions;

import java.nio.channels.NonWritableChannelException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AlertsModalsStep {
	WebDriver driver = null;
	Actions actions = null;
	WebDriverWait wait = null;
long	stratTime, endTime;
	
@Given("^login to the applicationA$")
public void login_to_the_application_a() {
	System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	wait = new WebDriverWait(driver, 20);
	driver.get("http://www.seleniumeasy.com/test/");
	driver.manage().window().maximize();
	try {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("at-cv-lightbox-close")));
		driver.findElement(By.id("at-cv-lightbox-close")).click();
	} catch (Exception e) {
		System.out.println("***NO pop up is shown***");
	}

}

@Given("^I click on Alert&Modals tab$")
public void i_click_on_alert_modals_tab() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/a")).click();
 
}

@Given("^I click on Bootstrap Alerts option$")
public void i_click_on_bootstrap_alerts_option() {
	wait.until(ExpectedConditions
			.presenceOfElementLocated(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/ul/li[1]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/ul/li[1]/a")).click();

}

@Given("^I click on Autoclosable success alert$")
public void i_click_on_autoclosable_success_alert() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='autoclosable-btn-success']")));
	driver.findElement(By.xpath("//*[@id='autoclosable-btn-success']")).click();
	stratTime=System.currentTimeMillis();
	
}

@Given("^I check if the alert box is visible$")
public void i_check_if_the_alert_box_is_visible() {
	try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='col-md-6']/div[1]")));
		String text= driver.findElement(By.xpath("//*[@class='col-md-6']/div[1]")).getText();
	  System.out.println("the text inside alert box is  "+text);
	}catch(Exception e) {
		e.getMessage();
	}
	
}

@Then("^I verify if the box closes after (.*) sec$")
public void i_verify_if_the_box_closes_after_sec(Integer int1) {
	try {
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='col-md-6']/div[1]")));
	endTime = System.currentTimeMillis();
	System.out.println("the time for which it was open is  "+(endTime-stratTime));
	}catch(Exception e) {
		e.getMessage();
		System.out.println("autoclosable didnt close");
	}
	driver.close();
  
}

@Given("^I click on normal success alert$")
public void i_click_on_normal_success_alert() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='normal-btn-success']")));
	driver.findElement(By.xpath("//*[@id='normal-btn-success']")).click();
	stratTime=System.currentTimeMillis();

}

@Given("^I check if the normal alert box is visible$")
public void i_check_if_the_normal_alert_box_is_visible() {
	try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='col-md-6']/div[2]")));
		String text= driver.findElement(By.xpath("//*[@class='col-md-6']/div[2]")).getText();
	  System.out.println("the text inside alert box is  "+text);
	}catch(Exception e) {
		e.getMessage();
	}
   
}

@Then("^I verify if the box doesnt close after (.*) sec$")
public void i_verify_if_the_box_doesnt_close_after_sec(Integer int1) {
	wait = new WebDriverWait(driver, 10);
	try {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='col-md-6']/div[2]")));
		endTime = System.currentTimeMillis();
		System.out.println("the time for which it was open is  "+(endTime-stratTime));
		}catch(Exception e) {
			e.getMessage();
			System.out.println("noraml alert box didnt close");
		}
	
  
}

@Then("^I click on close button$")
public void i_click_on_close_button() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@class='col-md-6']/div[2]/button")));
	driver.findElement(By.xpath("//*[@class='col-md-6']/div[2]/button")).click();
	
}

@Then("^I verify if normal alert box is close$")
public void i_verify_if_normal_alert_box_is_close() {
	try {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='col-md-6']/div[2]")));
		endTime = System.currentTimeMillis();
		System.out.println("the alert box is closed now ");
		}catch(Exception e) {
			e.getMessage();
			System.out.println("noraml alert box didnt close after clicking close button");
		}
	
 driver.close();
}


@Given("^I click on Bootstrap Modals option$")
public void i_click_on_bootstrap_modals_option() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/ul/li[2]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/ul/li[2]/a")).click();
 
}

@Given("^I click on Multiple Launch Modal button$")
public void i_click_on_multiple_launch_modal_button() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a")));
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a")).click();
 
}

@Then("^I verify is modal is open$")
public void i_verify_is_modal_is_open() {
	try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='myModal']")));
		String text= driver.findElement(By.xpath("//*[@id='myModal']")).getText();
	  System.out.println("the text inside alert box is  "+text);
	}catch(Exception e) {
		e.getMessage();
	}
	
    
}

@Then("^I click on Launch Modal button on Modal$")
public void i_click_on_launch_modal_button_on_modal() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='myModal']/div/div/div[3]/a")));
	driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/a")).click();
 
}

@Then("^I verify if second modal is open$")
public void i_verify_if_second_modal_is_open() {
	try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='myModal2']")));
		String text= driver.findElement(By.xpath("//*[@id='myModal2']")).getText();
	  System.out.println("the text inside alert box 2 is  "+text);
	}catch(Exception e) {
		e.getMessage();
	}
    
}

@Then("^I click on close button of current modal$")
public void i_click_on_close_button_of_current_modal() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id=\"myModal2\"]/div/div/div[6]/a[1]")));
	driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[6]/a[1]")).click();
 
}

@Then("^I verify if second modal is close and first modal is visible$")
public void i_verify_if_second_modal_is_close_and_first_modal_is_visible() {
	try {
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='myModal2']")));
	System.out.println("the second modal is close now ");
	}catch(Exception e) {
		e.getMessage();
		System.out.println("second modal didnt close");
	}
}

@Then("^I click on close button of fist modal$")
public void i_click_on_close_button_of_fist_modal() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id=\"myModal\"]/div/div/div[4]/a[1]")));
	driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[4]/a[1]")).click();
 
}

@Then("^I verify if first modal is closed$")
public void i_verify_if_first_modal_is_closed() {
	try {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='myModal']")));
		System.out.println("the first modal is close now ");
		}catch(Exception e) {
			e.getMessage();
			System.out.println("first modal didnt close");
		}
	driver.close();
}

@Given("^I click on window popup modal option$")
public void i_click_on_window_popup_modal_option() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/ul/li[3]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[2]/ul/li[3]/a")).click();
   
}

@Given("^I click on follow on twitter button$")
public void i_click_on_follow_on_twitter_button() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/a")));
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/a")).click();
  
}

@Then("^I verify if new window is open for twitter login$")
public void i_verify_if_new_window_is_open_for_twitter() {
	try {
		switchToWindow(2);
	}catch(NoSuchWindowException e) {
		e.getMessage();
	}
	String Title = driver.getTitle();
	System.out.println("new window of twitter is open "+Title);
    
}

@Then("^I click on close button to close the window$")
public void i_click_on_close_button_to_close_the_window() {
	System.out.println("closing twitter");
	driver.close();
	
    
}

@Then("^I verify if the new window is close$")
public void i_verify_if_the_new_window_is_close() {
	try {
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		switchToWindow(2);
	}catch(Exception e) {
		e.getMessage();
		System.out.println("the index is greater than available NO. of windows, so window is closed");
	}
	switchToWindow(1);
 driver.close();   
}

public  void switchToWindow(int index)throws NoSuchWindowException {
	 String windowId = null;
	 Set<String> WindowHandles =  driver.getWindowHandles();
	 Iterator<String> itr =   WindowHandles.iterator();
	 if(WindowHandles.size()<index) {
		throw new NoSuchWindowException("the index is greater than available NO. of windows");
	 }
	 for (int i=0; i<index; i++) {
		 windowId = itr.next();
	 }
	 driver.switchTo().window(windowId);
	}
}

