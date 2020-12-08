package br.alves.steps;

import org.junit.Assert;

import br.alves.pages.PaginaAdicionarQuestao;
import br.alves.pages.PaginaPrincipal;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class AdicionarQuestaoOpenTriviaSteps {

	private static PaginaPrincipal page = new PaginaPrincipal();
	private static PaginaAdicionarQuestao paginaAdd = new PaginaAdicionarQuestao();

	@Dado("^que navego para a página de ADD NEW QUESTIONS$")
	public void que_navego_para_a_página_de_ADD_NEW_QUESTIONS() throws Throwable {
		page.clicarBotaoPorTexto("Add New Questions");
	}

//	@Dado("^informo o titulo da questão \"([^\"]*)\"$")
//	public void informo_o_titulo_da_questão(String titulo) throws Throwable {
//		page.escrever("trivia_question", titulo);
//	}

	@Quando("^clicar em SUBMIT$")
	public void clicar_em_SUBMIT() throws Throwable {
		page.clicarBotaoSubmit();
	}

	@Dado("^informo uma referencia \"([^\"]*)\"$")
	public void informo_uma_referencia(String referencia) throws Throwable {
		page.escrever("trivia_reference", referencia);
	}

	@Entao("^sistema exibe mensagem de erro \"([^\"]*)\"$")
	public void sistema_exibe_mensagem_de_erro(String mensagemErro) throws Throwable {
		Assert.assertEquals(mensagemErro, paginaAdd.validarMensagemErro());
		page.deslogar();
	}

	@Dado("^informo o titulo da questão (.*)$")
	public void informo_o_titulo_da_questão(String titulo) throws Throwable {
		page.escrever("trivia_question", titulo);
	}

	@Dado("^informo uma resposta correta \"([^\"]*)\"$")
	public void informo_uma_resposta_correta(String respostaCorreta) throws Throwable {
		page.escrever("correct_answer", respostaCorreta);
	}

	@Dado("^informo uma resposta incorreta \"([^\"]*)\"$")
	public void informo_uma_resposta_incorreta(String respostaIncorreta) throws Throwable {
		page.escrever("incorrect_answer_1", respostaIncorreta);
	}
}
