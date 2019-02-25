package main.java.com.example.jpa.database.model;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Partie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_partie;
	@Column(name = "niveau", nullable = false)
	private Integer niveau;
	@Column(name = "score", nullable = false)
	private Integer score;
	@Column(name = "date_DATE", nullable = false)
	private LocalDate date_DATE;
	
	
	public Integer getId_partie() {
		return id_partie;
	}
	public void setId_partie(Integer id_partie) {
		this.id_partie = id_partie;
	}
	public Integer getNiveau() {
		return niveau;
	}
	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public LocalDate getDate_DATE() {
		return date_DATE;
	}
	public void setDate_DATE(LocalDate date_DATE) {
		this.date_DATE = date_DATE;
	}
	
	@Override
	public String toString() {
		return "Partie [id_partie=" + id_partie + ", niveau=" + niveau + ", score=" + score + ", date_DATE=" + date_DATE
				+ "]";
	}
	
	
	
}
