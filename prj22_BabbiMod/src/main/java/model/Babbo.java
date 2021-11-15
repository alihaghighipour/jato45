package model;

public class Babbo {
	private int id;
	private String nome;
	private String password;
	private String mezzoTrasporto;
	private String zona;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMezzoTrasporto() {
		return mezzoTrasporto;
	}
	public void setMezzoTrasporto(String mezzoTrasporto) {
		this.mezzoTrasporto = mezzoTrasporto;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Babbo [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", password=");
		builder.append(password);
		builder.append(", mezzoTrasporto=");
		builder.append(mezzoTrasporto);
		builder.append(", zona=");
		builder.append(zona);
		builder.append("]");
		return builder.toString();
	}
	
}
