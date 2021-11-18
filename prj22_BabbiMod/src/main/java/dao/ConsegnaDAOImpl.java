package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import database.DB;
import model.Bambino;
import model.Consegna;
import model.Dono;
import model.Sacco;

public class ConsegnaDAOImpl implements ConsegnaDAO {

	DB db = new DB();
	/*
	 * verrano utilizatti per interagire con altre tabelle
	 */
	DonoDAO donoDAO = new DonoDAOImpl();
	BambinoDAO bambinoDAO = new BambinoDAOImpl();
	SaccoDAO saccoDAO = new SaccoDAOImpl();
	
	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public void addConsegna(Consegna consegna) throws SQLException {
		
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(INSERT);
		this.ps.setInt(1, consegna.getDono().getId());
		this.ps.setInt(2, consegna.getBambino().getId());
		this.ps.setInt(3, consegna.getSacco().getId());
	
	    Timestamp timestampAssegnazione = Timestamp.valueOf(consegna.getDataAssegnazione());
		this.ps.setString(4, timestampAssegnazione.toString());
		
		Timestamp timestampConsegna = Timestamp.valueOf(consegna.getDataConsegna());
		this.ps.setString(5, timestampConsegna.toString());
		this.ps.execute();
	}

	@Override
	public void updateConsegna(Consegna consegna) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(UPDATE);
		this.ps.setInt(1, consegna.getDono().getId());
		this.ps.setInt(2, consegna.getBambino().getId());
		this.ps.setInt(3, consegna.getSacco().getId());
		
	    Timestamp timestampAssegnazione = Timestamp.valueOf(consegna.getDataAssegnazione());
		this.ps.setString(4, timestampAssegnazione.toString());
		
		Timestamp timestampConsegna = Timestamp.valueOf(consegna.getDataConsegna());
		this.ps.setString(5, timestampConsegna.toString());
		
		this.ps.setInt(6, consegna.getId());
		this.ps.execute();
	}

	@Override
	public void deleteConsegna(int id) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(DELETE);
		this.ps.setInt(1, id);
		this.ps.execute();
	}

	@Override
	public Consegna getConsegna(int id) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(FIND_ONE);
		this.ps.setInt(1, id);
		this.rs = this.ps.executeQuery();
		this.rs.next();
		
		Consegna consegna = new Consegna(); 
		consegna.setId(this.rs.getInt("id"));
		
		int idDonoTmp = this.rs.getInt("id_dono");
		int idBambinoTmp = this.rs.getInt("id_bambino");
		int idSaccoTmp = this.rs.getInt("id_sacco");
		
		Dono dono = new Dono();
		Bambino bambino = new Bambino();
		Sacco sacco = new Sacco();
		
		dono = donoDAO.getDono(idDonoTmp);
		bambino = bambinoDAO.getBambino(idBambinoTmp);
		sacco = saccoDAO.getSacco(idSaccoTmp);
		
		consegna.setDono(dono);
		consegna.setBambino(bambino);
		consegna.setSacco(sacco);
		
		String dataAssegnazione = this.rs.getString("data_assegnazione"); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDateTimeAssegnazione = LocalDateTime.parse(dataAssegnazione, formatter);
		
		String dataConsegna = this.rs.getString("data_consegna"); 
		LocalDateTime localDateTimeConsegna = LocalDateTime.parse(dataConsegna, formatter);
		
		consegna.setDataAssegnazione(localDateTimeAssegnazione);
		consegna.setDataConsegna(localDateTimeConsegna);
		return consegna;
	}

	@Override
	public ArrayList<Consegna> getConsegne() throws SQLException {
		
		ArrayList<Consegna> consegne = new ArrayList<Consegna>();
		
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(FIND_ALL);
		this.rs = this.ps.executeQuery();
		while (rs.next()) {
			Consegna consegna = new Consegna(); 
			consegna.setId(this.rs.getInt("id"));
			
			int idDonoTmp = this.rs.getInt("id_dono");
			int idBambinoTmp = this.rs.getInt("id_bambino");
			int idSaccoTmp = this.rs.getInt("id_sacco");
			
			Dono dono = new Dono();
			Bambino bambino = new Bambino();
			Sacco sacco = new Sacco();
			
			dono = donoDAO.getDono(idDonoTmp);
			bambino = bambinoDAO.getBambino(idBambinoTmp);
			sacco = saccoDAO.getSacco(idSaccoTmp);
			
			consegna.setDono(dono);
			consegna.setBambino(bambino);
			consegna.setSacco(sacco);
			
			String dataAssegnazione = this.rs.getString("data_assegnazione"); 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime localDateTimeAssegnazione = LocalDateTime.parse(dataAssegnazione, formatter);
			
			String dataConsegna = this.rs.getString("data_consegna"); 
			LocalDateTime localDateTimeConsegna = LocalDateTime.parse(dataConsegna, formatter);
			
			consegna.setDataAssegnazione(localDateTimeAssegnazione);
			consegna.setDataConsegna(localDateTimeConsegna);
			
			consegne.add(consegna);
		}
		
		return consegne;
	}
	
}
