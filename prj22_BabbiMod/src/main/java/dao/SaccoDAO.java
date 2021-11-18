package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Sacco;

public interface SaccoDAO {
	
	String FIND_ALL = "select * from sacchi";
	String FIND_ONE = "select * from sacchi where id = ?";
	String INSERT = "insert into sacchi(id_babbo) values(?)";
	String UPDATE = "update sacchi set id_babbo = ? where id = ?";
	String DELETE = "delete from sacchi where id = ?";
	
	void addSacco(Sacco sacco) throws SQLException;
	void updateSacco(Sacco sacco) throws SQLException;
	void deleteSacco(int id) throws SQLException;
	Sacco getSacco(int id) throws SQLException;
	ArrayList<Sacco> getSacchi() throws SQLException;
}