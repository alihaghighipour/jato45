package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DB;
import model.Babbo;
import model.Dono;
import model.Sacco;

public class SaccoDAOImpl implements SaccoDAO {
	
	DB db = new DB();
	BabboDAO babboDAO = new BabboDAOImpl();
	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public void addSacco(Sacco sacco) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(INSERT);
		this.ps.setInt(1, sacco.getBabbo().getId());
		this.ps.execute();
	}

	@Override
	public void updateSacco(Sacco sacco) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(UPDATE);
		this.ps.setInt(1, sacco.getBabbo().getId());
		this.ps.setInt(2, sacco.getId());
		this.ps.execute();
	}

	@Override
	public void deleteSacco(int id) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(DELETE);
		this.ps.setInt(1, id);
		this.ps.execute();
	}

	@Override
	public Sacco getSacco(int id) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(FIND_ONE);
		this.ps.setInt(1, id);
		this.rs = this.ps.executeQuery();
		
		this.rs.next();
		Sacco sacco = new Sacco();
		sacco.setId(this.rs.getInt("id"));
		
		Babbo babbo = new Babbo();
		babbo = babboDAO.getBabbo(this.rs.getInt("id_babbo"));
		sacco.setBabbo(babbo);
		
		return sacco;
	}

	@Override
	public ArrayList<Sacco> getSacchi() throws SQLException {
		
		ArrayList<Sacco> sacchi = new ArrayList<Sacco>();
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(FIND_ALL);
		this.rs = this.ps.executeQuery();
		
		while(this.rs.next()) {
			Sacco sacco = new Sacco();
			sacco.setId(this.rs.getInt("id"));
			
			Babbo babbo = new Babbo();
			babbo = babboDAO.getBabbo(this.rs.getInt("id_babbo"));
			sacco.setBabbo(babbo);
			
			sacchi.add(sacco);
		}
		
		return sacchi;
	}


}
