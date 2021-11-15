package model;

public class Dono {
	private int id;
	private String desc;
	private int disponibilita;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public int getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dono [id=");
		builder.append(id);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", disponibilita=");
		builder.append(disponibilita);
		builder.append("]");
		return builder.toString();
	}
	
}
