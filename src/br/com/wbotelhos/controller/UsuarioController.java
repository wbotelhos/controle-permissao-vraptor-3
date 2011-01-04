package br.com.wbotelhos.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.wbotelhos.dao.UsuarioDao;
import br.com.wbotelhos.interceptor.Permissao;
import br.com.wbotelhos.model.Usuario;
import br.com.wbotelhos.model.common.TipoPerfil;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://wbotelhos.com/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Resource
@Path("/usuario")
public class UsuarioController {

	private Result result;
	private UsuarioDao usuarioDao;

	public UsuarioController(Result result, UsuarioDao usuarioDao) {
		this.result = result;
		this.usuarioDao = usuarioDao;
	}

	@Get
	public void listar() {
		int tam = usuarioDao.getUsuarioList().size();
		result.include("msg",  "[" + tam + "] usuário(s) encontrado(s)...");
	}

	@Post
	@Path("/adicionar")
	@Permissao(TipoPerfil.MODERADOR)
	public void adicionar(Usuario usuario) {
		usuario.setId((long) (usuarioDao.getUsuarioList().size() + 1));
		usuarioDao.adicionar(usuario);
		result.include("msg", "Usuário adicionado com sucesso!");
		result.redirectTo(getClass()).listar();
	}

	@Get
	@Path("/remover/{usuario.id}")
	@Permissao({TipoPerfil.MODERADOR, TipoPerfil.ADMINISTRADOR})
	public void remover(Usuario usuario) {
		usuarioDao.remover(usuario);
		result.include("msg", "Usuário removido com sucesso!");
		result.redirectTo(getClass()).listar();
	}

	@Get
	@Path("/negado")
	public void negado() {
		result.include("msg", "Ops! Você não pode fazer isso! (:");
	}

}