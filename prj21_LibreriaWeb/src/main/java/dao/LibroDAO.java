package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.DB;
import model.Libro;

/*
 * DAO = data access object
 */
public class LibroDAO {
	private Connection connection;
	private Statement stat;
	private ResultSet rs;
	
	private DB db = new DB();
	
	public ArrayList<Libro> getLibri() {
		ArrayList<Libro> libri = new ArrayList<Libro>();
		
		this.connection = db.connect();
		try {
			this.stat = this.connection.createStatement();
			String queryString = "select id, titolo, prezzo from libro";
			this.rs = this.stat.executeQuery(queryString);
			while (rs.next()) {
				int id = rs.getInt("id"); // name or index of the column
				String titolo = rs.getString("titolo");
				double prezzo = rs.getDouble("prezzo");
				Libro libro = new Libro(id, titolo, prezzo);
				libri.add(libro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return libri;
	}
}
