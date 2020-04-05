package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BHomePage;

public class BEnterStoreTest extends ATestTemplate {

	@Test
	public void EnterStoreTest() throws InterruptedException {

		driver.navigate().to(this.locators.getProperty("b_url"));

		BHomePage hp = new BHomePage(driver, locators, waiter);
		hp.enterStore();

		Assert.assertTrue(hp.inStore());
	}

}
