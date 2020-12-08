package br.alves.pages;

import static br.alves.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.alves.core.BasePage;

public class PaginaPrincipal extends BasePage {

	public void acessarTelaInicial() {
		getDriver().get("https://opentdb.com/");
	}

	public void clicarBotaoPorTexto(String texto) {
		clicarBotao(By.xpath("//a[contains(text(),\'" + texto + "')]"));
	}

	public void deslogar() {
		clicarBotao(By.xpath("//a[contains(text(),\'gustavoalves\')]"));
		clicarBotao(By.xpath("//a[contains(text(),\'Logout\')]"));
	}
}
