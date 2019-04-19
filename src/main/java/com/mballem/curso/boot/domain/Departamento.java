package com.mballem.curso.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long>{
	
	@NotBlank(message = "Informe um nome.")
	@Size(min = 3, max = 60, message = "O nome do departamento deve ter entre {min} e o máximo de {max}")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@OneToMany(mappedBy = "departamento")
	private List<Cargo> cargos;

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

/*
 *  - Mapear a entidade com Entity
 * 	- Mapear o nome da tabela se necessário
 *  - Mapear campos da tabela 
 */
