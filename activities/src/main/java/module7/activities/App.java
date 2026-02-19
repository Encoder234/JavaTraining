package module7.activities;

import static spark.Spark.*;              				// Spark Java

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; 	// Jackson
import org.slf4j.Logger;                  				// SLF4J API
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
   
		try {
			  // SLF4J logging
	        Logger log = LoggerFactory.getLogger(App.class);
	        log.info("SLF4J is working!");

	        // Jackson object mapper
	        ObjectMapper mapper = new ObjectMapper();
	        String json;
			
			json = mapper.writeValueAsString(new Person("Alice", 30));
			
			
			log.info("Jackson serialized object: " + json);

	        // Spark Java simple REST endpoint
	        get("/hello", (req, res) -> "Hello from Spark!");
	        log.info("Spark endpoint /hello is ready. Try http://localhost:4567/hello");
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
    
 // Simple POJO for Jackson
    static class Person {
        public String name;
        public int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    
    
}
