package br.com.wbotelhos.controller;

import java.util.Collection;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.wbotelhos.business.UsuarioBusiness;
import br.com.wbotelhos.interceptor.Permissao;
import br.com.wbotelhos.model.Usuario;
import br.com.wbotelhos.model.common.TipoPerfil;

/**
 * @author Washington Botelho
 * @artigo http://wbotelhos.com.br/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Resource
public class UsuarioController {

	private Result result;
	private UsuarioBusiness business;

	public UsuarioController(Result result, UsuarioBusiness usuarioDao) {
		this.result = result;
		this.business = usuarioDao;
	}

	@Get("/usuario")
	public void listagem() {
		Collection<Usuario> usuarioList = business.loadAll();

		result
		.include("usuarioList",  usuarioList)
		.include("notice",  "[" + usuarioList.size() + "] usuário(s) encontrado(s)...");
	}

	@Post("/usuario")
	@Permissao(TipoPerfil.MODERADOR)
	public void salvar(Usuario usuario) {
		usuario.setId((long) business.loadAll().size() + 1);

		business.save(usuario);

		result
		.include("notice", "Usuário adicionado com sucesso!")
		.redirectTo(this).listagem();
	}

	@Delete("/usuario/{usuario.id}")
	@Permissao({ TipoPerfil.MODERADOR, TipoPerfil.ADMINISTRADOR })
	public void remover(Usuario usuario) {
		business.remove(usuario);

		result
		.include("notice", "Usuário removido com sucesso!")
		.redirectTo(this).listagem();
	}

	public void negado() {
		result.include("notice", "Ops! Você não pode fazer isso! (:");
	}

}