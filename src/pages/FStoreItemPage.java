package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FStoreItemPage extends APageTemplate {

	public FStoreItemPage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		super(driver, locators, waiter);
	}

	public WebElement getAddToCart() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("f_add_button")));
	}

	public void clickAddToCart() {
		this.getAddToCart().click();
	}

}
