package com.haghighipour.tvseries.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haghighipour.tvseries.dal.SerieDAO;
import com.haghighipour.tvseries.entites.Serie;

@Service
public class SerieSerivceImpl implements SerieService {

	@Autowired
	private SerieDAO repo;
	
	@Override
	public void addSerie(Serie serie) {
		this.repo.save(serie);
	}

	@Override
	public void deleteSerie(Serie serie) {
		this.repo.deleteById(serie.getId());
	}

	@Override
	public void updateSerie(Serie serie) {
		this.repo.save(serie);
	}

	@Override
	public List<Serie> getSeries() {
		return this.repo.findAll();
	}

	@Override
	public Serie getSerie(String titolo) {
		for (Serie serie: this.getSeries()) {
			if (serie.getTitolo().equals(titolo)) {
				return serie;
			}
		}
		return null;
	}

	@Override
	public List<Serie> getSeriesByGenere(String genere) {
		return this.getSeries()
				   .stream()
				   .filter((s) -> s.getGenere().equals(genere))
				   .toList();
	}

	@Override
	public Set<String> getAllGenere() {
		return this.getSeries()
				   .stream()
				   .map((s) -> s.getGenere())
				   .collect(Collectors.toSet());
	}

}
