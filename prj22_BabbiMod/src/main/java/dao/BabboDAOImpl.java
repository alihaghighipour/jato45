package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DB;
import model.Babbo;

public class BabboDAOImpl implements BabboDAO {
	
	DB db = new DB();
	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public void addBabbo(Babbo babbo) throws SQLException {
		
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(INSERT);
		this.ps.setString(1, babbo.getNome());
		this.ps.setString(2, babbo.getPassword());
		this.ps.setString(3, babbo.getMezzoTrasporto());
		this.ps.setString(4, babbo.getZona());
		this.ps.execute();
	}

	@Override
	public void updateBabbo(Babbo babbo) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(UPDATE);
		this.ps.setString(1, babbo.getNome());
		this.ps.setString(2, babbo.getPassword());
		this.ps.setString(3, babbo.getMezzoTrasporto());
		this.ps.setString(4, babbo.getZona());
		this.ps.setInt(5, babbo.getId());
		this.ps.execute();
	}

	@Override
	public void deleteBabbo(int id) throws SQLException {
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(DELETE);
		this.ps.setInt(1, id);
		this.ps.execute();
	}

	@Override
	public Babbo getBabbo(int id) throws SQLException {
		
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(FIND_ONE);
		this.ps.setInt(1, id);
		this.rs = this.ps.executeQuery();
		this.rs.next();
		
		Babbo babbo = new Babbo();
		babbo.setId(this.rs.getInt("id"));
		babbo.setNome(this.rs.getString("nome"));
		babbo.setPassword(this.rs.getString("password"));
		babbo.setMezzoTrasporto(this.rs.getString("mezzo_trasporto"));
		babbo.setZona(this.rs.getString("zona"));
		
		return babbo;
	}

	@Override
	public ArrayList<Babbo> getBabbi() throws SQLException {
		
		ArrayList<Babbo> babbi = new ArrayList<Babbo>();
		
		this.connection = this.db.getConnection();
		this.ps = this.connection.prepareStatement(FIND_ALL);
		this.rs = this.ps.executeQuery();
		while (rs.next()) {
			Babbo babbo = new Babbo();
			babbo.setId(this.rs.getInt("id"));
			babbo.setNome(this.rs.getString("nome"));
			babbo.setPassword(this.rs.getString("password"));
			babbo.setMezzoTrasporto(this.rs.getString("mezzo_trasporto"));
			babbo.setZona(this.rs.getString("zona"));
			
			babbi.add(babbo);
		}
		
		return babbi;
	}

}
