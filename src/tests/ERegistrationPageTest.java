package tests;

import java.util.Scanner;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CPetStoreMenuPage;
import pages.ERegistrationPage;
import utils.ExcelUtils;

public class ERegistrationPageTest extends ATestTemplate {

	@Test(priority = 1)
	public void userRegistration() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		ERegistrationPage registrationPage = new ERegistrationPage(driver, locators, waiter);

		ExcelUtils petStoreData = new ExcelUtils();
		petStoreData.setExcell("data/pet-store-data.xlsx");
		petStoreData.setWorkSheet(1);

		for (int i = 1; i < petStoreData.getRowNumber(); i++) {

			driver.navigate().to(this.locators.getProperty("e_url"));

			String userID = petStoreData.getDataAt(i, 0);
			String password = petStoreData.getDataAt(i, 1);
			String firstName = petStoreData.getDataAt(i, 2);
			String lastName = petStoreData.getDataAt(i, 3);
			String email = petStoreData.getDataAt(i, 4);
			String phone = petStoreData.getDataAt(i, 5);
			String address1 = petStoreData.getDataAt(i, 6);
			String address2 = petStoreData.getDataAt(i, 7);
			String city = petStoreData.getDataAt(i, 8);
			String state = petStoreData.getDataAt(i, 9);
			String zip = petStoreData.getDataAt(i, 10);
			String country = petStoreData.getDataAt(i, 11);

			registrationPage.userRegistration(userID, password, firstName, lastName, email, phone, address1, address2,
					city, state, zip, country);

			sa.assertTrue(registrationPage.registrationPassed());

		}

		petStoreData.closeExcell();

		sa.assertAll();

	}

	@Test(priority = 2)
	public void newInputUserRegistration() throws InterruptedException {

		SoftAssert sa = new SoftAssert();

		ERegistrationPage registrationPage = new ERegistrationPage(driver, locators, waiter);

		ExcelUtils petStoreData = new ExcelUtils();
		petStoreData.setExcell("data/pet-store-data.xlsx");
		petStoreData.setWorkSheet(1);

		int a = petStoreData.getRowNumber();
		int b = petStoreData.getRowNumber() + 1;

		Scanner s = new Scanner(System.in);

		String userID = petStoreData.getDataAt(a, 0);
		System.out.print("Enter password: ");
		String password = s.next();
		System.out.print("Enter first name: ");
		String firstName = s.next();
		System.out.print("Enter last name: ");
		String lastName = s.next();
		System.out.print("Enter email: ");
		String email = s.next();
		System.out.print("Enter phone: ");
		String phone = s.next();
		System.out.print("Enter address1: ");
		String address1 = s.next();
		System.out.print("Enter address2: ");
		String address2 = s.next();
		System.out.print("Enter city: ");
		String city = s.next();
		System.out.print("Enter state: ");
		String state = s.next();
		System.out.print("Enter zip: ");
		String zip = s.next();
		System.out.print("Enter country: ");
		String country = s.next();

		petStoreData.setDataAt(b, 0, userID);
		petStoreData.setDataAt(b, 1, password);
		petStoreData.setDataAt(b, 2, firstName);
		petStoreData.setDataAt(b, 3, lastName);
		petStoreData.setDataAt(b, 4, email);
		petStoreData.setDataAt(b, 5, phone);
		petStoreData.setDataAt(b, 6, address1);
		petStoreData.setDataAt(b, 7, address2);
		petStoreData.setDataAt(b, 8, city);
		petStoreData.setDataAt(b, 9, state);
		petStoreData.setDataAt(b, 10, zip);
		petStoreData.setDataAt(b, 11, country);

		driver.navigate().to(this.locators.getProperty("e_url"));

		userID = petStoreData.getDataAt(b, 0);
		password = petStoreData.getDataAt(b, 1);
		firstName = petStoreData.getDataAt(b, 2);
		lastName = petStoreData.getDataAt(b, 3);
		email = petStoreData.getDataAt(b, 4);
		phone = petStoreData.getDataAt(b, 5);
		address1 = petStoreData.getDataAt(b, 6);
		address2 = petStoreData.getDataAt(b, 7);
		city = petStoreData.getDataAt(b, 8);
		state = petStoreData.getDataAt(b, 9);
		zip = petStoreData.getDataAt(b, 10);
		country = petStoreData.getDataAt(b, 11);

		registrationPage.userRegistration(userID, password, firstName, lastName, email, phone, address1, address2, city,
				state, zip, country);

		sa.assertTrue(registrationPage.registrationPassed());

		petStoreData.closeExcell();

		sa.assertAll();

	}

}
