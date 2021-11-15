package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DB;
import model.Bambino;

public class BambinoDAOImpl implements BambinoDAO {
	
	DB db = new DB();
	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	
	
	@Override
	public void addBambino(Bambino bambino) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(INSERT);
		this.ps.setString(1, bambino.getNome());
		this.ps.setString(2, bambino.getIndirizzo());
		this.ps.execute();
	}

	@Override
	public void updateBambino(Bambino bambino) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(UPDATE);
		this.ps.setString(1, bambino.getNome());
		this.ps.setString(2, bambino.getIndirizzo());
		this.ps.setInt(3, bambino.getId());
		this.ps.execute();
	}

	@Override
	public void deleteBambino(int id) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(DELETE);
		this.ps.setInt(1, id);
		this.ps.execute();
	}

	@Override
	public Bambino getBambino(int id) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(FIND_ONE);
		this.ps.setInt(1, id);
		this.rs = this.ps.executeQuery();
		this.rs.next();
		
		Bambino bambino = new Bambino();
		int idTmp = this.rs.getInt("id");
		String nomeTmp = this.rs.getString("nome");
		String indirizzoTmp = this.rs.getString("indirizzo");
		
		bambino.setId(idTmp);
		bambino.setNome(nomeTmp);
		bambino.setIndirizzo(indirizzoTmp);
		
		return bambino;
	}

	@Override
	public ArrayList<Bambino> getBambini() throws SQLException {
		
		ArrayList<Bambino> bambini = new ArrayList<Bambino>();
		
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(FIND_ALL);
		this.rs = this.ps.executeQuery();
		
		while (rs.next()) {
			
			Bambino bambino = new Bambino();
			int idTmp = this.rs.getInt("id");
			String nomeTmp = this.rs.getString("nome");
			String indirizzoTmp = this.rs.getString("indirizzo");
			
			bambino.setId(idTmp);
			bambino.setNome(nomeTmp);
			bambino.setIndirizzo(indirizzoTmp);
			
			bambini.add(bambino);
		}
		
		return bambini;
	}

}
