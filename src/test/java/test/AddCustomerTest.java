package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {
	
	WebDriver driver;
	
	String userName;
	String password;
	String fullName;
	String companyName;
	String email;
	String phone;
	String address;
	String city;
	String country;
	String state;
	String zip;
	
	//@Test
	@Parameters({"userName","password","fullName","companyName","email","phone","address","city","country","state","zip"})
	public void validUserShouldBeAbleToCreateCustomer(String userName,String password,String fullName,String companyName,String email,String phone,String address,String city,String country,String state,String zip) {
		
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

	
	@Test
	@Parameters({"userName","password","fullName","companyName","email","phone","address","city","country","state","zip"})
	public void validUserShouldBeAbleToAddCustomerOnListCustomers(String userName,String password,String fullName,String companyName,String email,String phone,String address,String city,String country,String state,String zip) {
		
		driver=BrowserFactory.init();
		
		LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
		
		LoginPage.enterUserName(userName);
		LoginPage.enterPassword(password);
		LoginPage.clickSigninButton();
		
		DashboardPage dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.verifyDashboardPage();
		dashboardPage.clickCustomersButton();
		dashboardPage.clickListCustomersButton();
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
		
		addCustomerPage.inserNameOnSearchBarOnListCustomers();
		addCustomerPage.verifySearchBarAndSmmaryButtonOnListCustomer();
		addCustomerPage.enterSummaryPage();
		
		BrowserFactory.tearDown();
		
	}
}
