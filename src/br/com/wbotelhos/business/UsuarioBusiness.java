package br.com.wbotelhos.business;

import java.util.ArrayList;
import java.util.Collection;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.wbotelhos.model.Usuario;

/**
 * @author Washington Botelho
 * @article http://wbotelhos.com.br/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Component
@SessionScoped
public class UsuarioBusiness {

	private Collection<Usuario> manager = new ArrayList<Usuario>();

	public void save(Usuario usuario) {
		manager.add(usuario);
	}

	public void remove(Usuario usuario) {
		manager.remove(usuario);
	}

	public Collection<Usuario> loadAll() {
		return manager;
	}

}