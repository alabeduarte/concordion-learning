package br.com.alabeduarte.repository;

import br.com.alabeduarte.domain.Usuario;

public interface Usuarios {

	Usuario get(String login);
	
	void add(String login, Usuario usuarioLogado);
	
}
