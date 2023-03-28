package eCommerce.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eCommerce.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> productTitles;
	
	@FindBy(css = ".totalRow button")
	WebElement checkOutIcon;
	
	
	By productsBy = By.cssSelector(".mb-3");
	
	public Boolean verifyProductDisplay(String productName) {
		return productTitles.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
	}
	
	public CheckOutPage goToCheckOutPage() {
		checkOutIcon.click();
		return new CheckOutPage(driver);
	}
	
}
