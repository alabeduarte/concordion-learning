package specs;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import br.com.alabeduarte.domain.Usuario;
import br.com.alabeduarte.persistence.dao.UsuariosDao;
import br.com.alabeduarte.repository.Usuarios;
import br.com.alabeduarte.service.Autenticador;
import br.com.alabeduarte.service.ValidadorAutenticacao;

@RunWith(ConcordionRunner.class)
public class LoginUsuarioTest {

	private Usuarios usuarios;
	
	@Before
	public void setUp() {
		usuarios = new UsuariosDao();
		usuarios.add("alabeduarte", new Usuario("alabeduarte", "******"));
	}
	
	public Usuario logon(String login, String senha) {
		Usuario usuarioLogado = new Usuario(login, senha);
		ValidadorAutenticacao validadorAutenticacao = new ValidadorAutenticacao(usuarioLogado);
		return new Autenticador(validadorAutenticacao, usuarios).logon(usuarioLogado);
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
		ValidadorAutenticacao validadorAutenticacao = new ValidadorAutenticacao(new Usuario(login, senha));
		if (validadorAutenticacao.isSenhaComQuantidadeDeCaracteresInvalidos()) {
			return validadorAutenticacao.getMensagemValidacao();
		} else return "";
	}
	
	public String logonEfetuadoComSucesso(String login, String senha) {
		try {
			if (this.logon(login, senha) != null) {
				return "OK";
			}
		} catch (IllegalArgumentException e) {
			return "FAIL";
		}
		return "ERRO";
	}
	
}
