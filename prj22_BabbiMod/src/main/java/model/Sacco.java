package model;

import java.util.ArrayList;

public class Sacco {
	private String nome;
	private Babbo babbo;
	private ArrayList<Consegna> consegne;
	
	public Sacco() {
		consegne = new ArrayList<Consegna>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Babbo getBabbo() {
		return babbo;
	}
	
	public void setBabbo(Babbo babbo) {
		this.babbo = babbo;
	}
	
	public ArrayList<Consegna> getConsegne() {
		return consegne;
	}
	
	public void setConsegne(ArrayList<Consegna> consegne) {
		this.consegne = consegne;
	}

	public void addConsegna(Consegna consegna) {
		this.consegne.add(consegna);
	}
	
}
