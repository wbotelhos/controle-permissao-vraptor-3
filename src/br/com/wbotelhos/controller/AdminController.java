package br.com.wbotelhos.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.wbotelhos.interceptor.Permission;
import br.com.wbotelhos.model.common.TipoPerfil;

/**
 * @author Washington Botelho
 * @artigo http://wbotelhos.com.br/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Resource
@Permission(TipoPerfil.ADMINISTRADOR)
public class AdminController {

	private Result result;

	public AdminController(Result result) {
		this.result = result;
	}

	@Get("/admin")
	public void admin() {
		result.include("notice", "Seja bem-vindo ao painel administrativo");
	}

}