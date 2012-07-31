package br.com.alabeduarte.service;

import br.com.alabeduarte.domain.Usuario;

public class ValidadorAutenticacao {

	private String mensagemValidacao;
	private Usuario usuarioLogado;

	public ValidadorAutenticacao(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public boolean isAutenticado(Usuario usuarioLogado, String senha) {
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
	
	private boolean isSenhaCorreta(Usuario usuarioLogado, String senha) {
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
