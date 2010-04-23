package com.wordpress.wbotelhos.controller;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

import com.wordpress.wbotelhos.model.Usuario;
import com.wordpress.wbotelhos.model.common.TipoPerfil;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://wbotelhos.wordpress.com/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Resource
public class IndexController {

	private HttpSession session;

	public IndexController(HttpSession session) {
		this.session = session;
	}

	@Path("/")
	public void index() {
		session.setAttribute("user", this.getUsuario());
	}
	
	private Usuario getUsuario() {
		Usuario entity = new Usuario();
		entity.setNome("Washington Botelho");
		entity.setPerfil(TipoPerfil.MODERADOR);
		return entity;
	}

}