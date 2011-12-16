package br.com.alabeduarte.service;

import br.com.alabeduarte.domain.UsuarioLogado;
import br.com.alabeduarte.repository.UsuariosDoSistema;

public class Autenticador {

	private ValidadorAutenticacao validadorAutenticacao;
	private UsuariosDoSistema usuariosDoSistema;

	public Autenticador(ValidadorAutenticacao validadorAutenticacao, UsuariosDoSistema usuariosDoSistema) {
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
