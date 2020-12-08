package br.alves.steps;

import org.junit.Assert;

import br.alves.pages.PaginaLogin;
import br.alves.pages.PaginaPrincipal;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class LoginOpenTriviaSteps {

	private static PaginaPrincipal page = new PaginaPrincipal();
	private static PaginaLogin paginaLogin = new PaginaLogin();

	@Dado("^que navego para a página de Login$")
	public void que_navego_para_a_página_de_Login() throws Throwable {
		page.clicarBotaoPorTexto("Login");
	}

	@Dado("^informo o login \"([^\"]*)\"$")
	public void informo_o_login(String login) throws Throwable {
		paginaLogin.setEmail(login);
	}

	@Dado("^informo a senha \"([^\"]*)\"$")
	public void informo_a_senha(String senha) throws Throwable {
		paginaLogin.setSenha(senha);
	}

	@Quando("^clicar em SIGN IN$")
	public void clicar_em_SIGN_IN() throws Throwable {
		page.clicarBotaoSubmit();
	}

	@Entao("^validar nome do usuário logado$")
	public void validar_nome_do_usuário_logado() throws Throwable {
		Assert.assertEquals("GUSTAVOALVES", paginaLogin.validarUsuarioLogado());
	}
}
