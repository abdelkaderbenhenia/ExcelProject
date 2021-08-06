package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;
	static String browser;
	static String url;

	
	
	
	public static void readConfig() {

		// BufferedReader//inputStream//FileReader//Scanner help to rad any type of file
		Properties prop = new Properties();

		try {
			InputStream input = new FileInputStream(
					"C:\\Users\\Abdelkader\\Desktop\\AEK\\Selenium\\session5-TestNG\\src\\main\\java\\Config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("Browser used" + browser);
			url = prop.getProperty("url");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static WebDriver init() {
		
		readConfig();

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Abdelkader\\Desktop\\AEK\\Selenium\\session5-TestNG\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Abdelkader\\Desktop\\AEK\\Selenium\\session5-TestNG\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void tearDown() {
		driver.close();
		driver.quit();

	}
}
