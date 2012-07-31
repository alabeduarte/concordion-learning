package br.com.alabeduarte.service;

import br.com.alabeduarte.domain.Usuario;
import br.com.alabeduarte.repository.Usuarios;

public class Autenticador {

	private ValidadorAutenticacao validadorAutenticacao;
	private Usuarios usuarios;

	public Autenticador(ValidadorAutenticacao validadorAutenticacao, Usuarios usuarios) {
		this.validadorAutenticacao = validadorAutenticacao;
		this.usuarios = usuarios;
	}

	public Usuario logon(final Usuario usuario) {
		if (validadorAutenticacao.isSenhaComQuantidadeDeCaracteresInvalidos()) {
			throw new IllegalArgumentException(validadorAutenticacao.getMensagemValidacao());
		}
		
		Usuario usuarioLogado = usuarios.get(usuario.getLogin());
		if (validadorAutenticacao.isAutenticado(usuarioLogado, usuario.getSenha())) {
			return usuarioLogado;
		} else {
			throw new IllegalArgumentException(validadorAutenticacao.getMensagemValidacao());
		}
	}
	
}
