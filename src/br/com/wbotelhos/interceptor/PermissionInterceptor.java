package br.com.wbotelhos.interceptor;

import java.util.Arrays;
import java.util.Collection;

import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.wbotelhos.component.UserSession;
import br.com.wbotelhos.controller.UsuarioController;
import br.com.wbotelhos.model.Usuario;
import br.com.wbotelhos.model.common.TipoPerfil;

@Intercepts
public class PermissionInterceptor implements Interceptor {

	private final Result result;
	private final UserSession userSession;
	
	public PermissionInterceptor(Result result, UserSession userSession) {
		this.result = result;
		this.userSession = userSession;
	}

	@SuppressWarnings("unchecked")
	public boolean accepts(ResourceMethod method) {
		return Arrays.asList(UsuarioController.class).contains(method.getMethod().getDeclaringClass());
	}

	public void intercept(InterceptorStack stack, ResourceMethod method, Object resource) {
		Permission metodoList = method.getMethod().getAnnotation(Permission.class);
		Permission controllerList = method.getResource().getType().getAnnotation(Permission.class);

		if (this.hasAccess(metodoList) && this.hasAccess(controllerList)) {
			stack.next(method, resource);
		} else {
			result
			.include("notice", "Você não tem permissão para tal ação!")
			.redirectTo(UsuarioController.class).negado();
		}
	}

	private boolean hasAccess(Permission permissaoList) {
		if (permissaoList == null) {
			return true;
		}

		Usuario user = userSession.getUser();

		Collection<TipoPerfil> perfilList = Arrays.asList(permissaoList.value());

		return perfilList.contains(user.getPerfil());
	}

}