package main.java.com.example.jpa.database.model;

import java.time.LocalDate;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nom", length = 30, nullable = false, unique = true)
	private String nom;
	@Column(name = "pseudo", length = 30, nullable = false)
	private String pseudo;
	@Column(name = "mail", length = 30, nullable = false)
	private String mail;

	

	// constructeurs
	public Player() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", nom=" + nom + ", pseudo=" + pseudo + ", mail=" + mail + "]";
	}
	

}