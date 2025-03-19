package com.app.service;

import java.util.List;
import java.util.Optional;
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

	public MovieDto addMovie(MovieDto movieDto) {
		// TODO Auto-generated method stub
		Movie newMovie=mapper.map(movieDto, Movie.class);
		Movie savedMovie=movieRepository.save(newMovie);
		return mapper.map(savedMovie, MovieDto.class);
	}

	public List<MovieDto> getAllMoviesGenre(String genre) {
		// TODO Auto-generated method stub
		
		return movieRepository.findByGenre(genre).stream().map(m->mapper.map(m,MovieDto.class )).toList();
	}

	public List<MovieDto> getAllMoviesByLanguage(String language) {
		// TODO Auto-generated method stub
		return movieRepository.findByLanguage(language).stream().map(m->mapper.map(m,MovieDto.class )).toList();

	}
	public List<MovieDto> getAllMoviesByTitle(String title) {
		// TODO Auto-generated method stub
		return movieRepository.findByTitle(title).stream().map(m->mapper.map(m,MovieDto.class )).toList();

	}
	public void deleteMovie(Long id) {
	    movieRepository.deleteById(id);
	}
	public MovieDto updateMovie(Long id,MovieDto movieDto) {
		Movie movie=movieRepository.findById(id).orElseThrow(()->new RuntimeException("Movie not found"));
		mapper.map(movieDto,movie );
		Movie updatedMovie=movieRepository.save(movie);
		return mapper.map(updatedMovie,MovieDto.class);
	}

}
