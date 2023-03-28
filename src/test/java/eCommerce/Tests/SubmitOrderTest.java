package eCommerce.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eCommerce.PageObjects.CartPage;
import eCommerce.PageObjects.CheckOutPage;
import eCommerce.PageObjects.ConfirmationPage;
import eCommerce.PageObjects.OrderPage;
import eCommerce.PageObjects.ProductCataloguePage;
import eCommerce.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String productName = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getData")
	public void SubmitOrder(HashMap<String, String> input) throws InterruptedException, IOException {

		ProductCataloguePage PRODUCT_CATALOGUE_PAGE = LANDING_PAGE.loginApplication(input.get("email"),
				input.get("password"));
		PRODUCT_CATALOGUE_PAGE.getProductList();
		PRODUCT_CATALOGUE_PAGE.addProductToCart(input.get("product"));

		CartPage CART_PAGE = PRODUCT_CATALOGUE_PAGE.goToCartPage();
		CART_PAGE.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(CART_PAGE.verifyProductDisplay(input.get("product")));

		CheckOutPage CHECK_OUT_PAGE = CART_PAGE.goToCheckOutPage();
		CHECK_OUT_PAGE.selectCountry("India");

		ConfirmationPage CONFIRMATION_PAGE = CHECK_OUT_PAGE.submitOrder();
		Assert.assertTrue(CONFIRMATION_PAGE.getConfirmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = { "SubmitOrder" })
	public void orderHistory() {
		ProductCataloguePage PRODUCT_CATALOGUE_PAGE = LANDING_PAGE.loginApplication("sailesh.ramesh@sdet.com",
				"Sdet@2023");
		OrderPage ORDER_PAGE = PRODUCT_CATALOGUE_PAGE.goToOrdersPage();
		Assert.assertTrue(ORDER_PAGE.verifyOrderDisplay(productName.toLowerCase()));
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\eCommerce\\data\\purchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
