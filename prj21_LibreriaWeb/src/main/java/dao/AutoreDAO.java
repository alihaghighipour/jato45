package dao;

import java.util.ArrayList;

import model.Autore;

public interface AutoreDAO {
	
	String FIND_ALL = "select * from autore";
	String FIND_ONE = "select * from autore where id = ";

	void addAutore(Autore autore);
	void updateAutore(Autore autore);
	void deleteAutore(int id);
	Autore getAutoreByID(int id);
	ArrayList<Autore> getAutori();
}
