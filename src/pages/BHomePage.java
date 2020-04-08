package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BHomePage extends APageTemplate {

	public BHomePage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		super(driver, locators, waiter);
	}

	public WebElement getEnter() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("b_enter")));
	}

	public void enterStore() {
		this.getEnter().click();
	}

	public WebElement getLogo() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("c_logo")));
	}

	public boolean inStore() {
		return this.getLogo().isDisplayed();
	}

}
