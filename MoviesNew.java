package movies;

public class MoviesNew {

	package com.example.demo;
	import java.util.Scanner;
	public class Runner {
	    // SQL -> Structured Query Language (mySQL workbench)
	    // Connect to a database -> to interact with it (CRUD -> Create, Read, Update,Delete
	   
	    // JDBC -> Java DataBase Connectivity - is an API which uses drivers to connect to database
	    
	     
	    private static Scanner sc = new Scanner(System.in);
	    private static String getInput() {
	        System.out.println("Enter CRUD choice: ");
	        return sc.nextLine();
	    }
	    public static void main(String[] args) {

	        MoviesQueries q = new MoviesQueries();
	        
	        // Ask for user input on CRUD choice and store it in the getInput() method, and now store it in the crud variable
	        String crud = getInput();
	        //do-while loop to start the loop
	        do {
	            //switch-case to match which CRUD to perform
	            switch (crud.toLowerCase()) {
	            case "create":
	                System.out.println("Enter movie name: ");
	                String n = sc.nextLine();
	                System.out.println("Enter movie director: ");
	                String c = sc.nextLine();
	                System.out.println("Enter movie genre: ");
	                String o = sc.nextLine();
	                System.out.println("Enter movie runtime: ");
	                String r = sc.nextLine();
	                System.out.println("Enter movie age-rating: ");
	                String a = sc.nextLine();
	                System.out.println(("Enter main actor: "));
	                String m = sc.nextLine();
	                
	                q.create(n, c, o, r, a, m);
	                break;
	            case "read":
	                q.read();
	                break;
	            case "update":
	                break;
	            case "delete":
	                break;
	            default:
	                System.out.println("Invalid CRUD choice");
	            }
	            //Check if the user wants to continue or break out of the loop
	            System.out.println("Would you like to continue (y/n)? ");
	            String quit = sc.nextLine();
	            if(quit.toLowerCase().equals("y")) {
	                crud = getInput();
	            }else {
	                crud = "exit";
	            }
	        } while (!crud.equals("exit"));
	        System.out.println("END");
	    }
	}