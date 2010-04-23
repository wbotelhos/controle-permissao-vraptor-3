package com.wordpress.wbotelhos.dao;

import java.util.ArrayList;
import java.util.Collection;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

import com.wordpress.wbotelhos.model.Usuario;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://wbotelhos.wordpress.com/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Component
@SessionScoped
public class UsuarioDao {

	private Collection<Usuario> usuarioList = new ArrayList<Usuario>();

	public void adicionar(Usuario usuario) {
		usuarioList.add(usuario);
	}

	public void remover(Usuario usuario) {
		usuarioList.remove(usuario);
	}

	public Collection<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(Collection<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

}