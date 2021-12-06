package com.haghighipour.tvseries.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.haghighipour.tvseries.entites.Serie;

@Service
public interface SerieService {
	
	void addSerie(Serie serie);
	void deleteSerie(Serie serie);
	void updateSerie(Serie serie);
	List<Serie> getSeries();
	Serie getSerie(String titolo);
	List<Serie> getSeriesByGenere(String genere);
	Set<String> getAllGenere();
}
