package br.com.iftm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_CARONA", schema = "EVE")
@SequenceGenerator(name = "SQ_CARONA", schema = "EVE", sequenceName = "SQ_CARONA", initialValue = 1, allocationSize = 1)

public class Carona {

	@Id
	@Column(name = "ID_CARONA")
	@GeneratedValue(generator = "SQ_CARONA", strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "ORIGEM_CARONA", nullable = false, length = 255)
	private String cidadeOrigem;

	@Column(name = "DESTINO_CARONA", nullable = false, length = 255)
	private String cidadeDestino;

	@Column(name = "VAGAS_CARONA", nullable = false)
	private Integer vagas;

	@Column(name = "PRECO_CARONA", nullable = false)
	private Double preco;

	@Column(name = "DATA_CARONA", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name = "HORA_CARONA", nullable = false, length = 50)
	private String hora;

	@Column(name = "STATUS_CARONA", nullable = false)
	private Integer status;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Usuario.class)
	@JoinColumn(name = "ID_USUARIO", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_CARONA_TB_USUARIO"))
	private Usuario usuario;

	@Column(name = "DESCRICAO_CARONA", nullable = true, length = 512)
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

}
