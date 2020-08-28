package ContinuumTraining.CucumberPractice.stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ListBoxTab {
	WebDriver driver = null;
	Actions actions = null;
	WebDriverWait wait = null;
	
 List <String> items;
 int sizeOfLeftList,sizeOfRightList;
 
@Given("^I login to the application L$")
public void i_login_to_the_application_l() {
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

@Given("^I click on the List Box tab$")
public void i_click_on_the_list_box_tab() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/nav/div/div[2]/ul[2]/li[3]/a")));
	driver.findElement(By.xpath("/html/body/div[1]/div[2]/nav/div/div[2]/ul[2]/li[3]/a")).click();

}

@Given("^I click on Bootstrap list box option$")
public void i_click_on_bootstrap_list_box_option() {
	wait.until(ExpectedConditions
			.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[3]/ul/li[1]/a")));
	driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[3]/ul/li[1]/a")).click();

}

@Given("^I click on first element of left list$")
public void i_click_on_first_element_of_left_list() {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//*[@class='well text-right']/ul/li[1]")));
	items= new ArrayList<String>();
	items.add(driver.findElement(By.xpath("//*[@class='well text-right']/ul/li[1]")).getText());
	driver.findElement(By.xpath("//*[@class='well text-right']/ul/li[1]")).click();
	
	
}

@Given("^I click on shift right button$")
public void i_click_on_shift_right_button() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[2]")));
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[2]")).click();

}

@Then("^I verify if the first element is shifted to right list$")
public void i_verify_if_the_first_element_is_shifted_to_right_list() {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='well']//ul")));

	List <WebElement> rightItems= driver.findElements(By.xpath("//*[@class='well']//ul/li"));
	for(WebElement ritem : rightItems) {
		if(items.get(0).equals(ritem.getText()))
			System.out.println("passed verify");
	}

}

@Then("^It is not in left list$")
public void it_is_not_in_left_list() {
	if(items.get(0)!=driver.findElement(By.xpath("//*[@class='well']//ul/li")).getText())
		System.out.println("passed");
	else
		System.out.println("failed");
	driver.close();
}

@Given("^I click on first element of right list$")
public void i_click_on_first_element_of_right_list() {
 
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath(" //*[@class='well']//ul")));
	items= new ArrayList<String>();
	items.add(driver.findElement(By.xpath(" //*[@class='well']//ul/li[1]")).getText());
	driver.findElement(By.xpath("//*[@class='well']/ul/li[1]")).click();
}

@Given("^I click on third element of right list$")
public void i_click_on_third_element_of_right_list() {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath(" //*[@class='well']//ul")));
	items.add(driver.findElement(By.xpath(" //*[@class='well']//ul/li[3]")).getText());
	driver.findElement(By.xpath("//*[@class='well']/ul/li[3]")).click();

}

@Given("^I click on fourth element of right list$")
public void i_click_on_fourth_element_of_right_list() {
	wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath(" //*[@class='well']//ul")));
	items.add(driver.findElement(By.xpath(" //*[@class='well']//ul/li[4]")).getText());
	driver.findElement(By.xpath("//*[@class='well']/ul/li[4]")).click();

}

@Given("^It is not in right list$")
public void it_is_not_in_right_list() {
	List<WebElement>lis= driver.findElements(By.xpath(" //*[@class='well']//ul/li"));
	boolean flag=true ,mflag=true;
	for(String str : items) {
		for(int i=0; i<lis.size(); i++) {
			if(str.equals(lis.get(i).getText())) {
				System.out.println("failed");
				flag=false;
				break;
			}
		}
		if(!flag) {
			mflag=false;
			break;
		}
	}
	if(mflag)
		System.out.println("passed");
	
  
}

@Then("^I verify if three elements are in left list$")
public void i_verify_if_three_elements_are_shifted_to_left_list() {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='well text-right']//ul")));

	List <WebElement> rightItems= driver.findElements(By.xpath("//*[@class='well text-right']//ul/li"));
	for(WebElement ritem : rightItems) {
		if(items.get(0).equals(ritem.getText()))
			System.out.println("passed verify");
	}
	driver.close();

}

@Given("^I click on select all button of right list$")
public void i_click_on_select_all_button_of_right_list() {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='well']//ul")));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='well text-right']//ul")));

	List <WebElement> rightItems= driver.findElements(By.xpath("//*[@class='well']//ul/li"));
	List <WebElement> leftItems= driver.findElements(By.xpath("//*[@class='well text-right']//ul/li"));
	sizeOfRightList =rightItems.size();
	sizeOfLeftList = leftItems.size();
	
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("//*[@id='listhead']/div[1]/div/a")));
	driver.findElement(By.xpath("//*[@id='listhead']/div[1]/div/a")).click();

	
  }

@When("^I click on shift left button$")
public void i_click_on_shift_left_button() {
	wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[1]")));
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[1]")).click();

	
    }

@When("^I check if right list is empty$")
public void i_check_if_right_list_is_empty() {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='well']//ul")));
	List <WebElement> rightItems= driver.findElements(By.xpath("//*[@class='well']//ul/li"));
	if(rightItems.isEmpty())
		System.out.println("passed");
 
}

@Then("^I verify if all elements are in left list$")
public void i_verify_if_all_elements_are_in_left_list() {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='well text-right']//ul")));
	List <WebElement> leftItems= driver.findElements(By.xpath("//*[@class='well text-right']//ul/li"));
	
	if((sizeOfLeftList*2)==leftItems.size()) {
		System.out.println("passed");
	}
 driver.close();
}
	
	
	
	
}
