package main.java.com.example.jpa.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.annotations.Synchronize;

public class DatabaseHandle {

	// Create an EntityManagerFactory when you start the application.
	private static EntityManager entityManager;
	
	public static synchronized EntityManager getEntityManagerFactory()
	{
		if (entityManager == null || ! entityManager.isOpen())
		{
			entityManager = Persistence.createEntityManagerFactory("jpa-game").createEntityManager();
		}
		
		return entityManager;
	}
	
	

}

	
	


