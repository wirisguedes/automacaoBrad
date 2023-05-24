package utils;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilitariosSelenium {

	public void acessarURL(WebDriver driver, String url) {
		driver.get(url);
	}

	public static void click(WebDriver driver, By by, int tempoEspera) {

		try {
			WebElement elemento = (new WebDriverWait(driver, Duration.ofSeconds(tempoEspera)))
					.until(ExpectedConditions.elementToBeClickable(by));
			elemento.click();
			return;
		} catch (Exception e) {
			System.err.println("Erro na acao de click no elemento:" + e.getMessage());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		}

	}

	public void scroll(WebDriver driver, int quantia) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + quantia + ")", "");
	}

	public void scrollParaElemento(WebDriver driver, By by, int tempoEspera) {
		boolean isPresente = elementoEstaPresente(driver, by, tempoEspera);

		if (isPresente) {
			WebElement element = driver.findElement(by);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} else {
			Assert.fail("Erro ao obter elemento para realizar scroll");
		}
	}

	public boolean elementoEstaPresente(WebDriver driver, By by, int tempoEspera) {
		boolean estaPresente;
		try {
			WebElement elemento = driver.findElement(by);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
			estaPresente = true;
			return estaPresente;
		} catch (Exception e) {
			System.out.println(e.toString());
			estaPresente = false;
			return estaPresente;
		}
	}

	public void selecionarPorTexto(WebDriver driver, By by, String texto, int tempoEspera) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(tempoEspera))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
			WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(by));

			Select selector = new Select(elemento);
			selector.selectByVisibleText(texto);

		} catch (Exception e) {
			Assert.fail("Erro ao selecionar por texto : " + e.getMessage());
		}
	}

	public WebElement enviarDados(WebDriver driver, By by, String valor, int tempoEspera) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tempoEspera));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
			WebElement elemento = driver.findElement(by);
			elemento.click();
			elemento.clear();
			elemento.sendKeys(valor.trim());
			return elemento;
		} catch (Exception e) {
			System.out.println("Erro ao enviar dados");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		return null;
	}

	public static void enviarDadosJS(WebDriver driver, By locator, String text, int time) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement elemento = driver.findElement(locator);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].value='" + text + "'", elemento);
	}

	public String pegarTexto(WebDriver driver, By by, int tempoEspera) {
		String valorObtido = "";

		WebElement elemento = driver.findElement(by);
		valorObtido = elemento.getText();
		return valorObtido;

	}
}
