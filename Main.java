package module7.activity1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
	
	private static final Logger logger =  LoggerFactory.getLogger(Main.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	 
    public static void main(String[] args) {
    	// intialize entityManager;
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
        // initialize movieRepository
    	MovieRepository movieRepository = new MovieRepository(em);
    	
    	// Start server on port 4567 (default)
    	port(4567);
        
        // add routes here
       
    	 get("/movies", (req, res) -> {
		      res.type("application/json");
		      return JsonUtil.toJson(movieRepository.findAll());
	      });
    	
         post("/movies", (req, res) -> {
 	    	res.type("application/json");
 		      
 	        try {
 	        	EntityTransaction tx = em.getTransaction(); 
 	        	tx.begin();
 	        	
 				movieRepository.save(JsonUtil.fromJson(req.body(), Movie.class));
 				tx.commit();
 				
 				return JsonUtil.toJson(Map.of("Result", "Movie Successsfully Inserted!"));
 	        
 	        } catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 				return JsonUtil.toJson(Map.of("Result", "Error! Failed to insert movie!"));
 			}
 	      });
    	 
    	 	
        // Get Profile List
        
        // Create Profile List
                  
	      
    }
    
    

}
