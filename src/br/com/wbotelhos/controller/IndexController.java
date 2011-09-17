package br.com.wbotelhos.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.wbotelhos.annotation.Public;
import br.com.wbotelhos.component.UserSession;
import br.com.wbotelhos.model.Usuario;
import br.com.wbotelhos.model.common.Perfil;

/**
 * @author Washington Botelho
 * @article http://wbotelhos.com.br/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Resource
public class IndexController {

	private UserSession userSession;

	public IndexController(UserSession userSession) {
		this.userSession = userSession;
	}

	@Public
	@Get("/")
	public void index() {
		Usuario usuario = new Usuario();
		usuario.setNome("Washington Botelho");
		usuario.setPerfil(Perfil.MODERADOR);

		userSession.setUser(usuario);
	}

}