package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DB;
import model.Sacco;

public class SaccoDAOImpl implements SaccoDAO {
	
	DB db = new DB();
	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public void addSacco(Sacco sacco) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(INSERT);
		this.ps.setString(1, sacco.getNome());
		this.ps.setInt(2, sacco.getBabbo().getId());
		
		for(int i = 0; i < sacco.getConsegne().size(); i++) {
			
			this.ps.setInt(3, sacco.getConsegne().get(i).getId());
			this.ps.execute();
		}
	}

	@Override
	public void updateSacco(Sacco sacco) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(UPDATE);
		this.ps.setString(1, sacco.getNome());
		this.ps.setInt(2, sacco.getBabbo().getId());
		this.ps.setString(4, sacco.getNome());
	}

	@Override
	public void deleteSacco(String nome) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Sacco getSacco(String nome) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Sacco> getSacchi() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
