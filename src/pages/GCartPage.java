package pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GCartPage extends APageTemplate {

	public GCartPage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		super(driver, locators, waiter);
	}

	public WebElement getEmptyCartText() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("g_empty_text")));
	}

	public List<WebElement> getItemsList() {
		return this.driver.findElements(By.xpath(this.locators.getProperty("g_items_list")));
	}

	public WebElement getProceedButton() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("g_proceed_button")));
	}

	public void clickProceedButton() {
		this.getProceedButton().click();
	}

}
