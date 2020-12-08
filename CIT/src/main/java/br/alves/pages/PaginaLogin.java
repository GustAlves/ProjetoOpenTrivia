package br.alves.pages;

import static br.alves.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.alves.core.BasePage;

public class PaginaLogin extends BasePage {

	public void setEmail(String login) {
		escrever("username", login);
	}

	public void setSenha(String senha) {
		escrever("password", senha);
	}

	public String validarUsuarioLogado() {
		return getDriver().findElement(By.xpath("//div[@id=\'navbar\']/ul/li[6]/a")).getText();
	}

}
