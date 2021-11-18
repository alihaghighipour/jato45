package model;

import java.time.LocalDateTime;

public class Consegna {
	
	private int id;
	private Dono dono;
	private Bambino bambino;
	private Sacco sacco;
	private LocalDateTime dataAssegnazione;
	private LocalDateTime dataConsegna;
	
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

	public Sacco getSacco() {
		return sacco;
	}

	public void setSacco(Sacco sacco) {
		this.sacco = sacco;
	}

	public LocalDateTime getDataAssegnazione() {
		return dataAssegnazione;
	}

	public void setDataAssegnazione(LocalDateTime dataAssegnazione) {
		this.dataAssegnazione = dataAssegnazione;
	}

	public LocalDateTime getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(LocalDateTime dataConsegna) {
		this.dataConsegna = dataConsegna;
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
		builder.append(", sacco=");
		builder.append(sacco.getId());
		builder.append(", dataAssegnazione=");
		builder.append(dataAssegnazione);
		builder.append(", dataConsegna=");
		builder.append(dataConsegna);
		builder.append("]");
		return builder.toString();
	}
	
}
