package br.com.wbotelhos.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
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
	private UsuarioBusiness usuarioDao;

	public UsuarioController(Result result, UsuarioBusiness usuarioDao) {
		this.result = result;
		this.usuarioDao = usuarioDao;
	}

	@Get
	@Path("/usuario")
	public void listagem() {
		int tam = usuarioDao.getUsuarios().size();
		result.include("message",  "[" + tam + "] usuário(s) encontrado(s)...");
	}

	@Post
	@Path("/usuario")
	@Permissao(TipoPerfil.MODERADOR)
	public void adicionar(Usuario usuario) {
		usuario.setId((long) (usuarioDao.getUsuarios().size() + 1));
		usuarioDao.adicionar(usuario);

		result
		.include("message", "Usuário adicionado com sucesso!")
		.redirectTo(this).listagem();
	}

	@Get
	@Path("/usuario/{usuario.id}/remover")
	@Permissao({TipoPerfil.MODERADOR, TipoPerfil.ADMINISTRADOR})
	public void remover(Usuario usuario) {
		usuarioDao.remover(usuario);

		result
		.include("message", "Usuário removido com sucesso!")
		.redirectTo(this).listagem();
	}

	@Get
	@Path("/usuario/negado")
	public void negado() {
		result.include("message", "Ops! Você não pode fazer isso! (:");
	}

}