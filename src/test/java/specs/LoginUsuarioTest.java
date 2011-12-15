package specs;

import java.util.HashMap;
import java.util.Map;

import org.concordion.api.ExpectedToFail;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import br.com.alabeduarte.domain.UsuarioLogado;
import br.com.alabeduarte.service.Autenticador;
import br.com.alabeduarte.service.ValidadorAutenticacao;

@RunWith(ConcordionRunner.class)
@ExpectedToFail
public class LoginUsuarioTest {

	private Map<String, UsuarioLogado> usuariosDoSistema;
	
	public LoginUsuarioTest() {
		usuariosDoSistema = new HashMap<String, UsuarioLogado>();
	}
	
	@Before
	public void setUp() {
		usuariosDoSistema.put("alabeduarte", new UsuarioLogado("alabeduarte", "******"));
	}
	
	public UsuarioLogado logon(String login, String senha) {
		UsuarioLogado usuarioLogado = new UsuarioLogado(login, senha);
		ValidadorAutenticacao validadorAutenticacao = new ValidadorAutenticacao(usuarioLogado);
		return new Autenticador(validadorAutenticacao, usuariosDoSistema).logon(usuarioLogado);
	}
	
	public String validaLogin(String login, String senha) {
		ValidadorAutenticacao validadorAutenticacao = new ValidadorAutenticacao(new UsuarioLogado(login, senha));
		if (validadorAutenticacao.isSenhaComQuantidadeDeCaracteresInvalidos()) {
			return validadorAutenticacao.getMensagemValidacao();
		} else return "";
	}
	
}
