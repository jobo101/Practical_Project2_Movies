
package com.example.demo;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/movies")

public class MoviesController {
	
	List<Movies> movies = List.of(
			new Movies("Blue Velvet", "David Lynch", "Film Noir", 120 , 1986, 18,"Kyle Machlaclan"),
			new Movies("Resevoir Dogs","Quentin Tarantino", "Thriller", 99, 1992, 18, "Harvey Keitel"),
			new Movies("No Country for Old Men", "Coen Brothers", "Drama", 122, 2007, 18, "Javier Bardem"),
			new Movies("Physco", "Alfred Hitchcock", "Horror", 109, 1960, 16, "Anthony Perkins"),
			new Movies("Trainspotting", "Danny Boyle", "Comedy", 121, 1996, 18,"Ewen McGregor"),
			new Movies("Hot Fuzz", "Nick Frost", "Comedy", 100, 2007, 16, "Simon Pegg"),
			new Movies("Alien", "Ridley Scott", "Sci-Fi", 117, 1979, 16, "Sigourney Weaver"),
			new Movies("Do the Right Thing", "Spike Lee", "Black Comedy", 120, 1989, 16, "John Tuturro") 
			);
		
	
	//localhost:8080/movie
	//127.0.0.1:8080/movie
	@GetMapping
	public ResponseEntity<List<String>> get() {
		ResponseEntity<List<String>> response = new ResponseEntity<List<String>>(HttpStatus.OK);
		
		return response;
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<Movies>get(@PathVariable("id")Integer id) ;


