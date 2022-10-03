package model;

/**
 * Classe "Pessoa", responsavel por modelar os registros
 * de dados das pessoas cadastradas no sistema.
 * 
 * @author pedro
 *
 */
public class Pessoa {
	
	private int id;
	private String nome;
	
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
	
	public Pessoa(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
}
