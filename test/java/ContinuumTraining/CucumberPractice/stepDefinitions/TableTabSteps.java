package ContinuumTraining.CucumberPractice.stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TableTabSteps {
	WebDriver driver = null;
	Actions actions = null;
	WebDriverWait wait = null;

	public TableTabSteps() {
		// TODO Auto-generated constructor stub
	}

	@Given("^I login to the application$")
	public void i_login_to_the_application() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 100);
		driver.get("http://www.seleniumeasy.com/test/");
		driver.manage().window().maximize();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("at-cv-lightbox-close")));
			driver.findElement(By.id("at-cv-lightbox-close")).click();
		} catch (Exception e) {
			System.out.println("***NO pop up is shown***");
		}

	}

	@And("^I click on the Table  tab$")
	public void i_click_on_the_table_tab() {
		//wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[3]/a"))));
		driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[3]/a")).click();
	}

	@Then("^I verify five drop-down values are getting displayed$")
	public void i_verify_five_drop_down_values_are_getting_displayed() {
		//wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='navbar-brand-centered']//ul[1]//li[3]//a[@class='dropdown-toggle']//following-sibling::ul")));
		List<WebElement> elements = driver.findElements(By.xpath(
				"//*[@id='navbar-brand-centered']//ul[1]//li[3]//a[@class='dropdown-toggle']//following-sibling::ul//li"));
		if (elements.size() == 5) {
			System.out.println("test pass: five drop-down values are getting displayed");
		} else
			System.out.println("test failed: five drop-down values are not getting displayed");
		driver.close();

	}

	@And("^I click on Table sort & search option$")
	public void i_click_on_table_sort_search_option() {
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[3]/ul/li[4]/a")));
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[3]/ul/li[4]/a")).click();
	}

	@Then("^I verify  Table sort and search demo page is getting displayed$")
	public void i_verify_table_sort_and_search_demo_page_is_getting_displayed() {
		wait = new WebDriverWait(driver, 50);

		String title = driver.getTitle();
		if (title.contains("Tabel Sort and Search Demo")) {
			System.out.println("test pass: Table sort and search demo page is getting displayed");
		} else
			System.out.println("test failed: Table sort and search demo page is not getting displayed");
		driver.close();
	}

	@Given("^I am on  Table sort and search demo page$")
	public void i_am_on_table_sort_and_search_demo_page() {
		wait = new WebDriverWait(driver, 50);

		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 40);
		driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
		driver.manage().window().maximize();

	}


	@Then("^I verify if rows containing (.*) field are displayed$")
	public void i_verify_if_rows_containing_that_field_are_displayed(String keyword) {
		//wait = new WebDriverWait(driver, 50);
	//	TableTabSteps.waitForLoad(driver);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='example']/tbody/tr")));
		List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='example']/tbody/tr"));
		boolean flag=false, mflag=false;
		
		for (WebElement tableRow : tableRows) {
			List<WebElement>  tableDatas = tableRow.findElements(By.tagName("td"));
			System.out.println("SIZE OF TDS "+ tableDatas);
			for (WebElement tableData : tableDatas) {
				String data = tableData.getText();
				System.out.println("the data in td is  "+data);
				if(data.contains(keyword))
				{
					flag=true;
					break;
				}
			}
			if (!flag) {
				System.out.println("test failed!! showing the row which do not contain keyword");
				mflag = true;
				break;
			}
		}
		if(!mflag)
		System.out.println("test passed!! showing the rows which contain keyword");
		driver.close();

	}

	@Then("^I verify if No matching records found is displayed$")
	public void i_verify_if_no_matching_records_found_is_displayed() {
		//wait = new WebDriverWait(driver, 50);
		//TableTabSteps.waitForLoad(driver);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='example']/tbody/tr")));

		List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr"));
		if (tableRows.size() == 1) {
			String val = tableRows.get(0).getAttribute("innerText");
			if (val.contains("No matching records found")) {
				System.out.println("passed!!!No matching records found is displayed ");
		
			}
		} else
			System.out.println("failed!!! No matching records found is NOT displayed ");
		driver.close();

	}

	@And("^I enter (.*) in search field$")
	public void i_enter_in_search_field(String str) {
		wait = new WebDriverWait(driver, 100);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='example_filter']/label/input")));
		driver.findElement(By.xpath("//*[@id='example_filter']/label/input")).sendKeys(str);
	//	TableTabSteps.waitForLoad(driver);

		//driver.findElement(By.id("//*[@id='example_filter']/label/input")).sendKeys(Keys.RETURN);
	}

	@And("^I click show entries drop down option$")
	public void i_click_show_entries_drop_down_option() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='example_length']/label/select")));
		driver.findElement(By.xpath("//*[@id='example_length']/label/select")).click();

	}

	@And("^I select (.*) from the drop down list$")
	public void i_select_from_the_drop_down_list(Integer int1) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='example_length']/label/select/option[@value=\"" + int1 + "\"]")));

		driver.findElement(By.xpath("//*[@id='example_length']/label/select/option[@value=\"" + int1 + "\"]"))
				.click();
	}

	@Then("^I check if that (.*) of rows are displyed$")
	public void i_check_if_that_of_rows_are_displyed(Integer int1) {
		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='example']/tbody")));
		List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='example']/tbody/tr"));
		if (int1 > 32 && tableRows.size() == 32) {
			System.out.println("passed");
		}

		else if (tableRows.size() == int1) {
			System.out.println("passed");
		} else
			System.out.println("failed");
		driver.close();

	}
	//table-search-filter-demo page*********************

	@When ("^I click on Table Data Search option$")
	public void i_click_on_table_data_search_option() {
		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[3]/ul/li[2]/a")));
		driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[3]/ul/li[2]/a")).click();
	}

	@And("^I enter (.*) in Tasks field$")
	public void i_enter_in_tasks_field(String str) {
		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='task-table-filter']")));

		driver.findElement(By.xpath("//*[@id='task-table-filter']")).sendKeys(str);
	}	
	
	@Then("^I verify if rows containing (.*) are displayed on Tasks table$")
	public void i_verify_if_rows_containing_software_engineer_are_displayed_on_tasks_table(String keyword) {
		wait = new WebDriverWait(driver, 70);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='task-table']/tbody/tr[not(contains(@style, 'display: none'))]")));

		List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='task-table']/tbody/tr[not(contains(@style, 'display: none'))]"));
		boolean flag=false, mfl=true;
		for (WebElement tableRow : tableRows) {
			List<WebElement>  tableDatas = tableRow.findElements(By.tagName("td"));
			for (WebElement tableData : tableDatas) {
				String data = tableData.getAttribute("innerText");
				if(data.contains(keyword))
				{
					flag=true;
					break;
				}
			}
			if (!flag) {
				mfl=false;
				System.out.println("test failed!! showing the row which do not contain keyword");
				break;
			}
		}
		if(mfl)
		System.out.println("test passed!! showing the rows which contain keyword");
		
		driver.close();

	}
	
	@Then("I verify if No matching records found is displayed on Tasks table")
	public void i_verify_if_no_matching_records_found_is_displayed_on_tasks_table() {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='task-table']/tbody/tr[not(contains(@style, 'display: none'))]")));
		List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='task-table']/tbody/tr[not(contains(@style, 'display: none'))]"));
		
		System.out.println("table rppowwss "+tableRows.size()+"   "+ tableRows.get(0).getText());
		
		if (tableRows.size() == 1) {
			String val = tableRows.get(0).findElement(By.tagName("td")).getAttribute("innerText");
			if (val.contains("No results found")) {
				System.out.println("passed!!!No matching records found is displayed ");
			}
			else
				System.out.println("failed!!! No matching records found is NOT displayed ");

				
		} else
			System.out.println("failed!!! No matching records found is NOT displayed ");
		driver.close();


	}

	   @And("^I click on the Table Filter option$")
	   public void click_table_filter_option() {
			wait = new WebDriverWait(driver, 50);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[3]/ul/li[3]/a")));
		   driver.findElement(By.xpath("//*[@id='navbar-brand-centered']/ul[1]/li[3]/ul/li[3]/a")).click();
	   }
	   
	    @When("^I click on green button of the Filter Records Table$")
	    public void click_green_btn_filter_table() {
			wait = new WebDriverWait(driver, 50);

	    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//button[@class='btn btn-success btn-filter']")));
			   driver.findElement(By.xpath("//div//button[@class='btn btn-success btn-filter']")).click();
	    	
	    }
	    @Then ("^I verify if only green emojis are visible$")
	    public void check_for_only_green_emojis(){
			wait = new WebDriverWait(driver, 50);

	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-filter']//tbody")));
	    	List <WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table table-filter']//tbody/tr[not(contains(@style, 'display: none'))]"));
	    	List <WebElement> greenRows = driver.findElements(By.xpath("//table[@class='table table-filter']/tbody/tr/td[3]/div/a/i[@style='color:green;']" ));
	    	if(tableRows.size()==greenRows.size())
	    		System.out.println("Passed");
	    	else
	    		System.out.println("failed");
	    }
	    @When("^I click on orange button of the Filter Records Table$")
	    public void click_orange_btn_filter_table() {
			wait = new WebDriverWait(driver, 50);

			   driver.findElement(By.xpath("//div//button[@class='btn btn-warning btn-filter']")).click();
	    	
	    }
	    @Then ("^I verify if only orange emojis are visible$")
	    public void check_for_only_orange_emojis(){
			wait = new WebDriverWait(driver, 50);

	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-filter']//tbody")));
	    	List <WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table table-filter']//tbody/tr[not(contains(@style, 'display: none'))]"));
	    	List <WebElement> greenRows = driver.findElements(By.xpath("//table[@class='table table-filter']/tbody/tr/td[3]/div/a/i[@style='color:orange;']" ));
	    	if(tableRows.size()==greenRows.size())
	    		System.out.println("Passed");
	    	else
	    		System.out.println("failed");
	    	driver.close();
	    }
	    
	    @When("^I click on red button of the Filter Records Table$")
	    public void click_red_btn_filter_table() {
			wait = new WebDriverWait(driver, 50);

			   driver.findElement(By.xpath("//div//button[@class='btn btn-danger btn-filter']")).click();
	    	
	    }
	    @Then ("^I verify if only red emojis are visible$")
	    public void check_for_only_red_emojis(){
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-filter']//tbody")));
	    	List <WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table table-filter']//tbody/tr[not(contains(@style, 'display: none'))]"));
	    	List <WebElement> greenRows = driver.findElements(By.xpath("//table[@class='table table-filter']/tbody/tr/td[3]/div/a/i[@style='color:red;']" ));
	    	if(tableRows.size()==greenRows.size())
	    		System.out.println("Passed");
	    	else
	    		System.out.println("failed");

	    }
	    
	
}