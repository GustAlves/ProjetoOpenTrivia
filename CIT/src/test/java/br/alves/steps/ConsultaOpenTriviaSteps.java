package br.alves.steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import br.alves.pages.PaginaPesquisa;
import br.alves.pages.PaginaPrincipal;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class ConsultaOpenTriviaSteps {

	private static PaginaPrincipal page = new PaginaPrincipal();
	private static PaginaPesquisa pagePesquisa = new PaginaPesquisa();

	@Dado("^que navego para a página de busca do banco de questões$")
	public void que_navego_para_a_página_de_busca_do_banco_de_questões() throws Throwable {
		page.clicarBotaoPorTexto("Browse");
	}

	@Dado("^digito 'Science: Computers' no campo de busca$")
	public void digito_Science_Computers_no_campo_de_busca() throws Throwable {
		pagePesquisa.pesquisarTexto("Science: Computers");
	}

	@Quando("^clico no botão de buscar$")
	public void clico_no_botão_de_buscar() throws Throwable {
		page.clicarBotao((By.xpath("//body[@id=\'page-top\']/div/form/div/button")));
	}

	@Então("^visualizo uma mensagem de erro com o texto 'No questions found\\.'$")
	public void visualizo_uma_mensagem_de_erro_com_o_texto_No_questions_found() throws Throwable {
		Assert.assertEquals("No questions found.", page.validarMensagemErro());
	}

	@Dado("^seleciono a busca por Categoria$")
	public void seleciono_a_busca_por_Categoria() throws Throwable {
		pagePesquisa.selecionarItemDePesquisa("Category");
	}

	@Então("^visualizo a quantidade de (\\d+) itens exibidos$")
	public void visualizo_a_quantidade_de_itens_exibidos(int qtdItens) throws Throwable {
		Assert.assertEquals(25, pagePesquisa.validarTotalItensRetornadosPesquisa(qtdItens));

	}

	@Então("^visualizo o controle de paginação$")
	public void visualizo_o_controle_de_paginação() throws Throwable {
		pagePesquisa.validarExibicaoPaginacao();
	}
}
