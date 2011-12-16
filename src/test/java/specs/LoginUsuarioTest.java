package specs;

import java.util.HashMap;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import br.com.alabeduarte.domain.UsuarioLogado;
import br.com.alabeduarte.persistence.dao.UsuariosDoSistemaDao;
import br.com.alabeduarte.repository.UsuariosDoSistema;
import br.com.alabeduarte.service.Autenticador;
import br.com.alabeduarte.service.ValidadorAutenticacao;

@RunWith(ConcordionRunner.class)
public class LoginUsuarioTest {

	private UsuariosDoSistema usuariosDoSistema;
	
	@Before
	public void setUp() {
		usuariosDoSistema = new UsuariosDoSistemaDao();
		usuariosDoSistema.add("alabeduarte", new UsuarioLogado("alabeduarte", "******"));
	}
	
	public UsuarioLogado logon(String login, String senha) {
		UsuarioLogado usuarioLogado = new UsuarioLogado(login, senha);
		ValidadorAutenticacao validadorAutenticacao = new ValidadorAutenticacao(usuarioLogado);
		return new Autenticador(validadorAutenticacao, usuariosDoSistema).logon(usuarioLogado);
	}
	
	public String logonInvalido(String login, String senha) {
		try {			
			this.logon(login, senha);
		} catch (IllegalArgumentException e) {
			return e.getMessage();
		}
		return "";
	}
	
	public String validaLogin(String login, String senha) {
		ValidadorAutenticacao validadorAutenticacao = new ValidadorAutenticacao(new UsuarioLogado(login, senha));
		if (validadorAutenticacao.isSenhaComQuantidadeDeCaracteresInvalidos()) {
			return validadorAutenticacao.getMensagemValidacao();
		} else return "";
	}
	
}
