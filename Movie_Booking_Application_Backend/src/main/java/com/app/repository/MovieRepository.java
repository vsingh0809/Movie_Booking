package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.dto.MovieDto;
import com.app.entities.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	List<Movie> findByTitle(String title);
	List<Movie> findByGenre(String genre);
	List<Movie> findByLanguage(String language);
}
