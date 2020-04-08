package tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.ERegistrationPage;
import pages.FStoreItemPage;
import pages.GCartPage;
import utils.ExcelUtils;

public class GCartTest extends ATestTemplate {

	@Test(priority = 1)
	public void cartAllItemsIn() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		GCartPage cartPage = new GCartPage(driver, locators, waiter);

		this.driver.navigate().to(this.locators.getProperty("g_url"));

		ExcelUtils petStoreData = new ExcelUtils();
		petStoreData.setExcell("data/pet-store-data.xlsx");
		petStoreData.setWorkSheet(0);

		String link = petStoreData.getDataAt(1, 1);

		List<String> itemsListGuess = new ArrayList<String>();

		for (int i = 1; i < petStoreData.getRowNumber(); i++) {

			this.driver.navigate().to(petStoreData.getDataAt(i, 1));

			FStoreItemPage pet = new FStoreItemPage(driver, locators, waiter);

			pet.clickAddToCart();

			itemsListGuess.add(petStoreData.getDataAt(i, 0));

		}

		petStoreData.closeExcell();

		Assert.assertTrue(itemsListGuess.equals(cartPage.returnListItemsId()));

		sa.assertAll();

	}

	@Test(priority = 2)
	public void isCartEmptyWithoutCookies() throws InterruptedException {

		this.driver.navigate().to(this.locators.getProperty("g_url"));
		this.driver.manage().deleteAllCookies();
		this.driver.navigate().refresh();

		GCartPage cartPage = new GCartPage(driver, locators, waiter);

		boolean empty = cartPage.getEmptyCartText().getText().contains("empty");

		Assert.assertTrue(empty);

	}

}
