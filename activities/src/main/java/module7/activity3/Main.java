package module7.activity3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import module7.activity3.controller.MovieController;
import module7.activity3.service.MovieService;


import static spark.Spark.*;

public class Main {
	
	private static final Logger logger =  LoggerFactory.getLogger(Main.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	 
    public static void main(String[] args) {

    	port(4567);
    	
    	MovieService movieService = new MovieService();
    	MovieController movieController = new MovieController(movieService);
    	movieController.registerRoutes();
    	
    	logger.info("Server started at port {}", port() );             	 
    }
}
