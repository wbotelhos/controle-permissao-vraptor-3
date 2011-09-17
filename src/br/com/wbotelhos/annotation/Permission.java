package br.com.wbotelhos.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.wbotelhos.model.common.Perfil;

/**
 * @author Washington Botelho
 * @article http://wbotelhos.com.br/2010/04/23/controle-de-permissao-com-vraptor-3
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Permission {
	
	Perfil[] value();
	
}