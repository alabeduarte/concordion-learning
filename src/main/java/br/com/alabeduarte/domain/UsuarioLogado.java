package br.com.alabeduarte.domain;

public class UsuarioLogado {

	private String login;
	private String senha;
	
	public UsuarioLogado(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	
}
