package br.alves.pages;

import static br.alves.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.alves.core.BasePage;

public class PaginaAdicionarQuestao extends BasePage {

	public String validarMensagemErro() {
		return getDriver().findElement(By.xpath("//body[@id=\'page-top\']/div/div")).getText();
	}
}
