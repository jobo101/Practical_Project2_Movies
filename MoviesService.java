package com.example.demo;


	import java.util.Optional;

	import org.springframework.stereotype.Service;

	@Service

	public class MoviesService {
		private MoviesRepo repo;

		public MoviesService(MoviesRepo repo) {
			this.repo = repo;
		}

		public List<Movies> getAllMovies() {
			// SELECT * FROM movies;	
			return this.repo.findALL();
		}

		public Movies updateMovies(Movies movie, Integer id) {
			// find the movie to update

			Optional<Movies> MoviesToFind = this.repo.findById(id);
			;
			Optional<Movies> movieToFind = null;
			Movies movieToUpdate = movieToFind.get();

			// set that movie with the new values
			movieToUpdate.setMovieName(movie.getMovieName());
			movieToUpdate.setMovieDirector(movie.getMovieDirector());
			movieToUpdate.setMovieGenre(movie.getMovieGenre());
			movieToUpdate.setMovieRuntime(movie.getMovieRuntime());
			movieToUpdate.setAgeRating(movie.getAgeRating());
			movieToUpdate.setMainActor(movie.getMainActor());

			// save updated movie
			return this.repo.save(movieToUpdate);

		}
	}

