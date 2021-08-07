package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FUL_NAME_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_FIELD;
	@FindBy(how = How.XPATH, using = "//select[@id=\"country\"]")
	WebElement COUNTRY_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SUBMIT_BUTTON_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")
	WebElement SUMMARY_PAGE_FIELD;

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[2]/div/div/div[1]/a[1]")
	WebElement ADD_CUSTOMER_ON_LIST_CUSTOMERS_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"foo_filter\"]")
	WebElement SEARCH_BAR_ON_LIST_CUSTOMERS_FIELD;

	String enterName;

	public void enterFullName(String fULLNANE) {
		waitForElement(driver, 5, FUL_NAME_FIELD);
		enterName = fULLNANE + generateNumber(999);
		FUL_NAME_FIELD.sendKeys(enterName);
	}

	public void enterCompany(String company) {

		selectDropdown(COMPANY_FIELD, company);
	}

	public void enterPhone(String phone) {
		PHONE_FIELD.sendKeys(phone + generateNumber(99));
	}

	public void enterEmail(String email) {
		EMAIL_FIELD.sendKeys(generateNumber(999) + email);
	}

	public void enterAddress(String address) {
		ADDRESS_FIELD.sendKeys(address);
	}

	public void enterCity(String city) {
		CITY_FIELD.sendKeys(city);
	}

	public void enterState(String state) {
		STATE_FIELD.sendKeys(state);
	}

	public void enterZip(String zip) {
		ZIP_FIELD.sendKeys(zip);
	}

	public void enterCountry(String country) {
		COUNTRY_FIELD.sendKeys(country);
	}

	public void enterSubmitt() {
		SUBMIT_BUTTON_FIELD.click();
	}

	public void enterSummaryPage() {

		waitForElement(driver, 5, SUMMARY_PAGE_FIELD);
		Assert.assertEquals(SUMMARY_PAGE_FIELD.getText(), "Summary", "Wrong Page!!!");

	}

	public void clickAddCustomerOnListCustomers() {

		ADD_CUSTOMER_ON_LIST_CUSTOMERS_FIELD.click();

	}

	public void inserNameOnSearchBarOnListCustomers() {

		SEARCH_BAR_ON_LIST_CUSTOMERS_FIELD.sendKeys(enterName);

	}

	// tbody/tr[1]/td[3]
	/*
	 * public void verifyEnterName() {
	 * 
	 * String befor_Xpath="//tbody/tr["; String after_Xpath="]/td[3]";
	 * 
	 * for(int i=1 ;i<=10;i++) { String
	 * name=driver.findElement(By.xpath(befor_Xpath+ i +after_Xpath)).getText();
	 * System.out.println(name); Assert.assertEquals(name, enterName,
	 * "enter name doest exist!!!"); break; }
	 */

	public void verifyEnterNameAndDelete() {

		String befor_Xpath = "//tbody/tr[";
		String after_Xpath = "]/td[3]";

		for (int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(befor_Xpath + i + after_Xpath)).getText();
			/*
			 * System.out.println(name); Assert.assertEquals(name, enterName,
			 * "enter name doest exist!!!"); break;
			 */

			if (name.contains(enterName)) {
				System.out.println("Enter name existe.");

				// tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]

				driver.findElement(By.xpath(befor_Xpath + i + "]/td[3]/following-sibling::td[4]/a[2]")).click();
			}
		}

	}

	public void verifySearchBarAndSmmaryButtonOnListCustomer() {

		String befor_Xpath = "//tbody/tr[";
		String after_Xpath = "]/td[3]";

		for (int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(befor_Xpath + i + after_Xpath)).getText();
			System.out.println(name);
			/*
			 * Assert.assertEquals(name, enterName, "enter name doest exist!!!"); break;
			 */

			if (name.contains(enterName)) {
				System.out.println("Enter name existe.");
				driver.findElement(By.xpath(befor_Xpath + i + "]/td[3]/following-sibling::td[4]/a[1]")).click();
			}
			break;
		}
	}
} 
