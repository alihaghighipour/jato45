package com.haghighipour.tvseries.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haghighipour.tvseries.entites.Serie;

public interface SerieDAO extends JpaRepository<Serie, Integer> {
	
}
