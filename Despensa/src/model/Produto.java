package model;

/**
 * Classe "Pessoa", responsavel por modelar os registros
 * de dados das pessoas cadastradas no sistema.
 * 
 * @author pedro
 *
 */
public class Produto {

	private int id;
	private String nome;
	private double valor;
	private String tipo;
	private String unidade;
	private double tamanho;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public double getTamanho() {
		return tamanho;
	}
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
	
	public Produto(int id, String nome, double valor, String tipo, String unidade, double tamanho) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
		this.unidade = unidade;
		this.tamanho = tamanho;
	}
	
	
}
