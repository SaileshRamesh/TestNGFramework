package eCommerce.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import eCommerce.PageObjects.CartPage;
import eCommerce.PageObjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartIcon;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
	}
	
	public void waitForWebElementToAppear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * Application has heavy load and that is why using implicit wait is not recommended here
	 * It will keep waiting until the loading is completely over, which is why the test will not proceed
	 * @param ele
	 * @throws InterruptedException
	 */
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
		Thread.sleep(1000);
	}
	
	public CartPage goToCartPage() {
		cartIcon.click();
		return new CartPage(driver);
	}
	
	public OrderPage goToOrdersPage() {
		orderHeader.click();
		return new OrderPage(driver);
	}

}
