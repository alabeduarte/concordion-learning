package br.com.alabeduarte.repository;

import java.util.HashMap;
import java.util.Map;

import br.com.alabeduarte.domain.UsuarioLogado;

public class UsuariosDoSistemaDao implements UsuariosDoSistema {

	private Map<String, UsuarioLogado> usuariosDoSistema = new HashMap<String, UsuarioLogado>();
	
	@Override
	public UsuarioLogado get(String login) {
		return usuariosDoSistema.get(login);
	}

	@Override
	public void add(String login, UsuarioLogado usuarioLogado) {
		usuariosDoSistema.put(login, usuarioLogado);
	}

}
