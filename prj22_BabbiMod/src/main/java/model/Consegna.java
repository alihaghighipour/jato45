package model;

public class Consegna {
	
	private int id;
	private Dono dono;
	private Bambino bambino;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Dono getDono() {
		return dono;
	}
	
	public void setDono(Dono dono) {
		this.dono = dono;
	}
	
	public Bambino getBambino() {
		return bambino;
	}
	
	public void setBambino(Bambino bambino) {
		this.bambino = bambino;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Consegna [id=");
		builder.append(id);
		builder.append(", dono=");
		builder.append(dono.getDesc());
		builder.append(", bambino=");
		builder.append(bambino.getNome());
		builder.append("]");
		return builder.toString();
	}	
	
}
