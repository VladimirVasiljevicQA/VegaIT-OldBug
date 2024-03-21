package testNGTests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.MainPage;
import resources.Base;

public class SearchTest extends Base {
	public WebDriver driver;
	Logger log;

	@BeforeMethod
	public void open() throws IOException {
		log = LogManager.getLogger(SearchTest.class.getName());
		log.debug("Test contactTest started");
		driver = initDriver();
		log.debug("driver is started");
		driver.get(prop.getProperty("url"));
		log.debug("app is open on contact page");
	}

	@Test(dataProvider = "getData")
	public void searchTest(String data) {
		MainPage MainPage = new MainPage(driver);

		MainPage.AllowButton().click();
		log.debug("click on the Allow button for cookies");

		MainPage.SearchButton().click();
		log.debug("click on the Search button");

		MainPage.SearchField().sendKeys(data);
		log.debug("write text");
		MainPage.SearchField().sendKeys(Keys.ENTER);
		log.debug("press enter on keyboard");

		log.info("check warning message for SearchResult");
		try {
			if (MainPage.SearchResult().isDisplayed()) {
				
				log.debug("proper message is displayed");

			} else {

				throw new Exception();
			}

		} catch (Exception e) {
			
			log.error("error message on page" + e);
		}
		Assert.assertNotNull(MainPage.SearchResult().isDisplayed());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.debug("Browser is closed");
	}

}
