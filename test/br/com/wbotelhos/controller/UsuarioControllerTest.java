package br.com.wbotelhos.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.wbotelhos.annotation.Permission;
import br.com.wbotelhos.business.UsuarioBusiness;
import br.com.wbotelhos.model.Usuario;
import br.com.wbotelhos.model.common.Perfil;

public class UsuarioControllerTest {

	private UsuarioController controller;

	@Spy private Result result = new MockResult();

	@Mock private UsuarioBusiness business;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new UsuarioController(result, business);
	}

	@Test
	public void deveriaListagem() {
		// given

		// when
		controller.listagem();

		// then
		verify(business).loadAll();
	}

	@Test
	public void deveriaSalvar() {
		// given
		Usuario usuario = new Usuario();

		// when
		controller.salvar(usuario);

		// then
		verify(business).save(usuario);
		verify(result).include("notice", "Usuário adicionado com sucesso!");

		assertTrue("deve haver uma notice", result.included().containsKey("notice"));
	}

	@Test
	public void deveriaRemover() {
		// given
		Usuario usuario = new Usuario();
		usuario.setId(1l);

		// when
		controller.remover(usuario);

		// then
		verify(business).remove(usuario);
		verify(result).include("notice", "Usuário removido com sucesso!");

		assertTrue("deve haver uma notice", result.included().containsKey("notice"));
	}

	@Test
	public void deveriaEstarAnotadoComPermissaoModeradorOMetodoSalvar() throws SecurityException, NoSuchMethodException {
		// given
		Class<? extends UsuarioController> clazz = controller.getClass();
		Method method = clazz.getMethod("salvar", Usuario.class);

		// when
		Permission permission = method.getAnnotation(Permission.class);

		// then
		assertNotNull(permission);
		assertTrue(method.isAnnotationPresent(Permission.class));
		assertEquals(1, permission.value().length);
		assertEquals(Perfil.MODERADOR, permission.value()[0]);
	}

	@Test
	public void deveriaEstarAnotadoComPermissaoModeradorEAdministradorOMetodoRemover() throws SecurityException, NoSuchMethodException {
		// given
		Class<? extends UsuarioController> clazz = controller.getClass();
		Method method = clazz.getMethod("remover", Usuario.class);

		// when
		Permission permission = method.getAnnotation(Permission.class);

		// then
		assertNotNull(permission);
		assertTrue(method.isAnnotationPresent(Permission.class));
		assertEquals(2, permission.value().length);
		assertEquals(Perfil.MODERADOR, permission.value()[0]);
		assertEquals(Perfil.ADMINISTRADOR, permission.value()[1]);
	}

}