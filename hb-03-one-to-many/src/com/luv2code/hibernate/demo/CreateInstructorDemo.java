package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			
		
			
			
			// create  object
			Instructor tempInstructor = new Instructor("susan", "public", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.luv2code.com", "video game");
			
				//associate object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
				
			// start a transaction
			session.beginTransaction();
					
				//save instructor
				//note: also save the detail object because of cascadetype all
				System.out.println("saving instructor : "+tempInstructor);
				
				session.save(tempInstructor);
				
				
			// commit transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





