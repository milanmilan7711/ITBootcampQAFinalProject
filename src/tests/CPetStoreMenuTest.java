package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CPetStoreMenuPage;

public class CPetStoreMenuTest extends ATestTemplate {

	@Test
	public void verifyLinksInAllMenus() throws InterruptedException {

		driver.navigate().to(this.locators.getProperty("c_url"));

		SoftAssert sa = new SoftAssert();

		CPetStoreMenuPage ps = new CPetStoreMenuPage(driver, locators, waiter);
		boolean topMenu = ps.verifyLinks(ps.getTopMenu());
		boolean horizontalMenu = ps.verifyLinks(ps.getHorizontalCategories());
		boolean verticalMenu = ps.verifyLinks(ps.getVerticalCategories());
		boolean mapMenu = ps.verifyLinks(ps.getMapCategories());

		sa.assertTrue(topMenu, "Verification failed for Top Menu");
		sa.assertTrue(horizontalMenu, "Verification failed for Horizontal Menu");
		sa.assertTrue(verticalMenu, "Verification failed for Vertical Menu");
		sa.assertTrue(mapMenu, "Verification failed for Map Menu");

		sa.assertAll();

	}

	@Test
	public void categoriesLinksRightPath() throws InterruptedException {

		driver.navigate().to(this.locators.getProperty("c_url"));

		CPetStoreMenuPage ps = new CPetStoreMenuPage(driver, locators, waiter);

		List<String> categoriesHorizontalGuess = new ArrayList<>(
				Arrays.asList("Fish", "Dogs", "Reptiles", "Cats", "Birds"));
		List<String> categoriesVerticalGuess = new ArrayList<>(
				Arrays.asList("Fish", "Dogs", "Cats", "Reptiles", "Birds"));
		List<String> categoriesMapGuess = new ArrayList<>(
				Arrays.asList("Birds", "Fish", "Dogs", "Reptiles", "Cats", "Birds"));

		Assert.assertTrue(categoriesHorizontalGuess.equals(ps.returnListHorizontalCategories()));
		Assert.assertTrue(categoriesVerticalGuess.equals(ps.returnListVerticalCategories()));
		Assert.assertTrue(categoriesMapGuess.equals(ps.returnListMapCategories()));

	}

	@Test
	public void pathToSignInPage() throws InterruptedException {

		driver.navigate().to(this.locators.getProperty("c_url"));

		CPetStoreMenuPage ps = new CPetStoreMenuPage(driver, locators, waiter);
		ps.signIn();

		Assert.assertTrue(ps.onSignInPage());

	}

}
