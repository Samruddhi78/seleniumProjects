package ContinuumTraining.CucumberPractice.stepDefinitions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatePickerStep {
	WebDriver driver = null;
	Actions actions = null;
	WebDriverWait wait = null;
	
@Given("^I login to the applicationD$")
public void i_login_to_the_application_d() {
	System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	wait = new WebDriverWait(driver, 60);
	driver.get("https://www.seleniumeasy.com/test/");
	driver.manage().window().maximize();
	try {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("at-cv-lightbox-close")));
		driver.findElement(By.id("at-cv-lightbox-close")).click();
	} catch (Exception e) {
		System.out.println("***NO pop up is shown***");
	}

}

@Given("^I click on the Date pickers tab$")
public void i_click_on_the_date_pickers_tab() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[2]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[2]/a")).click();

}

@Given("^I click on Bootstrap Date Picker option$")
public void i_click_on_bootstrap_date_picker_option() {
    wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[2]/ul/li[1]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[2]/ul/li[1]/a")).click();

}

@Given("^I click on select date button$")
public void i_click_on_select_date_button() throws InterruptedException {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='sandbox-container1']/div/span/i")));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"sandbox-container1\"]/div/span/i")).click();
	wait.until(ExpectedConditions
			.presenceOfElementLocated(By.xpath("//div[contains(@class,'datepicker datepicker-dropdown')]")));

}

@Given("^I click on Today butoon$")
public void i_click_on_today_butoon() {
	
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/table/tfoot/tr[1]/th")));
	driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tfoot/tr[1]/th")).click();

}

@Then("^I verify if today's date is selected in select box$")
public void i_verify_if_today_s_date_is_selected_in_select_box() {
	   LocalDate currentDate = LocalDate.now(); 
	   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id='sandbox-container1']/div/input")));
	String date =driver.findElement(By.xpath("//*[@id='sandbox-container1']/div/input")).getAttribute("value");
	   LocalDate localDate = LocalDate.parse(date, formatter);

	if(localDate.equals(currentDate)) {
		System.out.println("success");
	}
	else
		System.out.println("failed"+currentDate);
		
  driver.close();
}

@Given("^I click on  third date$")
public void i_click_on_third_date() {
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[2]/td[1]")));
			driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[2]/td[1]")).click();

			
}

@Given("^I verify if its visible on select box$")
public void i_verify_if_its_visible_on_select_box() {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id='sandbox-container1']/div/input")));
	String date =driver.findElement(By.xpath("//*[@id='sandbox-container1']/div/input")).getAttribute("value");
	if(date.equals(String.valueOf("03/08/2020"))) {
		System.out.println("success");
	}
	else
		System.out.println("failed");
    
}


@When("^I click on clear button$")
public void i_click_on_clear_button() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/table/tfoot/tr[2]/th")));
	driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tfoot/tr[2]/th")).click();

}

@Then("^I verify if dd\\/mm\\/yyyy$")
public void i_verify_if_dd_mm_yyyy() {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id='sandbox-container1']/div/input")));
	String date =driver.findElement(By.xpath("//*[@id='sandbox-container1']/div/input")).getAttribute("value");
	if(date.equals(String.valueOf(""))) {
		System.out.println("success");
	}
	else
		System.out.println("failed"+date);
 driver.close();
}


@Given("^I select date by clicking privious button$")
public void i_select_date() {	
	wait.until(ExpectedConditions
		.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[2]/th[1]")));
	driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[2]/th[1]")).click();
	
	wait.until(ExpectedConditions
		.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[2]/td[2]")));
	driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[2]/td[2]")).click();

}

@Then("^I verify if date is visible and has month july$")
public void i_verify_if_date_is_visible_august() {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id='sandbox-container1']/div/input")));
	String date =driver.findElement(By.xpath("//*[@id='sandbox-container1']/div/input")).getAttribute("value");
	if(date.contains("/07/")) {
		System.out.println("success");
	}
	else
		System.out.println("failed"+date);
 driver.close();   
}



@Given("^I select date thirteen as a start date$")
public void i_select_date_thirteen_as_a_start_date() throws InterruptedException {
			Thread.sleep(1000);
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='datepicker']/input[1]")));
		driver.findElement(By.xpath("//*[@id='datepicker']/input[1]")).click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(@class,'datepicker datepicker-dropdown')]")));
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[3]/td[5]")).click();
}

@Then("^I verify if end date and start date is same$")
public void i_verify_if_end_date_and_start_date_is_same() throws InterruptedException {
	Thread.sleep(1000);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"datepicker\"]/input[2]")));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"datepicker\"]/input[1]")));
if(driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[1]")).getText()==driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[1]")).getText())
	System.out.println("success");
else 
	System.out.println("failed");


}

@When("^I select end date as ten$")
public void i_select_end_date_as_ten() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='datepicker']/input[2]")));
		driver.findElement(By.xpath("//*[@id='datepicker']/input[2]")).click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(@class,'datepicker datepicker-dropdown')]")));
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr[3]/td[2]")).click();

}

}
