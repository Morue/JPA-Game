package main.java.com.example.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import main.java.com.example.jpa.database.DatabaseHandle;
import main.java.com.example.jpa.database.model.Player;

public class Main {
	
	public static void main(String[] args) {

		EntityManager em = DatabaseHandle.getEntityManagerFactory();
		
		//EntityTransaction transaction = em.getTransaction();
		
		// Begin the transaction
		//transaction.begin();
		
		// the record is read and the object is now managed by Hibernate in memory
		Player p = em.find(Player.class, 1);
		System.out.println(p.toString());
		System.out.println(p.getNom());
		TypedQuery<Player> query = em.createQuery("FROM Player",Player.class);
		System.out.println("Nombre de joueurs : " + query.getResultList().size());
		System.out.println(query.getResultList());
		
		// the persistent object is modified
		//p.setPseudo("JeanMichelPseudo");
		
		// the new objet is transient
		//Player p2 = new Player();
		//p2.setId(1);
		//p2.setNom("Jean");
		//p2.setPseudo("JeanMichelPseudodu93");
		//p2.setMail("jeanmichel@mail.com");
		
		// this object become a persistent object
		//em.persist(p2);
		
		//p = em.find(Player.class, 1);
		//System.out.println(p.toString());
		
		// all the objects will be detached
		//transaction.commit();
		
		
		em.close();
		System.exit(0);
	}


	
}
