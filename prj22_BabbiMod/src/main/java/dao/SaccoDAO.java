package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Sacco;

public interface SaccoDAO {
	
	String FIND_ALL = "select * from sacchi";
	String FIND_ONE = "select * from sacchi where nome = ?";
	String INSERT = "insert into sacchi(nome, id_babbo, id_consegna) values(?,?,?)";
	String UPDATE = "update sacchi set nome = ? , id_babbo = ?, id_consegna = ?  where nome = ?";
	String DELETE = "delete from sacchi where nome = ?";
	
	void addSacco(Sacco sacco) throws SQLException;
	void updateSacco(Sacco sacco) throws SQLException;
	void deleteSacco(String nome) throws SQLException;
	Sacco getSacco(String nome) throws SQLException;
	ArrayList<Sacco> getSacchi() throws SQLException;
}