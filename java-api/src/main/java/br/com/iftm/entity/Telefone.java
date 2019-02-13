package br.com.iftm.entity;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_TELEFONE", schema = "EVE")
@SequenceGenerator(name = "SQ_TELEFONE", schema = "EVE", sequenceName = "SQ_TELEFONE", initialValue = 1, allocationSize = 1)
@JsonIgnoreProperties(value = { "usuario" })
public class Telefone {

	@Id
	@Column(name = "ID_TELEFONE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEFONE")
	private Integer id;

	@Column(name = "DDD_TELEFONE", length = 2, nullable = false)
	private String ddd;

	@Column(name = "NUM_TELEFONE", length = 20, nullable = false)
	private String numero;
	
	@Column(name = "DDD_TELEFONE2", length = 2, nullable = false)
	private String ddd2;

	@Column(name = "NUM_TELEFONE2", length = 20, nullable = false)
	private String numero2;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = Usuario.class)
	@JoinColumn(name = "ID_USUARIO", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_TELEFONE_TB_USUARIO"))
	private Usuario usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDdd2() {
		return ddd2;
	}

	public void setDdd2(String ddd2) {
		this.ddd2 = ddd2;
	}

	public String getNumero2() {
		return numero2;
	}

	public void setNumero2(String numero2) {
		this.numero2 = numero2;
	}
}
