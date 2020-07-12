package HomePagesTests;

import org.openqa.selenium.WebDriver;

public class HomePagesTests {

	private static WebDriver driver;
	
	public HomePagesTests(WebDriver driver) {
		
	}

	public void carregarPaginaInicial() {
		driver.get("https://mantis-prova.base2.com.br/");
		
	}

	public String obterTituloPagina() {
		return driver.getTitle();
		 
	}

}
