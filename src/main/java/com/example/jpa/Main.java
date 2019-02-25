package main.java.com.example.jpa;

import java.util.List;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import main.java.com.example.jpa.database.DatabaseHandle;
import main.java.com.example.jpa.database.model.Player;
import main.java.com.example.jpa.database.model.Partie;

public class Main {
	
	public static void main(String[] args) {

		EntityManager em = DatabaseHandle.getEntityManagerFactory();
		
		EntityTransaction transaction = em.getTransaction();
		
		// Begin the transaction
		transaction.begin();
		
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
		
		Partie part1 = new Partie();
		part1.setNiveau(10);
		part1.setScore(685654552);
		part1.setDate_DATE(LocalDate.of(1993,3,3));

		
		// this object become a persistent object
		em.persist(part1);
		
		
		Partie part2 = new Partie();
		part2.setNiveau(5);
		part2.setScore(52394);
		part2.setDate_DATE(LocalDate.of(2003,5,6));

		
		// this object become a persistent object
		em.persist(part2);
		
		//p = em.find(Player.class, 1);
		//System.out.println(p.toString());
		
		// all the objects will be detached
		
			  
		
		TypedQuery<Partie> query2 = em.createQuery("FROM Partie",Partie.class);
		System.out.println(query2.getResultList());
		
		try {
			for (Partie partie : query2.getResultList()){
			partie.setNiveau(partie.getNiveau()+1);
			}
			transaction.commit();
		
		}catch (Exception e) {
				System.out.println("Pas d'ajout de niveau");
				transaction.rollback();
			}
		
		System.out.println(query2.getResultList());
		
		em.close();
		System.exit(0);
	}


	
}
