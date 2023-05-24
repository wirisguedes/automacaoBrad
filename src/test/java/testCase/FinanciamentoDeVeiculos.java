package testCase;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectFinanciamentoDeVeiculos;
import PageObjects.PageObjectProdutosServicos;
import utils.GerencimanetoDeDrivers;
import utils.Report;
import utils.UtilitariosSelenium;

public class FinanciamentoDeVeiculos {
	
	private String url = "https://banco.bradesco/html/classic/index.shtm";
	private String tipoDeBem = "ATÉ 3 ANOS – ENTRADA ATÉ 30%";
	private String anoFabricacao = "2020";
	private String valorBemSeFinanciado = "100000";
	private String valorEntrada = "30000";
	private String dataPrimeiraParcela = "25/07/2023";
	private String quantiaParcelas = "60";
	private String prazoParcelas = "60 meses";
	private String valorFinanciado = "R$72.348,37";
	
	private WebDriver driver;
	GerencimanetoDeDrivers gerencimanetoDeDrivers;
	
	PageObjectProdutosServicos pageObjectProdutosServicos;
	PageObjectFinanciamentoDeVeiculos pageObjectFinanciamentoDeVeiculos;
	UtilitariosSelenium utilitariosSelenium;
	Report report;
	
	@Before
	public void inicio() {
		gerencimanetoDeDrivers = new GerencimanetoDeDrivers();
		driver = GerencimanetoDeDrivers.abrirBrowser("chrome");
		driver.manage().deleteAllCookies();
		pageObjectProdutosServicos = new PageObjectProdutosServicos(driver);
		pageObjectFinanciamentoDeVeiculos = new PageObjectFinanciamentoDeVeiculos(driver); 
		utilitariosSelenium = new UtilitariosSelenium();
		report = new Report(driver);
	}
	
	@Test
	public void financiamentoDeVeiculos() {
		
		utilitariosSelenium.acessarURL(driver, url);		
		pageObjectProdutosServicos.escolherProdutosEServicos();
		pageObjectFinanciamentoDeVeiculos.acessarFinanciamentoVeiculos();
		pageObjectFinanciamentoDeVeiculos.preencherSimulacao(tipoDeBem, anoFabricacao, valorBemSeFinanciado, valorEntrada, dataPrimeiraParcela, quantiaParcelas);
		pageObjectFinanciamentoDeVeiculos.validarResultadoSimulacao(prazoParcelas, valorFinanciado);	
		
	}
	
	@After
	public void fim() {
		System.out.println("Fim");
	}

}
