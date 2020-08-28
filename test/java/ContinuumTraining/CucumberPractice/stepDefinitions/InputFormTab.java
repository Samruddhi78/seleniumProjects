package ContinuumTraining.CucumberPractice.stepDefinitions;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.protobuf.StringValue;

public class InputFormTab {

	WebDriver driver = null;
	Actions actions = null;
	WebDriverWait wait = null;
	List<String> options;
	
@Given("login to the applicationI$")
public void login_to_the_application_i() {
	System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	wait = new WebDriverWait(driver, 20);
	driver.get("https://www.seleniumeasy.com/test/");
	driver.manage().window().maximize();
	try {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("at-cv-lightbox-close")));
		driver.findElement(By.id("at-cv-lightbox-close")).click();
	} catch (Exception e) {
		System.out.println("***NO pop up is shown***");
	}

 
}

@Given("^I click on Input Forms tab$")
public void i_click_on_input_forms_tab() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/a")).click();
 
}

@Given("^I click on Simple Form Demo option$")
public void i_click_on_simple_form_demo_option() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[1]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[1]/a")).click();
 
}


@Given("^I click on Get Total$")
public void i_click_on_get_total() {
	
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='gettotal']/button")));
	driver.findElement(By.xpath("//*[@id='gettotal']/button")).click();
 
}

@Then("^I verify if the total is correct for (.*)  (.*) strings$")
public void i_verify_if_the_total_is_correct_for_stings(String str1, String str2) {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id='displayvalue']")));
	String value=driver.findElement(By.xpath("//*[@id='displayvalue']")).getText();
	if(value.equals("NaN"))
		System.out.println(" the addition is  correct "+value);
	else
		System.out.println(" the addition is  wrong "+value);
	 driver.close();

}

@Then("I verify if the total is correct for {int}  {int} integers")
public void i_verify_if_the_total_is_correct_for_integers(Integer int1, Integer int2) {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id='displayvalue']")));
	String value=driver.findElement(By.xpath("//*[@id='displayvalue']")).getText();
	int sum=int1+int2;
	if(value.equals(String.valueOf(sum)))
	System.out.println(" the addition is  correct "+value+"  "+String.valueOf(int1+int2));
	else
		System.out.println(" the addition is  wrong "+value+"  "+String.valueOf(int1+int2));
 driver.close();
}

@Then("I verify if the total is correct for {double}  {double} floats")
public void i_verify_if_the_total_is_correct_for_floats(Double double1, Double double2) {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id='displayvalue']")));
	String value=driver.findElement(By.xpath("//*[@id='displayvalue']")).getText();
	double sum= double1+double2;
	if(value.equals(String.valueOf(sum)))
	System.out.println(" the addition is  correct "+value);
	else
		System.out.println(" the addition is  wrong "+value);
 
	 driver.close();
}

@Given("^I type (.*) in Enter a and (.*) in Enter b integer$")
public void i_type_in_enter_a_and_in_enter_b_integer(Integer int1, Integer int2) {	
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='sum1']")));
	driver.findElement(By.xpath("//*[@id='sum1']")).sendKeys(""+int1);
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='sum2']")));
	driver.findElement(By.xpath("//*[@id='sum2']")).sendKeys(""+int2);
 
}


@Given("^I type (.*) in Enter a and (.*) in Enter b floats$")
public void i_type_in_enter_a_and_in_enter_b_double(Double double1, Double double2) {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='sum1']")));
	driver.findElement(By.xpath("//*[@id='sum1']")).sendKeys(""+double1);
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='sum2']")));
	driver.findElement(By.xpath("//*[@id='sum2']")).sendKeys(""+double2);
  
 
}

@Given("^I type (.*) in Enter a and (.*) in Enter b string$")
public void i_type_in_enter_a_and_in_enter_b_string(String str, String str2) {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='sum1']")));
	driver.findElement(By.xpath("//*[@id='sum1']")).sendKeys(""+str);
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='sum2']")));
	driver.findElement(By.xpath("//*[@id='sum2']")).sendKeys(""+str2);
   
 
}


@Given("^I click on checkbox Demo option$")
public void i_click_on_checkbox_demo_option() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[2]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[2]/a")).click();
 
 
}

@Given("^I check Click on this check box checkbox$")
public void i_check_click_on_this_check_box_checkbox() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='isAgeSelected']")));
	driver.findElement(By.xpath("//*[@id='isAgeSelected']")).click();
 
 
}

@Then("^I verify if success msg is shown$")
public void i_verify_if_success_msg_is_shown() {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id='txtAge']")));
	//driver.findElement(By.xpath("//*[@id='txtAge']")).click();
	System.out.println("checked");
 
}

@And("^I uncheck check box checkbox$") 
public void I_uncheck_check_box_checkbox() {
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='isAgeSelected']")));
		if(driver.findElement(By.xpath("//*[@id='isAgeSelected']")).isSelected())
		driver.findElement(By.xpath("//*[@id='isAgeSelected']")).click();
		else
			System.out.println("not checked, already uncheked");
	 
}
@Then ("^I verify if success msg is not shown$")
public void I_verify_if_success_msg_is_not_shown() {
	wait.until(ExpectedConditions
			.invisibilityOfElementLocated(By.xpath("//*[@id='txtAge']")));
	//driver.findElement(By.xpath("//*[@id='txtAge']")).click();
	System.out.println("unchecked succesfully");
}


@Then("^I cick on check all button$")
public void i_cick_on_check_all_button() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='check1']")));
	driver.findElement(By.xpath("//*[@id='check1']")).click();
 
 
}

@Then("^I verify if all four options are checked$")
public void i_verify_if_all_four_options_are_checked() {
	
	wait.until(ExpectedConditions
			.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div")));
	List<WebElement> options = driver.findElements(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div"));
	boolean flag=false;
for(WebElement option : options) {
	
	WebElement check = option.findElement(By.xpath("label/input"));
	if(check.isSelected())
		continue;
	else
	{
		flag=true;
		System.out.println("one element is not selected");
		break;
	}
	
}
if(!flag)
	System.out.println("all elements are selected");
 driver.close();
}

@Given("^I click on Radio button Demo option$")
public void i_click_on_radio_button_demo_option() {
	//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[3]/a
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[3]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[3]/a")).click();
 
 
}

@Given("^I select Female radio button and (.*) to (.*) radio button$")
public void i_select_female_radio_button_and_to_radio_button(Integer int1, Integer int2) {
	//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[1]/label[2]/input   female
	//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label[1]      age group
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[1]/label[2]/input")));
	driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[1]/label[2]/input")).click();
	
	if(int1==0) {
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label[1]/input")));
		driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label[1]/input")).click();
	}
	else if(int1==5) {
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label[2]/input")));
		driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label[2]/input")).click();
	}
 
 
}

@When("^I click on Get Values button$")
public void i_click_on_get_values_button() {
	//*[@id='easycont']/div/div[2]/div[2]/div[2]/button
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/button")));
	driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/button")).click();
}

@Then("^I verify if Female and (.*) to (.*) is correct$")
public void i_verify_if_female_and_to_is_correct(Integer int1, Integer int2) {
	//*[@id="easycont"]/div/div[2]/div[2]/div[2]/p[2]
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")));
	String text=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")).getText();
	if(text.contains("Female") && text.contains(String.valueOf(int1))&& text.contains(String.valueOf(int2)))
		System.out.println("successfulll");
	
	driver.close();	
}

@Given("^I select Male radio button and (.*) to (.*) radio button$")
public void i_select_male_radio_button_and_to_radio_button(Integer int1, Integer int2) {
	//*[@id="easycont"]/div/div[2]/div[2]/div[2]/div[1]/label[1]/input   male
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[1]/label[1]/input")));
	driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[1]/label[1]/input")).click();
	
	if(int1==0) {
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label[1]/input")));
		driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label[1]/input")).click();
	}
	else if(int1==5) {
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label[2]/input")));
		driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div[2]/label[2]/input")).click();
	}
}

@Then("^I verify if Male and (.*) to (.*) is correct$")
public void i_verify_if_male_and_to_is_correct(Integer int1, Integer int2) {
	
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")));
		String text=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")).getText();
		if(text.contains("Male") && text.contains(String.valueOf(int1))&& text.contains(String.valueOf(int2)))
			System.out.println("successfulll");
		
		driver.close();
}

@Given("^I click on dropdown demo$")
public void i_click_on_dropdown_demo() {
	//*[@id="navbar-brand-centered"]/ul[1]/li[1]/ul/li[4]/a
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[4]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[4]/a")).click();
}

@Given("^I select three cities$")
public void i_select_cities() {
	//*[@id="multi-select"]/option[1]
	options = new ArrayList<String>();
	wait.until(ExpectedConditions
			.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='multi-select']/option")));
	options.add(driver.findElement(By.xpath("//*[@id='multi-select']/option[1]")).getText());	
	options.add(driver.findElement(By.xpath("//*[@id='multi-select']/option[2]")).getText());
	options.add(driver.findElement(By.xpath("//*[@id='multi-select']/option[3]")).getText());
	
	Actions actions = new Actions(driver);
	actions.keyDown(Keys.CONTROL).pause(Duration.ofSeconds(3))
	    .click(	driver.findElement(By.xpath("//*[@id='multi-select']/option[2]"))).pause(Duration.ofSeconds(4))
	    .click(driver.findElement(By.xpath("//*[@id='multi-select']/option[3]"))).pause(Duration.ofSeconds(4))
	    .click(driver.findElement(By.xpath("//*[@id='multi-select']/option[4]"))).pause(Duration.ofSeconds(4))
	    .keyUp(Keys.CONTROL)
	    .build()
	    .perform();
//	List<WebElement> option =
 
}

@Given("^I click on first selected$")
public void i_click_on_first_selected() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='printMe']")));
	driver.findElement(By.xpath("//*[@id='printMe']")).click();
}

@Then("^I check if its city1$")
public void i_check_if_its_city1() {
	
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/p[2]")));
	String text=driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/p[2]")).getText();
	if(text.contains("California"))
		System.out.println("success");
	else
		System.out.println(text);
}

@Then("^I click on  get all selected$")
public void i_click_on_get_all_selected() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='printAll']")));
	driver.findElement(By.xpath("//*[@id='printAll']")).click();
 
}

@Then("^I check if its three cities$")
public void i_check_if_its_california_new_jersey_texas() {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/p[2]")));
	String text=driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/p[2]")).getText();
	if(text.contains("California") &&text.contains("Florida")&&text.contains("New Jersey"))
		System.out.println("success");
	else
		System.out.println(text);
	driver.close();
}

@Given("^I click on jquery dropdown$")
public void i_click_on_jquery_dropdown() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[7]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[7]/a")).click();
}

@Given("^I click on select state option$")
public void i_click_on_select_state_option() {	
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul/li/input")));
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul/li/input")).sendKeys("a");
}
//error
@Given("^I select city1 city2$")
public void i_select_city1() {
	wait.until(ExpectedConditions
			.presenceOfElementLocated(By.xpath("/html/body/span/span/span")));
	driver.findElement(By.xpath("/html/body/span/span/span/ul/li[1]")).click();
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul/li/input")).sendKeys("a");
	driver.findElement(By.xpath("/html/body/span/span/span/ul/li[2]")).click();
	
}


@Given("^I deselect city1$")
public void i_deselect_city1() {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul")));
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul/li[1]/span")).click();

}

@Then("^I verify if only one city is selected$")
public void i_verify_if_only_one_city_is_selected_city2() {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul")));
 List<WebElement> options =driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul/li"));
if(options.size()==2) 
	System.out.println("success");
	else 
		System.out.println("failed");
	driver.close();

}

}
