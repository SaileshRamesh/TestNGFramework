package eCommerce.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

    WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement SelectCountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
	   Actions a = new Actions(driver);
	   a.sendKeys(country,countryName).build().perform();
	   waitForElementToAppear(results);
	   SelectCountry.click();
	}
	
	public ConfirmationPage submitOrder() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", submit);
		return new ConfirmationPage(driver);
	}
}
