package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='nav__search']")
	private WebElement SearchButton;
	@FindBy(id = "nav__search-input-search")
	private WebElement SearchField;
	@FindBy(xpath = "//h1[normalize-space()='Search results']")
	private WebElement SearchResult;
	@FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
	private WebElement AllowButton;

	public WebElement SearchButton() {
		return SearchButton;
	}

	public WebElement SearchResult() {
		return SearchResult;
	}

	public WebElement SearchField() {
		return SearchField;
	}

	public WebElement AllowButton() {
		return AllowButton;
	}

}
