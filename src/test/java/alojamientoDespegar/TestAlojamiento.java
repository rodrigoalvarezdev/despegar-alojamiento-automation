package alojamientoDespegar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAlojamiento {
  private WebDriver driver;
  private PageAlojamiento page;
  WebDriverWait wait;
  Select select;
  
  @BeforeMethod
  public void setUp() {
	  System.out.println("-------------------");
	  System.out.println("comenzando el test");
	  System.out.println("-------------------");
	  page = new PageAlojamiento(driver, wait, select);
	  driver = page.connection();
	  page.visit("https://www.despegar.com.ar/hoteles/");
  }
  
  @DataProvider
  public Object[][] data() {
	return new Object[][] {
		{"men", "3 años"}
	};
	  
  }
  
  
  
  @Test(description = "validar happy path de alojamiento", enabled = true, dataProvider = "data")
  public void test(String ciudad, String edad) throws InterruptedException{
	 page.closeModal();
	 page.inputDestino(ciudad);
	 page.calendarioFechas();
	 page.inputHabitaciones(edad);
	 page.clickBuscar();
	 Assert.assertTrue(driver.findElement(page.tituloValidar()).isDisplayed());
	 page.clickImg();
	 page.switchHandles();
	 Assert.assertTrue(driver.findElement(page.resultTitle()).isDisplayed());
	 Thread.sleep(5000);
  }
  
  @AfterMethod
  public void tearDown(ITestResult result) {
	  System.out.println(result.getMethod().getDescription());
	  System.out.println(result.getStatus());
	  System.out.println("-------------------");
	  System.out.println("terminando el test");
	  System.out.println("-------------------");
	  driver.quit();
  }
}
