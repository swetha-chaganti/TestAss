package Steps;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepD {
	public static WebDriver driver;
	@Given("I Open browser and naviagte to {string}")
	public void i_open_browser_and_naviagte_to(String URL) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
		driver=new ChromeDriver();
	    driver.get(URL);
	   driver.manage().window().maximize();
}
	@When("I click on Sign in button")
	public void i_click_on_sign_in_button() throws InterruptedException {
	   String parent=driver.getWindowHandle();
	   System.out.println("ParentwindowHandle " +parent);
	   driver.findElement(By.xpath("//*[@id='jumbo']/div/div/a")).click();
	   
	   Set<String> allwindows=driver.getWindowHandles();
	   for(String child:allwindows)
	   {
		   if(!parent.equalsIgnoreCase(child))
		   {
			   driver.switchTo().window(child);
			   WebElement ele=driver.findElement(By.xpath("//*[@id='tp-form']/div[10]/a"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", ele);
				
		   }
	   }
	}

@Then("^I enters \"(.*)\" and \"(.*)\"$")
public void i_enters_username_and_password(String username,String password ) throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
	driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
	driver.findElement(By.xpath("//*[@id='tp-sign-in']")).click();
}

@Then("I should be able to land on the homepage")
public void i_should_be_able_to_land_on_the_homepage() {
	String actuaTitle=driver.getTitle();
	String expTitle="TestProject";
	System.out.println("Home page Title" +actuaTitle);
	Assert.assertEquals(actuaTitle, expTitle);
}
}

//*[@id='jumbo']/div/div/a