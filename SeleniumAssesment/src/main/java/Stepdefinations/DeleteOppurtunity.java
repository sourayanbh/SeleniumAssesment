package Stepdefinations;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOppurtunity {
public ChromeDriver driver;
    
	
	@Given("Open Chrome browser")
	public void opening_chrome() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);//opening chrome browser

		driver.get("https://qeagle-dev-ed.my.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Tuna@123");
		driver.findElement(By.id("Login")).click(); //login to salesforce application
		try {
			TimeUnit.SECONDS.sleep(30);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	
	@When("Click on App launcher & select sales")
	public void AppLauncher() {
		  
		try {
			TimeUnit.SECONDS.sleep(30);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();//clicking on all launcher 
		    driver.findElement(By.xpath("//img[@src ='https://qeagle-dev-ed.my.salesforce.com/logos/Salesforce/SalesCloud/logo.png']")).click();
		    //clicking on sales from all launcher
	}
	
	@And("click on created Opportunity")
	public void Sales() {
		  
		    WebElement element2 = driver.findElement(By.xpath("html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[2]/a/span"));
		    driver.executeScript("arguments[0].click();", element2);
		    WebElement element = driver.findElement(By.xpath("//a[@title='xyz1']"));
		    Actions action = new Actions(driver);
		    action.moveToElement(element).click().perform();//selecting opportunity to delete xyz1
		   
	}    
	
	@And("select delete from dropdown")
	public void Delete() {
		    try {
				TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		    WebElement element5 = driver.findElement(By.xpath("//ul[@class='slds-button-group-list']//child::lightning-primitive-icon"));
		    Actions action1 = new Actions(driver);
		    action1.moveToElement(element5).click().perform();
            WebElement element6 = driver.findElement(By.xpath("//a[@name='Delete']"));
		    Actions action2 = new Actions(driver);
		    action2.moveToElement(element6).click().perform();//selecting delete
	}

    
    @When("select delete")
    public void Save() {
    	WebElement element7 = driver.findElement(By.xpath("(//span[@dir='ltr'])[6]"));
		Actions action5 = new Actions(driver);
		action5.moveToElement(element7).click().perform();//clicking delete button


		  }
}	
