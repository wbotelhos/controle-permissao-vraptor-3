package br.com.wbotelhos.model.common;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Washington Botelho
 * @artigo http://wbotelhos.com.br/2010/04/23/controle-de-permissao-com-vraptor-3
 */

public enum TipoPerfil {

	MEMBRO, MODERADOR, ADMINISTRADOR;

	public static Collection<TipoPerfil> loadAll() {
		Collection<TipoPerfil> perfilList = new ArrayList<TipoPerfil>();

		for (TipoPerfil item : values()) {
			perfilList.add(item);
		}
		return perfilList;
	}

}