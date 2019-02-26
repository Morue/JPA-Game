package main.java.com.example.jpa.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="engin")
public class Engin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_engin;
	@Column(name = "couleur", length = 30, nullable = false, unique = true)
	private String couleur;
	@Column(name = "vitesse_max", nullable = false)
	private Integer vitesse_max;
	
	@ManyToOne
	@JoinColumn(name="id_personnage")
	private Personnage personnage;

	public Integer getId_engin() {
		return id_engin;
	}

	public void setId_engin(Integer id_engin) {
		this.id_engin = id_engin;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Integer getVitesse_max() {
		return vitesse_max;
	}

	public void setVitesse_max(Integer vitesse_max) {
		this.vitesse_max = vitesse_max;
	}

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}

	@Override
	public String toString() {
		return "Engin [id_engin=" + id_engin + ", couleur=" + couleur + ", vitesse_max=" + vitesse_max + ", personnage="
				+ personnage + "]";
	}
	
	

}
