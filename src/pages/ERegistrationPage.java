package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ERegistrationPage extends APageTemplate {

	public ERegistrationPage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		super(driver, locators, waiter);
	}

	public WebElement getUserId() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_user_id")));
	}

	public WebElement getNewPassword() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_new_password")));
	}

	public WebElement getRepeatPassword() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_repeat_password")));
	}

	public WebElement getFirstName() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_first_name")));
	}

	public WebElement getLastName() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_last_name")));
	}

	public WebElement getEmail() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_email")));
	}

	public WebElement getPhone() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_phone")));
	}

	public WebElement getAddress1() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_address_1")));
	}

	public WebElement getAddress2() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_address_2")));
	}

	public WebElement getCity() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_city")));
	}

	public WebElement getState() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_state")));
	}

	public WebElement getZip() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_zip")));
	}

	public WebElement getCountry() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_country")));
	}

	public WebElement getLanguage() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_language_preference")));
	}

	public WebElement getFavoriteCategory() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_favourite_category")));
	}

	public WebElement getEnableMyList() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_enable_mylist")));
	}

	public WebElement getEnableMyBanner() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_enable_mybanner")));
	}

	public WebElement getSaveButton() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("e_save_button")));
	}

	public void fillInUserID(String userID) {
		this.getUserId().clear();
		this.getUserId().sendKeys(userID);
	}

	public void fillInNewPassword(String newPassword) {
		this.getNewPassword().clear();
		this.getNewPassword().sendKeys(newPassword);
	}

	public void fillInRepeatPassword(String repeatPassword) {
		this.getRepeatPassword().clear();
		this.getRepeatPassword().sendKeys(repeatPassword);
	}

	public void fillInFirstName(String firstName) {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
	}

	public void fillInLasttName(String lastName) {
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
	}

	public void fillInEmail(String email) {
		this.getEmail().clear();
		this.getEmail().sendKeys(email);
	}

	public void fillInPhone(String phone) {
		this.getPhone().clear();
		this.getPhone().sendKeys(phone);
	}

	public void fillInAddress1(String address1) {
		this.getAddress1().clear();
		this.getAddress1().sendKeys(address1);
	}

	public void fillInAddress2(String address2) {
		this.getAddress2().clear();
		this.getAddress2().sendKeys(address2);
	}

	public void fillInCity(String city) {
		this.getCity().clear();
		this.getCity().sendKeys(city);
	}

	public void fillInState(String state) {
		this.getState().clear();
		this.getState().sendKeys(state);
	}

	public void fillInZip(String zip) {
		this.getZip().clear();
		this.getZip().sendKeys(zip);
	}

	public void fillInCountry(String country) {
		this.getCountry().clear();
		this.getCountry().sendKeys(country);
	}

	public void selectLanguage(String language) {
		Select languages = new Select(this.getLanguage());
		languages.selectByVisibleText(language);
	}

	public void selectFavoriteCategory(String favoriteCategory) {
		Select categories = new Select(this.getFavoriteCategory());
		categories.selectByVisibleText(favoriteCategory);
	}

	public void clickEnableMyList(boolean myList) {
		if (myList) {
			this.getEnableMyList().click();
		}
	}

	public void clickEnableMyBanner(boolean myBanner) {
		if (myBanner) {
			this.getEnableMyBanner().click();
		}
	}

	public void clickSaveButton() {
		this.getSaveButton().click();
	}

	public void userRegistration(String userID, String password, String firstName, String lastName, String email,
			String phone, String address1, String address2, String city, String state, String zip, String country) {
		this.fillInUserID(userID);
		this.fillInNewPassword(password);
		this.fillInRepeatPassword(password);
		this.fillInFirstName(firstName);
		this.fillInLasttName(lastName);
		this.fillInEmail(email);
		this.fillInPhone(phone);
		this.fillInAddress1(address1);
		this.fillInAddress2(address2);
		this.fillInCity(city);
		this.fillInState(state);
		this.fillInZip(zip);
		this.fillInCountry(country);
		this.clickSaveButton();
	}

	public void userRegistrationFull(String userID, String password, String firstName, String lastName, String email,
			String phone, String address1, String address2, String city, String state, String zip, String country,
			String language, String category) {
		this.fillInUserID(userID);
		this.fillInNewPassword(password);
		this.fillInRepeatPassword(password);
		this.fillInFirstName(firstName);
		this.fillInLasttName(lastName);
		this.fillInEmail(email);
		this.fillInPhone(phone);
		this.fillInAddress1(address1);
		this.fillInAddress2(address2);
		this.fillInCity(city);
		this.fillInState(state);
		this.fillInZip(zip);
		this.fillInCountry(country);
		this.selectLanguage(language);
		this.selectFavoriteCategory(category);
		this.clickSaveButton();
	}

	public WebElement getLogo() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("c_logo")));
	}

	public boolean registrationPassed() {
		return this.getLogo().isDisplayed();
	}

}
