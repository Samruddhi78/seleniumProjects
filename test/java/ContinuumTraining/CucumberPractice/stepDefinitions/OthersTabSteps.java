package ContinuumTraining.CucumberPractice.stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OthersTabSteps {

	WebDriver driver = null;
	Actions actions = null;
	WebDriverWait wait = null;
	
	@Given("^I login to the applicationO$")
	public void i_login_to_the_application() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 100);
		driver.get("https://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
	//	TableTabSteps.waitForLoad(driver);
		//Actions action = new Actions(driver);
	//	action.dragAndDrop(driver.findElement(By.id("")), driver.findElement(By.id(""))).build().perform();
		// To handle the pop up
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("at-cv-lightbox-close")));
			driver.findElement(By.id("at-cv-lightbox-close")).click();
		} catch (Exception e) {
			System.out.println("***NO pop up is shown***");
		}

	}

@Given("^I click on the Others tab$")
public void i_click_on_the_others_tab() {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[4]/a")));
    driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[4]/a")).click();
	
}

@Given("^I click on Drag and Drop option$")
public void i_click_on_drag_and_drop_option() {
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[4]/ul/li[1]/a")));
    driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[4]/ul/li[1]/a")).click();
}

@Given("^I check if the drag and drop table is present$")
public void i_check_if_the_drag_and_drop_table_is_present() {
	String title = driver.getTitle();
	if(title.equalsIgnoreCase("Selenium Easy Demo - Drag and Drop Demo"))
		System.out.println("i m on the drag and drop page");
}

@Given("^I drag Draggable1 and drop it in drop here box$")
public void i_drag_draggable1_and_drop_it_in_drop_here_box() throws InterruptedException {
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")))

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='todrag']")));
	Actions action = new Actions(driver);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='todrag']/span[1]")));
	//action.dragAndDropBy(driver.findElement(By.xpath("//*[@id='todrag']/span[1]")), driver.findElement(By.id("mydropzone"))).build().perform();
//	 action.clickAndHold(driver.findElement(By.xpath("//*[@id='todrag']/span[1]"))).pause(Duration.ofSeconds(5))
//			   .moveToElement(driver.findElement(By.id("mydropzone"))).pause(Duration.ofSeconds(5))
//			   .release(driver.findElement(By.id("mydropzone"))).perform();
//	 

//	action.keyDown(Keys.CONTROL)
//	   .click(driver.findElement(By.xpath("//*[@id='todrag']/span[1]")))
//	   .click(driver.findElement(By.id("mydropzone")))
//	   .keyUp(Keys.CONTROL).build().perform();;

	 
	 WebElement _sourceElement = driver.findElement(By.xpath("//*[@id='todrag']/span[1]"));
	 WebElement _targetElement = driver.findElement(By.id("mydropzone"));
//	 JavascriptExecutor _js = (JavascriptExecutor) driver;
//	 _js.executeScript("$(arguments[0]).simulate('drag-n-drop',{dragTarget:arguments[1],interpolation:{stepWidth:100,stepDelay:50}});", _sourceElement, _targetElement);

	 Thread.sleep(1000);
	 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
			                     + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
			                     + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
			                     + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
			                     + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
			                     + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
			                     + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
			                     + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
			                     + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
			                     + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
			                     + "var dropEvent = createEvent('drop');\n"
			                     + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
			                     + "var dragEndEvent = createEvent('dragend');\n"
			                     + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
			                     + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
			                     + "simulateHTML5DragAndDrop(source,destination);", _sourceElement, _targetElement);



}

@Then("^I verify if the Draggable1 is in droped item list box$")
public void i_verify_if_the_draggable1_is_in_droped_item_list_box() {

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='droppedlist']")));
	List<WebElement> spans = driver.findElements(By.xpath("//*[@id='droppedlist']/span"));
	if(spans.size()==1){
		if(spans.get(0).getText().equalsIgnoreCase("Draggable 1"))
			System.out.println("passed");
		
	}
    
}

@Then("^it is not in Items to drag box$")
public void it_is_not_in_items_to_drag_box() {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='todrag']/span")));
	List<WebElement> spans = driver.findElements(By.xpath("//*[@id='todrag']/span"));
	boolean flag=false;
	for(WebElement span : spans) {
		if(span.getText().equalsIgnoreCase("Draggable 1")){
			flag=true;
			System.out.println("failed");
			break;	
		}
	}
	if(!flag)
		System.out.println("passed");
	
}

//@When("^I drag another Draggable2 and drop it in drop here box$")
//public void I_drag_another_Draggable2_in_drop_here_box() {
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"todrag\"]")));
//	Actions action = new Actions(driver);
//	action.dragAndDrop(driver.findElement(By.xpath("//*[@id=\"todrag\"]/span[1]")), driver.findElement(By.id("droppedlist"))).build().perform();
//
//	
//}
@Then("^I verify if both the items are in item list box$")
public void I_verify_both_the_items_list_box(){
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='droppedlist']/span")));
	List<WebElement> spans = driver.findElements(By.xpath("//*[@id='droppedlist']/span"));
	if(spans.size()==2){
		if(spans.get(0).getText().equalsIgnoreCase("Draggable 1") && spans.get(1).equals("Draggable 2"))
			System.out.println("passed");
		
	}
	
}
@Given("^I click on Dynamic Data Loading$")
public void i_click_on_dynamic_data_loading() {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[4]/ul/li[2]/a")));
 driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[2]/li[4]/ul/li[2]/a")).click();;
}

@When("^I click on Get New User button$")
public void i_click_on_get_new_user_button() {

	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='save']")));
 driver.findElement(By.xpath("//*[@id='save']")).click();
}

@When("^I check if Loading is shown and how long it takes to load data$")
public void i_check_if_loading_is_shown() {
	long start = System.currentTimeMillis();
String text =	driver.findElement(By.id("loading")).getText();
wait = new WebDriverWait(driver, 100);

wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("loading")), "innerText", "First Name"));
long finish = System.currentTimeMillis();

if(text.equalsIgnoreCase("loading..."))
System.out.println("Loading is shown for "+ (finish-start) +"milliseconds");
}

@Then("^I verify if all the deatils are available after loading$")
public void i_verify_if_all_the_deatils_are_available_after_loading() {
	String details= driver.findElement(By.id("loading")).getText();
	String str = driver.findElement(By.xpath("//*[@id='loading']/img")).getAttribute("src");
	if(details.contains("First Name")&& details.contains("Last Name"))
		System.out.println("\n passed\n"+details+"\n result  "+str);
}


}
