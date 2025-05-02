package com.iorta.sboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.MovieDTO;


@RestController
@RequestMapping("/movies") 
public class MovieController {
	
	private static final List<MovieDTO> movieList = Arrays.asList(
			new MovieDTO(1, "Inception", "Sci-Fi", 148, 8.8),
			new MovieDTO(2, "The Dark Knight", "Action", 152, 9.0),
			new MovieDTO(3, "Interstellar", "Sci-Fi", 169, 8.6),
			new MovieDTO(4, "The Matrix", "Sci-Fi", 136, 8.7)
	);
	
	@GetMapping("/{id}")
	public MovieDTO getMovieById(@PathVariable int id) {
		return movieList.stream()
				.filter(movie -> movie.getId() == id)
				.findFirst()
				.orElse(null);
	}

	

}
