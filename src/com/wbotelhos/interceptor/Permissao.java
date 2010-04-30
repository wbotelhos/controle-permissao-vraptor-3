package com.wbotelhos.interceptor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.wbotelhos.model.common.TipoPerfil;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://wbotelhos.com/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Permissao {
	
	TipoPerfil[] value();
	
}