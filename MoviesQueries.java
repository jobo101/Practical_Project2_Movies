package com.example.demo;



	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
    public class MoviesQueries { 
	    // To carry out the CRUD queries, we first need to access the database
	    // Four main things to do:
	    // - connection
	    // - Write your query (create a statement)
	    // - Execute query
	    // - Close connection
	    // Connect to database, we need: url, username, password
	    // static - only one instance of it
	    // final - fixed
	    public static final String URL = "jdbc:mysql://localhost:3306/movies";
	    public static final String USER = "root";
	    public static final String PASS = "root";
	    private Connection conn;
	    private Statement stmt;
	    // open connection in the constructor - initialise anything
	    public MoviesQueries() {
	        // Exceptions -> Abnormal conditions which affect the flow of the application
	        // but can be handled using try-catch blocks
	        // Try-catch block -> try{code}catch(exception){do this instead}
	        try {
	            conn = DriverManager.getConnection(URL, USER, PASS);
	            this.stmt = conn.createStatement(); // create a statement object to execute sql queries
	            System.out.println("Connection Successful!!");
	        } catch (SQLException e) {
	            System.out.println("Incorrect credentials");
	            e.printStackTrace();
	        }
	    }
	    // Need a way to run queries - call these methods from the Statement class:
	    // - executeQuery -> retrieving info -> READ
	    // - executeUpdate -> passing info through, return nothing -> CREATE, UPDATE,
	    // DELETE
	    // CREATE - INSERT INTO .... -> returns nothing, just say "OK"
	    public void create(String mName, String dir, String gen, String len, String age, String main) {
	        String createStmt = "INSERT INTO movies(movie_id, movie_name, movie_director, movie_year_released, movie_genre,  movie _age_rating, movie_main_actor) VALUES('" + mName + "','" + dir + "','"+ gen + "','"  + len + "','";
	        try {
	            stmt.executeUpdate(createStmt);
	            System.out.println("Statement executed");
	        } catch (SQLException e) {
	            System.out.println("Bad query");
	            e.printStackTrace();
	        }
	    }
	    
	    // READ - SELECT .... -> returns info
	        public void read() {
	            String read = "SELECT * FROM movies;";
	            ResultSet rs;
	            
	            try {
	                rs = stmt.executeQuery(read);
	                while(rs.next()) {
	                    System.out.println("ID:" + rs.getInt("id") + ", Movie Name: "+ rs.getString("movie_name")+ ",Movie Director: "+ rs.getString("director"));
	                }
	                
	                
	            } catch (SQLException e) {
	                System.out.println("Bad query");
	                e.printStackTrace();
	            }
	            
	        }
	    
	    
	}