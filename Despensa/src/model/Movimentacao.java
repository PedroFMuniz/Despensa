package model;

import java.time.LocalDate;

public class Movimentacao {
	
	private int id;
	private LocalDate data;
	private String tipo;
	private boolean ativo;
	private int quantidade;
	private Produto produto;
	private Pessoa pessoa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Movimentacao(int id, LocalDate data, String tipo, boolean ativo, int quantidade, Produto produto,
			Pessoa pessoa) {
		this.id = id;
		this.data = data;
		this.tipo = tipo;
		this.ativo = ativo;
		this.quantidade = quantidade;
		this.produto = produto;
		this.pessoa = pessoa;
	}

}
