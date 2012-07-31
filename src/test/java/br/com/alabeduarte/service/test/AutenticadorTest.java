package br.com.alabeduarte.service.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.alabeduarte.domain.Usuario;
import br.com.alabeduarte.persistence.dao.UsuariosDao;
import br.com.alabeduarte.repository.Usuarios;
import br.com.alabeduarte.service.Autenticador;
import br.com.alabeduarte.service.ValidadorAutenticacao;

public class AutenticadorTest {

	private Usuarios usuariosDoSistema = new UsuariosDao();
	
	@Before
	public void setUp() {
		usuariosDoSistema.add("alabeduarte", new Usuario("alabeduarte", "******"));
	}
	
	@Test
	public void deve_logar_usuario() {
		final String LOGIN = "alabeduarte";
		final String SENHA = "******";
		Usuario usuarioLogado = new Usuario(LOGIN, SENHA);
		
		ValidadorAutenticacao validadorAutenticacao = new ValidadorAutenticacao(usuarioLogado);
		Autenticador autenticador = new Autenticador(validadorAutenticacao, usuariosDoSistema);
		
		assertNotNull(autenticador.logon(usuarioLogado));
	}
	
}
