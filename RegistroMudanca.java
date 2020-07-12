package Mantis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.io.File;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import HomePagesTests.HomePagesTests;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class RegistroMudanca {
	String url;
	private static WebDriver driver;
	private HomePagesTests homePage = new HomePagesTests(driver);
	
@Before
public void iniciar() {
	url = "https://mantis-prova.base2.com.br/";
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Barbara\\TESTE\\Mantis\\drives\\chrome\\83\\chromedriver.exe");
	driver = new ChromeDriver();
}
	
	@Dado("^que o usuario acessa a ferramenta Mantis$")
	public void que_o_usuario_acessa_a_ferramenta_Mantis() throws Throwable {
		homePage.carregarPaginaInicial();
		asserthat(homePage.obterTituloPagina(), is ("Minha Visão - MantisBT"));
		
			}
	
	@Quando("^preenche login e senha em seguida clica em enter$")
	public void preenche_login_e_senha_em_seguida_clica_em_enter(String username, String password) throws Throwable {
		driver.findElement(By.name("username")).sendKeys(Keys.chord("Barbara.Resende"));
		driver.findElement(By.name("password")).sendKeys(Keys.chord("qaresende"));
		driver.findElement(By.name("button")).click();
	}

	@Entao("^abre a pagina inicial do Mantis$")
	public void abre_a_p_gina_inicial_do_Mantis() throws Throwable {
		
	}

	@Quando("^acesso a aba de \"([^\"]*)\"$")
	public void acesso_a_aba_de(String button) throws Throwable {
		
		driver.get("https://mantis-prova.base2.com.br/bug_report_page.php");
		assertTrue("Titulo diferente do esperado", driver.getTitle().contentEquals("Selecionar Projeto"));
		WebElement SelecionarProjeto = driver.findElement(By.name("project_id"));
				Select combobox = new Select(SelecionarProjeto);
				combobox.selectByVisibleText("Desafio jMeter Project 1");
				driver.findElement(By.cssSelector("Selecionar Projeto")).click();
				assertEquals("Selecionar Projeto", driver.findElement(By.cssSelector("Selecionar Projeto")).getText());
				}

	@Entao("^exibe um relatorio a ser preenchido$")
	public void exibe_um_relatorio_a_ser_preenchido() throws Throwable {
		
		WebElement Categoria = driver.findElement(By.name("category_id"));
		Select combobox = new Select(Categoria);
		combobox.selectByVisibleText("[Todos os Projetos] Teste");
		assertEquals("[Todos os Projetos] Teste", driver.findElement(By.cssSelector("Selecionar Projeto")).getText());
		WebElement Frequencia = driver.findElement(By.name("reproducibility"));
		Select combobox1 = new Select(Frequencia);
		combobox1.selectByVisibleText("sempre");
		assertEquals("sempre", driver.findElement(By.cssSelector("Selecionar Projeto")).getText());
		WebElement Gravidade = driver.findElement(By.name("severity"));
		Select combobox2 = new Select(Gravidade);
		combobox2.selectByVisibleText("pequeno");
		assertEquals("pequeno", driver.findElement(By.cssSelector("Selecionar Projeto")).getText());
		WebElement Prioridade = driver.findElement(By.name("priority"));
		Select combobox3 = new Select(Prioridade);
		combobox3.selectByVisibleText("normal");
		assertEquals("normal", driver.findElement(By.cssSelector("Selecionar Projeto")).getText());
		WebElement Perfil = driver.findElement(By.name("profile_id"));
		Select combobox4 = new Select(Perfil);
		combobox4.selectByVisibleText("Desktop  Windows 10");
		assertEquals("Perfil", driver.findElement(By.cssSelector("Selecionar Projeto")).getText());
		driver.findElement(By.id("platform")).sendKeys(Keys.chord(""));
		driver.findElement(By.id("os")).sendKeys(Keys.chord(""));
		driver.findElement(By.id("os_build")).sendKeys(Keys.chord(""));
		driver.findElement(By.name("summary")).sendKeys(Keys.chord("Compra sendo finalizada indevidamente"));
		driver.findElement(By.name("description")).sendKeys(Keys.chord("Ao incluir um item no carrinho a compra é finalizada sem clicar no botão"));
		driver.findElement(By.name("steps_to_reproduce")).sendKeys(Keys.chord("Nenhum"));
		driver.findElement(By.name("additional_info")).sendKeys(Keys.chord("Nenhum"));
		
	}

	@Quando("^preencho o relatorio  e seleciono um arquivo$")
	public void preencho_o_relat_rio_e_seleciono_um_arquivo() throws Throwable {
	   
	}

	@Entao("^clico em enviar relatorio$")
	public void clico_em_enviar_relatorio() throws Throwable {
		driver.findElement(By.cssSelector("Enviar Relatario")).click();
		assertEquals("Enviar Relatario", driver.findElement(By.cssSelector("Enviar Relatario")).getText());
	}
	@After
	public void finalizar() {
		driver.quit();
	}
	
	}




