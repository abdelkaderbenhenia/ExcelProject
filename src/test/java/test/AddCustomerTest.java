package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	
	WebDriver driver;
	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TF-TestData.xlsx");
	String userName = exlread.getCellData("Logininfo", "UserName", 2);
	String password = exlread.getCellData("Logininfo", "Password", 2);
	String fullName = exlread.getCellData("AddContactinfo", "FullName", 2);
	String companyName = exlread.getCellData("AddContactinfo", "CompanyName", 2);
	String email = exlread.getCellData("AddContactinfo", "Email", 2);
	String phone = exlread.getCellData("AddContactinfo", "Phone", 2);
	String address = exlread.getCellData("AddContactinfo", "Address", 2);
	String city = exlread.getCellData("AddContactinfo", "City", 2);
	String country = exlread.getCellData("AddContactinfo", "Country", 2);
	String state = exlread.getCellData("AddContactinfo", "State", 2);
	String zip = exlread.getCellData("AddContactinfo", "Zip", 2);
	@Test
	public void validUserShouldBeAbleToCreateCustomer() {
		
		driver=BrowserFactory.init();
		
		LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
		
		LoginPage.enterUserName(userName);
		LoginPage.enterPassword(password);
		LoginPage.clickSigninButton();
		
		DashboardPage dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomersButton();
		dashboardPage.clickAddCustomersButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterCompany(companyName);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.enterSubmitt();
		addCustomerPage.enterSummaryPage();
		
		dashboardPage.clickListCustomersButton();
		
		addCustomerPage.verifyEnterNameAndDelete();
		
	}

}
