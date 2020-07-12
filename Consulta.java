package Mantis;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import HomePagesTests.HomePagesTests;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Consulta {
	String url;
	private static WebDriver driver;
	private HomePagesTests homePage = new HomePagesTests(driver);
	
@Before
public void iniciar() {	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Barbara\\TESTE\\Mantis\\drives\\chrome\\83\\chromedriver.exe");
		
@After 
public void finalizar() {
	driver.quit();
}
	
@Given("^o usuario acessa o site do Mantis$")
	public void o_usu_rio_acessa_o_site_do_Mantis() throws Throwable {
	homePage.carregarPaginaInicial();
	asserthat(homePage.obterTituloPagina(), is ("Minha Visão - MantisBT"));
	   	}

@When("^preenche login e senha e clica em Login$")
public void preenche_login_e_senha_e_clica_em_enter() throws Throwable {
	driver.findElement(By.name("username")).sendKeys(Keys.chord("Barbara.Resende"));
	driver.findElement(By.name("password")).sendKeys(Keys.chord("qaresende"));
	driver.findElement(By.name("button")).click();
    }

@Then("^abre a pagina inicial do Mantis$")
public void abre_a_p_gina_inicial_do_Mantis() throws Throwable {
	  }

@When("^Clico na aba \"([^\"]*)\"$")
public void clico_na_aba(String vercasos) throws Throwable {
	driver.get("https://mantis-prova.base2.com.br/view_all_bug_page.php");   
		}

@Then("^apresenta a lista de casos$")
public void apresenta_a_lista_de_casos() throws Throwable {
	
   }

}
