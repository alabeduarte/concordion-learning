package br.com.alabeduarte.service;

import java.util.Map;

import br.com.alabeduarte.domain.UsuarioLogado;

public class Autenticador {

	private ValidadorAutenticacao validadorAutenticacao;
	private Map<String, UsuarioLogado> usuariosDoSistema;

	public Autenticador(ValidadorAutenticacao validadorAutenticacao, Map<String, UsuarioLogado> usuariosDoSistema) {
		this.validadorAutenticacao = validadorAutenticacao;
		this.usuariosDoSistema = usuariosDoSistema;
	}

	public UsuarioLogado logon(final UsuarioLogado usuario) {
		if (validadorAutenticacao.isSenhaComQuantidadeDeCaracteresInvalidos()) {
			throw new IllegalArgumentException(validadorAutenticacao.getMensagemValidacao());
		}
		
		UsuarioLogado usuarioLogado = usuariosDoSistema.get(usuario.getLogin());
		if (validadorAutenticacao.isAutenticado(usuarioLogado, usuario.getSenha())) {
			return usuarioLogado;
		} else {
			throw new IllegalArgumentException(validadorAutenticacao.getMensagemValidacao());
		}
	}
	
}
