package alojamientoDespegar;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAlojamiento extends BaseAlojamiento{
	By cerrarModal = By.xpath("//nav/div[4]/div[1]/i");
	By inputDestinoLocator = By.xpath("//div[@class='sbox5-box-container']/div[3]/div[1]/div/div/div/input");
	By inputFechaEntLocator = By.xpath("//div[@class='sbox5-box-dates-ovr sbox5-dates-container']/div[1]/div/div/div/div/input");
	By inputFechaSalLocator = By.xpath("//div[@class='sbox5-box-dates-ovr sbox5-dates-container']/div[2]/div/div/div/div/input");
	By diaEntradaLocator = By.xpath("//div[@class='sbox5-monthgrid'][1]/div[3]/div[15]");
	By diaSalidaLocator = By.xpath ("//div[@class='sbox5-monthgrid'][2]/div[3]/div[10]");
	By btnaplicarCalenLocator = By.xpath("//*[@id='component-modals']/div[1]/div[2]/div[1]/button");
	By inputHabLocator = By.xpath("//div[@class='sbox5-distributionPassengers sbox5-box-distributionPassengers-ovr']/div/div/div[1]/input");
	By btnMasAdulto = By.xpath("//div[@class='stepper__room']/div[2]/div[1]/div[2]/div/button[2]");
	By btnMenosAdulto = By.xpath("//div[@class='stepper__room']/div[2]/div[1]/div[2]/div/button[1]");
	By btnMasNino = By.xpath("//div[@class='stepper__room']/div[2]/div[2]/div[2]/div/button[2]");
	By btnMenosNino = By.xpath("//div[@class='stepper__room']/div[2]/div[2]/div[2]/div/button[1]");
	By selectNino = By.xpath("//div[@class='stepper__room']/div[2]/div[3]/div[2]/div/div/select");
	By btnBuscar = By.xpath("//div[@class='sbox5-box-container']/div[3]/button");
	By btnAplicarHabLocator = By.xpath("//div[@id='component-modals']/div[2]/div/div/div[2]/a[1]");
	By tituloValidar = By.xpath("//div[@class='sbox5-box-header']/div/div/h1");
	By imgCard = By.xpath("//div/aloha-cluster-container/div[1]/div/div[1]/div/div");
	By resultTitle = By.xpath("//h1[@class='accommodation-name eva-3-h2']");
	By menuInputLoc = By.xpath("//div[@class='ac-wrapper -desktop -show sbox-ab-ls']/div/div[2]/ul/li[1]");
	By menu = By.xpath("//div[@class='ac-container']");
	
	public PageAlojamiento(WebDriver driver, WebDriverWait wait, Select select) {
		super(driver, wait, select);
	}
	
	public void closeModal() {
		waiting(cerrarModal);
		click(cerrarModal);
	}
	
	public void inputDestino(String text) throws InterruptedException {
		click(inputDestinoLocator);
		Thread.sleep(500);
		sendText(inputDestinoLocator, text);
		waiting(menu);
		click(menuInputLoc);
	}
	
	public void calendarioFechas() {
		click(inputFechaEntLocator);
		waiting(diaEntradaLocator);
		click(diaEntradaLocator);
		click(inputFechaSalLocator);
		waiting(diaSalidaLocator);
		click(diaSalidaLocator);
		click(btnaplicarCalenLocator);
	}
	
	public void inputHabitaciones(String text) {
		click(inputHabLocator);
		waiting(btnMasAdulto);
		click(btnMasAdulto);
		click(btnMasNino);
		selectElement(selectNino).selectByVisibleText(text);
		click(btnAplicarHabLocator);
	}
	
	public void clickBuscar() {
		click(btnBuscar);
	}
	
	public By tituloValidar() {
		return tituloValidar;
	}
	
	public void clickImg() {
		click(imgCard);
	}
	
	public void switchHandles() {
		Set <String> handles = driver.getWindowHandles();
		for (String actual : handles) {
			if(!actual.equalsIgnoreCase(driver.getWindowHandle())) {
				driver.switchTo().window(actual);
			}
		}
	}
	
	public By resultTitle() {
		return resultTitle;
	}
}
