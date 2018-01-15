package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			
			// create  object
		Instructor tempInstructor = new Instructor("chad", "Darby", "darby@luv2code.com");
		
		InstructorDetail tempInstructorDetail = new InstructorDetail("www.luv2code.com", "luv 2 code");
		
			//associate object
		tempInstructor.setInstructorDetail(tempInstructorDetail);
			
Instructor tempInstructor2 = new Instructor("sp", "Darby", "darby@luv2code.com");
		
		InstructorDetail tempInstructorDetail2 = new InstructorDetail("www.sp.com", "luv 2 code");
		
			//associate object
		tempInstructor2.setInstructorDetail(tempInstructorDetail2);
			// start a transaction
			session.beginTransaction();
			
			//save instructor
			//note: also save the detail object because of cascadetype all
			System.out.println("saving instructor : "+tempInstructor);
			System.out.println("saving instructor : "+tempInstructor2);
			session.save(tempInstructor);
			session.save(tempInstructor2);
			
			// commit transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





