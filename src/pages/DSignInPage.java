package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSignInPage extends APageTemplate {

	public DSignInPage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		super(driver, locators, waiter);
	}

	public WebElement getUsername() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("d_username")));
	}

	public WebElement getPassword() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("d_password")));
	}

	public WebElement getLogin() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("d_login_button")));
	}

	public WebElement getRegisterNow() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("d_regnow_button")));
	}

	public WebElement getSignInSucceed() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("d_welcome")));
	}

	public WebElement getSignInFailed() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("d_sign_in_failed")));
	}

	public void fillInUsername(String username) {
		this.getUsername().clear();
		this.getUsername().sendKeys(username);
	}

	public void fillInPassword(String password) {
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
	}

	public void clickLogin() {
		this.getLogin().click();
	}

	public void clickRegisterNow() {
		this.getRegisterNow().click();
	}

	public void userLogin(String username, String password) {
		this.fillInUsername(username);
		this.fillInPassword(password);
		this.clickLogin();
	}

	public boolean signInPassed() {
		return this.getSignInSucceed().getText().contains("Welcome");
	}

}
