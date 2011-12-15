package br.com.alabeduarte.service;

import br.com.alabeduarte.domain.UsuarioLogado;

public class ValidadorAutenticacao {

	private String mensagemValidacao;
	private UsuarioLogado usuarioLogado;

	public ValidadorAutenticacao(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public boolean isSenhaCorreta(UsuarioLogado usuarioLogado, String senha) {
		if (usuarioLogado != null) {
			boolean senhaCorreta = usuarioLogado.getSenha().equals(senha);
			if (senhaCorreta) {
				return true;
			} else {
				mensagemValidacao = "Senha Inválida";
				return false;
			}
		} else {
			mensagemValidacao = "Usuário não encontrado";
			return false;
		}
	}
	
	public boolean isSenhaComQuantidadeDeCaracteresInvalidos() {
		if (usuarioLogado.getSenha().length() < 6) {
			mensagemValidacao = "Senha deve conter no mínimo 6 caracteres";
			return true;
		} else return false;
	}

	public String getMensagemValidacao() {
		return mensagemValidacao;
	}
	
}
