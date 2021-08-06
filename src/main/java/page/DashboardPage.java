package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
	}


	@FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]")WebElement DASHBOARD_HEADER_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]")WebElement CUSTOMER_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")WebElement ADD_CUSTOMER_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")WebElement LIST_CUSTOMER_FIELD;
	
	
	
	
	 public void verifyDashboardPage() {
		Assert.assertEquals(DASHBOARD_HEADER_FIELD.getText(), "Dashboard", "Wrong Page!!!!!"); 
		  
	 }

	 
	 public void clickCustomersButton() {
		 CUSTOMER_FIELD.click();
	 }
	 public void clickAddCustomersButton() {
		 ADD_CUSTOMER_FIELD.click();
	 }
	 
	 public void clickListCustomersButton() {
		 LIST_CUSTOMER_FIELD.click();
		
	 }
	 
	 
}
