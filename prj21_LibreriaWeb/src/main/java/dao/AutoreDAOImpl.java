package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DB;
import model.Autore;

public class AutoreDAOImpl implements AutoreDAO {

	DB db = new DB();
	Connection connessione;
	Statement stat;
	ResultSet rs;
	
	@Override
	public void addAutore(Autore autore) {
		
		String query = "insert into autore(nome,cognome,nazionalita)"
				+ " values('"+ autore.getNome() +"','"+ autore.getCognome()+"','"+ autore.getNazionalita()+"')";
		
		this.connessione = this.db.getConnection();
		try {
			this.stat = this.connessione.createStatement();
			this.stat.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateAutore(Autore autore) {

	}

	@Override
	public void deleteAutore(int id) {

	}

	@Override
	public Autore getAutoreByID(int id) {

		Autore tmpAutore = null;
		this.connessione = this.db.getConnection();
		try {
			this.stat = this.connessione.createStatement();
			this.rs = this.stat.executeQuery(FIND_ONE + id);
			while (rs.next()) {
				tmpAutore = new Autore();
				tmpAutore.setId(rs.getInt("id"));
				tmpAutore.setNome(rs.getString("nome"));
				tmpAutore.setCognome(rs.getString("cognome"));
				tmpAutore.setNazionalita(rs.getString("nazionalita"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tmpAutore;
	}

	@Override
	public ArrayList<Autore> getAutori() {
		ArrayList<Autore> autori = new ArrayList<Autore>();
		
		this.connessione = this.db.getConnection();
		try {
			this.stat = this.connessione.createStatement();
			this.rs = this.stat.executeQuery(FIND_ALL);
			while (rs.next()) {
				Autore tmpAutore = new Autore();
				tmpAutore.setId(rs.getInt("id"));
				tmpAutore.setNome(rs.getString("nome"));
				tmpAutore.setCognome(rs.getString("cognome"));
				tmpAutore.setNazionalita(rs.getString("nazionalita"));
				autori.add(tmpAutore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return autori;
	}

}
