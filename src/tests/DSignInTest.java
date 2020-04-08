package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.DSignInPage;
import pages.ERegistrationPage;
import utils.ExcelUtils;

public class DSignInTest extends ATestTemplate {

	@Test
	public void testingUserSignIn() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		DSignInPage signInPage = new DSignInPage(driver, locators, waiter);

		ExcelUtils petStoreData = new ExcelUtils();
		petStoreData.setExcell("data/pet-store-data.xlsx");
		petStoreData.setWorkSheet(1);

		for (int i = 1; i < petStoreData.getRowNumber(); i++) {

			driver.navigate().to(this.locators.getProperty("d_url"));

			String userID = petStoreData.getDataAt(i, 0);
			String password = petStoreData.getDataAt(i, 1);

			signInPage.userLogin(userID, password);

			sa.assertTrue(signInPage.signInPassed());

		}

		petStoreData.closeExcell();

		sa.assertAll();

	}

}
