package br.com.alabeduarte.persistence.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.alabeduarte.domain.Usuario;
import br.com.alabeduarte.repository.Usuarios;

public class UsuariosDao implements Usuarios {

	private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();
	
	@Override
	public Usuario get(String login) {
		return usuarios.get(login);
	}

	@Override
	public void add(String login, Usuario usuarioLogado) {
		usuarios.put(login, usuarioLogado);
	}

}
