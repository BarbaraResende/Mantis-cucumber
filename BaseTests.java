package BasesTests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseTests {
	static WebDriver driver;	

	@Before
	public static void inicializar(ChromeDriver driver) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Barbara\\TESTE\\Mantis\\drives\\chrome\\83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After(order  = 1)
	public void capturarTela(Scenario scenario) {
		TakesScreenshot camera = (TakesScreenshot) driver;
		File capturaDeTela = camera.getScreenshotAs(OutputType.FILE);
		String	nomeArquivo = "resources/screenshots/" + scenario.getName() + "_" + scenario.getStatus() + ".png";
		System.out.println(nomeArquivo);
		try {
			Files.move(capturaDeTela, new File(nomeArquivo));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@After(order  = 0)
	public void finalizar() {
		driver.quit();
	}
	}
