package module7.activity3.controller;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import module7.activity3.model.Movie;
import module7.activity3.repository.MovieRepository;
import module7.activity3.service.MovieService;
import module7.activity3.util.EntityManagerUtil;
import module7.activity3.util.JsonUtil;

public class MovieController {

		private MovieService movieService;
	
		public MovieController(MovieService movieService) {
			this.movieService = movieService;
		}


		public void registerRoutes() {
						
			 //Get Movies
			 get("/movies", (req, res) -> {
			      res.type("application/json");	            		       
			      return JsonUtil.toJson(movieService.findAll());
		      });
	    	
			 	 
			 //Insert new Movie
	         post("/movies", (req, res) -> {
	 	    	res.type("application/json");
	 		      
	 	        try {
//	 	        	EntityTransaction tx = em.getTransaction(); 
//	 	        	tx.begin();
	 	        	
	 				//movieRepository.save(JsonUtil.fromJson(req.body(), Movie.class));
	 				movieService.insertMovie(JsonUtil.fromJson(req.body(), Movie.class));
	 				
//	 				tx.commit();
	 				
	 				return JsonUtil.toJson(Map.of("Result", "Movie Successsfully Inserted!"));
	 	        
	 	        } catch (Exception e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 				return JsonUtil.toJson(Map.of("Result", "Error! Failed to insert movie!"));
	 			}
	 	        
	 	        
	 	        
	 	      });
					
		}
	
}
