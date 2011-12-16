package br.com.alabeduarte.service;

import br.com.alabeduarte.domain.UsuarioLogado;

public class ValidadorAutenticacao {

	private String mensagemValidacao;
	private UsuarioLogado usuarioLogado;

	public ValidadorAutenticacao(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public boolean isAutenticado(UsuarioLogado usuarioLogado, String senha) {
		final String MENSAGEM = "Login/Senha inválido(s)";
		boolean loginValido = false;
		if (usuarioLogado == null) {
			loginValido = false;
		} else {
			loginValido = this.isSenhaCorreta(usuarioLogado, senha);
		}
		if (!loginValido) {
			mensagemValidacao = MENSAGEM;
		}
		return loginValido;
	}
	
	private boolean isSenhaCorreta(UsuarioLogado usuarioLogado, String senha) {
		return usuarioLogado.getSenha().equals(senha);
	}
	
	public boolean isSenhaComQuantidadeDeCaracteresInvalidos() {
		final int minimoDeCaracteresExigidos = 6;
		if (usuarioLogado.getSenha().length() < minimoDeCaracteresExigidos) {
			mensagemValidacao = "Senha deve conter no mínimo " + minimoDeCaracteresExigidos + " caracteres";
			return true;
		} else return false;
	}

	public String getMensagemValidacao() {
		return mensagemValidacao;
	}
	
}
