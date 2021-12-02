package com.example.demo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true, nullable = false)
	public String movieName;

	@Column(unique = true, nullable = false)
	public String movieDirector;

	@Column(nullable = false)
	public int ageRating;

	@Column
	public int yearReleased;

	@Column
	public String movieGenre;

	@Column
	private String mainActor;

	@Column
	private int movieRuntime;

	// default constructor
	public Movies(String string, String string2, String string3, int i, int j, int k, String string4) {
		super();
	}

	public Movies(String movieName, String movieDirector, int movieRuntime, int ageRating, int yearReleased,
			String movieGenre, String mainActor) {

		super();
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieRuntime = movieRuntime;
		this.ageRating = ageRating;
		this.movieGenre = movieGenre;
		this.yearReleased = yearReleased;
		this.mainActor = mainActor;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public int getMovieRuntime() {
		return movieRuntime;
	}

	public void setMovieRuntime(int movieRuntime) {
		this.movieRuntime = movieRuntime;
	}

	public int getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}

	public int getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMainActor() {
		return mainActor;
	}

	public void setMainActor(String mainActor) {
		this.mainActor = mainActor;

	}

}
