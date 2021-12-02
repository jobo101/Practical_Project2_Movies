package com.example.demo;

class MyPracticalProjectApplicationTests {

import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoconfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.data.genre.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scrpipts = { "classpath:test-schema.sql", "classpath:test-data.sql" }
executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)

public class MovieControllerIntegrationTests {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void getAllMoviesTest()throws Exception {
		String listOfMoviesAsJSON = this.mapper
				.writeValueAsString(List.of(
						new Movies(1, "Hostel", "Eli Roth", 94, 18, "Horror", 2005, "Jay Hernandez"), 
						new Movies(2, "Hostel", "Eli Roth", 95, 18, "Horror", 2005, "Jay Hernandez")));
					
		RequestBuilder request = get("/movies");
		ResultMatcher status = status().isOk();
		ResultMatcher content =content().json(listOfMoviesAsJSON);
			
		this.mvc.perform(request).andExpect(status).andExpect(content);						
	}
@Test

void createMoviesTest()  throws Exeption {
	String testMoviesAsJson = this.mapper.writeValueAsString(
			new Movie (null, "The Godfather", "Francis Ford Coppola", 177, 15, "Drama", 1972, "Al Pacino" ));
			String tesMovieAsJsonResponse = this.mapper.writeValueAsString(testMoviesAsJson(
			new Movie (3, "The Godfather", "Francis Ford Coppola", 177, 15,"Drama", 1972, "Marlon Brando")
			);
			
			RequestBuilder request = get("/movie/create").contentType(MediaType.APPLICATION_JSON).content(testMovieAsJson);
			ResultMatcher status = status().isCreated();
			ResultMatcher content = conten().json(testMoviesAsJsonResponse);
			
			this.mvcperform(request).andExpect(content);
			
}

}	
	
	


