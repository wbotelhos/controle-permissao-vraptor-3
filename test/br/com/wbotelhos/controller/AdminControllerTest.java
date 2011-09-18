package br.com.wbotelhos.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.wbotelhos.annotation.Permission;
import br.com.wbotelhos.model.common.Perfil;

public class AdminControllerTest {

	private AdminController controller;

	@Spy private Result result = new MockResult();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new AdminController(result);
	}

	@Test
	public void deveriaAdmin() {
		// given
		
		// when
		controller.admin();

		// then
		assertTrue("deve haver uma notice", result.included().containsKey("notice"));
	}

	@Test
	public void deveriaEstarAnotadoComPermissaoAdministrativaOController() {
		// given
		Class<? extends AdminController> clazz = controller.getClass();

		// when
		Permission permission = clazz.getAnnotation(Permission.class);

		// then
		assertNotNull(permission);
		assertTrue(clazz.isAnnotationPresent(Permission.class));
		assertEquals(1, permission.value().length);
		assertEquals(Perfil.ADMINISTRADOR, permission.value()[0]);
	}

}