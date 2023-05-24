package PageObjects;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Report;
import utils.UtilitariosSelenium;

public class PageObjectFinanciamentoDeVeiculos extends UtilitariosSelenium {

	private WebDriver driver;

	public PageObjectFinanciamentoDeVeiculos(WebDriver driver) {
		this.driver = driver;
	}

	public static final By financiamentoVeiculos = By.xpath("//h3[contains(text(),'Financiamento')]");
	public static final By seletorTipoDeBem = By.xpath("//select[@id='ddlTipoBem']");
	public static final By seletorAnoFabricacao = By.xpath("//select[@id='ddlAno']");
	public static final By inputValorBemASerFinanciado = By.xpath("//input[@name='txtVl']");
	public static final By btnOkValorBemASerFinanciado = By.xpath("//input[@value='Ok']");
	public static final By inputValorEntrada = By.xpath("//input[@name='txtVlEntrada']");
	public static final By btnValorEntrada = By.xpath("//input[@name='btnTxtVlEntrada']");
	public static final By inputDataPrimeiraParcela = By.xpath("//input[@name='txtDataPrimeiraParcela']");
	public static final By inputQuantiaParcelas = By.xpath("//input[@name='txtQtdeParc']");
	public static final By btnQuantiaParcelas = By.xpath("//input[@name='btnQtdeParc']");
	public static final By btnFecharDiretivaPrivacidade = By.xpath("//a[text()='Fechar']");
	public static final By labelPrazo = By.xpath("//span[@id='lblResPrazo']");
	public static final By labelValorFinanciado = By.xpath("//span[@id='lblResVlFinanc']");
	public static final By labelResultado = By.xpath("//h3[text()='Resultado da simulação *']");

	public void acessarFinanciamentoVeiculos() {
		click(driver, btnFecharDiretivaPrivacidade, 20);
		scroll(driver, 700);
		Report.capturarTela();
		click(driver, financiamentoVeiculos, 30);
	}

	public void preencherSimulacao(String tipoDeBem, String anoFabricacao, String valorBemSeFinanciado,
			String valorEntrada, String dataPrimeiraParcela, String quantiaParcelas) {
		// ir para a nova aba aberta
		ArrayList<String> abas = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));

		// acessar iframe Simuladores
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iframeSimuladores']"));
		driver.switchTo().frame(iframe);

		click(driver, btnFecharDiretivaPrivacidade, 20);

		if (elementoEstaPresente(driver, seletorTipoDeBem, 30)) {
			selecionarPorTexto(driver, seletorTipoDeBem, tipoDeBem, 30);
		} else {
			Assert.fail("Erro tentar selecionar Tipo de Bem");
		}

		if (elementoEstaPresente(driver, seletorAnoFabricacao, 20)) {
			selecionarPorTexto(driver, seletorAnoFabricacao, anoFabricacao, 30);
		} else {
			Assert.fail("Erro tentar selecionar Ano de Fabricação");
		}

		System.out.println("LOG: Tipo de Bem e Ano de Fabricação selecionados com Sucesso ");
		Report.capturarTela();

		enviarDadosJS(driver, inputValorBemASerFinanciado, valorBemSeFinanciado, 20);
		click(driver, btnOkValorBemASerFinanciado, 20);
		enviarDadosJS(driver, inputValorEntrada, valorEntrada, 20);
		click(driver, btnValorEntrada, 20);
		enviarDados(driver, inputDataPrimeiraParcela, dataPrimeiraParcela, 20).sendKeys(Keys.ENTER);
		enviarDadosJS(driver, inputQuantiaParcelas, quantiaParcelas, 20);
		click(driver, btnQuantiaParcelas, 20);
		Report.capturarTela();
	}

	public void validarResultadoSimulacao(String valorEsperadoPrazo, String valorEsperadoValorFinanciado) {

		if (elementoEstaPresente(driver, labelResultado, 20)) {
			System.out.println("LOG: Resultado da simulação Apresentado com Sucesso ");
		} else {
			Assert.fail("Erro ao validar Resultado da simulação");
		}

		String textoInterfacePrazo = pegarTexto(driver, labelPrazo, 20);

		if (valorEsperadoPrazo.equalsIgnoreCase(textoInterfacePrazo)) {
			System.out.println("LOG: Prazo validado com sucesso " + textoInterfacePrazo);
		} else {
			Assert.fail("Erro ao validar Prazo");
		}

		String textoInterfaceValorFinanciado = pegarTexto(driver, labelValorFinanciado, 20);

		if (valorEsperadoValorFinanciado.equalsIgnoreCase(textoInterfaceValorFinanciado)) {
			System.out.println("LOG: Valor financiado validado com Sucesso " + textoInterfaceValorFinanciado);
		} else {
			Assert.fail("Erro ao validar Valor financiado");
		}

		Report.capturarTela();

	}

}
