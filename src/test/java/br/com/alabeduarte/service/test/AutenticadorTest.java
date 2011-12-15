package br.com.alabeduarte.service.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.com.alabeduarte.domain.UsuarioLogado;
import br.com.alabeduarte.service.Autenticador;
import br.com.alabeduarte.service.ValidadorAutenticacao;

public class AutenticadorTest {

	private Map<String, UsuarioLogado> usuariosDoSistema = new HashMap<String, UsuarioLogado>();
	
	@Before
	public void setUp() {
		usuariosDoSistema.put("alabeduarte", new UsuarioLogado("alabeduarte", "******"));
	}
	
	@Test
	public void deve_logar_usuario() {
		final String LOGIN = "alabeduarte";
		final String SENHA = "******";
		UsuarioLogado usuarioLogado = new UsuarioLogado(LOGIN, SENHA);
		
		/*
		ValidadorAutenticacao validadorAutenticacao = mock(ValidadorAutenticacao.class);
		when(validadorAutenticacao.isSenhaValida(usuarioLogado, SENHA)).thenReturn(Boolean.TRUE);
		*/
		
		ValidadorAutenticacao validadorAutenticacao = new ValidadorAutenticacao(usuarioLogado);
		Autenticador autenticador = new Autenticador(validadorAutenticacao, usuariosDoSistema);
		
		assertNotNull(autenticador.logon(usuarioLogado));
	}
	
}
