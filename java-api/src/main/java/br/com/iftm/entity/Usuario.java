package br.com.iftm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_USUARIO", schema = "EVE", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_USUARIO", columnNames = { "EMAIL_USUARIO" }) })
@SequenceGenerator(name = "SQ_USUARIO", schema = "EVE", sequenceName = "SQ_USUARIO", initialValue = 1, allocationSize = 1)
public class Usuario {

	@Id()
	@Column(name = "ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
	private Integer id;

	@Column(name = "NOME_USUARIO", length = 100, nullable = false)
	private String nome;

	@Column(name = "EMAIL_USUARIO", length = 255, nullable = false)
	private String email;

	@Column(name = "SENHA_USUARIO", length = 32, nullable = false)
	private String senha;

	@Column(name = "CPF_USUARIO", length = 15, nullable = false)
	private String cpf;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario", orphanRemoval = true, targetEntity = Telefone.class)
	private Telefone telefones;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Telefone getTelefones() {
		return telefones;
	}

	public void setTelefones(Telefone telefones) {
		this.telefones = telefones;
	}

}
