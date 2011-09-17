package br.com.wbotelhos.controller;

import java.util.Collection;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.wbotelhos.annotation.Permission;
import br.com.wbotelhos.business.UsuarioBusiness;
import br.com.wbotelhos.model.Usuario;
import br.com.wbotelhos.model.common.Perfil;

/**
 * @author Washington Botelho
 * @article http://wbotelhos.com.br/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Resource
public class UsuarioController {

	private Result result;
	private UsuarioBusiness business;

	public UsuarioController(Result result, UsuarioBusiness business) {
		this.result = result;
		this.business = business;
	}

	@Get("/usuario")
	public Collection<Usuario> listagem() {
		return business.loadAll();
	}

	@Permission(Perfil.MODERADOR)
	@Post("/usuario")
	public void salvar(Usuario usuario) {
		usuario.setId((long) business.loadAll().size() + 1);

		business.save(usuario);

		result
		.include("notice", "Usuário adicionado com sucesso!")
		.redirectTo(this).listagem();
	}

	@Permission({ Perfil.MODERADOR, Perfil.ADMINISTRADOR })
	@Delete("/usuario/{usuario.id}")
	public void remover(Usuario usuario) {
		business.remove(usuario);

		result
		.include("notice", "Usuário removido com sucesso!")
		.redirectTo(this).listagem();
	}

}