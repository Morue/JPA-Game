package main.java.com.example.jpa.database.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table (name="personnage")
public class Personnage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_personnage;
	@Column(name = "nom", length = 30, nullable = false, unique = true)
	private String nom;
	@Column(name = "puissance", nullable = false)
	private Integer puissance;
	
	@OneToMany(mappedBy="personnage")
	private Set<Partie> partie; 
	
	@OneToMany(mappedBy="personnage")
	private Set<Engin> engin; 

	public Personnage() {
	partie = new HashSet<Partie>();
	}
	
	public Integer getId_personnage() {
		return id_personnage;
	}
	public void setId_personnage(Integer id_personnage) {
		this.id_personnage = id_personnage;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getPuissance() {
		return puissance;
	}
	public void setPuissance(Integer puissance) {
		this.puissance = puissance;
	}

	@Override
	public String toString() {
		return "Personnage [id_personnage=" + id_personnage + ", nom=" + nom + ", puissance=" + puissance + ", partie="
				+ partie + ", engin=" + engin + "]";
	}
	
	
	
}