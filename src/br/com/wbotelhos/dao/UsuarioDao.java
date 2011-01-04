package br.com.wbotelhos.dao;

import java.util.ArrayList;
import java.util.Collection;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.wbotelhos.model.Usuario;

/**
 * @author Washington Botelho
 * @artigo http://wbotelhos.com.br/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Component
@SessionScoped
public class UsuarioDao {

	private Collection<Usuario> usuarios = new ArrayList<Usuario>();

	public void adicionar(Usuario usuario) {
		usuarios.add(usuario);
	}

	public void remover(Usuario usuario) {
		usuarios.remove(usuario);
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}