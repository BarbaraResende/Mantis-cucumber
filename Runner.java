package Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "scr\\teste\\resources\\RegistroMudanca.features",
		glue     = "Mantis",
		tags     = "@RegistroMudanca",
		plugin   = {"pretty"},
		monochrome = true		
		)

public class Runner {

}
