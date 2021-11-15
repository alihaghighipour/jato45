package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DB;
import model.Bambino;
import model.Consegna;
import model.Dono;

public class ConsegnaDAOImpl implements ConsegnaDAO {

	DB db = new DB();
	/*
	 * verrano utilizatti per interagire con altre tabelle
	 */
	DonoDAO donoDAO = new DonoDAOImpl();
	BambinoDAO bambinoDAO = new BambinoDAOImpl();
	
	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public void addConsegna(Consegna consegna) throws SQLException {
		
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(INSERT);
		this.ps.setInt(1, consegna.getDono().getId());
		this.ps.setInt(2, consegna.getBambino().getId());
		this.ps.execute();
	}

	@Override
	public void updateConsegna(Consegna consegna) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(UPDATE);
		this.ps.setInt(1, consegna.getDono().getId());
		this.ps.setInt(2, consegna.getBambino().getId());
		this.ps.setInt(3, consegna.getId());
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

		Dono dono = new Dono();
		Bambino bambino = new Bambino();
		
		dono = donoDAO.getDono(idDonoTmp);
		bambino = bambinoDAO.getBambino(idBambinoTmp);
		
		consegna.setDono(dono);
		consegna.setBambino(bambino);
		
		
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

			Dono dono = new Dono();
			Bambino bambino = new Bambino();
			
			dono = donoDAO.getDono(idDonoTmp);
			bambino = bambinoDAO.getBambino(idBambinoTmp);
			
			consegna.setDono(dono);
			consegna.setBambino(bambino);
			
			consegne.add(consegna);
		}
		
		return consegne;
	}

}
