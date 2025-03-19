package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.MovieDto;
import com.app.entities.Movie;
import com.app.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	public MovieService movieService;
	
	
	@GetMapping("/getMovies")
	public ResponseEntity<List<MovieDto>> getMovies(){
		
		return ResponseEntity.ok(movieService.getAllMovies());
	}
	@PostMapping("/addMovies")
	public ResponseEntity<MovieDto> addMovies(@RequestBody MovieDto movieDto){
		return ResponseEntity.ok(movieService.addMovie(movieDto));
	}
	@GetMapping("/getMoviesByGenre")
	public ResponseEntity<List<MovieDto>> getMoviesByGenre(@RequestParam String genre){
		
		return ResponseEntity.ok(movieService.getAllMoviesGenre(genre));
	}
	@GetMapping("/getMoviesByLanguage")
	public ResponseEntity<List<MovieDto>> getMoviesByLanguage(@RequestParam String language){
		
		return ResponseEntity.ok(movieService.getAllMoviesByLanguage(language));
	}
	@GetMapping("/getMoviesByTitle")
	public ResponseEntity<List<MovieDto>> getMoviesByTitle(@RequestParam String title){
		
		return ResponseEntity.ok(movieService.getAllMoviesByTitle(title));
	}
	@DeleteMapping("/deleteMovie/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
		 movieService.deleteMovie(id);
		 return ResponseEntity.ok().build();
	}
	@PutMapping("/updateMovies/{id}")
	public ResponseEntity<MovieDto> addMovies(@PathVariable Long id,@RequestBody MovieDto movieDto){
		return ResponseEntity.ok(movieService.updateMovie(id,movieDto));
	}
	
}
