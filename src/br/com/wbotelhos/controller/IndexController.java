package br.com.wbotelhos.controller;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.wbotelhos.model.Usuario;
import br.com.wbotelhos.model.common.TipoPerfil;

/**
 * @author Washington Botelho
 * @artigo http://wbotelhos.com.br/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Resource
public class IndexController {

	private HttpSession session;

	public IndexController(HttpSession session) {
		this.session = session;
	}

	@Get
	@Path("/")
	public void index() {
		session.setAttribute("user", this.getUsuario());
	}
	
	private Usuario getUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Washington Botelho");
		usuario.setPerfil(TipoPerfil.MODERADOR);
		return usuario;
	}

}