package com.haghighipour.tvseries.integration;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haghighipour.tvseries.entites.Serie;
import com.haghighipour.tvseries.services.SerieService;

@RestController
@RequestMapping("/api")
public class SerieRestCtrl {
	
	@Autowired
	private SerieService service;
	
	@PostMapping(path = "/insert", consumes = "application/json")
	public void addOne(@RequestBody Serie serie) {
		this.service.addSerie(serie);
	}
	
	@GetMapping("")
	public List<Serie> getAll() {
		return this.service.getSeries();
	}
	
	@GetMapping("/{titolo}")
	public Serie getOne(@RequestBody String titolo) {
		return this.service.getSerie(titolo);
	}
	
	@GetMapping("/generi/{genere}")
	public List<Serie> getAllByGenere(@RequestBody String genere) {
		return this.service.getSeriesByGenere(genere);
	}
	
	@GetMapping("/generi")
	public Set<String> getAllGenere() {
		return this.service.getAllGenere();
	}
}
