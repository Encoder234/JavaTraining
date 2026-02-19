package module7.activity3.service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import module7.activity3.model.Movie;
import module7.activity3.repository.MovieRepository;
import module7.activity3.util.EntityManagerUtil;


public class MovieService {
	
    EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
	MovieRepository movieRepository = new MovieRepository(em);
	
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	public void insertMovie(Movie movie) {		
		try {
	        	EntityTransaction tx = em.getTransaction(); 
	        	tx.begin();   
				movieRepository.save(movie);
				tx.commit();			        
	        } catch (Exception e) {
				e.printStackTrace();
			}	
	}
	
}
