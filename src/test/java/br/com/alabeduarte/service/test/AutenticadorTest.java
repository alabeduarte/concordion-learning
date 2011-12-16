package br.com.alabeduarte.service.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.alabeduarte.domain.UsuarioLogado;
import br.com.alabeduarte.persistence.dao.UsuariosDoSistemaDao;
import br.com.alabeduarte.repository.UsuariosDoSistema;
import br.com.alabeduarte.service.Autenticador;
import br.com.alabeduarte.service.ValidadorAutenticacao;

public class AutenticadorTest {

	private UsuariosDoSistema usuariosDoSistema = new UsuariosDoSistemaDao();
	
	@Before
	public void setUp() {
		usuariosDoSistema.add("alabeduarte", new UsuarioLogado("alabeduarte", "******"));
	}
	
	@Test
	public void deve_logar_usuario() {
		final String LOGIN = "alabeduarte";
		final String SENHA = "******";
		UsuarioLogado usuarioLogado = new UsuarioLogado(LOGIN, SENHA);
		
		ValidadorAutenticacao validadorAutenticacao = new ValidadorAutenticacao(usuarioLogado);
		Autenticador autenticador = new Autenticador(validadorAutenticacao, usuariosDoSistema);
		
		assertNotNull(autenticador.logon(usuarioLogado));
	}
	
}
