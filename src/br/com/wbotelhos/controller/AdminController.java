package br.com.wbotelhos.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.wbotelhos.interceptor.Permissao;
import br.com.wbotelhos.model.common.TipoPerfil;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://wbotelhos.com/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Resource
@Permissao(TipoPerfil.ADMINISTRADOR)
public class AdminController {

	private Result result;

	public AdminController(Result result) {
		this.result = result;
	}

	@Get
	@Path("/admin")
	public void admin() {
		result.include("msg", "Seja bem-vindo ao painel administrativo");
	}

}