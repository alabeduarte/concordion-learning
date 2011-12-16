package br.com.alabeduarte.repository;

import br.com.alabeduarte.domain.UsuarioLogado;

public interface UsuariosDoSistema {

	UsuarioLogado get(String login);
	
	void add(String login, UsuarioLogado usuarioLogado);
	
}
