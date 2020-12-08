
import static br.alves.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.alves.core.DriverFactory;
import br.alves.core.Properties;
import br.alves.pages.PaginaPrincipal;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", monochrome = true)
public class Runner {

	private static PaginaPrincipal page = new PaginaPrincipal();

	@Rule
	public static TestName testName = new TestName();

	@BeforeClass
	public static void acessarSite() {
		page.acessarTelaInicial();
	}

	@AfterClass
	public static void finalizaTudo() throws IOException {

		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(
				"target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));

		if (Properties.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}
	}
}
