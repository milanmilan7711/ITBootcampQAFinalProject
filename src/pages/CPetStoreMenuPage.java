package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CPetStoreMenuPage extends APageTemplate {

	public CPetStoreMenuPage(WebDriver driver, Properties locators, WebDriverWait waiter) {
		super(driver, locators, waiter);
	}

	public WebElement getCart() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("c_cart")));
	}

	public WebElement getSignIn() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("c_sign_in")));
	}
	
	public void signIn() {
		this.getSignIn().click();
	}
	
	public WebElement getLoginButton() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("d_login_button")));
	}
	
	public boolean onSignInPage() {
		return this.getLoginButton().isDisplayed();
	}

	public List<WebElement> getHorizontalCategories() {
		List<WebElement> categories = this.driver.findElements(By.xpath(this.locators.getProperty("c_menu_h")));
		return categories;
	}

	public List<WebElement> getVerticalCategories() {
		List<WebElement> categories = this.driver.findElements(By.xpath(this.locators.getProperty("c_menu_v")));
		return categories;
	}

	public List<WebElement> getMapCategories() {
		List<WebElement> categories = this.driver.findElements(By.xpath(this.locators.getProperty("c_menu_m")));
		return categories;
	}
	
	public WebElement getCategoryName() {
		return this.driver.findElement(By.xpath(this.locators.getProperty("c_text")));
	}
	
	public void clickMapCategories() throws InterruptedException {
		for (int i = 0; i < this.getMapCategories().size(); i++) {
			this.getMapCategories().get(i).click();
			this.driver.navigate().back();
		}
	}

	public List<String> returnListHorizontalCategories() {
		List<String> categories = new ArrayList<>();
		for (int i = 0; i < this.getHorizontalCategories().size(); i++) {
			this.getHorizontalCategories().get(i).click();
			categories.add(this.getCategoryName().getText());
			this.driver.navigate().back();
		}
		return categories;
	}
	
	public List<String> returnListVerticalCategories() {
		List<String> categories = new ArrayList<>();
		for (int i = 0; i < this.getVerticalCategories().size(); i++) {
			this.getVerticalCategories().get(i).click();
			categories.add(this.getCategoryName().getText());
			this.driver.navigate().back();
		}
		return categories;
	}
	
	public List<String> returnListMapCategories() {
		List<String> categories = new ArrayList<>();
		for (int i = 0; i < this.getMapCategories().size(); i++) {
			this.getMapCategories().get(i).click();
			categories.add(this.getCategoryName().getText());
			this.driver.navigate().back();
		}
		return categories;
	}
	
	public List<WebElement> getTopMenu() {
		List<WebElement> categories = this.driver.findElements(By.xpath(this.locators.getProperty("c_top_menu")));
		return categories;
	}

	public boolean verifyLinks(List<WebElement> menu) {
		boolean status = false;
		for (int i = 0; i < menu.size(); i++) {
			String url = menu.get(i).getAttribute("href");
			if (this.verifyURLStatus(url) == 404) {
				status = false;
				break;
			}
			status = true;
		}
		return status;
	}

	public int verifyURLStatus(String urlString) {
		int status = 404;
		try {
			URL link = new URL(urlString);
			HttpURLConnection hConn = null;
			hConn = (HttpURLConnection) link.openConnection();
			hConn.setRequestMethod("GET");
			hConn.connect();
			status = hConn.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

}
