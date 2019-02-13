package br.com.iftm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_CIDADE", schema = "EVE", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_CIDADE", columnNames = { "NOME_CIDADE", "EST_CIDADE" }) })
@SequenceGenerator(name = "SQ_CIDADE", schema = "EVE", sequenceName = "SQ_CIDADE", initialValue = 1, allocationSize = 1)
public class Cidade {

	@Id
	@Column(name = "ID_CIDADE")
	@GeneratedValue(generator = "SQ_CIDADE", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "NOME_CIDADE", nullable = false, length = 100)
	private String nome;

	@Column(name = "EST_CIDADE", nullable = false, length = 2)
	private String estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
