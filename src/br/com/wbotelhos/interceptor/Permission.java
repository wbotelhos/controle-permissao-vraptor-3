package br.com.wbotelhos.interceptor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import br.com.wbotelhos.model.common.TipoPerfil;

/**
 * @author Washington Botelho
 * @artigo http://wbotelhos.com.br/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
	
	TipoPerfil[] value();
	
}