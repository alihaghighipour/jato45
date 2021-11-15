package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Bambino;

public interface BambinoDAO {
	
	String FIND_ALL = "select * from bambini";
	String FIND_ONE = "select * from bambini where id = ?";
	String INSERT = "insert into bambini(nome, indirizzo) values(?,?)";
	String UPDATE = "update bambini set nome = ? , indirizzo = ? where id = ?";
	String DELETE = "delete from bambini where id = ?";	
	
	void addBambino(Bambino bambino) throws SQLException;
	void updateBambino(Bambino bambino) throws SQLException;
	void deleteBambino(int id) throws SQLException;
	Bambino getBambino(int id) throws SQLException;
	ArrayList<Bambino> getBambini() throws SQLException;
	
}
