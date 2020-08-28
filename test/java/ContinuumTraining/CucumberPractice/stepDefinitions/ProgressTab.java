package ContinuumTraining.CucumberPractice.stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProgressTab {
	WebDriver driver = null;
	Actions actions = null;
	WebDriverWait wait = null;
	long	stratTime, endTime;
	

@Given("^I login to the application P$")
public void i_login_to_the_application_l() {
	System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	wait = new WebDriverWait(driver, 70);
	driver.get("https://www.seleniumeasy.com/test/");
	driver.manage().window().maximize();
	try {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("at-cv-lightbox-close")));
		driver.findElement(By.id("at-cv-lightbox-close")).click();
	} catch (Exception e) {
		System.out.println("***NO pop up is shown***");
	}
}
	
@Given("^I click on the Progress tab$")
public void i_click_on_the_progress_tab() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[1]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[1]/a")).click();

}

@Given("^I click on JQuery Download Progress bars option$")
public void i_click_on_j_query_download_progress_bars_option() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[1]/ul/li[1]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[1]/ul/li[1]/a")).click();

}

@Given("^I click on start download button$")
public void i_click_on_start_download_button() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='downloadButton']")));
	driver.findElement(By.xpath("//*[@id='downloadButton']")).click();
	stratTime=System.currentTimeMillis();

}

@Then("^I check if current progress is shown$")
public void i_check_if_current_progress_is_shown() {
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]")));
System.out.println(driver.findElement(By.xpath("//*[@id='dialog']/div[1]")));
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dialog']/div[contains(text(),'Complete!')]")));
System.out.println("success, curret progress");  
}


@Then("^I click on cancel download button$")
public void i_click_on_cancel_download_button() {
	wait.until(ExpectedConditions
			.presenceOfElementLocated(By.xpath("//*[contains(text(),'Cancel Download')] ")));
	driver.findElement(By.xpath("//*[contains(text(),'Cancel Download')]")).click();
}

@Then("^I verify if download complete is shown and how much time it took to download$")
public void i_verify_if_download_complete_is_shown_and_how_much_time_it_took_to_download() {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dialog']/div[contains(text(),'Complete!')]")));
	endTime=System.currentTimeMillis();
	System.out.println("success, download complete  "+(endTime-stratTime));  

}

@Then("^I click on close download button$")
public void i_click_close() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/button")));
	driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button")).click();
	
}
@Then("^I verify if download widndow is closed$")
public void i_verify_if_download_widndow_is_closed() {
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[3]")));
	System.out.println("success, download window closed");  
	driver.close();

}

@Given("^I click on Bootstrap Download Progress bars option$")
public void i_click_on_bootstrap_download_progress_bars_option() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[1]/ul/li[2]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[1]/ul/li[2]/a")).click();

	
}

@Given("^I click on download button$")
public void i_click_on_download_button() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='cricle-btn']")));
	driver.findElement(By.xpath("//*[@id='cricle-btn']")).click();
	stratTime=System.currentTimeMillis();

}

@Then("^I check if progress percentage is shown$")
public void i_check_if_progress_percentage_is_shown() {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id='circle']/div/div[1]")));
	System.out.println(driver.findElement(By.xpath("//*[@id='circle']/div/div[1]")).getText());

	
}

@Then("^I verify if Hundred percent is shown and how much time it took to download$")
public void i_verify_if_hundred_percent_is_shown_and_how_much_time_it_took_to_download() {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='circle']/div/div[contains(text(),'100%')]")));
	endTime=System.currentTimeMillis();
	System.out.println("success, download complete  "+(endTime-stratTime)); 
driver.close();
	
}
}
