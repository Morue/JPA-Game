package main.java.com.example.jpa;

import java.util.List;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import main.java.com.example.jpa.database.DatabaseHandle;
import main.java.com.example.jpa.database.model.Player;
import main.java.com.example.jpa.database.model.Engin;
import main.java.com.example.jpa.database.model.Partie;
import main.java.com.example.jpa.database.model.Personnage;

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
		TypedQuery<Player> query = em.createQuery("FROM Player", Player.class);
		System.out.println("Nombre de joueurs : " + query.getResultList().size());
		System.out.println(query.getResultList());

		// the persistent object is modified
		// p.setPseudo("JeanMichelPseudo");

		// the new objet is transient

		Partie part1 = new Partie();
		part1.setNiveau(10);
		part1.setScore(685654552);
		part1.setDate_DATE(LocalDate.of(1993, 3, 3));

		// this object become a persistent object
		em.persist(part1);

		Partie part2 = new Partie();
		part2.setNiveau(5);
		part2.setScore(52394);
		part2.setDate_DATE(LocalDate.of(2003, 5, 6));

		// this object become a persistent object
		em.persist(part2);
		
		TypedQuery<Partie> query2 = em.createQuery("FROM Partie", Partie.class);
		System.out.println(query2.getResultList());
		
		Personnage perso1 = new Personnage();
		perso1.setNom("Gudul");
		perso1.setPuissance(50000);
		em.persist(perso1);
		
		Personnage perso2 = new Personnage();
		perso2.setNom("Machin");
		perso2.setPuissance(35000);
		em.persist(perso2);
		
		TypedQuery<Personnage> query3 = em.createQuery("FROM Personnage", Personnage.class);
		System.out.println(query3.getResultList());
		
		Engin engin1 = new Engin();
		engin1.setVitesse_max(50);
		engin1.setCouleur("bleu");
		em.persist(engin1);
		
		Engin engin2 = new Engin();
		engin2.setVitesse_max(30);
		engin2.setCouleur("rouge");
		em.persist(engin2);
		
		TypedQuery<Engin> query4 = em.createQuery("FROM Engin", Engin.class);
		System.out.println(query4.getResultList());

		// p = em.find(Player.class, 1);
		// System.out.println(p.toString());

		// all the objects will be detached

		

		try {
			for (Partie partie : query2.getResultList()) {
				partie.setNiveau(partie.getNiveau() + 1);
			}
			transaction.commit();

		} catch (Exception e) {
			System.out.println("Pas d'ajout de niveau");
			transaction.rollback();
		}

		System.out.println(query2.getResultList());

		em.close();
		System.exit(0);
	}

}
