package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Report;
import utils.UtilitariosSelenium;


public class PageObjectProdutosServicos extends UtilitariosSelenium{
	
	private WebDriver driver;
	
	public PageObjectProdutosServicos(WebDriver driver) {
		this.driver = driver;
	}
	
	public static final By produtosEServicos = By.xpath("//a[@class='hover-menu']");
	public static final By emprestimosEFinanciamentos = By.xpath("//a[contains(text(),'Empréstimos')]");
	
	
	public void escolherProdutosEServicos() {		
		click(driver, produtosEServicos, 20);
		Report.capturarTela();
		click(driver, emprestimosEFinanciamentos, 20);		
	}

}
