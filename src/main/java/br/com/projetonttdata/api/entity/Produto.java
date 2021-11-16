package br.com.projetonttdata.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3218666159636893657L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column(length = 100)
	private String nome;
	@Column(length = 4)
	private Integer estoque;
	@Column(name = "preco_venda", precision = 10, scale = 4)
	private BigDecimal precoVenda;
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Status status;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Produto(Long id, String nome, Integer estoque, BigDecimal precoVenda, Status status) {
		super();
		this.id = id;
		this.nome = nome;
		this.estoque = estoque;
		this.precoVenda = precoVenda;
		this.status = status;
	}

	public Produto() {
		super();
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

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void clone(final Produto produto) {
		if (StringUtils.isNotBlank(produto.getNome())) {
			this.nome = produto.getNome();
		}

		if (produto.getEstoque() != null) {
			this.estoque = produto.getEstoque();
		}

		if (produto.getPrecoVenda() != null) {
			this.precoVenda = produto.getPrecoVenda();
		}

		if (produto.getCategoria() != null) {
			this.categoria = produto.getCategoria();
		}
	}

}
