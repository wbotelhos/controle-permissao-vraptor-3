package com.wbotelhos.model;

import com.wbotelhos.model.common.TipoPerfil;

/**
 * @author Washington Botelho dos Santos
 * @artigo http://wbotelhos.com/2010/04/23/controle-de-permissao-com-vraptor-3
 */

public class Usuario {

	private Long id;
	private String nome;
	private TipoPerfil perfil;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Usuario other = (Usuario) obj;
		
		if (id == null) {
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(TipoPerfil perfil) {
		this.perfil = perfil;
	}

}