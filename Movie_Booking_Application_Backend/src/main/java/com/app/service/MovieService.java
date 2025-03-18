package com.app.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.MovieDto;
import com.app.entities.Movie;
import com.app.repository.MovieRepository;
@Service
public class MovieService{
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ModelMapper mapper;

	public List<MovieDto> getAllMovies() {
		// TODO Auto-generated method stub
		
		return movieRepository.findAll().stream().map(m->mapper.map(m, MovieDto.class)).collect(Collectors.toList());
	}

	public Movie addMovie(MovieDto movieDto) {
		// TODO Auto-generated method stub
		Movie newMovie=mapper.map(movieDto, Movie.class);
		return movieRepository.save(newMovie);
	}

//	public Object getAllMoviesGenre(String genre) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Object getAllMoviesByLanguage(String language) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
