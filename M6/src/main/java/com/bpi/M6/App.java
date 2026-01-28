package com.bpi.M6;

import com.bpi.M6.model.Course;
import com.bpi.M6.model.Student;

import jakarta.persistence.EntityManager;

/**
 * Hello world!
 *
 */
public class App
{
	public static void main(String[] args) {
    	//testConnection();
    	
    	EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
    	try {
			//runM6Activity2(em);
			
			persistOneToMany(em);
			
			
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		}

   }
	
	static void runM6Activity2(EntityManager em) {
		
		try {
			em.getTransaction().begin();

			Student newStudent = new Student();
			newStudent.setName("Juan Dela Cruz");
			newStudent.setAge(50);
			newStudent.setEmail("juandelacruz@gmail.com");

			em.persist(newStudent);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // runM6Activity2()

   
   static void testConnection() {
    	EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	
    	try {
    		if(em.isOpen()) {
    			System.out.println("entity manager open, ready to create transaction");
    		}
    		
    	} finally {
    		EntityManagerUtil.getInstance().closeEntityManager(em);
    		EntityManagerUtil.getInstance().shutdownFactory();
    	}
  } // testConnection()
   
   
   static void persistOneToMany(EntityManager em) {
		em.getTransaction().begin();
		
		Student student1 = em.find(Student.class, 1L);
		
		Course newCourse = new Course();
		newCourse.setCourseName("Spanish");
		newCourse.setGrade(80.00);
		newCourse.setStudent(student1);
		
		em.persist(newCourse);
		
		em.getTransaction().commit();
	} // persistOneToMany ()


}
