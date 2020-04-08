package pages;

import java.util.ArrayList;
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
	
	public List<WebElement> getItemsId() {
		return this.driver.findElements(By.xpath(this.locators.getProperty("g_items_id")));
	}
	
	public List<String> returnListItemsId() {
		List<String> itemIDs = new ArrayList<>();
		for (int i = 0; i < this.getItemsId().size(); i++) {
			itemIDs.add(this.getItemsId().get(i).getText());
		}
		return itemIDs;
	}
	
	public List<WebElement> getItemsPrice() {
		return this.driver.findElements(By.xpath(this.locators.getProperty("g_items_price")));
	}
	
	public List<String> returnItemsPrice() {
		List<String> itemPrice = new ArrayList<>();
		for (int i = 0; i < this.getItemsPrice().size(); i++) {
			itemPrice.add(this.getItemsPrice().get(i).getText());
		}
		return itemPrice;
	}
	
	public void clickProceedButton() {
		this.getProceedButton().click();
	}

}
