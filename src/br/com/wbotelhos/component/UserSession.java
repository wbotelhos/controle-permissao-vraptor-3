package br.com.wbotelhos.component;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.wbotelhos.model.Usuario;

@Component
@SessionScoped
public class UserSession implements Serializable {

	private static final long serialVersionUID = 8113472081570152045L;

	private Usuario user;

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}