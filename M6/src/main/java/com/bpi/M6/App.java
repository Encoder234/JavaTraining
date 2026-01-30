package com.bpi.M6;

import java.util.List;

import com.bpi.M6.model.Course;
import com.bpi.M6.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * Hello world!
 *
 */
public class App
{
	public static void main(String[] args) {
    	EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
    	try {
    		//testConnection();
			//runM6Activity2(em);
			//persistOneToMany(em);
			//m6Activity4Solution(em);
    		//printAllStudentNames(em);
    		//countCoursesByStudentId(em, (long) 1);
    		//countStudentsByAgeGreaterThan(em,15);
    		printAllStudentNamesCQ(em);
    		countCoursesByStudentIdCQ(em, (long) 1);
    		countStudentsByAgeGreaterThanCQ(em,15);
    		
		} finally {
			EntityManagerUtil.getInstance().closeEntityManager(em);
			EntityManagerUtil.getInstance().shutdownFactory();
		} //try
   } // main
	
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
	}// m6Activity4Solution()
   
   
   static void printAllStudentNames(EntityManager em) {
	   try {
		   em.getTransaction().begin();
		   String jpql = "Select s FROM Student s";
		   TypedQuery<Student> query = em.createQuery(jpql, Student.class);
		   List<Student> students = query.getResultList();
		   //print student names
		   students.forEach(student -> System.out.println(student.getName()));
		   em.getTransaction().commit();
	   } catch (Exception e) {
		   e.printStackTrace();
	   } // try	   
   } // printAllStudentNames
   
   
   static Long countCoursesByStudentId(EntityManager em, Long id) {
	   try {
		   em.getTransaction().begin();
		   //String jpql = "SELECT COUNT(c) FROM Course c WHERE c.student.id = ?1";
		   String jpql = "SELECT COUNT(c) FROM Course c JOIN c.student s WHERE s.id = ?1";
		   TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		   query.setParameter(1, id);
		   Long count = query.getSingleResult();
		   System.out.println("Number of courses by Student: " + id + " is: " + count);
		   em.getTransaction().commit();
		   return count;
	   } catch (Exception e) {
		   e.printStackTrace();
		   return null;
	   } // try
	   
   } // countCoursesByStudentId()
   
   static Long countStudentsByAgeGreaterThan(EntityManager em, int age) {
	   try {
	
		   em.getTransaction().begin();
		   String jpql = "SELECT COUNT(s) FROM Student s WHERE s.age > ?1";
		   TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		   query.setParameter(1, age);
		   Long count = query.getSingleResult();
		   System.out.println("Number of Student with age greater than: " + age + " is: " + count);
		   em.getTransaction().commit();
		   return count;
	   } catch (Exception e) {
		   e.printStackTrace();
		   return null;
	   } // try 
	   
   } //countStudentsByAgeGreaterThan()
   

   static void printAllStudentNamesCQ(EntityManager em) {
	   try {	   		   
		   CriteriaBuilder cb = em.getCriteriaBuilder();
		   CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		   Root<Student> root = cq.from(Student.class);
		   cq.select(root);
		   TypedQuery<Student> query = em.createQuery(cq);
		   List<Student> result = query.getResultList();
		   result.forEach(student -> System.out.println(student.getName()));		   	   	   
	   } catch (Exception e) {
		   e.printStackTrace();
	   } // try	   
   } // printAllStudentNamesCQ
   
   static Long countCoursesByStudentIdCQ(EntityManager em, Long id) {
	   try {	  
		    em.getTransaction().begin();
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
	        Root<Course> courseRoot = cq.from(Course.class);
	        Join<Course, Student> studentJoin = courseRoot.join("student");
	        cq.select(cb.count(courseRoot)).where(cb.equal(studentJoin.get("id"), id));
	        Long count = em.createQuery(cq).getSingleResult();
	        System.out.println("Number of courses by Student: " + id + " is: " + count);
	        em.getTransaction().commit();
	        return count;	    
	   } catch (Exception e) {
		   e.printStackTrace();
		   return null;
	   } // try
	   
   } // countCoursesByStudentIdCQ()
   
   
   static Long countStudentsByAgeGreaterThanCQ(EntityManager em, int age) {
	   try {
		    em.getTransaction().begin();
	        CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
	        Root<Student> studentRoot = cq.from(Student.class);
	        cq.select(cb.count(studentRoot)).where(cb.greaterThan(studentRoot.get("age"), age));
	        Long count = em.createQuery(cq).getSingleResult();
	        System.out.println("Number of Students with age greater than: " + age + " is: " + count);
	        em.getTransaction().commit();
	        return count;
	   } catch (Exception e) {
		   e.printStackTrace();
		   return null;
	   } // try 
	   
   } //countStudentsByAgeGreaterThanCQ()
   
   

} // class()
