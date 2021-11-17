package br.com.projetonttdata.api.dto;

import java.math.BigDecimal;

public class ProdutoDTO {
	
	private Long id;
	private String nome;
	private Integer estoque;
	private BigDecimal precoVenda;
	private BigDecimal totalVenda;
	private String status;
	private Long idCategoria;
	private String categoria;
	
	public ProdutoDTO(Long id, String nome, Integer estoque, BigDecimal precoVenda, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.estoque = estoque;
		this.precoVenda = precoVenda;
		this.status = status;
	}
	public ProdutoDTO(Long id, String nome, Integer estoque, BigDecimal precoVenda, String status, Long idCategoria, String categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.estoque = estoque;
		this.precoVenda = precoVenda;
		this.status = status;
		this.idCategoria = idCategoria;
		this.categoria = categoria;
	}
	public ProdutoDTO() {
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
	public BigDecimal getTotalVenda() {
		this.totalVenda = this.precoVenda.multiply( BigDecimal.valueOf(this.estoque) );
		return totalVenda;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}
