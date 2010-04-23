package com.wordpress.wbotelhos.interceptor;

import static br.com.caelum.vraptor.view.Results.logic;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

import com.wordpress.wbotelhos.controller.IndexController;
import com.wordpress.wbotelhos.controller.UsuarioController;
import com.wordpress.wbotelhos.model.Usuario;
import com.wordpress.wbotelhos.model.common.TipoPerfil;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://wbotelhos.wordpress.com/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Intercepts
@RequestScoped
public class PermissaoInterceptor implements Interceptor {

	private Result result;
	private HttpSession session;

	public PermissaoInterceptor(Result result, HttpSession session) {
		this.result = result;
		this.session = session;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean accepts(ResourceMethod method) {
		return !Arrays.asList(IndexController.class).contains(method.getMethod().getDeclaringClass());
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method, Object resourceInstance) {
		if (isAcessoMetodo(method) && isAcessoController(method)) {
			stack.next(method, resourceInstance);
		} else {
			result.use(logic()).redirectTo(UsuarioController.class).negado();
		}
	}

	private Usuario getUser() {
		return (Usuario) session.getAttribute("user");
	}

	private boolean isAcessoMetodo(ResourceMethod method) {
		Permissao permissaoList = method.getMethod().getAnnotation(Permissao.class);
		return isExistePermissao(permissaoList);
	}

	private boolean isAcessoController(ResourceMethod method) {
		Permissao permissaoList = method.getResource().getType().getAnnotation(Permissao.class);		
		return isExistePermissao(permissaoList);
	}

	private boolean isExistePermissao(Permissao permissaoList) {
		Usuario user = this.getUser();

		if (permissaoList != null) { // Com permissão anotada. Verificar!
			for (TipoPerfil perfil : permissaoList.value()) {
				if (perfil.equals(user.getPerfil())) {
					return true;
				}
			}
		} else { // Sem permissão anotada. Continue!
			return true;
		}

		return false;
	}

}