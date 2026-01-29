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
			//persistOneToMany(em);
			
			m6Activity4Solution(em);
			
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

   static void m6Activity4Solution (EntityManager em) {
	   
	   try {
		   em.getTransaction ().begin();
		   // 1. create Student object, assign values
			Student newStudent = new Student();
			newStudent.setName("Monkey D. Luffy");
			newStudent.setAge(19);
			newStudent.setEmail("luffy@onepiece.com");	   
		   // 2. attach transient student object to persistence context
			em.persist(newStudent);	
			// 3. call flush()
			em.flush();	
		   // 4. detach the managed newStudent from the persistence context   
			em.detach(newStudent);	
			// 5. print "is newStudent inside the persistence context: " + call contains()
		   System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent ));
		   // 6. reattach the detached newStudent   
		   newStudent = em.merge(newStudent);
		   // 7. update newStudent, change some values like age or email   
		   newStudent.setAge(20);
		   newStudent.setEmail("stawhatluffy@onepiece.com");   
		   // 8. call flush()  
		   em.flush(); 
		   // 9. print "is newStudent inside the persistence context: " + call contains()
		   System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent ));
		   // 10. mark managed newStudent for deletion
		   em.remove(newStudent);
		   // 11. call flush()
		   em.flush();
		   // 12. print "is newStudent inside the persistence context: " + call contains()
		   System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent ));	   
		   em.getTransaction ().commit();
		   
	   } catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   
	  }
   

}
