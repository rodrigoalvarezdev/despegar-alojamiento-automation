package alojamientoDespegar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseAlojamiento {
	WebDriver driver;
	WebDriverWait wait;
	Select select;
	
	public BaseAlojamiento(WebDriver driver, WebDriverWait wait, Select select) {
		this.driver = driver;
		this.wait = wait;
		this.select = select;
	}
	
	public WebDriver connection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public Select selectElement(By locator) {
		return select = new Select(driver.findElement(locator));
	}
	
	public WebElement waiting(By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void sendText(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
}
