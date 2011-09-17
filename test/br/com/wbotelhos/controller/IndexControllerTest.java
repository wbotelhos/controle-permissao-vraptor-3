package br.com.wbotelhos.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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

}