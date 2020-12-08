package br.alves.pages;

import static br.alves.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.alves.core.BasePage;

public class PaginaPesquisa extends BasePage {
	
	public void pesquisarTexto(String texto) {
		escrever("query", texto);
	}

	public void selecionarItemDePesquisa(String itemPesquisa) {
		WebElement dropdown = getDriver().findElement(By.id("type"));
		dropdown.findElement(By.xpath("//option[. = '" + itemPesquisa + "']")).click();
	}

	public void validarExibicaoPaginacao() {
		List<WebElement> paginacao = getDriver().findElements(By.linkText("1"));
		assert (paginacao.size() > 0);
	}

	public int validarTotalItensRetornadosPesquisa(int qtdItens) {
		List<WebElement> itens = getDriver()
				.findElements(By.xpath("//body[@id=\'page-top\']/div[2]/table/tbody/tr[" + qtdItens + "]/td"));
		assert (itens.size() > 0);

		List<WebElement> rowCount = getDriver()
				.findElements(By.xpath("//body[@id=\'page-top\']/div[2]/table/tbody/tr"));
		return rowCount.size();
	}
}
