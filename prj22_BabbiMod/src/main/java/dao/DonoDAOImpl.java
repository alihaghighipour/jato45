package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DB;
import model.Dono;

public class DonoDAOImpl implements DonoDAO {
	
	DB db = new DB();
	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public void addDono(Dono dono) throws SQLException {
		
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(INSERT);
		this.ps.setString(1, dono.getDesc());
		this.ps.setInt(2, dono.getDisponibilita());
		this.ps.execute();
	}

	@Override
	public void updateDono(Dono dono) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(UPDATE);
		this.ps.setString(1, dono.getDesc());
		this.ps.setInt(2, dono.getDisponibilita());
		this.ps.setInt(3, dono.getId());
		this.ps.execute();
	}

	@Override
	public void deleteDono(int id) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(DELETE);
		this.ps.setInt(1, id);
		this.ps.execute();
	}

	@Override
	public Dono getDono(int id) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(FIND_ONE);
		this.ps.setInt(1, id);
		this.rs = this.ps.executeQuery();
		this.rs.next();
		
		Dono dono = new Dono();
		dono.setId(this.rs.getInt("id"));
		dono.setDesc(this.rs.getString("descrizione"));
		dono.setDisponibilita(this.rs.getInt("disponibilita"));
		return dono;
	}

	@Override
	public ArrayList<Dono> getDoni() throws SQLException {
		
		ArrayList<Dono> doni = new ArrayList<Dono>();
		
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(FIND_ALL);
		this.rs = this.ps.executeQuery();
		while (rs.next()) {
			Dono dono = new Dono();
			dono.setId(this.rs.getInt("id"));
			dono.setDesc(this.rs.getString("descrizione"));
			dono.setDisponibilita(this.rs.getInt("disponibilita"));

			doni.add(dono);
		}
		
		return doni;
	}

}
