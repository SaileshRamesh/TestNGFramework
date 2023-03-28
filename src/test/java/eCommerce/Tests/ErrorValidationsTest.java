package eCommerce.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;



import eCommerce.TestComponents.BaseTest;
import eCommerce.TestComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups={"errorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws InterruptedException, IOException {

		LANDING_PAGE.loginApplication("sailesh.ramesh@sdet.com",
				"ErrorValidation@2023");
		Assert.assertEquals(LANDING_PAGE.getErrorMessage(), "Incorrect email or password.");
		
	}
}
