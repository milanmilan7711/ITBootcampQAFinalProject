package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class APageTemplate {

	protected WebDriver driver;
	protected Properties locators;
	protected WebDriverWait waiter;

	public APageTemplate(WebDriver driver, Properties locators, WebDriverWait waiter) {
		this.driver = driver;
		this.locators = locators;
		this.waiter = waiter;
	}

}
