package br.com.wbotelhos.controller;

import java.util.Collection;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.wbotelhos.business.UsuarioBusiness;
import br.com.wbotelhos.interceptor.Permission;
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
	public Collection<Usuario> listagem() {
		return business.loadAll();
	}

	@Post("/usuario")
	@Permission(TipoPerfil.MODERADOR)
	public void salvar(Usuario usuario) {
		usuario.setId((long) business.loadAll().size() + 1);

		business.save(usuario);

		result
		.include("notice", "Usuário adicionado com sucesso!")
		.redirectTo(this).listagem();
	}

	@Delete("/usuario/{usuario.id}")
	@Permission({ TipoPerfil.MODERADOR, TipoPerfil.ADMINISTRADOR })
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