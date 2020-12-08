package br.alves.core;

import static br.alves.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BasePage {

	public void escrever(By by, String texto) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto) {
		escrever(By.id(id_campo), texto);
	}

	public String validarMensagemErro() {
		return getDriver().findElement(By.xpath("//body[@id=\'page-top\']/div[2]/div")).getText();
	}

	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarBotaoSubmit() {
		clicarBotao((By.xpath("//button[@type=\'submit\']")));
	}
}
