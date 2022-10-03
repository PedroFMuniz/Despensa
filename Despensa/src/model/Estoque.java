package model;

import java.util.ArrayList;

public class Estoque {
	
	private int id;
	private ArrayList<Movimentacao> movimentacoes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}
	
	public Estoque(int id, ArrayList<Movimentacao> movimentacoes) {
		this.id = id;
		this.movimentacoes = movimentacoes;
	}

}
