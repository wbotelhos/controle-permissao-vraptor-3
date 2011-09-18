package br.com.wbotelhos.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.wbotelhos.annotation.Public;
import br.com.wbotelhos.component.UserSession;

public class IndexControllerTest {

	private IndexController controller;

	@Mock private UserSession userSession;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new IndexController(userSession);
	}

	@Test
	public void deveriaIndex() {
		// given

		// when
		controller.index();

		// then
	}

	@Test
	public void deveriaEstarAnotadoComPermissaoPublicaOMetodoIndex() throws SecurityException, NoSuchMethodException {
		// given
		Class<? extends IndexController> clazz = controller.getClass();
		Method method = clazz.getMethod("index");

		// when
		Public publyc = method.getAnnotation(Public.class);

		// then
		assertNotNull(publyc);
		assertTrue(method.isAnnotationPresent(Public.class));
	}

}